package org.hasandag.java.programming.masterclass.autoboxing_unboxing_challange;

import java.util.ArrayList;

/**
 * Created by : hdag
 * Date: 5.09.2019
 * Time: 11:03
 */
public class Customer {

    private String name;

    private ArrayList<Double> transactionList;

    public Customer(String name, Double initialTransaction) {
        this.name = name;
        transactionList = new ArrayList<>();
        addTransaction(initialTransaction);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList<Double> transactionList) {
        this.transactionList = transactionList;
    }

    public boolean addTransaction(Double transaction) {
        return transactionList.add(transaction);
    }
}
