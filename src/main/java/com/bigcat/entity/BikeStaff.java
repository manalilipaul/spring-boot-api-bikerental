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

public class BikeStaff {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long staffid;
    @NotEmpty
    private String staffname;
    @NotEmpty
    private String staffrole;

    public BikeStaff(String staffname, String staffrole) {
        this.setStaffname(staffname);
        this.setStaffrole(staffrole);
    }


    public Long getStaffid() {
        return staffid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffrole() {
        return staffrole;
    }

    public void setStaffrole(String staffrole) {
        this.staffrole = staffrole;
    }
}
