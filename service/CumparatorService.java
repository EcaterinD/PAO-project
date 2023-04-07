package service;

import model.Cumparator;
import repository.CumparatorRepository;

import java.time.Year;
import java.util.List;

public class CumparatorService {
    private CumparatorRepository cumparatorRepository;

    public CumparatorService() {
        this.cumparatorRepository= new CumparatorRepository();
    }

    public Cumparator addCumparator(String nume, String prenume, String CNP, Year anulNasterii,String adresa, String metodaPlata, Integer nrOrdine, Integer recenzie) {

        Cumparator c = new Cumparator(nume, prenume, CNP, anulNasterii, adresa, metodaPlata, nrOrdine, recenzie);
        Cumparator result = cumparatorRepository.add(c);

        return result;
    }
    public Cumparator getCumparator(Integer nrOrdine) {
        Cumparator result = cumparatorRepository.get(nrOrdine);
        return result;
    }

    public Cumparator getCumparatorIndex(int index) {
        Cumparator result = cumparatorRepository.getIndex(index);
        return result;
    }

    public List<Cumparator> getAllCumparator() {
        List<Cumparator> result = cumparatorRepository.getAll();
        return result;
    }

    public boolean updateCumparator(int index, String nume, String prenume, String CNP, Year anulNasterii, String adresa, String metodaPlata, Integer nrOrdine, Integer recenzie) {

        Cumparator c = new Cumparator(nume, prenume, CNP, anulNasterii, adresa, metodaPlata, nrOrdine, recenzie);
        boolean result = cumparatorRepository.update(index, c);

        return result;
    }

    public boolean deleteCumparator(int index) {
        return cumparatorRepository.delete(index);
    }

    public float score() { return cumparatorRepository.score();}
    public int countOver18() { return cumparatorRepository.countOver18();}

}
