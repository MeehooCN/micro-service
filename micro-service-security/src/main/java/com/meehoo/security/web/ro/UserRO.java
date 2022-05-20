package com.meehoo.security.web.ro;

import lombok.Data;

@Data
public class UserRO {
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 密码
     */
    private String userPwd;
}
