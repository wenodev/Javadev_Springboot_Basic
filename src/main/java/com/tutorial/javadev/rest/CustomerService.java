package com.tutorial.javadev.rest;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public Long createCustomer(CustomerDto customerDto){
        return customerRepository.save(customerDto.toEntity()).getId();
    }

    @Transactional
    public List<CustomerDto> findAllCustomer(){

        return customerRepository.findAll().stream()
                .map(CustomerDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public CustomerDto findCustomer(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        CustomerDto customerDto = CustomerDto.builder()
                .age(customer.get().getAge())
                .email(customer.get().getEmail())
                .name(customer.get().getName())
                .build();

        return  customerDto;

    }

    @Transactional
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

}
