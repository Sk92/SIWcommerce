package facades;


import model.Product;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.*;
import java.math.BigInteger;
import java.util.List;

@Stateless(name="productFacade")
public class ProductFacade {


    @PersistenceContext(unitName = "smcommerce-unit")
    private EntityManager em;

    public ProductFacade() {

    }

    public Product createProduct(String name, String code, String description, Double price, int stockQuantity) {
        Product product = new Product();
        product.setName(name);
        product.setCode(code);
        product.setDescription(description);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        em.persist(product);
        return product;
    }


    public List<Product> getProductList() {
        return em.createNamedQuery("Product.getAllProducts", Product.class).getResultList();
    }

    public Product getProductById(Long id) {
        //List<Product> productList = em.createNamedQuery("Product.findProductById", Product.class).setParameter("id", id).getResultList();
        //return productList.get(0);
        return em.find(Product.class, id);
    }



}
