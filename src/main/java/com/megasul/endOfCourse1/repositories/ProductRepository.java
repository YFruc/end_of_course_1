package com.megasul.endOfCourse1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.megasul.endOfCourse1.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

}
