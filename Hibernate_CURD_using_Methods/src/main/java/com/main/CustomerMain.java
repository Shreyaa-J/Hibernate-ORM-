package com.main;

import java.util.Scanner;
import com.model.Customer;
import com.service.CustomerService;

public class CustomerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerService service = new CustomerService();

        while (true) {
            System.out.println("\n1. Add Customer\n2. Update Customer\n3. Delete Customer\n4. Get Customer by ID\n5. List All Customers\n6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    service.addCustomer(new Customer(name, email));
                    break;

                case 2:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();
                    service.modifyCustomer(updateId, newName, newEmail);
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    service.removeCustomer(deleteId);
                    break;

                case 4:
                    System.out.print("Enter ID to fetch: ");
                    int fetchId = sc.nextInt();
                    service.getCustomer(fetchId);
                    break;

                case 5:
                    service.listAllCustomers();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
