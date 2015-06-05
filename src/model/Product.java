package model;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by alessandro on 05/06/15.
 */
@Entity
@NamedQuery(name="Product.getAllProducts", query="SELECT p FROM Product p")
@Table(name = "products", schema = "public", catalog = "smcommerce")
public class Product {
    private BigInteger id;
    private String name;
    private String code;
    private String description;
    private Double price;
    private int stockQuantity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "stock_quantity")
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public boolean equals(Object o) {
        //TODO
        return true;
    }

    @Override
    public int hashCode() {
        //TODO
        return 1;
    }
}
