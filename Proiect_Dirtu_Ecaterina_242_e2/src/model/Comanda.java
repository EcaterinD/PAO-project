package model;

import java.util.Objects;

public class Comanda implements Comparable<Comanda> {
    private Cumparator cumparator;
    private Meniu meniu;
    private Desert desert;
    private Bautura bautura;

    public Comanda(Cumparator cumparator, Meniu meniu, Desert desert, Bautura bautura) {
        this.cumparator = cumparator;
        this.meniu = meniu;
        this.desert = desert;
        this.bautura = bautura;
    }

    public Comanda() {
    }

    public Cumparator getCumparator() {
        return cumparator;
    }

    public void setCumparator(Cumparator cumparator) {
        this.cumparator = cumparator;
    }

    public Meniu getMeniu() {
        return meniu;
    }

    public void setMeniu(Meniu meniu) {
        this.meniu = meniu;
    }

    public Bautura getBautura() {
        return bautura;
    }

    public void setBautura(Bautura bautura) {
        this.bautura = bautura;
    }

    public Desert getDesert() {
        return desert;
    }

    public void setDesert(Desert desert) {
        this.desert = desert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comanda comanda)) return false;
        return Objects.equals(cumparator, comanda.cumparator) && Objects.equals(meniu, comanda.meniu) && Objects.equals(desert, comanda.desert) && Objects.equals(bautura, comanda.bautura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cumparator, meniu, desert, bautura);
    }

    @Override
    public String toString() {
        String meniustring = "";
        if (meniu != null) {
            meniustring = "\n" + meniu;
        }

        String desertstring = "";
        if (desert != null) {
            desertstring = "\n" + desert;
        }

        String bauturastring = "";
        if (bautura != null) {
            bauturastring = "\n" + bautura;
        }

        return "\nComanda realizata de: " + cumparator.getNume() +
                meniustring + desertstring + bauturastring;
    }

    @Override
    public int compareTo(Comanda o) {
        return this.cumparator.getNume().compareTo(o.cumparator.getNume());
    }
}