package service;

import model.Meniu;
import model.Comanda;
import repository.MeniuRepository;

import java.util.List;

public class MeniuService {
    private MeniuRepository meniuRepository;

    public MeniuService() {
        this.meniuRepository= new MeniuRepository();
    }

    public Comanda addMeniu(Boolean premium, Integer cantitate, String tipSandwich, Integer nrSuplimente, String tipSos, Integer cantitateCartofi) {

        Comanda c = new Meniu(premium, cantitate, tipSandwich, nrSuplimente, tipSos, cantitateCartofi);
        Comanda result = meniuRepository.add(c);

        return result;
    }
    public Comanda getMeniu(int index) {
        Comanda result = meniuRepository.get(index);
        return result;
    }

    public List<Comanda> getAllMeniu() {
        List<Comanda> result = meniuRepository.getAll();
        return result;
    }

    public List<Comanda> getByPC(Boolean premium, Integer cantitate) {
        List<Comanda> result = meniuRepository.getByPC(premium, cantitate);
        return result;
    }

    public boolean updateMeniu(int index, Boolean premium, Integer cantitate, String tipSandwich, Integer nrSuplimente, String tipSos, Integer cantitateCartofi) {

        Comanda c = new Meniu(premium, cantitate, tipSandwich, nrSuplimente, tipSos, cantitateCartofi);
        boolean result = meniuRepository.update(index, c);

        return result;
    }

    public boolean deleteMeniu(int index) {
        return meniuRepository.delete(index);
    }

    public int price(int index) {
        int result = meniuRepository.price(index);
        return result;
    }
}
