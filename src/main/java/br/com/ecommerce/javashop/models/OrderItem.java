package br.com.ecommerce.javashop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @JsonIgnore
    private OrderItemPK id = new OrderItemPK();

    private BigDecimal discount;

    private BigDecimal price;

    private Integer amount;

    public OrderItem() {
    }

    public OrderItem(BigDecimal discount, BigDecimal price, Integer amount, Orders order, Products product) {
        this.discount = discount;
        this.price = price;
        this.amount = amount;
        this.id.setOrder(order);
        this.id.setProduct(product);
    }

    public OrderItemPK getId() {
        return id;
    }

    public void setId(OrderItemPK id) {
        this.id = id;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Orders getOrders() {

        return id.getOrder();
    }

    public void setOrders(Orders order) {
        id.setOrder(order);
    }

    public Products getProducts() {

        return id.getProduct();
    }

    public void setProducts(Products product) {
        id.setProduct(product);
    }

    public BigDecimal subTotal() {

        return new BigDecimal(this.getAmount()).multiply((this.getPrice().subtract(this.getDiscount())));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return id.equals(orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
