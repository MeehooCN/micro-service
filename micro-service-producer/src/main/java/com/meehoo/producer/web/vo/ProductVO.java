package com.meehoo.producer.web.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductVO implements Serializable {
    private String number;

    public ProductVO(String number) {
        this.number = number;
    }
}
