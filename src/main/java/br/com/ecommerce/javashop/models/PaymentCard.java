package br.com.ecommerce.javashop.models;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;


@Entity
@JsonTypeName("paymentCard")
public class PaymentCard extends Payments {

    private Integer numberInstallments;

    private String nameCard;

    private Integer SecurityCode;

    private Integer numberCard;

    public PaymentCard(){}

    public PaymentCard(PaymentStatus paymentStatus, Orders order, Integer numberInstallments, String nameCard, Integer securityCode, Integer numberCard) {
        super(paymentStatus, order);
        this.numberInstallments = numberInstallments;
        this.nameCard = nameCard;
        this.SecurityCode = securityCode;
        this.numberCard = numberCard;
    }

    public Integer getNumberInstallments() {
        return numberInstallments;
    }

    public String getNameCard() {
        return nameCard;
    }

    public Integer getSecurityCode() {
        return SecurityCode;
    }

    public Integer getNumberCard() {
        return numberCard;
    }
}
