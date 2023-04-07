package model;

import java.util.Objects;

public class Comanda {
    private Boolean premium;

    public Comanda() {
    }

    public Comanda(Boolean premium) {
        this.premium = premium;
    }

    public Boolean getPremium() {
        return premium;
    }
    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comanda comanda = (Comanda) o;
        return premium.equals(comanda.premium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(premium);
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "premium=" + premium +
                '}';
    }
}
