package model;

import java.util.Objects;

public class Bautura extends Comanda{
    private String tipBautura; //calda sau rece si in functe de asta si denumirile
    private String denumire;
    private Character dimensiune; // s l m

    public Bautura() {
    }

    public Bautura(Boolean premium, String tipBautura, String denumire, Character dimensiune) {
        super(premium);
        this.tipBautura = tipBautura;
        this.denumire = denumire;
        this.dimensiune = dimensiune;
    }

    public String getTipBautura() {
        return tipBautura;
    }
    public void setTipBautura(String tipBautura) {
        this.tipBautura = tipBautura;
    }

    public String getDenumire() {
        return denumire;
    }
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Character getDimensiune() {
        return dimensiune;
    }
    public void setDimensiune(Character dimensiune) {
        this.dimensiune = dimensiune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bautura bautura = (Bautura) o;
        return tipBautura.equals(bautura.tipBautura) && denumire.equals(bautura.denumire) && dimensiune.equals(bautura.dimensiune);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipBautura, denumire, dimensiune);
    }

    @Override
    public String toString() {
        return "Bautura{" +
                "tipBautura='" + tipBautura + '\'' +
                ", denumire='" + denumire + '\'' +
                ", dimensiune=" + dimensiune +
                '}'+ super.toString();
    }
}
