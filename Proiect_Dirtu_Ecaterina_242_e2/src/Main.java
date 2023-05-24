import model.*;
import service.*;
import others.AuditHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws IOException {

        CumparatorService cumparatorService = new CumparatorService();
        MeniuService meniuService = new MeniuService();
        DesertService desertService = new DesertService();
        BauturaService bauturaService = new BauturaService();
        ComandaService comandaService = new ComandaService();

        AuditHelper auditHelper = new AuditHelper();

        Scanner scanner = new Scanner(System.in);

        Map<Integer, Meniu> meniuri = meniuService.getAllMeniu();
        Map<Integer, Desert> deserturi = desertService.getAllDesert();
        Map<Integer, Bautura> bauturi = bauturaService.getAllBauturi();
        Map<Integer, Cumparator> cumparatori = cumparatorService.getAllCumparatori();
        ArrayList<Comanda> comenzi = comandaService.getAllComenzi(cumparatori, meniuri, deserturi, bauturi);
        Collections.sort(comenzi);

        System.out.println("Main Application: \n (pentru iesirea din program tastati '0')");

        while(true) {
            System.out.println();
            System.out.println("1. Afisare\n2. Adaugare\n3. Modificare\n4. Stergere");
            System.out.print("Optiunea aleasa: ");
            String option = scanner.nextLine();
            switch(option) {
                case "0" : { System.exit(0); }
                case "1" : {
                    int ok = 1;
                    while (ok == 1) {
                        System.out.println();
                        System.out.println("1. Afisare cumparatori\n2. Afisare produse\n3. Afisare comenzi\n4. Afisarea comenzilor unui cumparator");
                        System.out.print("Optiunea aleasa: ");
                        String afisareOption = scanner.nextLine();
                        switch (afisareOption) {
                            case "0": {
                                ok = 0;
                                break;
                            }
                            case "1": {
                                for (Map.Entry<Integer, Cumparator> i : cumparatori.entrySet()) {
                                    System.out.println(i.getKey() + ". " + i.getValue());
                                }
                                auditHelper.addAction("Afisare cumparatori");
                                break;
                            }
                            case "2": {
                                System.out.println("Ce produse doriti sa fie afisate? \n1. toate\n2. bauturi cu un pret si denumire specificate");//\n3. ");
                                String produsoption = scanner.nextLine();
                                switch (produsoption) {
                                    case "1" : {
                                        for (Map.Entry<Integer, Meniu> i : meniuri.entrySet()) {
                                            System.out.println(i.getKey() + ". " + i.getValue());
                                        }
                                        for (Map.Entry<Integer, Desert> i : deserturi.entrySet()) {
                                            System.out.println(i.getKey() + ". " + i.getValue());
                                        }
                                        for (Map.Entry<Integer, Bautura> i : bauturi.entrySet()) {
                                            System.out.println(i.getKey() + ". " + i.getValue());
                                        }
                                        auditHelper.addAction("Afisare produse");
                                        break;
                                    }
                                    case "2" : {
                                        Map<Integer, Bautura> bauturiCautate = bauturaService.getByPret(bauturi, scanner);
                                        for (Map.Entry<Integer, Bautura> i : bauturiCautate.entrySet()) {
                                            System.out.println(i.getKey() + ". " + i.getValue());
                                        }
                                        auditHelper.addAction("Afisarea bauturilor cu un pret dat");
                                        break;
                                    }
//                                    case "3" : {
//                                        //
//                                    }
                                    default:
                                        System.out.println("Optiunea e invalida, introduceti o valoare din lista de mai sus.");
                                }
                                break;
                            }
                            case "3": {
                                for (Comanda o : comenzi) {
                                    System.out.println(o);
                                }
                                auditHelper.addAction("Afisare comenzi");
                                break;
                            }
                            case "4" : {
                                comandaService.getAllComenziByCumparator(scanner, cumparatori, meniuri, deserturi, bauturi);
                                auditHelper.addAction("Afisarea comenzilor unui cumparator");
                                break;
                            }
                            default: {
                                System.out.println("Optiunea e invalida, introduceti o valoare din lista de mai sus.");
                            }
                        }
                    }
                    break;
                }
                case "2" : {
                    int ok = 1;
                    while (ok == 1) {
                        System.out.println();
                        System.out.println("1. Adaugare cumparator\n2. Adaugare produs\n3. Adaugare comanda");
                        System.out.print("Optiunea aleasa: ");
                        String addOption = scanner.nextLine();
                        switch (addOption) {
                            case "0" : {
                                ok = 0;
                                break;
                            }
                            case "1" : {
                                cumparatorService.addCumparator(cumparatorService.buildCumparator(scanner));
                                auditHelper.addAction("Adaugare cumparator");
                                cumparatori = cumparatorService.getAllCumparatori();
                                break;
                            }
                            case "2" : {
                                System.out.println("Ce tip de produs adaugati? \n1. meniu\n2. desert\n3. bautura");
                                String produsoption = scanner.nextLine();
                                switch (produsoption) {
                                    case "1" : {
                                        meniuService.addMeniu(meniuService.buildMeniu(scanner));
                                        meniuri = meniuService.getAllMeniu();
                                        auditHelper.addAction("Adaugare meniu");
                                        break;
                                    }
                                    case "2" : {
                                        desertService.addDesert(desertService.buildDesert(scanner));
                                        deserturi = desertService.getAllDesert();
                                        auditHelper.addAction("Adaugare desert");
                                        break;
                                    }
                                    case "3" : {
                                        bauturaService.addBautura(bauturaService.buildBautura(scanner));
                                        bauturi = bauturaService.getAllBauturi();
                                        auditHelper.addAction("Adaugare bautura");
                                        break;
                                    }
                                    default:
                                        System.out.println("Optiunea e invalida, introduceti o valoare din lista de mai sus.");
                                }
                                break;
                            }
                            case "3" : {
                                comandaService.addComanda(comandaService.buildComanda(scanner, cumparatori, meniuri, deserturi, bauturi));
                                comenzi = comandaService.getAllComenzi(cumparatori, meniuri, deserturi, bauturi);
                                auditHelper.addAction("Adaugare comanda");
                                break;
                            }
                            default: {
                                System.out.println("Optiunea e invalida, introduceti o valoare din lista de mai sus.");
                            }
                        }
                    }
                    break;
                }
                case "3" : {
                    int ok = 1;
                    while (ok == 1) {
                        System.out.println();
                        System.out.println("1. Modificarea emailului unui cumparator\n2. Modificarea pretului unui produs");
                        System.out.print("Optiunea aleasa: ");
                        String updateOption = scanner.nextLine();
                        switch (updateOption) {
                            case "0" : {
                                ok = 0;
                                break;
                            }
                            case "1" : {
                                cumparatorService.updateCumparator(cumparatori, scanner);
                                auditHelper.addAction("Modificarea emailului unui cumparator");
                                cumparatori = cumparatorService.getAllCumparatori();
                                break;
                            }
                            case "2" : {
                                System.out.println("Ce tip de produs modificati? \n1. meniu\n2. desert\n3. bautura");
                                String produsoption = scanner.nextLine();
                                switch (produsoption) {
                                    case "1" : {
                                        meniuService.updateMeniu(meniuri, scanner);
                                        meniuri = meniuService.getAllMeniu();
                                        auditHelper.addAction("Modificarea pretului unui meniu");
                                        break;
                                    }
                                    case "2" : {
                                        desertService.updateDesert(deserturi, scanner);
                                        deserturi = desertService.getAllDesert();
                                        auditHelper.addAction("Modificarea pretului unui desert");
                                        break;
                                    }
                                    case "3" : {
                                        bauturaService.updateBautura(bauturi, scanner);
                                        bauturi = bauturaService.getAllBauturi();
                                        auditHelper.addAction("Modificarea pretului unei bauturi");
                                        break;
                                    }
                                    default:
                                        System.out.println("Optiunea e invalida, introduceti o valoare din lista de mai sus..");
                                }
                                break;
                            }
                            default : {
                                System.out.println("Optiunea e invalida, introduceti o valoare din lista de mai sus.");
                            }
                        }
                    }
                    break;
                }
                case "4" : {
                    int ok = 1;
                    while (ok == 1) {
                        System.out.println();
                        System.out.println("1. Stergerea unui cumparator\n2. Stergerea unui produs");
                        System.out.print("Optiunea aleasa: ");
                        String updateOption = scanner.nextLine();
                        switch (updateOption) {
                            case "0" : {
                                ok = 0;
                                break;
                            }
                            case "1" : {
                                cumparatorService.deleteCumparator(cumparatori, scanner);
                                auditHelper.addAction("Stergerea unui cumparator");
                                cumparatori = cumparatorService.getAllCumparatori();
                                break;
                            }
                            case "2" : {
                                System.out.println("Ce tip de produs stergeti? \n1. meniu\n2. desert\n3. bautura");
                                String produsoption = scanner.nextLine();
                                switch (produsoption) {
                                    case "1" : {
                                        meniuService.deleteMeniu(meniuri, scanner);
                                        meniuri = meniuService.getAllMeniu();
                                        break;
                                    }
                                    case "2" : {
                                        desertService.deleteDesert(deserturi, scanner);
                                        deserturi = desertService.getAllDesert();
                                        break;
                                    }
                                    case "3" : {
                                        bauturaService.deleteBautura(bauturi, scanner);
                                        bauturi = bauturaService.getAllBauturi();
                                        break;
                                    }
                                    default:
                                        System.out.println("Optiunea e invalida, introduceti o valoare din lista de mai sus..");
                                }
                                auditHelper.addAction("Stergerea unui produs");
                                break;
                            }
                            default : {
                                System.out.println("Optiunea e invalida, introduceti o valoare din lista de mai sus.");
                            }
                        }
                    }
                    break;
                }
                default : {
                    System.out.println("Optiunea e invalida, introduceti o valoare din lista de mai sus.");
                }
            }

        }
    }
}