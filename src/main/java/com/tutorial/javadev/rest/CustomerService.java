package com.tutorial.javadev.rest;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public Long createCustomer(CustomerDto customerDto){
        return customerRepository.save(customerDto.toEntity()).getId();
    }

//    @Transactional
//   public List<CustomerDto> findAllCustomer(){
//        List<Customer> customerList = customerRepository.findAll();
//        List<CustomerDto> customerDtoList = new ArrayList<>();
//
//        BeanUtils.copyProperties(customerList, customerDtoList);
//        return  customerDtoList;
//    }

    @Transactional
    public List<CustomerDto> findAllCustomer(){
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        BeanUtils.copyProperties(customerList, customerDtoList);
        return  customerDtoList;
    }


    @Transactional
    public CustomerDto findCustomer(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }




    @Transactional
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

}
