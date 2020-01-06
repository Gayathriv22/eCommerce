
package com.deloitte.ecommerce.service;


import com.deloitte.ecommerce.dao.CustomerDao;
import com.deloitte.ecommerce.entities.Customer;
import com.deloitte.ecommerce.exceptions.IncorrectMobileNumberException;

import java.util.*;

public class CustomerServiceImp implements CustomerService {
    private CustomerDao dao;

    public CustomerServiceImp(
            CustomerDao dao) {
        this.dao = dao;
    }

    @Override
    public void addServiceCustomer(Customer c) {
        dao.addCustomer(c);

    }

    @Override
    public void transferAmount(Customer c1, Customer c2, double amount) {
        dao.transferAmount(c1, c2, amount);
    }

    @Override
    public Customer findCustomerByMobile(String mobile) {
        if (mobile==null || mobile.length()<10) {
            throw new IncorrectMobileNumberException("there is no customer for this id");

        }
        Customer c = dao.findCustomerByMobile(mobile);
        return c;

    }

    @Override
    public boolean credentialsCorrect(String mobile, String password) {
        boolean correct = dao.credentialsCorrect(mobile, password);
        return correct;
    }

    @Override
    public Set<Customer> addAllCustomers() {
        Set<Customer> customers = dao.addAllCustomers();
        return customers;
    }
}


