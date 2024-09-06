package com.example.ProductManagementSystem.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Table(name = "product")
@Entity
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;// Product ID

    @NotNull(message = "Name should not be null")
    @NotBlank(message = "Name should not be blank")
    private String name;

    private Double price;

}


