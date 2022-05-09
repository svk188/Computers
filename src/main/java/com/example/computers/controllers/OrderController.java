package com.example.computers.controllers;

import com.example.computers.entities.Orders;
import com.example.computers.entities.OrdersCompleted;
import com.example.computers.repos.OrdersCompletedRepo;
import com.example.computers.repos.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {

   @Autowired
   private OrdersRepo ordersRepo;

   @Autowired
   private OrdersCompletedRepo ordersCompletedRepo;


    @GetMapping("/orders")
    public String orders(Model model) {

        List<Orders> orders = ordersRepo.findAll();

        model.addAttribute("orders", orders);
        model.addAttribute("activeOrders", "active");

        return "orders";
    }


    @PostMapping("/ordersCompleted")
    public String ordersCompleted(
            @RequestParam("orderId") Orders order
    ) {

        OrdersCompleted orderCompleted = new OrdersCompleted(order.getId(), order.getUser(), order.getLaptops(), order.getTablets(), order.getPhones());

        ordersCompletedRepo.save(orderCompleted);

        ordersRepo.delete(order);

        return "redirect:/orders";
    }
}
