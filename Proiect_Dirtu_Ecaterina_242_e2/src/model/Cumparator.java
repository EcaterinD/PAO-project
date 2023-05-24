package model;

import java.util.Objects;

public class Cumparator {

    private Integer id;
    private String nume;
    private Integer varsta;
    private String email;
    private String nrTel;
    private String adresa;


    public Cumparator() {}
    public Cumparator(String nume, Integer varsta, String email, String nrTel, String adresa) {
        this.nume = nume;
        this.varsta = varsta;
        this.email = email;
        this.nrTel = nrTel;
        this.adresa = adresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getVarsta() {
        return varsta;
    }
    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrTel() {
        return nrTel;
    }
    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }

    public String getAdresa() {
        return adresa;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cumparator user = (Cumparator) o;
        return Objects.equals(nume, user.nume) && Objects.equals(email, user.email) && Objects.equals(nrTel, user.nrTel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, email, nrTel);
    }

    @Override
    public String toString() {
        return "Cumparator - nume: " + nume + ", varsta: " + varsta +
                ", email: " + email + ", numar de telefon: " + nrTel  + ", adresa: " + adresa;
    }
}