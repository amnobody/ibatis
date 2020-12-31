package com.leo.ibatis.jackson;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/30
 * @description
 */
public class ExportUtils {
    
    public static String doExport(List<String> list,IExport export) {
        for (String s : list) {
            export.export(s);
        }
        return "http://www.jkdjfk";
    }
    public static void doExport(List<String> list, Consumer<String> consumer) {
        for (String s : list) {
            consumer.accept(s);
        }
    }

}
