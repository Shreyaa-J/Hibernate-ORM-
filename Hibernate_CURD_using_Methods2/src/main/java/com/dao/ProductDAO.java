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



import com.model.Book;

public class BookDAO {
	public void insertBook(Book book) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Book.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(book);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Book inserted...");
    }

    public void updateBook(int id, String newTitle, String newAuthor) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Book.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, id);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            session.merge(book);
            System.out.println("Book updated...");
        }

        tx.commit();
        session.close();
        factory.close();
    }

    public void deleteBook(int id) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Book.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, id);
        if (book != null) {
            session.remove(book);
            System.out.println("Book deleted...");
        }

        tx.commit();
        session.close();
        factory.close();
    }

    public void fetchBookById(int id) {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Book.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Book book = session.get(Book.class, id);
        if (book != null)
            System.out.println(book);
        else
            System.out.println("Book not found");

        session.close();
        factory.close();
    }

    public void fetchAllBooks() {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Book.class);

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);

        Query query = session.createQuery(cq);
        List<Book> books = query.getResultList();

        for (Book book : books) {
            System.out.println(book);
        }

        tx.commit();
        session.close();
        factory.close();
    }


}
