/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samiya Fasihuddin
 */
public class Customer extends Account {

    private double balance;

    public Customer(String username, String password, double balance) {
        super(username, password, "Customer");
        FileOutputStream out = null;
        try {
            this.balance = balance;
            String fileData = password + "\n" + balance;
            out = new FileOutputStream(username);
            out.write(fileData.getBytes());
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Customer getCustomer(String username) {

        Customer customer = null;
        FileInputStream in = null;
        try {
            File file = new File(username);
            if (!file.exists()) {
                throw new IllegalArgumentException("Customer does not exist");
            }   in = new FileInputStream(username);
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            String line = buf.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                sb.append(line).append("\n");
                line = buf.readLine();
            }   String fileAsString = sb.toString();
            String[] fileData = fileAsString.split("\n");
            customer = new Customer(username, fileData[0], Double.valueOf(fileData[1]));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return customer;
    }

    public String getLevel() {
        if (getBalance() >= 10000 && getBalance() < 20000) {
            return "Gold";
        } else if (getBalance() >= 20000) {
            return "Platinum";
        } else {
            return "Silver";
        }
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        try {
            this.balance = balance;
            
            String fileData = password + "\n" + balance;
            FileOutputStream out = new FileOutputStream(username);
            out.write(fileData.getBytes());
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void depositMoney(double deposit) {
        if (deposit < 0) {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        }
        balance = balance + deposit;

        setBalance(balance);
    }

    public void withdrawMoney(double withdrawAmount) {
        if (balance < withdrawAmount) {
            throw new IllegalArgumentException("Balance not enough");
        }
        balance = balance - withdrawAmount;
        setBalance(balance);
    }

    public void onlinePurchase(double purchaseAmount) {
        if (purchaseAmount < 50) {
            throw new IllegalArgumentException("Purchase amount cannot be less than $50");
        }

        double fee = calculatePurchaseFee();
        double purchaseAmountWithFee = purchaseAmount + fee;

        if (balance < purchaseAmountWithFee) {
            throw new IllegalArgumentException("Not enough balance in account");
        }

        balance = balance - purchaseAmountWithFee;

        setBalance(balance);
    }

    public double calculatePurchaseFee() {
        String level = getLevel();

        if ("Silver".equals(level)) {
            return 20.0;
        } else if ("Gold".equals(level)) {
            return 10.0;
        } else {
            // Level must be Platinum
            return 0.0;
        }
    }
}
