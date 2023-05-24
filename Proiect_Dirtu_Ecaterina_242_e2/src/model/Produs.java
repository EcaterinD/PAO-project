package model;

import java.util.Objects;

public abstract class Produs {
    private Integer id;
    private Float pret;

    public Produs() {
    }

    public Produs(Float pret) {
        this.pret = pret;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPret() {
        return pret;
    }
    public void setPret(Float pret) {
        this.pret = pret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs produs = (Produs) o;
        return Objects.equals(pret, produs.pret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pret);
    }

    @Override
    public String toString() {
        return  pret + " lei ";
    }
}