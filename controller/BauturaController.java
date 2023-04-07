package controller;

import model.Comanda;
import model.Bautura;
import service.BauturaService;
import service.CumparatorService;

import java.util.List;

public class BauturaController{

    private BauturaService bauturaService;
    public BauturaController() {
        this.bauturaService = new BauturaService();
    }
    public Comanda addBautura(Boolean premium, String tipBautura, String denumire, Character dimensiune) {
        Comanda bautura = bauturaService.addBautura(premium, tipBautura, denumire, dimensiune);
        return bautura;
    }
    public Comanda getBautura(int index) {
        Comanda bautura = bauturaService.getBautura(index);
        return bautura;
    }

    public List<Comanda> getAllBauturi() {
        List<Comanda> bauturi = bauturaService.getAllBautura();
        return bauturi;
    }

    public boolean updateBautura(int index, Boolean premium, String tipBautura, String denumire, Character dimensiune) {

        return bauturaService.updateBautura(index, premium, tipBautura, denumire, dimensiune);
    }
    public boolean deleteBautura(int index) {
        return bauturaService.deleteBautura(index);
    }

    public int readyTime(int index) {return bauturaService.readyTime(index);}

}
