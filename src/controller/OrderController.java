package controller;


import facades.OrderFacade;
import model.Customer;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
public class OrderController {

    @EJB
    private OrderFacade orderFacade;

    private Long orderId;
    private Customer requestedCustomer;



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
