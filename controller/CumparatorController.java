package controller;

import model.Cumparator;
import service.CumparatorService;

import java.util.List;
import java.time.Year;

public class CumparatorController {
    private CumparatorService cumparatorService;
    public CumparatorController() {
        this.cumparatorService = new CumparatorService();
    }
    public Cumparator addCumparator(String nume, String prenume, String CNP, Year anulNasterii, String adresa, String metodaPlata, Integer nrOrdine, Integer recenzie) {
        nume = nume.toUpperCase();
        prenume = prenume.toUpperCase();
        metodaPlata = metodaPlata.toUpperCase();
        Cumparator cumparator = cumparatorService.addCumparator(nume, prenume, CNP, anulNasterii, adresa, metodaPlata, nrOrdine, recenzie);
        return cumparator;
    }
    public Cumparator getCumparator(Integer nrOrdine) {
        Cumparator cumparator = cumparatorService.getCumparator(nrOrdine);
        return cumparator;
    }

    public Cumparator getCumparatorIndex(int index) {
        Cumparator cumparator = cumparatorService.getCumparatorIndex(index);
        return cumparator;
    }

    public List<Cumparator> getAllCumparatori() {
        List<Cumparator> cumparatori = cumparatorService.getAllCumparator();
        return cumparatori;
    }

    public boolean updateCumparator(int index, String nume, String prenume, String CNP, Year anulNasterii,String adresa, String metodaPlata, Integer nrOrdine, Integer recenzie) {
        nume = nume.toUpperCase();
        prenume = prenume.toUpperCase();
        metodaPlata = metodaPlata.toUpperCase();
        return cumparatorService.updateCumparator(index, nume, prenume, CNP, anulNasterii,adresa, metodaPlata, nrOrdine, recenzie);
    }

    public boolean deleteCumparator(int index) {
        return cumparatorService.deleteCumparator(index);
    }

    public float score() { return cumparatorService.score();}
    public int countOver18() { return cumparatorService.countOver18();}
}
