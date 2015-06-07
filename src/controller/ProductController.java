package controller;

import model.Product;
import model.ProductFacade;

import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import java.util.List;

@ManagedBean
public class ProductController {

    @EJB
    private ProductFacade productFacade;
    private String name;
    private Double price;
    private String description;
    private String code;
    private int stockQuantity;
    private Product product;
    private List<Product> productList;

    public String createProduct() {
        this.product = productFacade.createProduct(name, code, description, price, stockQuantity);
        return "products";
    }

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProductList() {
        return productFacade.getProductList();
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
