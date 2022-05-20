package com.meehoo.security.web.vo;

import lombok.Data;

@Data
public class UserVO {
    /**
     * 唯一id
     */
    private String uuid;
    /**
     * 登录名
     */
    private String loginName;
}
