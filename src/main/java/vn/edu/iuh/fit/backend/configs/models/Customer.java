package vn.edu.iuh.fit.backend.configs.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = "Customer.getAll", query = "select c from Customer c ")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cus_id;
    @Column(length = 150, nullable = false)
    private String cus_name;
    @Column(unique = true, length = 150)
    private String email;
    @Column(length = 15, nullable = false)
    private String phone;
    @Column(length = 250, nullable = false)
    private String address;
    @OneToMany(mappedBy = "customer")
    private List<Order> orderList;

    public Customer() {
    }



    public Customer(String cus_name, String email, String phone, String address) {
        this.cus_name = cus_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cus_id=" + cus_id +
                ", cus_name='" + cus_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address +
                '}';
    }

    public long getCus_id() {
        return cus_id;
    }

    public void setCus_id(long cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
