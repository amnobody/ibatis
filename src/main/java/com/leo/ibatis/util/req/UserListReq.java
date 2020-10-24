package com.leo.ibatis.util.req;

import javax.validation.constraints.NotNull;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/24
 * @description 用户请求列表查询参数
 */
public class UserListReq extends BaseRequest{

    @NotNull(message = "年龄不能为空")
    private Integer age;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
