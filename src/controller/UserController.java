package controller;

import facades.OrderFacade;
import facades.ProductFacade;
import facades.UserFacade;
import model.Order;
import model.Product;
import model.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.math.BigInteger;
import java.util.Map;

@ManagedBean
@SessionScoped
public class UserController {


    private String email;
    private String password;
    private String name;
    private String lastName;
    private User currentUser;
    private Order currentOrder;

    private String productQuantity;

    @EJB
    private UserFacade userFacade;

    @EJB
    private OrderFacade orderFacade;

    @EJB
    private ProductFacade productFacade;


    public String login() {
        currentUser = userFacade.findByEmail(email);

        if (currentUser != null) {
            if (currentUser.checkPassword(password)) {
                return "index?faces-redirect=true";
            }
        }
        return "login?faces-redirect=true";
    }

    public String register() {
        User user = userFacade.createUser(email, password, name, lastName);
        if (user != null)
            return "index?faces-redirect=true";
        return "register?faces-redirect=true";
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }


    public String addProductToOrder() {
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String productId = params.get("id");
        Product product = productFacade.getProductById(Long.parseLong(productId));
        if (currentOrder == null)
            currentOrder = orderFacade.createOrder();

        //TODO: add customer to currentOrder
        currentOrder.addProduct(product, 1);
        return "products?faces-redirect=true";
    }

    public String nullifyOrder() {
        this.currentOrder = null;
        return "products?faces-redirect=true";
    }


    public String confirmOrder() {
        orderFacade.saveOrder(this.currentOrder);
        this.currentOrder = null;
        return "myOrders?faces-redirect=true";
    }



    public boolean isLoggedIn() {
        return (currentUser != null);
    }

    public boolean isAdmin() {
        return (this.isLoggedIn() && currentUser.getRole().equals("admin"));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }


    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }
}
