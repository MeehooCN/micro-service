package com.meehoo.security.web.vo;

import lombok.Data;

@Data
public class AuthVO {
    private String token;
    private UserVO user;
}
