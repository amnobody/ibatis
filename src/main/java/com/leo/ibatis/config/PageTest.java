package com.leo.ibatis.config;

import java.util.Map;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2021/02/26
 * @description
 */
public class PageTest {

    private int number;

    private Map<String,Object> param;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Map<String, Object> getParam() {
        return param;
    }

    public void setParam(Map<String, Object> param) {
        this.param = param;
    }
}
