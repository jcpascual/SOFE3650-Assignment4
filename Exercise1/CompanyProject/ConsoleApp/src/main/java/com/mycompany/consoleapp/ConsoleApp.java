/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consoleapp;

import com.mycompany.sharedlibrary.CommonUtility;

/**
 *
 * @author julian
 */
public class ConsoleApp {
    public static void main(String[] args)
    {
        String appName = CommonUtility.getAppName();
        System.out.println("Welcome to " + appName);
    }
}
