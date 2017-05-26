package com.invoker.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/5/24 at 23:30
 */
@Entity
@Table(name = "game_info")
public class GameInfo {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 60)
    private String name;
    @Column(length = 60)
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
