package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "orderLine", eager = true)
@RequestScoped
public class OrderLine {
    private float unity_price;
    private int quantity;


    public OrderLine(){

    }

    public float getUnity_price() {
        return unity_price;
    }

    public void setUnity_price(float unity_price) {
        this.unity_price = unity_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderLine(float unity_price, int quantity) {

        this.unity_price = unity_price;
        this.quantity = quantity;
    }
}
