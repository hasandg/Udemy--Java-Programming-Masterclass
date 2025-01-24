package org.hasandag.java.programming.masterclass.autoboxing_unboxing_challange;

/**
 * Created by : hdag
 * Date: 5.09.2019
 * Time: 11:17
 */
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Bank A");
         bank.addBranch("Ankara");

        bank.addCustomer("Ankara", "Mike", 50.05);
        bank.addCustomer("Ankara", "Tim", 15.00);
        bank.addCustomer("Ankara", "Hasan", 150.75);

        bank.addBranch("Istanbul");

        bank.addCustomer("Istanbul", "Mike", 25.84);
        bank.addCustomer("Istanbul", "David", 85.34);

        bank.addCustomerTransaction("Ankara","Mike", 60.44);

         bank.listCustomers("Ankara",true);

    }
}
