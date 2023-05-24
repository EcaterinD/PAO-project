package model;

public class Bautura extends Produs {
    private Boolean eCaldaRece;
    private String denumire;
    private String dimensiune;

    public Bautura(Float pret, Boolean caldaRece, String denumire, String dimensiune) {
        super(pret);
        this.eCaldaRece = caldaRece;
        this.denumire = denumire;
        this.dimensiune = dimensiune;
    }

    public Bautura() {

    }

    public Boolean getCaldaRece() {
        return eCaldaRece;
    }

    public void setCaldaRece(Boolean caldaRece) {
        eCaldaRece = caldaRece;
    }

    public String getDenumire() {
        return denumire;
    }
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDimensiune() {
        return dimensiune;
    }
    public void setDimensiune(String dimensiune) {
        this.dimensiune = dimensiune;
    }

    public String toString() {
        String temp;
        if (eCaldaRece)
            temp = "calda"; //1
        else
            temp = "rece";  //0
        return "Bautura - " + super.toString() + denumire + " " + temp + " - " + dimensiune;
    }
}