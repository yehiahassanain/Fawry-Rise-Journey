/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author compu malek
 */
public class Customer {
    private String name;
    private double balance;
    private Cart cart = new Cart();

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void checkout() throws Exception {
        if (cart.isEmpty()) throw new Exception("Cart is empty");

        for (CartItem item : cart.getItems()) {
            if (item.product.isExpired()) throw new Exception(item.product.getName() + " is expired");
        }

        double subtotal = cart.getSubtotal();
        double shippingFee = cart.getShippableItems().stream().mapToDouble(Shippable::getWeight).sum() * 5.0;
        double total = subtotal + shippingFee;

        if (balance < total) throw new Exception("Insufficient balance");

        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        balance -= total;

        System.out.println("Checkout Summary:");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Shipping: $" + shippingFee);
        System.out.println("Total Paid: $" + total);
        System.out.println("Remaining Balance: $" + balance);

        ShippingService.sendItems(cart.getShippableItems());
    }
}