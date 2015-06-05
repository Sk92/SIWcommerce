package model;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "vendor", eager = true)
@RequestScoped
public class Vendor {

    private String address;
    private String email;
    private String telephone;
    private String p_iva;


    public Vendor(){

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getP_iva() {
        return p_iva;
    }

    public void setP_iva(String p_iva) {
        this.p_iva = p_iva;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Vendor(String address, String email, String telephone, String p_iva) {

        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.p_iva = p_iva;
    }
}
