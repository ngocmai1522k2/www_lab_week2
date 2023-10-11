package vn.edu.iuh.fit.backend.configs.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import vn.edu.iuh.fit.backend.configs.enumClass.EmployeeStatus;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e where e.status= 0"),
        @NamedQuery(name = "Employee.findByID", query = "select e from Employee e where e.id =: id")
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long emp_id;
    @Column(length = 150, nullable = false)
    private String full_name;
    @Column(nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private Date dob;
    @Column(unique = true, length = 150)
    private String email;
    @Column(length = 15, nullable = false)
    private String phone;
    @Column(length = 250, nullable = false)
    private String address;
    @Column(columnDefinition = "int", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus status;
    @OneToMany(mappedBy = "employee")
    private List<Order> orderList;



    public Employee(String full_name, Date dob, String email, String phone, String address, EmployeeStatus e) {
        this.full_name = full_name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = e;
    }



    public Employee() {

    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", full_name='" + full_name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
