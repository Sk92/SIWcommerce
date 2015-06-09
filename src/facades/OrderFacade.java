package facades;

import model.Order;
import model.OrderLine;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;

@Stateless(name="orderFacade")
public class OrderFacade {




    @PersistenceContext(unitName = "smcommerce-unit")
    private EntityManager em;

    public OrderFacade() {

    }


    public Order createOrder() {
        Order order = new Order();
        order.setCreatedAt(new Date(System.currentTimeMillis()));
        return order;
    }


    public void saveOrder(Order currentOrder) {
        em.persist(currentOrder);
    }
}
