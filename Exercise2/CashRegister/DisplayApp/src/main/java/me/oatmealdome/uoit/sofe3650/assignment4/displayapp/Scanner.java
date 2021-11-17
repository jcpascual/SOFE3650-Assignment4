/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.oatmealdome.uoit.sofe3650.assignment4.displayapp;

import me.oatmealdome.uoit.sofe3650.assignment4.register.CashRegister;

/**
 *
 * @author julian
 */
public class Scanner {
    private final CashRegister register;
    private String scannedUpc;

    public Scanner(CashRegister register) {
        this.register = register;
    }

    public String getScannedUpcCode() {
        return scannedUpc;
    }

    public void setScannedUpcCode(String upc) {
        scannedUpc = upc;
        register.setCurrentProductUpc(scannedUpc);
    }
}
