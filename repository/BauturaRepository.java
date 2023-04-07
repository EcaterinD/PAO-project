package repository;

import model.Bautura;
import model.Comanda;
import model.Cumparator;
import model.Meniu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BauturaRepository {

    //Comanda[] bauturi = new Bautura[20];
    List<Comanda> bauturi = new ArrayList<>();

    public Comanda add(Comanda bautura) {

        bauturi.add(bautura);
        //System.out.println(bauturi);
        System.out.println("\nAdaugarea a fost realizata cu succes");
        for (Comanda element : bauturi) {
            System.out.println(element);
        }
        return bautura;
    }

    public Comanda get(int index) {
        if (bauturi.size()>index)
            return bauturi.get(index);
        else
            System.out.println("Bautura cautata nu exista!");
        return null;
    }

    public List<Comanda> getAll() {
        return bauturi;
    }

    public boolean update(int index, Comanda bautura) {
        if (bauturi.size()>index) {
            bauturi.set(index, bautura);
            System.out.println("\nModificarea a fost realizata cu succes");
            for (Comanda element : bauturi) {
                System.out.println(element);
            }
            return true;
        } else {
            System.out.println("Bautura cautata nu exista pentru a fi modificata!");
            return false;
        }
    }

    public boolean delete(int index) {
        if (bauturi.size()>index) {
            bauturi.remove(index);
            System.out.println("\nStergerea a fost realizata cu succes");
            return true;
        } else {
            System.out.println("Bautura cautata nu exista pentru a fi stearsa!");
            return false;
        }
    }

    public int readyTime(int index)
    {
        int timp=0;
        Bautura b = (Bautura) bauturi.get(index);
        if (bauturi.get(index) != null){
            if(b.getDimensiune()=='S')
                timp=1;
            else if(b.getDimensiune()=='M')
                timp=2;
            else if (b.getDimensiune()=='L')
                timp=3;

            if (Objects.equals(b.getTipBautura(), "calda"))
                if (Objects.equals(b.getDenumire(), "ceai"))
                    timp=4;
                else timp=8; // cafea/cappuccino
            else // rece
                if (!Objects.equals(b.getDenumire(), "suc")) // frappe
                    timp=8;
                // else ramane timpul de la dimensiune
            return timp;
        }
        else
            System.out.println("Bautura cautata nu exista!");
        return -1;
    }
}
