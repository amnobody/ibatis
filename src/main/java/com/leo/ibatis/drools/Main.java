package com.leo.ibatis.drools;

import com.github.benmanes.caffeine.cache.stats.CacheStats;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/03/22
 * @description
 */
public class Main {


    public static void main(String[] args) {
        String rule =
                "\n" +
                        "\n" +
                        "rule \"WuYouZhuYuanYiLiao_GuangDaYongMing\"\n" +
                        "        when\n" +
                        "        $flag: Integer();\n" +
                        "        then\n" +
                        "        ruleCheck($flag);\n" +
                        "        end\n" +
                        "\n" +
                        "        function ruleCheck(Integer flag) {\n" +
                        "            \n" +
                        "\n" +
                        "            System.out.println(\"参数...\"+flag+\"------------------------- drools end --------------------------\");\n" +
                        "\n" +
                        "        }";
        for (int i = 0; i < 20; i++) {
            final long start = System.currentTimeMillis();
            CusDroolsUtil.runRule(rule, new Object[]{i});
            System.out.println("耗时ms=" + (System.currentTimeMillis() - start));
        }
        final CacheStats stats = CusDroolsUtil.cache.stats();
        System.out.println("...");
    }
}
