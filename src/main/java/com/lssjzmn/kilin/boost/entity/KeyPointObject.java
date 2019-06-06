package com.lssjzmn.kilin.boost.entity;

import java.io.Serializable;

public class KeyPointObject implements Serializable {

    private static final long serialVersionUID = -1331937567286136346L;
    private Long id;
    private Double lng;
    private Double lat;
    private Double high;
    private Double x;
    private Double y;
    //KeyPointType
    private Integer type;
    private Integer typeOrder;
    private String comment;
    private Long createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(Integer typeOrder) {
        this.typeOrder = typeOrder;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "KeyPointObject{" +
                "id=" + id +
                ", lng=" + lng +
                ", lat=" + lat +
                ", high=" + high +
                ", x=" + x +
                ", y=" + y +
                ", type=" + type +
                ", typeOrder=" + typeOrder +
                ", comment='" + comment + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
