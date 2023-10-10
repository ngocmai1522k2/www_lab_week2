package vn.edu.iuh.fit.backend.configs.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.backend.configs.enumClass.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@NamedQueries(value={
        @NamedQuery(name = "Product.findAll", query = "select p from Product p where p.status = 1")
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productID;
    @Column(length = 150, nullable = false)
    private String name;
    @Column(length = 250, nullable = false)
    private String description;
    @Column(length = 25, nullable = false)
    private String unit;
    @Column(length = 150, nullable = false)
    private String manufacturer_name;
    @Column(columnDefinition = "int", nullable = false)
    private ProductStatus status;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> imageList;

    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPriceList;

    @OneToMany(mappedBy = "product",  cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetailList;

    public Product() {
    }


    public Product(long productID, String name, String description, String unit, String manufacturer_name, ProductStatus status, List<ProductImage> imageList, List<ProductPrice> productPriceList, List<OrderDetail> orderDetailList) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
        this.imageList = imageList;
        this.productPriceList = productPriceList;
        this.orderDetailList = orderDetailList;
    }

    public Product(String name, String description, String unit, String manufacturer_name, ProductStatus status) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer_name = manufacturer_name;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer_name='" + manufacturer_name + '\'' +
                ", status=" + status +
                ", imageList=" + imageList +
                ", productPriceList=" + productPriceList +
                ", orderDetailList=" + orderDetailList +
                '}';
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public List<ProductImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<ProductImage> imageList) {
        this.imageList = imageList;
    }

    public List<ProductPrice> getProductPriceList() {
        return productPriceList;
    }

    public void setProductPriceList(List<ProductPrice> productPriceList) {
        this.productPriceList = productPriceList;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
