package com.service;

import com.dao.BookDAO;
import com.model.Book;

public class BookService {
	BookDAO dao = new BookDAO();

    public void addBook(Book book) {
        dao.insertBook(book);
    }

    public void modifyBook(int id, String title, String author) {
        dao.updateBook(id, title, author);
    }

    public void removeBook(int id) {
        dao.deleteBook(id);
    }

    public void getBook(int id) {
        dao.fetchBookById(id);
    }

    public void listAllBooks() {
        dao.fetchAllBooks();
    }
}
