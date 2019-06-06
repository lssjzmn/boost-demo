package com.lssjzmn.kilin.boost.entity;

import java.io.Serializable;
import java.util.List;

public class KeyPointsEntity implements Serializable {

    private static final long serialVersionUID = -2031837931288536348L;

    private String name;
    private String authorName;
    private List<KeyPointObject> keyPointObjects;
    private Long createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<KeyPointObject> getKeyPointObjects() {
        return keyPointObjects;
    }

    public void setKeyPointObjects(List<KeyPointObject> keyPointObjects) {
        this.keyPointObjects = keyPointObjects;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
