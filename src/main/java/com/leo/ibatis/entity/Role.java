package com.leo.ibatis.entity;

import com.leo.ibatis.util.req.BaseRequest;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/19
 */
public class Role extends BaseRequest implements Serializable {
    private static final long serialVersionUID = 7089699938704876104L;

    private String id;

    @NotEmpty(message = "角色名称不能为空")
    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
