package facades;

import model.Customer;
import model.Order;
import model.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless(name="customerFacade")
public class CustomerFacade {



    @PersistenceContext(unitName = "smcommerce-unit")
    private EntityManager em;


    public List<Customer> getCustomerList() {
        return em.createNamedQuery("Customer.getAllCustomers", Customer.class).getResultList();
    }


    public List<Order> getOrderList() {
        CriteriaQuery<Order> cq = em.getCriteriaBuilder().createQuery(Order.class);
        cq.select(cq.from(Order.class));
        return em.createQuery(cq).getResultList();
    }




}
