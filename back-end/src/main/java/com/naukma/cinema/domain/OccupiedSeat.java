package com.naukma.cinema.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OccupiedSeat {

    public OccupiedSeat() {
    }

    @Id

    private Integer id;

    private Integer row;

    private Integer seat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }
}