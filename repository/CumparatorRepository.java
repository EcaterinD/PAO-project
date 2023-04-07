package repository;
import model.Cumparator;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class CumparatorRepository {

    // Cumparator[] cumparatori = new Cumparator[20];
    List<Cumparator> cumparatori = new ArrayList<>();

    public Cumparator add(Cumparator cumparator) {
        cumparatori.add(cumparator);
        System.out.println("\nAdaugarea a fost realizata cu succes");
        // System.out.println(Arrays.toString(cumparatori));

        for (Cumparator element : cumparatori) {
            System.out.println(element);
        }
        return cumparator;
    }

    public Cumparator get(Integer nrOrdine) {

        for (Cumparator element : cumparatori)
            if (Objects.equals(element.getNrOrdine(), nrOrdine))
                return element;
        System.out.println("Cumparatorul cautat nu exista!");
        return null;
    }

    public Cumparator getIndex(int index) {
        if (cumparatori.size()>index)
            return cumparatori.get(index);
        else
            System.out.println("Cumparatorul cautat nu exista!");
        return null;
    }

    public List<Cumparator> getAll() {
        return cumparatori;
    }

    public boolean update(int index, Cumparator cumparator) {
        if (cumparatori.size()>index) {
            cumparatori.set(index,cumparator);
            System.out.println("\nModificarea a fost realizata cu succes");
            // System.out.println(Arrays.toString(cumparatori));

            for (Cumparator element : cumparatori) {
                System.out.println(element);
            }
            return true;
        }
        else {
            System.out.println("Cumparatorul cautat nu exista pentru a fi modificat!");
            return false;
        }
    }

    public boolean delete(int index) {
        if (cumparatori.size()>index) {
            cumparatori.remove(index);
            System.out.println("\nStergerea a fost realizata cu succes");
            return true;
        }
        else {
            System.out.println("Cumparatorul cautat nu exista pentru a fi sters!");
            return false;
        }
    }
    public float score()
    {
        float scor=0;
        for (Cumparator element : cumparatori)
            scor+=element.getRecenzie();
        return scor/cumparatori.size();
    }
    public int countOver18()
    {
        int cnt=0;
        for (Cumparator element : cumparatori)
            if (ChronoUnit.YEARS.between(element.getAnulNasterii(), Year.now())>=18)
                cnt++;
        return cnt;
    }

}