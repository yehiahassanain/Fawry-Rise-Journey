/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Product cheese = new Cheese("Cheddar", 5.0, 10, LocalDate.now().plusDays(10), 1.0);
            Product tv = new TV("Samsung TV", 1000.0, 2, 20.0);
            Product biscuit = new Biscuit("Oreo", 2.0, 5, LocalDate.now().plusDays(5));
            Product card = new MobileCard("Scratch Card", 1.0, 20);

            Customer customer = new Customer("Ali", 1200);

            customer.getCart().addItem(cheese, 2);
            customer.getCart().addItem(tv, 1);
            customer.getCart().addItem(biscuit, 2);
            customer.getCart().addItem(card, 3);

            customer.checkout();

        } catch (Exception e) {
            System.out.println("Checkout Failed: " + e.getMessage());
        }
    }
}

