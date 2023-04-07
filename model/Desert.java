package model;

import java.util.Objects;

public class Desert extends Mancare{
    private String tipDesert; //prajitura sau inghetata
    private String aroma;
    private Boolean topping;

    public Desert() {
    }

    public Desert(Boolean premium, Integer cantitate, String tipDesert, String aroma, Boolean topping) {
        super(premium, cantitate);
        this.tipDesert = tipDesert;
        this.aroma = aroma;
        this.topping = topping;
    }

    public String getTipDesert() {
        return tipDesert;
    }
    public void setTipDesert(String tipDesert) {
        this.tipDesert = tipDesert;
    }

    public String getAroma() {
        return aroma;
    }
    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public Boolean getTopping() {
        return topping;
    }
    public void setTopping(Boolean topping) {
        this.topping = topping;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Desert desert = (Desert) o;
        return tipDesert.equals(desert.tipDesert) && aroma.equals(desert.aroma) && topping.equals(desert.topping);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tipDesert, aroma, topping);
    }

    @Override
    public String toString() {
        return "Desert{" +
                "tipDesert='" + tipDesert + '\'' +
                ", aroma='" + aroma + '\'' +
                ", topping=" + topping +
                "} " + super.toString();
    }
}
