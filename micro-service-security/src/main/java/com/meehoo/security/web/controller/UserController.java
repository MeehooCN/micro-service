package com.meehoo.security.web.controller;

import com.meehoo.security.web.config.HttpResult;
import com.meehoo.security.web.ro.UserRO;
import com.meehoo.security.web.service.UserService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户服务接口")
@RestController
@RequestMapping("/security/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @ApiOperation("登录")
    @PostMapping("login")
    public HttpResult login(@RequestBody UserRO ro) {
        try {
            return HttpResult.success(userService.login(ro));
        } catch (Exception e) {
            return HttpResult.fail(e);
        }
    }
}