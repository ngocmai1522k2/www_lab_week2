package vn.edu.iuh.fit.backend.configs.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "order_detail")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@IdClass(OrderDetailPK.class)
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private double quantity;
    private double price;
    @Column(length = 250, nullable = false)
    private String note;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product, double quantity, double price, String note) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
@Embeddable
class OrderDetailPK implements Serializable {
    private long order;
    private long product;

    public OrderDetailPK() {

    }

    public OrderDetailPK(long order, long product) {
        this.order = order;
        this.product = product;
    }
}

