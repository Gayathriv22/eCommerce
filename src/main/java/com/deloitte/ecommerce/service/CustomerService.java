package com.deloitte.ecommerce.service;


import com.deloitte.ecommerce.entities.Customer;

import java.util.*;

public interface CustomerService {
    void addServiceCustomer(Customer c);
    Customer  findCustomerByMobile(String mobile);
    boolean credentialsCorrect(String mobile, String password);
    Set<Customer>addAllCustomers();
    void transferAmount(Customer c1,Customer c2,double amount);
}
