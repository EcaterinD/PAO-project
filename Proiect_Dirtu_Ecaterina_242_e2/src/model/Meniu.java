package model;

import java.util.Objects;

public class Meniu extends Mancare {

    private String tipSandwich;
    private Integer nrSuplimente;
    private Integer cantitateCartofi;

    public Meniu() {}

    public Meniu(Float pret, Integer timpPreparare, Integer gramaj, String tipSandwich, Integer nrSuplimente, Integer cantitateCartofi) {
        super(pret, timpPreparare, gramaj);
        this.tipSandwich = tipSandwich;
        this.nrSuplimente = nrSuplimente;
        this.cantitateCartofi = cantitateCartofi;
    }

    public String getTipSandwich() {
        return tipSandwich;
    }
    public void setTipSandwich(String tipSandwich) {
        this.tipSandwich = tipSandwich;
    }

    public Integer getNrSuplimente() {
        return nrSuplimente;
    }
    public void setNrSuplimente(Integer nrSuplimente) {
        this.nrSuplimente = nrSuplimente;
    }

    public Integer getCantitateCartofi() {
        return cantitateCartofi;
    }
    public void setCantitateCartofi(Integer cantitateCartofi) {
        this.cantitateCartofi = cantitateCartofi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Meniu meniu = (Meniu) o;
        return tipSandwich.equals(meniu.tipSandwich) && nrSuplimente.equals(meniu.nrSuplimente) && cantitateCartofi.equals(meniu.cantitateCartofi);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), tipSandwich, nrSuplimente, cantitateCartofi);
        return result;
    }

    @Override
    public String toString() {
        return " Meniu - " + super.toString() + " Sandwich " + tipSandwich +
                " cu " + nrSuplimente + " suplimente si " + cantitateCartofi + "g cartofi";
    }
}
