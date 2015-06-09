package controller;


import facades.OrderFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
public class OrderController {

    @EJB
    private OrderFacade orderFacade;




}
