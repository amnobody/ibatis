package com.leo.ibatis.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leo.ibatis.util.common.RequestPage;

import java.util.List;

/**
 * DESC: 封装的抽象service
 *
 * @author JiWei.Chen
 * @date 2020/08/05
 */
public interface BaseService<Req, Resp> {

    default PageInfo<Resp> page(RequestPage<Req> requestPage) {
        return PageHelper.startPage(requestPage.getPageNum(), requestPage.getPageSize())
                .doSelectPageInfo(() -> list(requestPage.getParam()));
    }

    List<Resp> list(Req baseRequest);
}
