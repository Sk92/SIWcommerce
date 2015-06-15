package controller;


import facades.OrderFacade;
import model.Customer;
import model.Order;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;

@ManagedBean
public class OrderController {

    @EJB
    private OrderFacade orderFacade;

    private Long orderId;
    private Customer requestedCustomer;
    private List<Order> unprocessedOrders;

    public String processOrder() {
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long orderId = Long.parseLong(params.get("id"));

        orderFacade.processOrder(orderId);
        return "unprocessedOrder";
    }

    public List<Order> getUnprocessedOrders() {
        return orderFacade.getUnprocessedOrders();
    }


    public String findCustomerByOrderId() {
        this.requestedCustomer = orderFacade.findCustomerByOrderId(orderId);
        return "searchCustomer";
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Customer getRequestedCustomer() {
        return requestedCustomer;
    }

    public void setRequestedCustomer(Customer requestedCustomer) {
        this.requestedCustomer = requestedCustomer;
    }
}
