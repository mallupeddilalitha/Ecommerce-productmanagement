package com.example.ProductManagementSystem.Entity;
import jakarta.persistence.*;
import lombok.Data;


@Table(name = "customer")

@Data
@Entity
public class Customer {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Customer ID
    
    private String name;
    private String email;


    }


