package com.spring.mvc.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class Order {
    @NotNull
    private Integer orderId;
    @NotEmpty
    private String orderState;
    @Valid
    private Address address;
}
