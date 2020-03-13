package com.tutorial.javadev.rest;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping(value = "/customer")
    public Long createCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }

    @GetMapping("/customer/{id}")
    public CustomerDto findCustomer(@PathVariable Long id){
        return customerService.findCustomer(id);
    }

    @GetMapping("/all")
    public List<CustomerDto>  findAllCustomer(){

        List<CustomerDto> customerDtoList = customerService.findAllCustomer();

        return customerDtoList;
    }

}
