package br.com.ecommerce.javashop.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar instante;

    @OneToOne(cascade = CascadeType.ALL)
    private Payments payment;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Address deliveryAddress;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<OrderItem>();

    public  Orders(){}

    public Orders(Calendar instante, Payments payment, Client client, Address deliveryAddress) {
        this.instante = instante;
        this.payment = payment;
        this.client = client;
        this.deliveryAddress = deliveryAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getInstante() {
        return instante;
    }

    public void setInstante(Calendar instante) {
        this.instante = instante;
    }

    public Payments getPayment() {
        return payment;
    }

    public void setPayment(Payments payment) {
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public BigDecimal total(){

        BigDecimal total = new BigDecimal(0);

        getItems().stream().map(item -> total.add(item.subTotal()));

        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id.equals(orders.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
