package com.desafiospring01;

import com.desafiospring01.entities.Order;
import com.desafiospring01.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan({"com.desafiospring01"})
public class Desafiospring01Application implements CommandLineRunner {

	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Desafiospring01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Order order1 = new Order(1034, 150.0, 20.0);
		Order order2 = new Order(2282, 800.0, 10.0);
		Order order3 = new Order(1309, 95.90, 0.0);

		List<Order> orderList = new ArrayList<>();
		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);

		System.out.println("*************************** ");
		for (Order lista : orderList) {
			System.out.println("Pedido código " + lista.getCode());
			System.out.println("Valor total: R$ " + String.format("%.2f", orderService.total(lista)));
			System.out.println();
		}
	}
}
