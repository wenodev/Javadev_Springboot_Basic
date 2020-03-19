package com.tutorial.javadev.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultMemberService implements MemberService{

    @Autowired
    private MemberRepository memberRepository;


    @Override
    public MemberDto saveCustomer(MemberDto customer) {
        Member customerModel = populateCustomerEntity(customer);
        return populateCustomerData(memberRepository.save(customerModel));
    }


    @Override
    public boolean deleteCustomer(Long customerId) {
        memberRepository.deleteById(customerId);
        return true;
    }


    @Override
    public List<MemberDto> getAllCustomers() {
        List<MemberDto> customers = new ArrayList<>();
        List<Member> customerList = memberRepository.findAll();
        customerList.forEach(customer -> {
            customers.add(populateCustomerData(customer));
        });
        return customers;
    }


    @Override
    public MemberDto getCustomerById(Long customerId) {
        return populateCustomerData( memberRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found")));
    }


    private MemberDto populateCustomerData(final Member customer){
        MemberDto customerData = new MemberDto();
        customerData.setId(customer.getId());
        customerData.setFirstName(customer.getFirstName());
        customerData.setLastName(customer.getLastName());
        customerData.setEmail(customer.getEmail());
        return  customerData;
    }

    private Member populateCustomerEntity(MemberDto customerData){
        Member customer = new Member();
        customer.setFirstName(customerData.getFirstName());
        customer.setLastName(customerData.getLastName());
        customer.setEmail(customerData.getEmail());
        return  customer;
    }



}
