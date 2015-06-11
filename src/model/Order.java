package model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "orders", schema = "public", catalog = "smcommerce")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "closed_at")
    private Date closedAt;

    @Column(name = "processed_at")
    private Date processedAt;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;

    @ManyToOne
    private Customer customer;


    public Order() {
        this.orderLines = new ArrayList<OrderLine>();
    }


    public void addProduct(Product product, int quantity) {
        OrderLine orderLine = new OrderLine();
        orderLine.setProduct(product);
        orderLine.setOrder(this);
        orderLine.setQuantity(quantity);
        System.out.println(quantity);
        this.orderLines.add(orderLine);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public Date getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(Date processedAt) {
        this.processedAt = processedAt;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
