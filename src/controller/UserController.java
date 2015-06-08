package controller;

import facades.UserFacade;
import model.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UserController {


    private String email;
    private String password;
    private String name;
    private String lastName;
    private User currentUser;

    @EJB
    private UserFacade userFacade;


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

    public boolean isLoggedIn() {
        return (currentUser != null);
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
}
