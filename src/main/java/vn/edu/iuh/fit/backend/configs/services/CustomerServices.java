package vn.edu.iuh.fit.backend.configs.services;

import vn.edu.iuh.fit.backend.configs.models.Customer;
import vn.edu.iuh.fit.backend.configs.models.Employee;
import vn.edu.iuh.fit.backend.configs.repositories.CustomerRepository;

import java.util.List;

public class CustomerServices {
    public CustomerRepository customerRepository;
    public CustomerServices(){
        customerRepository = new CustomerRepository();
    }
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }
    public boolean insert(Customer customer) {
        return customerRepository.insert(customer);
    }
}
