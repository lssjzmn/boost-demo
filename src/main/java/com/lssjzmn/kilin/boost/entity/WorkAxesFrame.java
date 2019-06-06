package com.lssjzmn.kilin.boost.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by guimu-yh on 2016/10/31.
 */
@Entity
@Table(name = "axes_frame_define")
public class WorkAxesFrame implements Serializable {


    private static final long serialVersionUID = -4381937567496138484L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "org_nav_id")
    private NavAxesPoint orgNavPoint;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "xdir_nav_id")
    private NavAxesPoint xDirNavPoint;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "ydir_nav_id")
    private NavAxesPoint yDirNavPoint;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "gps_pta_id")
    private RobotLocationPoint orgPoint;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "gps_ptb_id")
    private RobotLocationPoint xDirPoint;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "gps_ptc_id")
    private RobotLocationPoint yDirPoint;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NavAxesPoint getOrgNavPoint() {
        return orgNavPoint;
    }

    public void setOrgNavPoint(NavAxesPoint orgNavPoint) {
        this.orgNavPoint = orgNavPoint;
    }

    public NavAxesPoint getxDirNavPoint() {
        return xDirNavPoint;
    }

    public void setxDirNavPoint(NavAxesPoint xDirNavPoint) {
        this.xDirNavPoint = xDirNavPoint;
    }

    public NavAxesPoint getyDirNavPoint() {
        return yDirNavPoint;
    }

    public void setyDirNavPoint(NavAxesPoint yDirNavPoint) {
        this.yDirNavPoint = yDirNavPoint;
    }

    public RobotLocationPoint getOrgPoint() {
        return orgPoint;
    }

    public void setOrgPoint(RobotLocationPoint orgPoint) {
        this.orgPoint = orgPoint;
    }

    public RobotLocationPoint getxDirPoint() {
        return xDirPoint;
    }

    public void setxDirPoint(RobotLocationPoint xDirPoint) {
        this.xDirPoint = xDirPoint;
    }

    public RobotLocationPoint getyDirPoint() {
        return yDirPoint;
    }

    public void setyDirPoint(RobotLocationPoint yDirPoint) {
        this.yDirPoint = yDirPoint;
    }

    @Override
    public String toString() {
        return "WorkAxesFrame{" +
                "name='" + name + '\'' +
                ", orgNavPoint=" + orgNavPoint +
                ", xDirNavPoint=" + xDirNavPoint +
                ", yDirNavPoint=" + yDirNavPoint +
                ", orgPoint=" + orgPoint +
                ", xDirPoint=" + xDirPoint +
                ", yDirPoint=" + yDirPoint +
                '}';
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
