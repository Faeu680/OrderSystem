package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		 Scanner sc = new Scanner(System.in);
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		 System.out.println("Enter client data: ");
		 System.out.print("Name: ");
		 sc.next();
		 String name = sc.nextLine();
		 System.out.print("E-mail: ");
		 sc.next();
		 String email = sc.nextLine();
		 System.out.print("Birth date (DD/MM/YYYY): ");
		 Date birthdate = sdf.parse(sc.next());
		 
		 Client client = new Client(name, email, birthdate);
		 
		 System.out.println("Enter order data: ");
		 System.out.print("Satus: ");
		 OrderStatus status = OrderStatus.valueOf(sc.next());
		 
		 Order order = new Order(new Date(), status, client);
		 
		 System.out.println("How many items to this order: ");
		 int numberOrder = sc.nextInt();
		 
		 for (int i=0; i<numberOrder; i++) {
			 System.out.println("Enter item " + (i+1) + " data: ");
			 System.out.println("Product name: ");
			 sc.nextLine();
			 String productName = sc.nextLine();
			 System.out.print("Product Price: $");
			 double productPrice =  sc.nextDouble();
			 System.out.print("Quantity: ");
			 int quantity = sc.nextInt();
			 
			 Product product = new Product(productName, productPrice);
			
			 OrderItem it = new OrderItem(quantity, productPrice, product);
			 
			 order.addItem(it);
		 }
		 System.out.println();
		 System.out.println(order);
		 
		
		sc.close();
	}
}
