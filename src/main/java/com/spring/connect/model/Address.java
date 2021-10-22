package com.spring.connect.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {


    private int addId;
    private String locationName;
    private String region;
    private String state;
    private String zipCode;
}
