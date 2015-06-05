package model;

import javax.persistence.*;
import java.math.BigInteger;


@Entity
@Table(name = "order_lines", schema = "public", catalog = "smcommerce")
public class OrderLine {
    private BigInteger id;
    private Double sellPrice;
    private BigInteger quantity;
    private Order ordersByOrderId;
    private Product productsByProductId;

    @Id
    @Column(name = "id")
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sell_price")
    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Basic
    @Column(name = "quantity")
    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderLine orderLine = (OrderLine) o;

        if (id != null ? !id.equals(orderLine.id) : orderLine.id != null) return false;
        if (quantity != null ? !quantity.equals(orderLine.quantity) : orderLine.quantity != null) return false;
        if (sellPrice != null ? !sellPrice.equals(orderLine.sellPrice) : orderLine.sellPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sellPrice != null ? sellPrice.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    public Order getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(Order ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public Product getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(Product productsByProductId) {
        this.productsByProductId = productsByProductId;
    }
}
