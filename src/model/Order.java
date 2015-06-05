package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "order", eager = true)
@RequestScoped
public class Order {

    private String date_of_creation;
    private String closing_date;
    private String date_of_evasion;
    private List<OrderLine> OrderLines;
    public Order(){

    }

    public Order(String date_of_creation, String closing_date, String date_of_evasion) {
        this.date_of_creation = date_of_creation;
        this.closing_date = closing_date;
        this.date_of_evasion = date_of_evasion;
    }

    public String getDate_of_creation() {
        return date_of_creation;
    }

    public void setDate_of_creation(String date_of_creation) {
        this.date_of_creation = date_of_creation;
    }

    public String getClosing_date() {
        return closing_date;
    }

    public void setClosing_date(String closing_date) {
        this.closing_date = closing_date;
    }

    public String getDate_of_evasion() {
        return date_of_evasion;
    }

    public void setDate_of_evasion(String date_of_evasion) {
        this.date_of_evasion = date_of_evasion;
    }
}
