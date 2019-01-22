/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528;

/**
 *
 * @author Samiya Fasihuddin
 */
import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class Manager extends Account {
    
    	// Overview: Manager is mutable, bounded         
	// Customer files that operate under
	// the Manager's control
	//     
	// The abstraction function is:    
	// a)Write the abstraction function here     
	// 		AF(s) = the stack of files A
	//			A.add = adds a file filled with information
	//			A.sum = shows the total number of customers
	
	
	// The rep invariant is:    
	// b)Write the rep invariant here    
	//      A.name != null
	//      A.name[i] != "admin"
	//the rep    
    
    
    
    
    private List<Customer> customerList;
    
    public Manager() {
        super("admin", "admin", "Manager");
        customerList = new ArrayList<Customer>();
    }
    
    public void addCustomer(String username, String password) throws IOException {
        Customer customer;
        customer = new Customer(username, password, 100.0);
    }
    
    public void deleteCustomer(String username) {        
        File file = new File(username);
        file.delete();
    }
}
