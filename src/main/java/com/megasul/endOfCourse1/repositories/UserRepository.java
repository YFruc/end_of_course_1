package com.megasul.endOfCourse1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.megasul.endOfCourse1.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
