package vn.edu.iuh.fit.backend.configs.models;

import jakarta.persistence.*;
import org.joda.time.DateTime;

@Entity
@Table(name = "product_price")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class ProductPrice {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
    @Id
    private DateTime price_date_time;
    private double price;
    @Column(length = 250, nullable = false)
    private String note;

    public ProductPrice() {
    }

    public ProductPrice(Product product, DateTime price_date_time, double price, String note) {
        this.product = product;
        this.price_date_time = price_date_time;
        this.price = price;
        this.note = note;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "product=" + product +
                ", price_date_time=" + price_date_time +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public DateTime getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(DateTime price_date_time) {
        this.price_date_time = price_date_time;
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
