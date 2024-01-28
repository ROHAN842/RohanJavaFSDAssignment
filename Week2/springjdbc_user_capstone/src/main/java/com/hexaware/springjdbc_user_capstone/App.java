package com.hexaware.springjdbc_user_capstone;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.hexaware.springjdbc_user_capstone.config.AppConfig;
import com.hexaware.springjdbc_user_capstone.pojo.User;
import com.hexaware.springjdbc_user_capstone.service.IUserService;

/**
 * Hello world!
 *
 */ 
public class App {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		IUserService userService = context.getBean(IUserService.class);

		boolean flag = true;

		while (flag) {
			System.out.println("****WELCOME User Management System ***");
			System.out.println("1. INSERT");
			System.out.println("2. UPDATE");
			System.out.println("3. DELETE");
			System.out.println("4. SELECT BY USERNAME");
			System.out.println("5. SELECT ALL");
			System.out.println("6. EXIT");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:

				User user = readData();

				boolean isInserted = userService.insertUser(user);

				if (isInserted) {
					System.out.println("Record inserted successfully...");
				} else {

					System.err.println("Insert fail");
				}

				break;

			case 2:

				User updatedUser = readData();

				boolean isUpdated = userService.updateUser(updatedUser);

				if (isUpdated) {
					System.out.println("Record Updated successfully...");
				} else {

					System.err.println("Update fail");
				}

				break;

			case 3:

				System.out.println("Enter User Name");

				String uname = scanner.next();

				boolean isDeleted = userService.deleteUserByName(uname);

				if (isDeleted) {
					System.out.println("Record Deleted successfully...");
				} else {

					System.err.println("Delete fail");
				}

				break;

			case 4:

				System.out.println("Enter User Name");

				String uname1 = scanner.next();

			    try {
			        User userFound = userService.selectUserByName(uname1);
			        System.out.println(userFound);
			    } catch (EmptyResultDataAccessException e) {
			        System.err.println("User Not Found");
			    }

				break;

			case 5:

				List<User> list = userService.selectAllUsers();

				for (User u : list) {

					System.out.println(u);

				}

				break;

			case 6:

				flag = false;

				System.out.println("Thanks!! Visit Again");

				break;

			default:
				break;
			}

		}

	}

	public static User readData() {

		User user = new User();

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
