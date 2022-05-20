package com.meehoo.gateway.web.filter;

import com.meehoo.gateway.web.config.HttpResult;
import com.meehoo.gateway.web.utils.JwtUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class AuthFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //登录接口放行
        if (exchange.getRequest().getPath().toString().equals("/security/user/login")) {
            return chain.filter(exchange);
        }
        // 认证
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if (JwtUtil.validationToken(token)) {
            return chain.filter(exchange);
        }

        // 认证过期、失败，均返回401
        ServerHttpResponse response = exchange.getResponse();
        byte[] bits = JSONObject.toJSONString(HttpResult.fail("token认证失败")).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        // 指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
