package com.main;
import java.util.*;

import com.model.Book;
import com.service.BookService;
import java.util.Scanner;

public class Main {
	   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        BookService service = new BookService();

	        while (true) {
	            System.out.println("\n1. Add Book\n2. Update Book\n3. Delete Book\n4. Get Book by ID\n5. List All Books\n6. Exit");
	            System.out.print("Enter choice: ");
	            int ch = sc.nextInt();
	            sc.nextLine();

	            switch (ch) {
	                case 1:
	                    System.out.print("Enter title: ");
	                    String title = sc.nextLine();
	                    System.out.print("Enter author: ");
	                    String author = sc.nextLine();
	                    service.addBook(new Book(title, author));
	                    break;
	                case 2:
	                    System.out.print("Enter ID to update: ");
	                    int upId = sc.nextInt();
	                    sc.nextLine();
	                    System.out.print("New title: ");
	                    String newTitle = sc.nextLine();
	                    System.out.print("New author: ");
	                    String newAuthor = sc.nextLine();
	                    service.modifyBook(upId, newTitle, newAuthor);
	                    break;
	                case 3:
	                    System.out.print("Enter ID to delete: ");
	                    int delId = sc.nextInt();
	                    service.removeBook(delId);
	                    break;
	                case 4:
	                    System.out.print("Enter ID to fetch: ");
	                    int getId = sc.nextInt();
	                    service.getBook(getId);
	                    break;
	                case 5:
	                    service.listAllBooks();
	                    break;
	                case 6:
	                    System.out.println("Exiting...");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice");
	            }
	        }
	    }
}
