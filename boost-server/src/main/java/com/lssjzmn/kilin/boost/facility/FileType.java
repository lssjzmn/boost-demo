package com.lssjzmn.kilin.boost.facility;

/**
 * Created by guimu-work on 2018/1/10.
 */
public enum FileType {

    RADAR("雷达"), IMAGE("图像"), LOG("日志");

    private String name;


    FileType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
