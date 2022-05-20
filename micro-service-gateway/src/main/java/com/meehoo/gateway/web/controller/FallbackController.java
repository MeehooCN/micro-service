package com.meehoo.gateway.web.controller;

import com.meehoo.gateway.web.config.HttpResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/fallback")
    public HttpResult fallback() {
        return HttpResult.fail("降级熔断");
    }
}
