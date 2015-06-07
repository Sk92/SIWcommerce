package model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;


@Entity
@Table(name = "customers", schema = "public", catalog = "smcommerce")
public class Customer {
    private BigInteger id;
    private String address;
    private Date dateOfBirth;
    private User usersByUserId;
    private Collection<Order> ordersesById;

    @Id
    @Column(name = "id")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(customer.dateOfBirth) : customer.dateOfBirth != null) return false;
        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(User usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @OneToMany(mappedBy = "getCustomersByCustomerId")
    public Collection<Order> getOrdersesById() {
        return ordersesById;
    }

    public void setOrdersesById(Collection<Order> ordersesById) {
        this.ordersesById = ordersesById;
    }
}
