package vn.edu.iuh.fit.week3_lab_lethingocmai_20005501;


import vn.edu.iuh.fit.backend.configs.connection.MySessionFactory;
import vn.edu.iuh.fit.backend.configs.enumClass.EmployeeStatus;
import vn.edu.iuh.fit.backend.configs.models.Customer;
import vn.edu.iuh.fit.backend.configs.models.Employee;
import vn.edu.iuh.fit.backend.configs.repositories.CustomerRepository;
import vn.edu.iuh.fit.backend.configs.repositories.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        MySessionFactory.getInstance();

        EmployeeRepository repository = new EmployeeRepository();
//        Employee e = new Employee("thai", LocalDate.now(),"thai@gmail.com", "0352594707", "Go Vap, HCM", EmployeeStatus.TERMINATED);
//        repository.insertEmp(e);
//        System.out.println(e);

//        List<Employee> list =  repository.getAll();
//        if(list.isEmpty()){
//            System.out.println("List empty");
//        }else {
//            System.out.println("List: ");
//        }
//        for (Employee em : list
//             ) {
//            System.out.println(em);
//        }

        CustomerRepository customerRepository = new CustomerRepository();
        Customer c = new Customer("thai","thai@123","0102345796","Go Vap, HCM");
        customerRepository.insert(c);
        System.out.println(c);
        List<Customer> lst = customerRepository.getAll();
        if(lst.isEmpty()){
            System.out.println("List empty");
        }else {
            System.out.println("List: ");
        }
        for (Customer cus : lst
             ) {
            System.out.println(cus);
        }
    }
}
