package model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;


@Entity
@Table(name = "orders", schema = "public", catalog = "smcommerce")
public class Order {
    private BigInteger id;
    private Date createdAt;
    private Date closedAt;
    private Date processedAt;
    private Collection<OrderLine> orderRowsesById;
    private Customer customersByCustomerId;
    private Collection<Provider> providersesById;

    @Id
    @Column(name = "id")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "closed_at")
    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    @Basic
    @Column(name = "processed_at")
    public Date getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(Date processedAt) {
        this.processedAt = processedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (closedAt != null ? !closedAt.equals(order.closedAt) : order.closedAt != null) return false;
        if (createdAt != null ? !createdAt.equals(order.createdAt) : order.createdAt != null) return false;
        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (processedAt != null ? !processedAt.equals(order.processedAt) : order.processedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (closedAt != null ? closedAt.hashCode() : 0);
        result = 31 * result + (processedAt != null ? processedAt.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ordersByOrderId")
    public Collection<OrderLine> getOrderRowsesById() {
        return orderRowsesById;
    }

    public void setOrderRowsesById(Collection<OrderLine> orderRowsesById) {
        this.orderRowsesById = orderRowsesById;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public Customer getCustomersByCustomerId() {
        return customersByCustomerId;
    }

    public void setCustomersByCustomerId(Customer clientsByCustomerId) {
        this.customersByCustomerId = clientsByCustomerId;
    }

    @OneToMany(mappedBy = "ordersByOrderId")
    public Collection<Provider> getProvidersesById() {
        return providersesById;
    }

    public void setProvidersesById(Collection<Provider> providersesById) {
        this.providersesById = providersesById;
    }
}
