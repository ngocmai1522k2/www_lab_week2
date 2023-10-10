package vn.edu.iuh.fit.backend.configs.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long image_id;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
    @Column(length = 250, nullable = false)
    private String path;
    @Column(length = 250)
    private String alternative;

    public ProductImage(Product product, String path, String alternative) {
        this.product = product;
        this.path = path;
        this.alternative = alternative;
    }

    public ProductImage(long image_id, Product product, String path, String alternative) {
        this.image_id = image_id;
        this.product = product;
        this.path = path;
        this.alternative = alternative;
    }

    public ProductImage() {
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "image_id=" + image_id +
                ", product=" + product +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                '}';
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }
}
