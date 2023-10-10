package vn.edu.iuh.fit.backend.configs.services;

import vn.edu.iuh.fit.backend.configs.models.Employee;
import vn.edu.iuh.fit.backend.configs.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    public EmployeeRepository employeeRepository ;
    public EmployeeService() { employeeRepository = new EmployeeRepository(); }

    public List<Employee> getAll(){
        return  employeeRepository.getAll();
    }
    public boolean update(Employee employee){
        return employeeRepository.update(employee);
    }
    public void insert(Employee employee){
        employeeRepository.insertEmp(employee);
    }
    public boolean delete(long id){
        return employeeRepository.delete(id);
    }
    public boolean activeEmp(long id){
        return  employeeRepository.activeEmp(id);
    }
    public Optional<Employee> findByID(long id){
        return employeeRepository.findById(id);
    }
}
