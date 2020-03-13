package com.tutorial.javadev.starter;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;



    public User(String firstName, String lastName) {
        //this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }





}
