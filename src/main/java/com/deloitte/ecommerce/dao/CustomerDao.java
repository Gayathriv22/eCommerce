package com.deloitte.ecommerce.dao;

import com.deloitte.ecommerce.entities.Customer;
import java.util.*;

public interface CustomerDao {
    void addCustomer(Customer c);
    Customer findCustomerByMobile(String mobile);
    boolean credentialsCorrect(String mobile, String password);
    Set<Customer>addAllCustomers();
    void transferAmount(Customer c1,Customer c2,double amount);
    }

