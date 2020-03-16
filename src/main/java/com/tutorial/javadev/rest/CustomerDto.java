package com.tutorial.javadev.rest;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomerDto {

    private String name;
    private int age;
    private String email;

    @Builder
    public CustomerDto(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public CustomerDto(Customer customer) {
        this.name = customer.getName();
        this.age = customer.getAge();
        this.email = customer.getEmail();
    }

    public Customer toEntity(){
        return Customer.builder()
                .name(name)
                .age(age)
                .email(email)
                .build();
    }


}
