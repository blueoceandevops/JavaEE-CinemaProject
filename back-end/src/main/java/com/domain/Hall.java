package com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hall {

    @Id
    private Integer id;

    private String name;

    private int rows;

    private int placesInRow;

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

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPlacesInRow() {
        return placesInRow;
    }

    public void setPlacesInRow(int placesInRow) {
        this.placesInRow = placesInRow;
    }
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Hall that = (Hall) object;
        return rows == that.rows &&
                placesInRow == that.placesInRow &&
                java.util.Objects.equals(name, that.name);
    }

    public int hashCode() {

        return Objects.hash(super.hashCode(), name, rows, placesInRow);
    }
}
