package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "loginController", eager = true)
@RequestScoped
public class LoginController {

    public String MoveToLogin(){
        return "login";
    }
    }




