package com.lssjzmn.kilin.boost.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by guimu-yh on 2016/10/31.
 */
@Entity
@Table(name="point")
public class Point implements Serializable {

    private static final long serialVersionUID = -2790620375602242109L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "x_value")
    private double x;

    @Column(name = "y_value")
    private double y;

    public Point() {

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        Point comparePoint=(Point)obj;
        if(comparePoint.getX()==this.getX()&&comparePoint.getY()==this.getY()){
            return true;
        }
        return false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Point{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}
