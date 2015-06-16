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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

@ManagedBean
@SessionScoped
public class UserController {


    private String email;
    private String password;
    private String name;
    private String lastName;
    private String dateOfBirth;
    private String address;

    private User currentUser;

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
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date parsed = null;
        try {
            parsed = format.parse(this.dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date dateOfBirth = new java.sql.Date(parsed.getTime());

        User user = userFacade.createUser(email, password, name, lastName, dateOfBirth, address);
        if (user != null)
            return "index?faces-redirect=true";
        return "register?faces-redirect=true";
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
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


    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
