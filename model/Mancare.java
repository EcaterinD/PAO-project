package model;

import java.util.Objects;

public class Mancare extends Comanda{
    private Integer cantitate;

    public Mancare() {
    }

    public Mancare(Boolean premium, Integer cantitate) {
        super(premium);
        this.cantitate = cantitate;
    }

    public Integer getCantitate() {
        return cantitate;
    }
    public void setCantitate(Integer cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mancare mancare = (Mancare) o;
        return cantitate.equals(mancare.cantitate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cantitate);
    }

    @Override
    public String toString() {
        return "Mancare{" +
                "cantitate=" + cantitate +
                "} " + super.toString();
    }
}
