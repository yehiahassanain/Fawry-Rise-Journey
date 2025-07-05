/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author compu malek
 */
import java.time.LocalDate;

public class Biscuit extends Product implements Expirable {
    private LocalDate expiryDate;

    public Biscuit(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public boolean isShippable() {
        return false;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
