package com.naukma.cinema.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Genre {

    @Id
    @Enumerated(EnumType.STRING)
    private GenreType type;

    private String name;

    public GenreType getType() {
        return type;
    }

    public void setType(GenreType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Genre genre = (Genre) object;
        return java.util.Objects.equals(type, genre.type) &&
                java.util.Objects.equals(name, genre.name);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), type, name);
    }
}