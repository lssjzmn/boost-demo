package com.lssjzmn.kilin.boost.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "work_area")
public class CommonWorkArea implements Serializable {

    private static final long serialVersionUID = -1768786075671223256L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "speed")
    private Float speed;

    @Column(name = "track_gap")
    private Float trackGap;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private WorkAreaType workAreaType;

    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "work_area_task_track",
            joinColumns = @JoinColumn(name = "work_area_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "location_point_id", referencedColumnName = "id")
    )
    private List<RobotLocationPoint> tracks;


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

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public List<RobotLocationPoint> getTracks() {
        return tracks;
    }

    public void setTracks(List<RobotLocationPoint> pointTrack) {
        this.tracks = pointTrack;
    }

    public Float getTrackGap() {
        return trackGap;
    }

    public void setTrackGap(Float trackGap) {
        this.trackGap = trackGap;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public WorkAreaType getWorkAreaType() {
        return workAreaType;
    }

    public void setWorkAreaType(WorkAreaType workAreaType) {
        this.workAreaType = workAreaType;
    }

    @Override
    public String toString() {
        return "CommonWorkArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                ", trackGap=" + trackGap +
                ", workAreaType=" + workAreaType +
                ", createTime=" + createTime +
                ", tracks=" + tracks +
                '}';
    }
}
