package com.orderservice.order.repo;


import com.orderservice.order.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,Integer> {
    Optional<User> findByUserName(String username);
}