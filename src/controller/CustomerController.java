package controller;



import facades.CustomerFacade;
import model.Customer;
import model.Order;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;


@ManagedBean
@SessionScoped
public class CustomerController {


    private List<Customer> customerList;
    private List<Order> orderList;

    @EJB
    private CustomerFacade customerFacade;


    @ManagedProperty(value="#{userController}")
    private UserController userController;


    public List<Customer> getCustomerList() {
        return customerFacade.getCustomerList();
    }


    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Order> getOrderList() {
        return userController.getCurrentUser().getCustomer().getOrders();
    }

    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}
