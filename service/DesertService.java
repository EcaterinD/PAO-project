package service;

import model.Comanda;
import model.Desert;
import repository.DesertRepository;

import java.util.List;

public class DesertService {
    private DesertRepository desertRepository;

    public DesertService() {
        this.desertRepository= new DesertRepository();
    }

    public Comanda addDesert(Boolean premium, Integer cantitate, String tipDesert, String aroma, Boolean topping) {

        Comanda c = new Desert(premium, cantitate, tipDesert, aroma, topping);
        Comanda result = desertRepository.add(c);

        return result;
    }
    public Comanda getDesert(int index) {
        Comanda result = desertRepository.get(index);
        return result;
    }

    public List<Comanda> getAllDesert() {
        List<Comanda> result = desertRepository.getAll();
        return result;
    }

    public boolean updateDesert(int index, Boolean premium, Integer cantitate, String tipDesert, String aroma, Boolean topping) {

        Comanda c = new Desert(premium, cantitate, tipDesert, aroma, topping);
        boolean result = desertRepository.update(index, c);

        return result;
    }

    public boolean deleteDesert(int index) {
        return desertRepository.delete(index);
    }
}
