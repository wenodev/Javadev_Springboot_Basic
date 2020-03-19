package com.tutorial.javadev.hibernate;


import java.util.List;

public interface MemberService {

    MemberDto saveCustomer(MemberDto memberDto);
    boolean deleteCustomer(final Long memberId);
    List<MemberDto> getAllCustomers();
    MemberDto getCustomerById(final Long memberId);


}
