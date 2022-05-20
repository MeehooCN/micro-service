package com.meehoo.producer.web.controller;

import com.meehoo.producer.web.service.ProductService;
import com.meehoo.producer.web.vo.ProductVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("create")
    public ProductVO create() {
        return productService.create();
    }
}
