package org.hasandag.java.programming.masterclass.autoboxing_unboxing_challange;

import java.util.ArrayList;

/**
 * Created by : hdag
 * Date: 5.09.2019
 * Time: 11:03
 */
public class Bank {

    private String name;
    ArrayList<Branch> branchList;

    public Bank(String name) {
        this.name = name;
        branchList = new ArrayList<>();
    }

    public boolean addBranch(String name) {
        if (findBranch(name) == null) {
            branchList.add(new Branch(name));
            return true;
        }
        return false;
    }

    private Branch findBranch(String name) {
        for (Branch branch : branchList) {
            if (branch.getName().equals(name)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTrnsactions) {

        Branch branch = findBranch(branchName);
        if (branch != null) {
            if (branch.getCustomerList() != null && branch.getCustomerList().size() > 0) {
                for (Customer customer : branch.getCustomerList()) {
                    System.out.println("Customer name: " + customer.getName());
                    if (showTrnsactions) {
                        for (Double transaction : customer.getTransactionList()) {
                            System.out.println("Transaction: " + transaction);
                        }
                    }
                }
            }
            return true;
        }

        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if(branch != null ){
            branch.createCustomer(customerName,initialTransaction);
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName,String customerName,Double tranaction){
        Branch branch = findBranch(branchName);
        if (branch != null){
            Customer customer = branch.findCustomer(customerName);
            if(customer != null){
                customer.addTransaction(tranaction);
                return true;
            }
        }
        return false;
    }
}
