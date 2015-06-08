package facades;


import model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless(name="pFacade")
public class ProductFacade {


    @PersistenceContext(unitName = "smcommerce-unit")
    private EntityManager em;

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
}
