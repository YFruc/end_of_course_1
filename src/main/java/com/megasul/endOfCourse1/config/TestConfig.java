package com.megasul.endOfCourse1.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.megasul.endOfCourse1.entities.Category;
import com.megasul.endOfCourse1.entities.Order;
import com.megasul.endOfCourse1.entities.OrderItem;
import com.megasul.endOfCourse1.entities.Payment;
import com.megasul.endOfCourse1.entities.Product;
import com.megasul.endOfCourse1.entities.User;
import com.megasul.endOfCourse1.entities.enums.OrderStatus;
import com.megasul.endOfCourse1.repositories.CategoryRepository;
import com.megasul.endOfCourse1.repositories.OrderItemRepository;
import com.megasul.endOfCourse1.repositories.OrderRepository;
import com.megasul.endOfCourse1.repositories.ProductRepository;
import com.megasul.endOfCourse1.repositories.UserRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "TVs");

		Product p1 = new Product(null, "Lord of the Rings", "Use The Force, Harry... ~Arthur Dent", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "It is smart. It knows.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Like a normal Macbook, but more expensive", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "WOW, NICE GRAPHICS !!", 1200.0, "");
		Product p5 = new Product(null, "Focusing for Dummies", "You won't be able to look away from  ", 100.99, "");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategories().add(cat2);

		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);

		p3.getCategories().add(cat1);

		p4.getCategories().add(cat1);

		p5.getCategories().add(cat2);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		// ----------------------------------------------------------------------

		User u1 = new User(null, "Candice", "candice@gmail.com", "2", "123456");
		User u2 = new User(null, "Joe", "joe@gmail.com", "977777777", "654321");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T02:42:10Z"), u2, OrderStatus.SHIPPED);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.DELIVERED);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}

}
