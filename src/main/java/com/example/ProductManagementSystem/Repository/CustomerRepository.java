package com.example.ProductManagementSystem.Repository;
import com.example.ProductManagementSystem.Entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    Optional<Customer> findById(Integer id);
}
