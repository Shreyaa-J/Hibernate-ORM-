package com.service;

import com.dao.CustomerDAO;
import com.model.Customer;
public class CustomerService {
 CustomerDAO dao=new CustomerDAO();
 
 public void addCustomer(Customer customer) {
	 dao.insertCustomer(customer);
 }
 
 public void modifyCustomer(int id,String name, String email) {
	 dao.updateCustomer(id, name, email);
 }
 public void removeCustomer(int id) {
	 dao.deleteCustomer(id);
 }
 public void getCustomer(int id) {
	 dao.fetchAllCustomers();
 }
 public void listAllCustomers() {
	 dao.fetchAllCustomers();
 }
 
}

