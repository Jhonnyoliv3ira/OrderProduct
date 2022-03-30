package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yy");
		
		
		

		System.out.println("Enter the client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("BirthDate: ");
		Date date = sdf1.parse(sc.next());
		Client client = new Client(name, email, date);

		System.out.println("Order Data: ");
		Date moment = new Date();
		System.out.print("Status: ");
		sc.nextLine();
		String status = sc.nextLine();
		Order order = new Order(moment, status, client);
		System.out.println("how many itens to this order? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter #" + i + "Item Data: ");
			System.out.println("Product Name: ");
			sc.nextLine();
			String produto = sc.nextLine();
			System.out.println("Product Price: ");
			Double price = sc.nextDouble();
			System.out.println("Quantity: ");
			Integer quantity = sc.nextInt();
			Product product = new Product(produto, price);
			OrderItem orderItem = new OrderItem(quantity, product, price);
			order.addItem(orderItem);

		}

		System.out.println("Order Sumary: ");
		System.out.println(order);
		
		
	}

}
