package vn.edu.iuh.fit.frontend.controllers;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.backend.configs.models.Customer;
import vn.edu.iuh.fit.backend.configs.models.Employee;
import vn.edu.iuh.fit.backend.configs.repositories.CustomerRepository;
import vn.edu.iuh.fit.backend.configs.repositories.EmployeeRepository;
import vn.edu.iuh.fit.frontend.model.CustomerModal;
import vn.edu.iuh.fit.frontend.model.EmployeeModal;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    EmployeeRepository employeeRepository = new EmployeeRepository();
    CustomerRepository customerRepository = new CustomerRepository();

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if(action.equals("emp_list")){
            try {
                listEmp(request, response);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        if(action.equals("cust_list")){
            try {
                listCus(request, response);
            }catch (Exception e){
                throw  new RuntimeException();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("insertUpdateEmployee")){
            try {
                EmployeeModal employeeModal = new EmployeeModal();
                employeeModal.insertEmp(req, resp);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        if(action.equals("insertUpdateCus")){
            try {
                CustomerModal customerModal = new CustomerModal();
                customerModal.insertCus(req, resp);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }

    }

    public List<Employee> listEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        List<Employee> employees = employeeRepository.getAll();
        request.setAttribute("listEmployees", employees);
        request.getRequestDispatcher("/listEmployees.jsp")
                .forward(request, response);
        return null;
    }

    public List<Customer> listCus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customer = customerRepository.getAll();
        request.setAttribute("listCustomer", customer);
        request.getRequestDispatcher("/listCustomer.jsp")
                .forward(request, response);
        return null;
    }

    public void destroy() {
    }
}