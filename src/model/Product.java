package model;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by alessandro on 05/06/15.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Product.getAllProducts", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.findProductById", query = "SELECT p FROM Product p WHERE p.id = :id")
})
@Table(name = "products", schema = "public", catalog = "smcommerce")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @ManyToOne
    private Provider provider;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
