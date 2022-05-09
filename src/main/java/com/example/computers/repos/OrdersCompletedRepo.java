package com.example.computers.repos;

import com.example.computers.entities.OrdersCompleted;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersCompletedRepo extends JpaRepository<OrdersCompleted, Long> {

}
