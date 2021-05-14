package com.leo.ibatis.drools;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderError;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/03/22
 * @description
 */
public class CusDroolsUtil {

    static Cache<String, InternalKnowledgeBase> cache = Caffeine.newBuilder()
            .initialCapacity(100)
            .maximumSize(200)
            .expireAfterWrite(3, TimeUnit.SECONDS)
            .recordStats()
            .build();

    static String ruleId = "hello";


    public static void runRule(String ruleText, Object[] objs) {
        StopWatch watch = new StopWatch("算费");
        KieSession kSession = null;
        try {
            final InternalKnowledgeBase kbase = cache.getIfPresent(ruleId);
            if (null != kbase) {
                System.out.println("命中缓存");
                kSession = kbase.newKieSession();
                for (Object obj : objs) {
                    kSession.insert(obj);
                }
                kSession.fireAllRules();
                return;
            }

            KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
            //装入规则，可以装入多个
            watch.start("加载文件");
            kb.add(ResourceFactory.newByteArrayResource(ruleText.getBytes("utf-8")), ResourceType.DRL);
            watch.stop();

            watch.start("packages init");
            KnowledgeBuilderErrors errors = kb.getErrors();
            for (KnowledgeBuilderError error : errors) {
                throw new RuntimeException(error.getMessage());
            }
            InternalKnowledgeBase kBase = KnowledgeBaseFactory.newKnowledgeBase();
            kBase.addPackages(kb.getKnowledgePackages());
            watch.stop();
            cache.put(ruleId, kBase);

            kSession = kBase.newKieSession();
            for (Object obj : objs) {
                kSession.insert(obj);
            }
            watch.start("执行脚本");
            kSession.fireAllRules();
            watch.stop();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
//            System.out.println(watch.getTotalTimeMillis());
//            System.out.println(watch.prettyPrint());
            if (kSession != null) {
                kSession.dispose();
            }
        }

    }
}
