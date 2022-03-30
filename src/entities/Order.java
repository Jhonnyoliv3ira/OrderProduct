package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	
	private Date moment;
	public String status;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	List<OrderItem> itens = new ArrayList<>();
	private Client client;
	private OrderItem orderItem;
	private Product product;

	public Order() {
		
	}
		
	public Order(Date moment, String status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}



	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}

	public Double total() {
		double sum = 0;
		for(OrderItem c: itens) {
			sum += c.subTotal();
		}
		
		return sum;
	}
		
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}
