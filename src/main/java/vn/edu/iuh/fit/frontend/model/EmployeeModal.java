package vn.edu.iuh.fit.frontend.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.backend.configs.enumClass.EmployeeStatus;
import vn.edu.iuh.fit.backend.configs.models.Employee;
import vn.edu.iuh.fit.backend.configs.services.EmployeeService;

import java.io.IOException;
import java.sql.Date;

public class EmployeeModal {
    public void insertEmp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("nameEm");
        Date date = Date.valueOf(req.getParameter("dateEm"));
        String address = req.getParameter("addEm");
        String email = req.getParameter("emailEm");
        String phone = req.getParameter("phoneEm");
        String status = req.getParameter("statusEm");
        EmployeeStatus employeeStatus = null;
        if ( status != null){
            switch (status){
                case "0":
                    employeeStatus = EmployeeStatus.INACTIVE;
                    break;
                case "1":
                    employeeStatus = EmployeeStatus.ACTIVE;
                    break;
                case "-1":
                    employeeStatus = EmployeeStatus.TERMINATED;
                    break;
                default:break;
            }
        }
        Employee employee = new Employee(name, date, email, phone, address, employeeStatus);

        EmployeeService employeeService = new EmployeeService();
        employeeService.insert(employee);

        resp.sendRedirect("../webapp/index.jsp");
    }
}
