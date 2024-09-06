package com.example.ProductManagementSystem.Repository;
import com.example.ProductManagementSystem.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer > {

}


