package service;

import model.Cumparator;
import repository.CumparatorRepository;

import java.util.Map;
import java.util.Scanner;

public class CumparatorService {
    private CumparatorRepository cumparatorRepository;

    public CumparatorService() {
        this.cumparatorRepository = new CumparatorRepository();
    }

    public void addCumparator(Cumparator cumparator) {
        cumparatorRepository.addCumparator(cumparator);
        System.out.println("Cumparatorul a fost adaugat");
    }

    public Cumparator buildCumparator(Scanner scanner) {
        System.out.println("\nIntroduceti urmatoarele date separate prin '/': \nnumele\nvarsta\nemailul\nnumarul de telefon\nadresa");
        String line = scanner.nextLine();
        String[] details = line.split("/");
        return new Cumparator(details[0], Integer.parseInt(details[1]),details[2],details[3],details[4]);
    }

    public void updateCumparator(Map<Integer, Cumparator> cumparatori, Scanner scanner) {
        System.out.println("Cumparatori existenti: ");
        for (Map.Entry<Integer, Cumparator> me : cumparatori.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue().getNume());
        }
        System.out.println("Introduceti id-ul ales din lista de mai sus: ");
        String cumparatorid = scanner.nextLine();
        System.out.println("Noul email: ");
        String email = scanner.nextLine();
        Cumparator cumparator = cumparatori.get(Integer.parseInt(cumparatorid));
        cumparatorRepository.updateEmail(cumparator, email);
        System.out.println("Emailul a fost modificat");
    }
    public void deleteCumparator(Map<Integer, Cumparator> cumparatori, Scanner scanner) {
        System.out.println("Cumparatori existenti: ");
        for (Map.Entry<Integer, Cumparator> me : cumparatori.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue().getNume());
        }
        System.out.println("Introduceti id-ul ales din lista de mai sus: ");
        String cumparatorid = scanner.nextLine();
        Cumparator cumparator = cumparatori.get(Integer.parseInt(cumparatorid));
        cumparatorRepository.deleteCumparator(cumparator);
        System.out.println("Cumparatorul a fost sters");
    }

    public Map<Integer, Cumparator> getAllCumparatori() {
        return cumparatorRepository.getAllCumparatori();
    }
}