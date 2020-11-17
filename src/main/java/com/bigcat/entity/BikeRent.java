package com.bigcat.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.jni.Time;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;


@Entity
@Getter
@ToString
@NoArgsConstructor

public class BikeRent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bikeid;
    @NotEmpty
    private String customername;

    @Column(name = "checkin", nullable = false)
    @CreationTimestamp
    private Date checkin;

    private Date checkout;
    private Long Timespent;

    @Column(name = "datemodified", nullable = false)
    @UpdateTimestamp
    private Date datemodified;

    public BikeRent(String customername, Date checkout) {

        long d = System.currentTimeMillis();
        Date date=new Date(d);

        this.setCustomername(customername);
        this.setCheckin(date);
        this.setCheckout(checkout);

        if (checkout != null) {
            long difference = checkout.getTime() - date.getTime();
            this.setTimespent(difference);
        }
    }

    public Long getBikeid() {
        return bikeid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
        if (checkout!=null) {
            long difference = this.checkout.getTime() - getCheckin().getTime();
            this.setTimespent(difference);
        }
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public void setTimespent(Long timespent) {
        Timespent = timespent;
    }
}


