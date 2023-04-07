package model;

import java.util.Arrays;
import java.util.Objects;

public class Meniu extends Mancare{
    private String tipSandwich;
    private Integer nrSuplimente;
    private String tipSos;
    private Integer cantitateCartofi;

    public Meniu() {
    }

    public Meniu(Boolean premium, Integer cantitate, String tipSandwich, Integer nrSuplimente, String tipSos, Integer cantitateCartofi) {
        super(premium, cantitate);
        this.tipSandwich = tipSandwich;
        this.nrSuplimente = nrSuplimente;
        this.tipSos = tipSos;
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

    public String getTipSos() {
        return tipSos;
    }
    public void setTipSos(String tipSos) {
        this.tipSos = tipSos;
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
        return tipSandwich.equals(meniu.tipSandwich) && nrSuplimente.equals(meniu.nrSuplimente) && tipSos.equals(meniu.tipSos) && cantitateCartofi.equals(meniu.cantitateCartofi);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), tipSandwich, nrSuplimente, tipSos, cantitateCartofi);
        return result;
    }

    @Override
    public String toString() {
        return "Meniu{" +
                "tipSandwich='" + tipSandwich + '\'' +
                ", nrSuplimente=" + nrSuplimente +
                ", tipSos='" + tipSos + '\'' +
                ", cantitateCartofi=" + cantitateCartofi +
                '}'+ super.toString();
    }
}
