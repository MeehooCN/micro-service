package com.meehoo.consumer.web.controller;

import com.meehoo.consumer.web.service.ProducerClient;
import com.meehoo.consumer.web.vo.HttpResult;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
@AllArgsConstructor
public class TestController {
    private final ProducerClient producerClient;

    @ApiOperation("测试")
    @PostMapping("test")
    public HttpResult test() {
        return HttpResult.success(producerClient.queryProduct());
    }
}
