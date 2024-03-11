package com.swaraj.functionality1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @NotBlank(message = "name cannot be null or empty")
    private String name;

    @NotBlank(message = "product type cannot be null or empty")
    private String productType;

    @Min(value = 0)
    @Max(value = 100,message = "allowed till 100")
    private int quantity;

//    @Email
//    private String email;
//
//    @Future
//    @Past
//    private Date date;
}
