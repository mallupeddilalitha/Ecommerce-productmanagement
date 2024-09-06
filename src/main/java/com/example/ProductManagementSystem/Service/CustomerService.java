package com.example.ProductManagementSystem.Service;
import com.example.ProductManagementSystem.Entity.Customer;
import com.example.ProductManagementSystem.Exceptions.ResourceNotFoundException;
import com.example.ProductManagementSystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
    public class CustomerService {


	@Autowired
	private CustomerRepository customerRepository;


    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Integer id) {
        return (Customer) customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }
    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Update an existing customer
    public Customer updateCustomer(Integer id, Customer customerDetails) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        existingCustomer.setName(customerDetails.getName());
        existingCustomer.setEmail(customerDetails.getEmail());
        // Update other fields as necessary

        return customerRepository.save(existingCustomer);
    }

    // Delete a customer by ID
    public void deleteCustomer(Integer id) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        customerRepository.delete(existingCustomer);
    }
}


