package com.leo.ibatis.jackson;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/30
 * @description
 */
public class CsvExporter implements IExport {

    @Override
    public void export(String filename) {
        System.out.println("csv导出器-每行数据" + filename);
    }
}
