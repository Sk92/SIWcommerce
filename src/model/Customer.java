package model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;


@Entity
@NamedQuery(name = "Customer.getAllCustomers", query = "SELECT c FROM Customer c")
@Table(name = "customers", schema = "public", catalog = "smcommerce")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;


    @OneToOne
    private User user;

    @OneToMany
    private Collection<Order> orders;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}
