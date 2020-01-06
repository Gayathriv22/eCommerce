package com.deloitte.ecommerce.dao;
import com.deloitte.ecommerce.entities.Customer;
import com.deloitte.ecommerce.exceptions.CustomerNotFoundException;
import com.deloitte.ecommerce.dao.CustomerDao;
import com.deloitte.ecommerce.exceptions.CustomerNotFoundException;


import java.util.*;


public class CustomerDaoImp implements CustomerDao{
    private Map<String, Customer> store=new HashMap<>();

    public CustomerDaoImp() {
        Customer customer1 = new Customer("9447318603", "gayathri","1998",400);
        store.put("gayathri", customer1);
        Customer customer2 = new Customer("9895426744", "anjitha","1997",800);
        store.put("anjitha", customer2);
    }

    @Override
    public void addCustomer(Customer c) {
      store.put(c.getMobile(),c);
    }

    @Override
    public Customer findCustomerByMobile(String mobile) {
        Customer c=store.get(mobile);
        if (c== null) {
            throw new CustomerNotFoundException("Customer not found for this mobile number"+mobile);
        }
        return c;
    }

    @Override
    public Set<Customer> addAllCustomers() {
        Collection<Customer>customers=store.values();
        Set<Customer>customerSet=new HashSet<>(customers);
        return customerSet;
    }

    @Override
    public boolean credentialsCorrect(String mobile, String password) {
        Customer customer = store.get(mobile);
        if (customer == null) {
            return false;
        }
        return customer.getPassword().equals(password);
    }

    @Override
    public void transferAmount(Customer c1, Customer c2, double amount) {
        double bal=c1.getBalance();
        if(amount<bal){
            bal=bal - amount;
            c1.setBalance(bal);
            double bal1=c2.getBalance();
            bal1=bal1+amount;
            c2.setBalance(bal1);
        }


    }
}