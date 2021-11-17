/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.oatmealdome.uoit.sofe3650.assignment4.register;

/**
 *
 * @author julian
 */
import java.util.HashMap;

public class ProductDB {
    private final HashMap<String, Product> productMap;

    public ProductDB() {
        productMap = new HashMap<>();
    }

    public void addProductInfo(String upc, Product product) {
        productMap.put(upc, product);
    }

    public Product getProductInfo(String upc) {
        return productMap.get(upc);
    }
}
