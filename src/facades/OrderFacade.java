package facades;

import model.Customer;
import model.Order;
import model.OrderLine;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.util.List;

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


    public Customer findCustomerByOrderId(Long id) {
        List<Order> orderList = em.createNamedQuery("Order.findById", Order.class).setParameter("id", id).getResultList();
        return (orderList.size() > 0) ? orderList.get(0).getCustomer() : null;
    }

    public List<Order> getUnprocessedOrders() {
        return em.createNamedQuery("Order.getUnprocessedOrders", Order.class).getResultList();
    }

    public void processOrder(Long orderId) {
        Order order = em.find(Order.class, orderId);
        boolean canProcess = true;
        for(OrderLine orderLine : order.getOrderLines()) {
            if (orderLine.getProduct().getStockQuantity() < orderLine.getQuantity()) {
                canProcess = false;
            }
        }
        if (canProcess) {
            for(OrderLine orderLine : order.getOrderLines()) {
                orderLine.getProduct().setStockQuantity(orderLine.getProduct().getStockQuantity() - orderLine.getQuantity());
            }
            order.setProcessedAt(new Date(System.currentTimeMillis()));
        }
        else {
            FacesMessage message = new FacesMessage("Non è stato possibile processare l'ordine "+order.getId()+": non tutti i prodotti richiesti sono presenti in magazzino");
            FacesContext.getCurrentInstance().addMessage("processOrder_"+order.getId(), message);
        }
    }
}
