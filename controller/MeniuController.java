package controller;

import model.Comanda;
import service.MeniuService;

import java.util.List;

public class MeniuController {
    private MeniuService meniuService;
    public MeniuController() {
        this.meniuService = new MeniuService();
    }
    public Comanda addMeniu(Boolean premium, Integer cantitate, String tipSandwich, Integer nrSuplimente, String tipSos, Integer cantitateCartofi) {
        Comanda meniu = meniuService.addMeniu(premium, cantitate, tipSandwich, nrSuplimente, tipSos, cantitateCartofi);
        return meniu;
    }
    public Comanda getMeniu(int index) {
        Comanda meniu = meniuService.getMeniu(index);
        return meniu;
    }

    public List<Comanda> getAllMeniuri() {
        List<Comanda> meniuri = meniuService.getAllMeniu();
        return meniuri;
    }

    public List<Comanda> getByPC(Boolean premium, Integer cantitate) {
        List<Comanda> result = meniuService.getByPC(premium, cantitate);
        return result;
    }

    public boolean updateMeniu(int index, Boolean premium, Integer cantitate, String tipSandwich, Integer nrSuplimente, String tipSos, Integer cantitateCartofi) {

        return meniuService.updateMeniu(index, premium, cantitate, tipSandwich, nrSuplimente, tipSos, cantitateCartofi);
    }

    public boolean deleteMeniu(int index) {
        return meniuService.deleteMeniu(index);
    }

    public int price(int index) { return meniuService.price(index);}
}
