package org.hasandag.java.programming.masterclass.autoboxing_unboxing_challange;

import java.util.ArrayList;

/**
 * Created by : hdag
 * Date: 5.09.2019
 * Time: 11:03
 */
public class Branch {
    private String name;
    private ArrayList<Customer> customerList;

    public Branch(String name) {
        this.name = name;
        customerList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public boolean createCustomer(String name, Double initialTransaction) {
        if (findCustomer(name) == null) {
            customerList.add(new Customer(name, initialTransaction));
            return true;
        } else {
            return false;
        }
    }

    public boolean addTransaction(String name, Double transaction) {
        Customer customer = findCustomer(name);
        if (customer != null) {
            findCustomer(name).addTransaction(transaction);
            return true;
        }
        return false;
    }

    public Customer findCustomer(String name) {
        for (Customer customer : customerList) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}
