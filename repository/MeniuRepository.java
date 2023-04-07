package repository;

import model.Comanda;
import model.Meniu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeniuRepository {

    List<Comanda> meniuri = new ArrayList<>();

    public Comanda add(Comanda meniu) {

        meniuri.add(meniu);
        //System.out.println(Arrays.toString(meniuri));
        System.out.println("\nAdaugarea a fost realizata cu succes");

        for (Comanda element : meniuri) {
            System.out.println(element);
        }
        return meniu;
    }

    public Comanda get(int index) {
        if (meniuri.size()>index)
            return meniuri.get(index);
        else
            System.out.println("Meniul cautat nu exista!");
        return null;
    }

    public List<Comanda> getByPC(Boolean premium, Integer cantitate) {
        List<Comanda> loc = new ArrayList<>();
        for (Comanda element : meniuri) {
            Meniu m = (Meniu) element;
            if (element != null)
                if(cantitate<m.getCantitate() && m.getPremium()==premium)
                    loc.add(element);
        }
        if (loc.size()==0)
        {System.out.println("Nu exista niciun meniu cu caracteristicile cautate!");
            return null;}
        else
            return loc;
    }

    public List<Comanda> getAll() {
        return meniuri;
    }

    public boolean update(int index, Comanda meniu) {
        if (meniuri.size()>index) {
            meniuri.set(index, meniu);
            //System.out.println(Arrays.toString(meniuri));
            System.out.println("\nModificarea a fost realizata cu succes");
            for (Comanda element : meniuri) {
                System.out.println(element);
            }
            return true;
        }
        else {
            System.out.println("Meniul cautat nu exista pentru a fi modificat!");
            return false;
        }
    }

    public boolean delete(int index) {
        if (meniuri.size()>index) {
            meniuri.remove(index);
            System.out.println("\nStergerea a fost realizata cu succes");
            return true;
        }
        else {
            System.out.println("Meniul cautat nu exista pentru a fi sters!");
            return false;
        }
    }

    public int price(int index)
    {
        int pret=0;
        Meniu m = (Meniu) meniuri.get(index);
        if (meniuri.get(index) != null){
            if (m.getCantitateCartofi()<300)
                pret+=5;
            else
                pret+=7;
            if (m.getTipSandwich()!="nimic")
                pret+=10;
            if (m.getTipSos()!="nimic")
                pret+=3;
            pret+=m.getNrSuplimente()*4;
            return pret;
        }
        else
            System.out.println("Meniul cautat nu exista!");
        return -1;
    }
}