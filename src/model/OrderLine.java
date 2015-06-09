package model;

import javax.persistence.*;
import java.math.BigInteger;


@Entity
@Table(name = "order_lines", schema = "public", catalog = "smcommerce")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "sell_price")
    private Double sellPrice;

    @Column(name = "quantity")
    private BigInteger quantity;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @OneToOne
    private Product product;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
