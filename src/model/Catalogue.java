package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "catalogue", eager = true)
@RequestScoped
public class Catalogue {

    private List<Product> products;

    public Catalogue() {
        this.products = new LinkedList<Product>();
        this.products.add(new Product("penna bella", "PN1", 10f, "Una fantastica penna", 2));
        this.products.add(new Product("matita bella", "MT1", 5f, "Una fantastica matita", 1));
    }

    public void addProduct(String name, String code, Float price, String description, int quantity) {
        Product product = new Product(name, code, price, description, quantity);
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
