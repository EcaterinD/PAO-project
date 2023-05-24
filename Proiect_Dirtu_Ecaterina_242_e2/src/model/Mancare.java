package model;

public abstract class Mancare extends Produs {
    private Integer timpPreparare;
    private Integer gramaj;

    public Mancare(Float pret, Integer timpPreparare, Integer gramaj) {
        super(pret);
        this.gramaj = gramaj;
        this.timpPreparare = timpPreparare;
    }

    public Mancare() {

    }

    public Integer getGramaj() {
        return gramaj;
    }

    public void setGramaj(Integer gramaj) {
        this.gramaj = gramaj;
    }

    public Integer getTimpPreparare() {
        return timpPreparare;
    }

    public void setTimpPreparare(Integer timpPreparare) {
        this.timpPreparare = timpPreparare;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + gramaj + "g," +
                " timp de preparare: " + timpPreparare + " minute ";
    }
}