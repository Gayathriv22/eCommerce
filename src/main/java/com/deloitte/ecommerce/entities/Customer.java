package com.deloitte.ecommerce.entities;

import java.util.Set;
import java.util.*;

public class Customer {
    private String mobile;
    private String name;

    private String password;
    private double balance;

    public Customer(String mobile, String name, String password, double balance) {
        this.mobile = mobile;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addsalary(double salary) {
        balance = balance + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return customer.mobile.equals(this.mobile);
    }


    @Override
    public int hashCode() {
        return mobile.hashCode();
    }
}
