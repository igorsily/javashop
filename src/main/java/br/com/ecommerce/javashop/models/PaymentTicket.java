package br.com.ecommerce.javashop.models;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;


@Entity
@JsonTypeName("paymentTicket")
public class PaymentTicket extends Payments {

    private Calendar dueDate;

    private Calendar payDay;

    public  PaymentTicket(){}

    public PaymentTicket(PaymentStatus paymentStatus, Orders order, Calendar dueDate, Calendar payDay) {
        super(paymentStatus, order);
        this.dueDate = dueDate;
        this.payDay = payDay;
    }
}
