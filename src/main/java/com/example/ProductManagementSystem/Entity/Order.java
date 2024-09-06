package com.example.ProductManagementSystem.Entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Table(name = "orders")
@Entity
public class Order {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

      @ManyToOne
      @JoinColumn(name = "customer_id")
      private Customer customer;

	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "order_id")  // Foreign key in Product table
	 private List<Product> products ;




}

