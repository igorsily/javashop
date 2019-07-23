package br.com.ecommerce.javashop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Payments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private  Long id;

    private Integer paymentStatus;


    @OneToOne
    @MapsId
    @JsonIgnore
    @JoinColumn(name = "order")
    private Orders order;

    public  Payments() {

    }

    public Payments( PaymentStatus paymentStatus, Orders order) {

        this.paymentStatus = (paymentStatus == null) ? null : paymentStatus.getCode();
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentStatus getPaymentStatus() {
        return PaymentStatus.toEnum(paymentStatus);
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus.getCode();
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payments payments = (Payments) o;
        return id.equals(payments.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
