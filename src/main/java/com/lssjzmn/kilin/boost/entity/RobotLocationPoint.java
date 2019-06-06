package com.lssjzmn.kilin.boost.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by guimu-yh on 2017-02-13.
 */
@Entity
@Table(name = "robot_location_point")
public class RobotLocationPoint implements Serializable {

    private static final long serialVersionUID = -4371429995998254248L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "high")
    private Double high;

    @Column(name = "longitudeMap")
    private Double longitudeMap;

    @Column(name = "latitudeMap")
    private Double latitudeMap;

    @Column(name = "highMap")
    private Double highMap;

    @Column(name = "local_x")
    private Double localX;

    @Column(name = "local_y")
    private Double localY;

    @Column(name = "local_z")
    private Double localZ;

    @Column(name = "time")
    private Long time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLongitudeMap() {
        return longitudeMap;
    }

    public void setLongitudeMap(Double longitudeMap) {
        this.longitudeMap = longitudeMap;
    }

    public Double getLatitudeMap() {
        return latitudeMap;
    }

    public void setLatitudeMap(Double latitudeMap) {
        this.latitudeMap = latitudeMap;
    }

    public Double getHighMap() {
        return highMap;
    }

    public void setHighMap(Double highMap) {
        this.highMap = highMap;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getLocalX() {
        return localX;
    }

    public void setLocalX(Double localX) {
        this.localX = localX;
    }

    public Double getLocalY() {
        return localY;
    }

    public void setLocalY(Double localY) {
        this.localY = localY;
    }

    public Double getLocalZ() {
        return localZ;
    }

    public void setLocalZ(Double localZ) {
        this.localZ = localZ;
    }

    @Override
    public String toString() {
        return "RobotLocationPoint{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", high=" + high +
                ", longitudeMap=" + longitudeMap +
                ", latitudeMap=" + latitudeMap +
                ", highMap=" + highMap +
                ", localX=" + localX +
                ", localY=" + localY +
                ", localZ=" + localZ +
                ", time=" + time +
                '}';
    }

    public RobotLocationPoint clone() {
        RobotLocationPoint cloneObject = new RobotLocationPoint();
        cloneObject.setLocalX(this.localX);
        cloneObject.setLocalY(this.localY);
        cloneObject.setLongitude(this.longitude);
        cloneObject.setLatitude(this.latitude);
        cloneObject.setLatitudeMap(this.latitudeMap);
        cloneObject.setLongitudeMap(this.latitudeMap);
        cloneObject.setHigh(this.high);
        cloneObject.setTime(this.time);
        cloneObject.setId(this.id);
        return cloneObject;
    }
}
