package com.meehoo.consumer.web.service;

import com.meehoo.consumer.web.vo.ProductVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "micro-service-producer")
public interface ProducerClient {
    @RequestMapping(value = "/producer/create", method = RequestMethod.POST)
    ProductVO queryProduct();
}
