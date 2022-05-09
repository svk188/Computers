package com.example.computers.repos;

import com.example.computers.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders, Long> {

}
