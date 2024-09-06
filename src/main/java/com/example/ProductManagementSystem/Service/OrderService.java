package com.example.ProductManagementSystem.Service;
import com.example.ProductManagementSystem.Entity.Customer;
import com.example.ProductManagementSystem.Entity.Order;
import com.example.ProductManagementSystem.Entity.Product;
import com.example.ProductManagementSystem.Exceptions.ResourceNotFoundException;
import com.example.ProductManagementSystem.Repository.CustomerRepository;
import com.example.ProductManagementSystem.Repository.OrderRepository;
import com.example.ProductManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {


	 @Autowired
   private OrderRepository orderRepository;

   @Autowired
   private CustomerRepository customerRepository;

   @Autowired
   private ProductRepository productRepository;

   @Autowired
   private CustomerService customerService;


   public Order createOrder(Integer customerId, List<Product> products) {
      Customer customer = customerService.getCustomerById(customerId);

      Order order = new Order();
      order.setCustomer(customer);
      order.setProducts(products);

      return orderRepository.save(order);
   }

   public Order getOrderById(Integer orderId) {
      return orderRepository.findById(orderId)
              .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
   }

   public List<Order> getAllOrders() {
      return orderRepository.findAll();
   }

   public Order updateOrder(Integer orderId, Order updatedOrder) {
      Order existingOrder = getOrderById(orderId);
      existingOrder.setCustomer(updatedOrder.getCustomer());
      existingOrder.setProducts(updatedOrder.getProducts());
      return orderRepository.save(existingOrder);
   }

   public void deleteOrder(Integer orderId) {
      Order order = getOrderById(orderId);
      orderRepository.delete(order);
   }


}

