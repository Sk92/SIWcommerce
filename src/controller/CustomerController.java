package controller;



import facades.CustomerFacade;
import model.Customer;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;


@ManagedBean
public class CustomerController {


    private List<Customer> customerList;

    @EJB
    private CustomerFacade customerFacade;


    public List<Customer> getCustomerList() {
        return customerFacade.getCustomerList();
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
