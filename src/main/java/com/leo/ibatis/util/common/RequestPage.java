package com.leo.ibatis.util.common;

import com.github.pagehelper.IPage;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/24
 * @description 分页查询参数
 */
public class RequestPage<T> implements IPage {
    @Min(1)
    private Integer pageNum;

    @Min(1)
    private Integer pageSize;

    private String orderBy;

    /**
     * 查询参数
     */
    @Valid
    private T param;

    @Override
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }
}
