package com.example.ProductManagementSystem.Repository;
import com.example.ProductManagementSystem.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, Integer> {

}
