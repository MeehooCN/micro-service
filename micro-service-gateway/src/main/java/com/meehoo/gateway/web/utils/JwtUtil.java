package com.meehoo.gateway.web.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtUtil {

    /**
     * 身份认证
     *
     * @param jwt 令牌
     * @return 成功状态返回200，其它均为失败
     */
    public static boolean validationToken(String jwt) {
        try {
            //解析JWT字符串中的数据，并进行最基础的验证
            Claims claims = Jwts.parser()
                    .setSigningKey("someday")
                    .parseClaimsJws(jwt)
                    .getBody();
            if (null != claims.get("uuid") && null != claims.get("loginName")) {
                return true;
            } else {
                return false;
            }
        } catch (ExpiredJwtException e) {
            // 已过期令牌
            return false;
        } catch (SignatureException e) {
            // 伪造令牌
            return false;
        } catch (Exception e) {
            // 系统错误
            return false;
        }
    }
}
