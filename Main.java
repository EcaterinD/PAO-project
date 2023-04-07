import controller.*;
import model.Comanda;
import model.Cumparator;

import java.time.Year;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CumparatorController cc = new CumparatorController();
        MeniuController mc = new MeniuController();
        DesertController dc = new DesertController();
        BauturaController bc = new BauturaController();


        String optio; String option; String optionn; String optionnn; String rasp;

        String nume; String prenume; String CNP; Year anulNasterii; String adresa;
        String metodaPlata; Integer recenzie; Integer nrOrdine; Integer index; int nr = 0;

        Boolean premium; Integer cantitate;
        String tipSandwich; Integer nrSuplimente; String tipSos; Integer cantitateCartofi;
        String tipDesert; String aroma; Boolean topping;
        String tipBautura; String denumire; Character dimensiune;


        System.out.println("Main Application: \n (pentru iesirea din program tastati 'stop')\n");
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\nAlegeti: \n'1': Despre Cumparatori; \n'2': Despre Comenzi;\n");
            optio = scan.nextLine().trim();
            System.out.println("Ai introdus: " + optio);

            if (optio.equals("stop"))
                System.out.println("Exit");
            else if (Integer.parseInt(optio) == 1) {
                do {
                    System.out.println("\nAlege o actiune/interogare: \n'1': Adauga in coada; \n'2': Cauta dupa numarul de ordine; " +
                            "\n'3': Afiseaza toata coada; \n'4': Modifica datele dupa index; \n'5': Sterge din coada dupa index; " +
                            "\n'6': Care e media recenziilor tuturor cumparatorilor?; \n'7': Cati din cumparatori au peste 18 ani?; ");
                    option = scan.nextLine();
                    System.out.println("Ai introdus: " + option);

                    if (option.equals("stop"))
                        System.out.println("Exit");
                    else if (Integer.parseInt(option) == 1) {
                        System.out.println("\nNume: ");
                        nume = scan.nextLine();
                        System.out.println("Prenume: ");
                        prenume = scan.nextLine();
                        System.out.println("CNP: ");
                        CNP = scan.nextLine();
                        System.out.println("Anul Nasterii: ");
                        anulNasterii = Year.of(Integer.parseInt(scan.nextLine()));
                        nrOrdine = nr;
                        System.out.println("Adresa livrarii: ");
                        adresa = scan.nextLine();
                        System.out.println("Metoda de plata: ");
                        metodaPlata = scan.nextLine();
                        System.out.println("Recenzie (nr de la 0 la 5): ");
                        recenzie = Integer.parseInt(scan.nextLine());

                        cc.addCumparator(nume, prenume, CNP, anulNasterii, adresa, metodaPlata, nrOrdine, recenzie);
                        nr++;

                    }
                    else if (Integer.parseInt(option) == 2) {
                        System.out.println("\nNr de ordine cautat: ");
                        nrOrdine = Integer.parseInt(scan.nextLine());

                        if (cc.getCumparator(nrOrdine)!=null)
                            System.out.println(cc.getCumparator(nrOrdine));
                    }
                    else if (Integer.parseInt(option) == 3) {
                        List<Cumparator> ccc = cc.getAllCumparatori();
                        for (int i = 0; i < ccc.size(); i++)
                            System.out.println(cc.getCumparatorIndex(i));
                    }
                    else if (Integer.parseInt(option) == 4) {
                        System.out.println("\nAl catelea cumparator doriti sa fie modificat? ");
                        index = Integer.parseInt(scan.nextLine());

                        System.out.println("\nNume: ");
                        nume = scan.nextLine();
                        System.out.println("Prenume: ");
                        prenume = scan.nextLine();
                        System.out.println("CNP: ");
                        CNP = scan.nextLine();
                        System.out.println("Anul Nasterii: ");
                        anulNasterii = Year.of(Integer.parseInt(scan.nextLine()));
                        System.out.println("Adresa livrarii: ");
                        adresa = scan.nextLine();
                        System.out.println("Metoda de plata: ");
                        metodaPlata = scan.nextLine();
                        System.out.println("Recenzie (nr de la 0 la 5): ");
                        recenzie = Integer.parseInt(scan.nextLine());

                        cc.updateCumparator(index-1, nume, prenume, CNP, anulNasterii, adresa, metodaPlata, cc.getCumparatorIndex(index-1).getNrOrdine(), recenzie);

                    }
                    else if (Integer.parseInt(option) == 5) {
                        System.out.println("\nAl catelea cumparator doriti sa fie eliminat de la coada? ");
                        index = Integer.parseInt(scan.nextLine());

                        cc.deleteCumparator(index-1);
                    }
                    else if (Integer.parseInt(option) == 6) {
                        System.out.println("Media recenziilor este: "+ cc.score());
                    }
                    else if (Integer.parseInt(option) == 7) {
                        System.out.println(cc.countOver18() + " dintre cumparatori au peste 18 ani ");
                    }
                } while (!option.equals("stop"));
            }
            else if (Integer.parseInt(optio) == 2)
            {
                System.out.println("\nPlasati comanda: ");
                do {
                    System.out.println("\nAlege o actiune/interogare: \n'1': Adauga in cos; \n'2': Cauta dupa indexul produsului; " +
                            "\n'3': Afiseaza toate produsele din cos; \n'4': Modifica o comanda dupa index; \n'5': Sterge din cos dupa indexul produsului; " +
                            "\n'6': Afiseaza pretul unui meniu cautat dupa index; \n'7': Afiseaza toate meniurile cu o cantitate minima si un anumit status al abomanentului; " +
                            "\n'8': Afiseaza timpul de preparare al unei bauturi cautate dupa index;");
                    optionn = scan.nextLine();
                    System.out.println("Ai introdus: " + optionn);

                    if (optionn.equals("stop"))
                        System.out.println("Exit");
                    else if (Integer.parseInt(optionn) == 1) {
                        do {
                            System.out.println("\nCe fel de comanda adaugati? \"1\": Meniu; \"2\": Desert; \"3\": Bautura;");
                            optionnn = scan.nextLine();
                            System.out.println("Ai introdus: " + optionnn);

                            if (optionnn.equals("stop")) System.out.println("Exit");
                            else if (Integer.parseInt(optionnn) == 1) {
                                System.out.println("\nDoriti servicii premium? ('da'/'nu') ");
                                rasp = scan.nextLine();
                                premium = Objects.equals(rasp, "da");
                                System.out.println("Cantitatea portiei: ");
                                cantitate = Integer.parseInt(scan.nextLine());
                                System.out.println("Tip Sandwich: ");
                                tipSandwich = scan.nextLine();
                                System.out.println("Numar de Suplimente: ");
                                nrSuplimente = Integer.parseInt(scan.nextLine());
                                System.out.println("Tip Sos: ");
                                tipSos = scan.nextLine();
                                System.out.println("Cantitate Cartofi: ");
                                cantitateCartofi = Integer.parseInt(scan.nextLine());

                                mc.addMeniu(premium, cantitate, tipSandwich, nrSuplimente, tipSos, cantitateCartofi);
                            } else if (Integer.parseInt(optionnn) == 2) {
                                System.out.println("\nDoriti servicii premium? ('da'/'nu') ");
                                rasp = scan.nextLine();
                                premium = Objects.equals(rasp, "da");
                                System.out.println("Cantitatea portiei: ");
                                cantitate = Integer.parseInt(scan.nextLine());
                                System.out.println("Tip Desert: ");
                                tipDesert = scan.nextLine();
                                System.out.println("Aroma: ");
                                aroma = scan.nextLine();
                                System.out.println("Doriti topping? ('da'/'nu') ");
                                rasp = scan.nextLine();
                                topping = Objects.equals(rasp, "da");

                                dc.addDesert(premium, cantitate, tipDesert, aroma, topping);
                            } else if (Integer.parseInt(optionnn) == 3) {
                                System.out.println("\nDoriti servicii premium? ('da'/'nu') ");
                                rasp = scan.nextLine();
                                premium = Objects.equals(rasp, "da");
                                System.out.println("Tip Bautura: (calda/rece) ");
                                tipBautura = scan.nextLine();
                                System.out.println("Denumire: ");
                                denumire = scan.nextLine();
                                System.out.println("Dimensiune: (S/M/L) ");
                                dimensiune = scan.nextLine().charAt(0);
                                bc.addBautura(premium, tipBautura, denumire, dimensiune);
                            }
                        } while (!optionnn.equals("stop"));
                    }
                    else if (Integer.parseInt(optionn) == 2) {
                        do {
                            System.out.println("\nCe fel de comanda cautati? \n'1': Meniu; \n'2': Desert; \n'3': Bautura;");
                            optionnn = scan.nextLine();
                            System.out.println("Ai introdus: " + optionnn);

                            if (optionnn.equals("stop"))
                                System.out.println("Exit");
                            else if (Integer.parseInt(optionnn) == 1) {
                                System.out.println("\nIndexul cautat: ");
                                index = Integer.parseInt(scan.nextLine());
                                if (mc.getMeniu(index-1)!=null)
                                    System.out.println(mc.getMeniu(index-1));
                            }
                            else if (Integer.parseInt(optionnn) == 2) {
                                System.out.println("\nIndexul cautat: ");
                                index = Integer.parseInt(scan.nextLine());
                                if (dc.getDesert(index-1)!=null)
                                    System.out.println(dc.getDesert(index-1));
                            }
                            else if (Integer.parseInt(optionnn) == 3) {
                                System.out.println("\nIndexul cautat: ");
                                index = Integer.parseInt(scan.nextLine());
                                if (bc.getBautura(index-1)!=null)
                                    System.out.println(bc.getBautura(index-1));
                            }

                        } while (!optionnn.equals("stop"));
                    }
                    else if (Integer.parseInt(optionn) == 3) {
                        List<Comanda> mcc = mc.getAllMeniuri();
                        if (mcc.size() != 0) System.out.println("\nMeniuri:");
                        for (int i = 0; i < mcc.size(); i++)
                            System.out.println(mc.getMeniu(i));

                        List<Comanda> dcc = dc.getAllDeserturi();
                        if (dcc.size() != 0) System.out.println("\nDeserturi:");
                        for (int i = 0; i < dcc.size(); i++)
                            System.out.println(dc.getDesert(i));

                        List<Comanda> bcc = bc.getAllBauturi();
                        if (bcc.size() != 0) System.out.println("\nBauturi:");
                        for (int i = 0; i < bcc.size(); i++)
                            System.out.println(bc.getBautura(i));
                    }
                    else if (Integer.parseInt(optionn) == 4) {
                        do {
                            System.out.println("\nCe fel de comanda modificati? \n'1': Meniu; \n'2': Desert; \n'3': Bautura;");
                            optionnn = scan.nextLine();
                            System.out.println("Ai introdus: " + optionnn);

                            if (optionnn.equals("stop")) System.out.println("Exit");
                            else if (Integer.parseInt(optionnn) == 1) {
                                System.out.println("\nAl catelea meniu doriti sa fie modificat? ");
                                index = Integer.parseInt(scan.nextLine());

                                System.out.println("\nDoriti servicii premium? ('da'/'nu') ");
                                rasp = scan.nextLine();
                                premium = Objects.equals(rasp, "da");
                                System.out.println("Cantitatea portiei: ");
                                cantitate = Integer.parseInt(scan.nextLine());
                                System.out.println("Tip Sandwich: ");
                                tipSandwich = scan.nextLine();
                                System.out.println("Numar de Suplimente: ");
                                nrSuplimente = Integer.parseInt(scan.nextLine());
                                System.out.println("Tip Sos: ");
                                tipSos = scan.nextLine();
                                System.out.println("Cantitate Cartofi: ");
                                cantitateCartofi = Integer.parseInt(scan.nextLine());

                                mc.updateMeniu(index-1, premium, cantitate, tipSandwich, nrSuplimente, tipSos, cantitateCartofi);

                            } else if (Integer.parseInt(optionnn) == 2) {
                                System.out.println("\nAl catelea desert doriti sa fie modificat? ");
                                index = Integer.parseInt(scan.nextLine());

                                System.out.println("\nDoriti servicii premium? ('da'/'nu') ");
                                rasp = scan.nextLine();
                                premium = Objects.equals(rasp, "da");
                                System.out.println("Cantitatea portiei: ");
                                cantitate = Integer.parseInt(scan.nextLine());
                                System.out.println("Tip Desert: ");
                                tipDesert = scan.nextLine();
                                System.out.println("Aroma: ");
                                aroma = scan.nextLine();
                                System.out.println("Doriti topping? ('da'/'nu') ");
                                rasp = scan.nextLine();
                                topping = Objects.equals(rasp, "da");

                                dc.updateDesert(index-1, premium, cantitate, tipDesert, aroma, topping);

                            } else if (Integer.parseInt(optionnn) == 3) {
                                System.out.println("\nAl cata bautura doriti sa fie modificata? ");
                                index = Integer.parseInt(scan.nextLine());

                                System.out.println("\nDoriti servicii premium? ('da'/'nu') ");
                                rasp = scan.nextLine();
                                premium = Objects.equals(rasp, "da");
                                System.out.println("Tip Bautura: (calda/rece) ");
                                tipBautura = scan.nextLine();
                                System.out.println("Denumire: ");
                                denumire = scan.nextLine();
                                System.out.println("Dimensiune: (S/M/L) ");
                                dimensiune = scan.nextLine().charAt(0);

                                bc.updateBautura(index-1, premium, tipBautura, denumire, dimensiune);
                            }

                        } while (!optionnn.equals("stop"));

                    }
                    else if (Integer.parseInt(optionn) == 5) {
                        do {
                            System.out.println("\nCe fel de comanda stergeti? \n'1': Meniu; \n'2': Desert; \n'3': Bautura;");
                            optionnn = scan.nextLine();
                            System.out.println("Ai introdus: " + optionnn);

                            if (optionnn.equals("stop")) System.out.println("Exit");
                            else if (Integer.parseInt(optionnn) == 1) {
                                System.out.println("\nIndexul cautat: ");
                                index = Integer.parseInt(scan.nextLine());

                                System.out.println(mc.deleteMeniu(index-1));
                            } else if (Integer.parseInt(optionnn) == 2) {
                                System.out.println("\nIndexul cautat: ");
                                index = Integer.parseInt(scan.nextLine());

                                System.out.println(dc.deleteDesert(index-1));
                            } else if (Integer.parseInt(optionnn) == 3) {
                                System.out.println("\nIndexul cautat: ");
                                index = Integer.parseInt(scan.nextLine());

                                System.out.println(bc.deleteBautura(index-1));
                            }

                        } while (!optionnn.equals("stop"));
                    }
                    else if (Integer.parseInt(optionn) == 6) {
                        System.out.println("Pentru al catele meniu doriti sa stiti pretul? ");
                        index = Integer.parseInt(scan.nextLine());
                        float pret = mc.price(index-1);
                        if (pret!=-1)
                            System.out.println("Acest meniu costa: "+ pret + " lei.");
                    }
                    else if (Integer.parseInt(optionn) == 7) {
                        System.out.println("\nDoriti sa gasiti meniuri cu servicii premium? ('da'/'nu') ");
                        rasp = scan.nextLine();
                        if (rasp == "da") premium = true;
                        else premium = false;
                        System.out.println("Cantitatea minima a portiei: ");
                        cantitate = Integer.parseInt(scan.nextLine());

                        List<Comanda> mcc = mc.getByPC(premium, cantitate);
                        if (mcc!=null) {System.out.println("Meniurile care indeplinesc cerintele sunt: \n");
                        for (int i = 0; i < mcc.size(); i++)
                            System.out.println(mc.getMeniu(i));}
                    }
                    else if (Integer.parseInt(optionn) == 8) {
                        System.out.println("Pentru a cata bautura doriti sa stiti timpul de preparare? ");
                        index = Integer.parseInt(scan.nextLine());
                        float timp = bc.readyTime(index-1);
                        if (timp!=-1)
                            System.out.println("Aceasta bautura va fi gata in "+ timp + " minute.");
                    }
                } while (!optionn.equals("stop"));
            }
        } while (!optio.equals("stop"));

        scan.close();

    }
}