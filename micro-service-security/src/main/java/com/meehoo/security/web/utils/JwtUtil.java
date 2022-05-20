package com.meehoo.security.web.utils;

import com.meehoo.security.web.vo.UserVO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    public static String buildJwt(Date expire, UserVO userVO) {
        String jwt = Jwts.builder()
                // 使用HS256加密算法
                .signWith(SignatureAlgorithm.HS256, "someday")
                // 过期时间
                .setExpiration(expire)
                .claim("loginName", userVO.getLoginName())
                .claim("uuid", userVO.getUuid())
                .compact();
        return jwt;
    }
}
