package com.megasul.endOfCourse1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megasul.endOfCourse1.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
