package com.bigcat.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty
    private String checkout;
    private String checkin;

    public BikeRent(String customername, String checkout, String checkin) {
        this.setCustomername(customername);
        this.setCheckout(checkout);
        this.setCheckin(checkin);
    }

    public Long getBikeid() {
        return bikeid;
    }

    public void setBikeid(Long bikeid) {
        this.bikeid = bikeid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }
}