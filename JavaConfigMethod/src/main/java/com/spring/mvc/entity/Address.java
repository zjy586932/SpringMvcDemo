package com.spring.mvc.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Address {
    @NotNull
    private Integer addressId;
    @NotEmpty
    private String addressDetail;
}
