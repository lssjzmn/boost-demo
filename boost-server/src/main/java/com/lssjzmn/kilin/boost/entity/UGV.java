package com.lssjzmn.kilin.boost.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class UGV implements Serializable{

    private static final long serialVersionUID = -7825783884747790532L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "serialId")
    private  String  serialId;

    @Column(name = "manufactureTime")
    private Long   manufactureTime;

    @Column(name = "lastOnlineTime")
    private Long   lastOnlineTime;

    @Column(name = "totalMileage")
    private Long  totalMileage;

    @Column(name = "totalWorkTime")
    private Long  totalWorkTime;

    @Column(name = "ownerShip")
    private String ownerShip;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public Long getManufactureTime() {
        return manufactureTime;
    }

    public void setManufactureTime(Long manufactureTime) {
        this.manufactureTime = manufactureTime;
    }

    public Long getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void setLastOnlineTime(Long lastOnlineTime) {
        this.lastOnlineTime = lastOnlineTime;
    }

    public Long getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(Long totalMileage) {
        this.totalMileage = totalMileage;
    }

    public Long getTotalWorkTime() {
        return totalWorkTime;
    }

    public void setTotalWorkTime(Long totalWorkTime) {
        this.totalWorkTime = totalWorkTime;
    }

    public String getOwnerShip() {
        return ownerShip;
    }

    public void setOwnerShip(String ownerShip) {
        this.ownerShip = ownerShip;
    }
}
