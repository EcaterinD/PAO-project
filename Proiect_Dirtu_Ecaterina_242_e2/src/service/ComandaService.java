package service;

import model.*;
import repository.ComandaRepository;

import java.util.*;

public class ComandaService {
    private ComandaRepository comandaRepository;

    public ComandaService() {
        this.comandaRepository = new ComandaRepository();
    }

    public void addComanda(Comanda comanda) {
        comandaRepository.addComanda(comanda);
        System.out.println("Comanda a fost adaugata");
    }

    public Comanda buildComanda(Scanner scanner, Map<Integer, Cumparator> cumparatori, Map<Integer, Meniu> menius, Map<Integer, Desert> deserturi, Map<Integer, Bautura> bauturi) {
        Comanda comanda = null;
        try {
            System.out.println("Cumparatori existenti: ");
            for (Map.Entry<Integer, Cumparator> me : cumparatori.entrySet()) {
                System.out.println(me.getKey() + ". " + me.getValue().getNume());
            }
            System.out.println("Introduceti id-ul ales din lista de mai sus: ");
            String cumparatorid = scanner.nextLine();
            Cumparator cumparator = cumparatori.get(Integer.parseInt(cumparatorid));
            if (cumparator == null) {
                System.out.println("Cumparatorul cu id-ul introdus nu exista");
            }
            System.out.println("Adaugati un meniu? (da/nu)");
            Meniu meniu = null;
            String meniuoption = scanner.nextLine();
            if (Objects.equals(meniuoption, "da")) {
                System.out.println("Meniuri existente:");
                for (Map.Entry<Integer, Meniu> me : menius.entrySet()) {
                    System.out.println(me.getKey() + ". " + me.getValue());
                }
                System.out.println("Introduceti id-ul ales din lista de mai sus: ");
                String meniuid = scanner.nextLine();
                Meniu meniuaux = menius.get(Integer.parseInt(meniuid));
                if (meniuaux == null) {
                    System.out.println("Meniul cu id-ul introdus nu exista");
                } else {
                    meniu = meniuaux;
                }
            }

            System.out.println("Adaugati un desert? (da/nu)");
            Desert desert = null;
            String desertoption = scanner.nextLine();
            if (Objects.equals(desertoption, "da")) {
                System.out.println("Desert available:");
                for (Map.Entry<Integer, Desert> me : deserturi.entrySet()) {
                    System.out.println(me.getKey() + ". " + me.getValue());
                }
                System.out.println("Introduceti id-ul ales din lista de mai sus: ");
                String desertid = scanner.nextLine();
                Desert desertaux = deserturi.get(Integer.parseInt(desertid));
                if (desertaux == null) {
                    System.out.println("Desertul cu id-ul introdus nu exista");
                } else {
                    desert = desertaux;
                }
            }

            System.out.println("Adaugati o bautura? (da/nu)");
            Bautura bautura = null;
            String bauturaoption = scanner.nextLine();
            if (Objects.equals(bauturaoption, "da")) {
                System.out.println("Bauturi existente:");
                for (Map.Entry<Integer, Bautura> me : bauturi.entrySet()) {
                    System.out.println(me.getKey() + ". " + me.getValue());
                }
                System.out.println("Introduceti id-ul ales din lista de mai sus: ");
                String bauturaid = scanner.nextLine();
                Bautura bauturaaux = bauturi.get(Integer.parseInt(bauturaid));
                if (bauturaaux == null) {
                    System.out.println("Bautura cu id-ul introdus nu exista");
                } else {
                    bautura = bauturaaux;
                }
            }
            if (bautura != null || desert!=null || meniu != null) {
                comanda = new Comanda(cumparator, meniu, desert, bautura);
            }
            else {
                throw new RuntimeException("Comanda nu a putut fi creata!");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return comanda;
    }
    
    public ArrayList<Comanda> getAllComenzi(Map<Integer, Cumparator> cumparatori, Map<Integer, Meniu> menius, Map<Integer, Desert> deserturi, Map<Integer, Bautura> bauturi) {
        return comandaRepository.getAllComenzi(cumparatori, menius, deserturi, bauturi);
    }

    public void getAllComenziByCumparator(Scanner scanner, Map<Integer, Cumparator> cumparatori, Map<Integer, Meniu> menius, Map<Integer, Desert> deserturi, Map<Integer, Bautura> bauturi) {
        System.out.println("Cumparatori existenti: ");
        for (Map.Entry<Integer, Cumparator> me : cumparatori.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue().getNume());
        }
        System.out.println("Introduceti id-ul ales din lista de mai sus: ");
        String cumparatorid = scanner.nextLine();
        comandaRepository.getAllComenziByCumparator(Integer.parseInt(cumparatorid), cumparatori, menius, deserturi, bauturi);
    }

}
