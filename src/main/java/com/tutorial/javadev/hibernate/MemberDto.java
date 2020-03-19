package com.tutorial.javadev.hibernate;

import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
