package com.deloitte.ecommerce.ui;

import com.deloitte.ecommerce.dao.CustomerDaoImp;
import com.deloitte.ecommerce.entities.Customer;
import com.deloitte.ecommerce.service.CustomerService;
import com.deloitte.ecommerce.service.CustomerServiceImp;

import java.util.*;



public class CustomerUi {
    private CustomerService cs = new CustomerServiceImp(new CustomerDaoImp());

    public static void main(String[] args) {
        CustomerUi c1 = new CustomerUi();
        c1.runUi();

    }

    public void runUi() {
        try {
            /*Customer c0 = new Customer("9447318603", "gayathri", "1998",400);
            Customer c1 = new Customer("9895426744", "anjitha", "1997",800);
            cs.addServiceCustomer(c0);
            cs.addServiceCustomer(c1);
            Customer fetched1 = cs.findCustomerByMobile("9447318603");
            Customer fetched2 = cs.findCustomerByMobile("9895426744");
            System.out.println(fetched1.getName());
            System.out.println(fetched2.getName());
            Set<Customer> c4 = new HashSet<>();
            c4 = cs.addAllCustomers();
            print(c4);
            cs.transferAmount(c0,c1,344);*/
            Set<Customer>customer1=cs.addAllCustomers();
            print(customer1);
        } catch (Throwable c) {
            System.out.println("something went wrong");
        }
    }

    void print(Collection<Customer> customers) {
        for (Customer c:
             customers) {
            System.out.println("name :"+c.getName());
            System.out.println("mobile no:"+c.getMobile());
            System.out.println("balance is "+c.getBalance());
        }
    }

}
