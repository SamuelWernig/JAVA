package at.htlle.pos;

import at.htlle.pos.drink.Beer;
import at.htlle.pos.drink.Soda;
import at.htlle.pos.food.Bun;
import at.htlle.pos.food.Sausage;

import java.util.Arrays;

public class CashRegisterDemo {
    public static void main(String[] args) {
        // create the snack bar's cash register
        CashRegister register = new CashRegister();

        // print out the current items, multiplier
        System.out.println("--- after instantiation of cash register - there are no products and no sub- or total sum, and the receipt is more or less empty.");
        System.out.println("register.getCurrentTotalSumInCent(): " + register.getCurrentTotalSumInCent());
        System.out.println("register.getCurrentTotalSumInEuro(): " + register.getCurrentTotalSumInEuro());
        System.out.println("register.getItems(): "+ Arrays.toString(register.getItems()));
        System.out.println("register.getMultipliers(): "+ Arrays.toString(register.getMultipliers()));
        System.out.println("register.getCurrentSubTotalSumInCent(): "+register.getCurrentSubTotalSumInCent());
        System.out.println("register.getCurrentSubTotalSumInEuro(): "+register.getCurrentSubTotalSumInEuro());
        System.out.println("Receipt: \n" + register.getSubTotalReceipt());

        // create some food items
        System.out.println("--- create some items and print the details");
        Drink beer = new Beer();
        Drink soda = new Soda();
        Food sausage = new Sausage();
        Food bun = new Bun();

        System.out.println("beer.toDetialedString(): " + beer.toDetailedString());
        System.out.println("soda.toDetialedString(): " + soda.toDetailedString());
        System.out.println("saasage.toDetialedString(): " + sausage.toDetailedString());
        System.out.println("bun.toDetialedString(): " + bun.toDetailedString());

        System.out.println();
        System.out.println("--- now enter some items to the register");

        // enter them into the cashRgeister
        register.addItem(beer, 3);
        register.addItem(sausage);
        register.addItem(bun,2);


        System.out.println("register.getCurrentTotalSumInCent(): " + register.getCurrentTotalSumInCent());
        System.out.println("register.getCurrentTotalSumInEuro(): " + register.getCurrentTotalSumInEuro());
        System.out.println("register.getItems()"+ Arrays.toString(register.getItems()));
        System.out.println("register.getMultipliers()"+ Arrays.toString(register.getMultipliers()));
        System.out.println("register.getCurrentSubTotalSumInCent(): "+register.getCurrentSubTotalSumInCent());
        System.out.println("register.getCurrentSubTotalSumInEuro(): "+register.getCurrentSubTotalSumInEuro());
        System.out.println("Receipt: \n" + register.getSubTotalReceipt());

        System.out.println("--- now conclude the customer session and create a new one");
        System.out.println("Call newCustomerSession():\n" + register.newCustomerSession());
         System.out.println("register.getCurrentTotalSumInCent(): " + register.getCurrentTotalSumInCent());
        System.out.println("register.getCurrentTotalSumInEuro(): " + register.getCurrentTotalSumInEuro());
        System.out.println("register.getItems()"+ Arrays.toString(register.getItems()));
        System.out.println("register.getMultipliers()"+ Arrays.toString(register.getMultipliers()));
        System.out.println("register.getCurrentSubTotalSumInCent(): "+register.getCurrentSubTotalSumInCent());
        System.out.println("register.getCurrentSubTotalSumInEuro(): "+register.getCurrentSubTotalSumInEuro());


    }
}
