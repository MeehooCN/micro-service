package com.meehoo.producer.web.service;

import com.meehoo.producer.web.vo.ProductVO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    public ProductVO create() {
        return new ProductVO(UUID.randomUUID().toString().replaceAll("-", ""));
    }
}
