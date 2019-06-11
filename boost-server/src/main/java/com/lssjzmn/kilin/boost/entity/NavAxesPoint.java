package com.lssjzmn.kilin.boost.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by guimu-yh on 2017-02-13.
 * Note: Use this data struction to save the point reported by Gpskit also
 */
@Entity
@Table(name = "nav_axes_point")
public class NavAxesPoint implements Serializable {

    private static final long serialVersionUID = 5976245581151321938L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "x_value")
    private double X;

    @Column(name = "y_value")
    private double Y;

    @Column(name = "z_value")
    private double Z;



    public double getX() {
        return X;
    }

    public void setX(double x) {
        this.X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        this.Y = y;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getZ() {
        return Z;
    }

    public void setZ(double z) {
        Z = z;
    }

    @Override
    public String toString() {
        return "NavAxesPoint{" +
                "X=" + X +
                ", Y=" + Y +
                ", navZ=" + Z +
                '}';
    }
}
