package controller;

import model.Comanda;
import model.Desert;
import model.Mancare;
import service.DesertService;

import java.util.List;

public class DesertController {

    private DesertService desertService;
    public DesertController() {
        this.desertService = new DesertService();
    }
    public Comanda addDesert(Boolean premium, Integer cantitate, String tipDesert, String aroma, Boolean topping) {

        Comanda desert = desertService.addDesert(premium, cantitate, tipDesert, aroma, topping);
        return desert;
    }
    public Comanda getDesert(int index) {
        Comanda desert = desertService.getDesert(index);
        return desert;
    }

    public List<Comanda> getAllDeserturi() {
        List<Comanda> deserturi = desertService.getAllDesert();
        return deserturi;
    }

    public boolean updateDesert(int index, Boolean premium, Integer cantitate, String tipDesert, String aroma, Boolean topping) {

        return desertService.updateDesert(index, premium, cantitate, tipDesert, aroma, topping);
    }

    public boolean deleteDesert(int index) {
        return desertService.deleteDesert(index);
    }
}
