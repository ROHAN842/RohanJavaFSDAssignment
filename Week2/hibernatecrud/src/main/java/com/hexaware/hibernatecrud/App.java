package com.hexaware.hibernatecrud;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.hexaware.hibernatecrud.entity.User;
import com.hexaware.hibernatecrud.service.IUserService;
import com.hexaware.hibernatecrud.service.UserServiceImp;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        IUserService userService = new UserServiceImp();

        boolean flag = true;

        while (flag) {

            System.out.println("***WELCOME USER MANAGEMENT SYSTEM**");
            System.out.println("1. INSERT USER");
            System.out.println("2. UPDATE USER");
            System.out.println("3. DELETE USER BY ID");
            System.out.println("4. SELECT USER BY NAME");
            System.out.println("5. SELECT ALL USERS");
            System.out.println("6. EXIT");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    User user = readUserData();
                    boolean isInserted = userService.insertUser(user);
                    if (isInserted)
                        System.out.println("User inserted successfully");
                    else
                        System.out.println("Insertion failed");

                    break;
                }
                case 2: {
                    User user = readUserData(); // Create a method similar to readData() for reading user data
                    boolean isUpdated = userService.updateUser(user);
                    if (isUpdated)
                        System.out.println("User updated successfully");
                    else
                        System.out.println("Updation failed");
                    break;
                }

               
                case 3: {

                    System.out.println("Enter User ID");
                    int userId = scanner.nextInt();
                    boolean isDeleted = userService.deleteUserById(userId);
                    if (isDeleted)
                        System.out.println("User deletion successful");
                    else
                        System.out.println("Deletion failed");
                    break;
                }
                case 4: {
                    System.out.println("Enter User Name:");
                    scanner.nextLine();
                    String userName = scanner.nextLine();
                    User user = userService.selectUserByName(userName);
                    if (user != null) {
                        System.out.println("User found: " + user);
                    } else {
                        System.out.println("No user found for the specified name.");
                    }
                    break;
                }

                case 5: {
                    List<User> userList = userService.selectAllUsers();
                    if (userList.isEmpty()) {
                        System.out.println("No users found");
                    } else {
                        for (User usr : userList)
                            System.out.println(usr.toString());
                    }
                    break;
                }
                case 6: {
                    flag = false;
                    System.out.println("Thank You!!");
                    break;

                }

                default:
                    break;
            }

        }

    }

    public static User readUserData() {
//        User user = new User();
//        System.out.println("Enter User ID:");
//        user.setUserId(scanner.nextInt());
//        scanner.nextLine();
//        System.out.println("Enter User Name:");
//        user.setUserName(scanner.nextLine());
//        System.out.println("Enter User Password:");
//        user.setPassword(scanner.nextLine());
//        System.out.println("Enter User Email:");
//        user.setEmail(scanner.nextLine());
//        System.out.println("Enter User First Name:");
//        user.setFirstName(scanner.nextLine());
//        System.out.println("Enter User Last Name:");
//        user.setLastName(scanner.nextLine());
//        System.out.println("Enter User Contact Number:");
//        user.setContactNumber(scanner.nextLine());
//        System.out.println("Enter User Address:");
//        user.setAddress(scanner.nextLine());

    	User user = new User();
    	
    	System.out.println("Enter User ID");

		user.setUserID(scanner.nextInt());
		
		System.out.println("Enter Username");

		user.setUsername(scanner.next());

		System.out.println("Enter Password");

		user.setPassword(scanner.next());

		System.out.println("Enter Email");

		user.setEmail(scanner.next());

		System.out.println("Enter First Name");

		user.setFirstName(scanner.next());

		System.out.println("Enter Last Name");

		user.setLastName(scanner.next());

		System.out.println("Enter Phone Number");

		user.setPhoneNumber(scanner.next());

		System.out.println("Enter Address");
		
		scanner.nextLine();
		user.setAddress(scanner.nextLine());

		// Assuming the registration date is set automatically by the system
		user.setRegistrationDate(LocalDateTime.now());

        return user;
    }
}

