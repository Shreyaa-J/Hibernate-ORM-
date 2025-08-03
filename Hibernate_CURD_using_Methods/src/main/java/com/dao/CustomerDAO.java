package com.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;



import com.model.Customer;

public class CustomerDAO {
	public void insertCustomer(Customer customer) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Customer.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(customer);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Customer added...");
    }

	public void updateCustomer(int id, String newName, String newEmail) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Customer.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = session.get(Customer.class, id);
        if (customer != null) {
            customer.setName(newName);
            customer.setEmail(newEmail);
            session.merge(customer);
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }

        tx.commit();
        session.close();
        factory.close();
    }



    public void deleteCustomer(int id) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Customer.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer=session.get(Customer.class,id);
        if (customer != null) {
            session.remove(customer);
            System.out.println("Customer deleted...");
        }

        tx.commit();
        session.close();
        factory.close();
    }

    public void fetchCustomerById(int id) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Customer.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

      
        Customer customer = session.get(Customer.class,id);
        if (customer!= null)
            System.out.println(customer);
        else
            System.out.println("Customer not found");

        session.close();
        factory.close();
    }

    public void fetchAllCustomers() {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Customer.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> root = cq.from(Customer.class);
        cq.select(root);

        Query query = session.createQuery(cq);
        List<Customer> customers = query.getResultList();

        for (Customer customer : customers) {
            System.out.println(customers);
        }

        tx.commit();
        session.close();
        factory.close();
    }


}
