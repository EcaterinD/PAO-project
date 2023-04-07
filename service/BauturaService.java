package service;

import model.Bautura;
import model.Comanda;
import repository.BauturaRepository;

import java.util.List;

public class BauturaService {
    private BauturaRepository bauturaRepository;

    public BauturaService() {
        this.bauturaRepository= new BauturaRepository();
    }

    public Comanda addBautura(Boolean premium, String tipBautura, String denumire, Character dimensiune) {

        Comanda c = new Bautura(premium, tipBautura, denumire, dimensiune);
        Comanda result = bauturaRepository.add(c);

        return result;
    }
    public Comanda getBautura(int index) {
        Comanda result = bauturaRepository.get(index);
        return result;
    }

    public List<Comanda> getAllBautura() {
        List<Comanda> result = bauturaRepository.getAll();
        return result;
    }

    public boolean updateBautura(int index, Boolean premium, String tipBautura, String denumire, Character dimensiune) {

        Comanda c = new Bautura( premium, tipBautura, denumire, dimensiune);
        boolean result = bauturaRepository.update(index, c);

        return result;
    }

    public boolean deleteBautura(int index) {
        return bauturaRepository.delete(index);
    }

    public int readyTime(int index) {return bauturaRepository.readyTime(index);}

}
