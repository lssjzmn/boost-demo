package com.lssjzmn.kilin.boost.entity;

import java.io.Serializable;

/**
 * Created by guimu-yh on 2016/10/31.
 */
public class RobotConfig implements Serializable {


    private static final long serialVersionUID = -8680754983101643153L;

    private Float width;

    private Float height;

    private Float length;

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

}
