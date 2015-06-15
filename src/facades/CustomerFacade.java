package facades;

import model.Customer;
import model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless(name="customerFacade")
public class CustomerFacade {



    @PersistenceContext(unitName = "smcommerce-unit")
    private EntityManager em;


    public List<Customer> getCustomerList() {
        return em.createNamedQuery("Customer.getAllCustomers", Customer.class).getResultList();
    }





}
