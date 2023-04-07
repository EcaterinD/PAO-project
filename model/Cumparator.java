package model;

import java.time.Year;
import java.util.Objects;

public class Cumparator {

    private String nume;
    private String prenume;
    private String CNP;
    private Year anulNasterii;
    private String adresa;
    private String metodaPlata;
    private Integer nrOrdine;
    private Integer recenzie; // nr de la 0 la 5
    public Cumparator() { }

    public Cumparator(String nume, String prenume, String CNP, Year anulNasterii, String adresa, String metodaPlata, Integer nrOrdine, Integer recenzie) {
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.anulNasterii = anulNasterii;
        this.adresa = adresa;
        this.metodaPlata = metodaPlata;
        this.nrOrdine = nrOrdine;
        this.recenzie = recenzie;
    }

    public String getNume() { return nume;}

    public void setNume(String nume) {this.nume = nume;}

    public String getPrenume() {return prenume;}

    public void setPrenume(String prenume) {this.prenume = prenume;}

    public String getCNP() {return CNP;}

    public void setCNP(String CNP) {this.CNP = CNP;}

    public Year getAnulNasterii() {return anulNasterii;}

    public void setAnulNasterii(Year anulNasterii) {this.anulNasterii = anulNasterii;}

    public String getAdresa() {
        return adresa;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMetodaPlata() {
        return metodaPlata;
    }
    public void setMetodaPlata(String metodaPlata) {
        this.metodaPlata = metodaPlata;
    }

    public Integer getNrOrdine() {
        return nrOrdine;
    }

    public void setNrOrdine(Integer nrOrdine) {this.nrOrdine = nrOrdine;}

    public Integer getRecenzie() {
        return recenzie;
    }
    public void setRecenzie(Integer recenzie) {
        this.recenzie = recenzie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cumparator that = (Cumparator) o;
        return nume.equals(that.nume) && prenume.equals(that.prenume) && CNP.equals(that.CNP) && anulNasterii.equals(that.anulNasterii) && metodaPlata.equals(that.metodaPlata) && nrOrdine.equals(that.nrOrdine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, CNP, anulNasterii, metodaPlata, nrOrdine);
    }

    @Override
    public String toString() {
        return "Cumparator{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", CNP='" + CNP + '\'' +
                ", anulNasterii=" + anulNasterii +
                ", adresa='" + adresa + '\'' +
                ", metodaPlata='" + metodaPlata + '\'' +
                ", nrOrdine=" + nrOrdine +
                ", recenzie=" + recenzie +
                '}';
    }
}
