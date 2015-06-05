package model;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "customer", eager = true)
@RequestScoped
public class Customer {
    private String name;
    private String surname;
    private String address;
    private String email;
    private String date_of_birth;
    private String date_of_registration;

    public Customer(){
    }

    public Customer(String name, String surname, String address, String email, String date_of_birth, String date_of_registration) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.date_of_registration = date_of_registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getDate_of_registration() {
        return date_of_registration;
    }

    public void setDate_of_registration(String date_of_registration) {
        this.date_of_registration = date_of_registration;
    }
}
