package repository;

import model.Comanda;
import model.Cumparator;
import model.Desert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesertRepository {

    //Comanda[] deserturi = new Desert[20];
    List<Comanda> deserturi = new ArrayList<>();
    public Comanda add(Comanda desert) {

        deserturi.add(desert);
        //System.out.println(Arrays.toString(deserturi));
        System.out.println("\nAdaugarea a fost realizata cu succes");

        for (Comanda element : deserturi) {
            System.out.println(element);
        }
        return desert;
    }

    public Comanda get(int index) {
        if (deserturi.size()>index)
            return deserturi.get(index);
        else
            System.out.println("Desertul cautat nu exista!");
        return null;
    }

    public List<Comanda> getAll() {
        return deserturi;
    }

    public boolean update(int index, Comanda desert) {
        if (deserturi.size()>index) {
            deserturi.set(index,desert);
            System.out.println("\nModificarea a fost realizata cu succes");
            for (Comanda element : deserturi) {
                System.out.println(element);
            }
            return true;
        }
        else {
            System.out.println("Desertul cautat nu exista pentru a fi modificat!");
            return false;
        }
    }

    public boolean delete(int index) {
        if (deserturi.size()>index) {
            deserturi.remove(index);
            System.out.println("\nStergerea a fost realizata cu succes");
            return true;
        }
        else {
            System.out.println("Desertul cautat nu exista pentru a fi sters!");
            return false;
        }
    }
}
