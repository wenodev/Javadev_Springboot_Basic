package com.tutorial.javadev.hibernate;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;


    @GetMapping
    public List<MemberDto> getCustomers(){
        return memberService.getAllCustomers();
    }


    @GetMapping("/customer/{id}")
    public MemberDto getCustomer(@PathVariable Long id){
        return memberService.getCustomerById(id);
    }


    @PostMapping("/customer")
    public MemberDto saveCustomer(final @RequestBody MemberDto customerData){
        return memberService.saveCustomer(customerData);
    }


    @DeleteMapping("/customer/{id}")
    public Boolean deleteCustomer(@PathVariable Long id){
        return memberService.deleteCustomer(id);
    }



}
