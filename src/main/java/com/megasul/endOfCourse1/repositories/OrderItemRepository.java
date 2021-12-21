package com.megasul.endOfCourse1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megasul.endOfCourse1.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
