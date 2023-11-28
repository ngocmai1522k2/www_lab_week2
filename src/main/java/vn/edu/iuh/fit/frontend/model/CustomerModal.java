package vn.edu.iuh.fit.frontend.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.configs.models.Customer;
import vn.edu.iuh.fit.backend.configs.services.CustomerServices;

public class CustomerModal {
    public void insertCus(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("nameCus");
        String add = req.getParameter("addCus");
        String email = req.getParameter("emailCus");
        String phone = req.getParameter("phoneCus");

        Customer customer = new Customer(name, email, phone, add);
        CustomerServices customerService = new CustomerServices();
        customerService.insert(customer);

    }
}
