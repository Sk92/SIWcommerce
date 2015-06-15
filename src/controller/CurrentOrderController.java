package controller;

import facades.OrderFacade;
import facades.ProductFacade;
import facades.UserFacade;
import model.Order;
import model.Product;
import model.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@ManagedBean
@SessionScoped
public class CurrentOrderController {


    @ManagedProperty(value="#{userController}")
    private UserController userController;

    private Order currentOrder;

    @EJB
    private UserFacade userFacade;

    @EJB
    private OrderFacade orderFacade;

    @EJB
    private ProductFacade productFacade;


    private int orderQuantity;


    public String setOrderQuantity() {
        //Nothing to do
        return "";
    }


    public String addProductToOrder() {
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String productId = params.get("id");
        Product product = productFacade.getProductById(Long.parseLong(productId));


        if (currentOrder == null)
            currentOrder = orderFacade.createOrder();

        if (userController.getCurrentUser().getCustomer() != null)
            currentOrder.setCustomer(userController.getCurrentUser().getCustomer());
        currentOrder.addProduct(product, orderQuantity);
        orderQuantity = 0;
        return "products";
    }


    public String nullifyOrder() {
        this.currentOrder = null;
        return "products?faces-redirect=true";
    }


    public String confirmOrder() {
        this.currentOrder.setClosedAt(new Date(System.currentTimeMillis()));
        orderFacade.saveOrder(this.currentOrder);
        this.currentOrder = null;
        return "myOrders?faces-redirect=true";
    }


    public UserController getUserController() {
        return userController;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
}
