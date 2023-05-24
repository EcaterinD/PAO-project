package service;

import model.Meniu;
import repository.MeniuRepository;

import java.util.Map;
import java.util.Scanner;

public class MeniuService {
    private MeniuRepository meniuRepository;

    public MeniuService() {
        this.meniuRepository = new MeniuRepository();
    }

    public void addMeniu(Meniu meniu) {
        meniuRepository.addMeniu(meniu);
        System.out.println("Meniul a fost adaugat");
    }

    public Meniu buildMeniu(Scanner scanner) {
        System.out.println("Introduceti urmatoarele date separate prin '/':\npretul\ntimpul de preparare in minute\ngramajul total\ntipul sandwichului\nnumarul de suplimente\ncantitatea de cartofi in grame");
        String str = scanner.nextLine();
        String[] details = str.split("/");
        return new Meniu(Float.parseFloat(details[0]),Integer.parseInt(details[1]),Integer.parseInt(details[2]), details[3],Integer.parseInt(details[4]),Integer.parseInt(details[5]));
    }

    public void updateMeniu(Map<Integer, Meniu> meniu, Scanner scanner) {
        System.out.println("Meniuri existente:");
        for (Map.Entry<Integer, Meniu> me : meniu.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue());
        }
        System.out.println("Introduceti id-ul ales din lista de mai sus: ");
        String meniuid = scanner.nextLine();
        System.out.println("Noul pret: ");
        Float price = Float.parseFloat(scanner.nextLine());
        Meniu meniuaux = meniu.get(Integer.parseInt(meniuid));
        meniuRepository.updatePret(meniuaux, price);
        System.out.println("Pretul a fost modificat");
    }

    public void deleteMeniu(Map<Integer, Meniu> meniu, Scanner scanner) {
        System.out.println("Meniuri existente:");
        for (Map.Entry<Integer, Meniu> me : meniu.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue());
        }
        System.out.println("Introduceti id-ul ales din lista de mai sus: ");
        String meniuid = scanner.nextLine();
        Meniu meniuaux = meniu.get(Integer.parseInt(meniuid));
        meniuRepository.deleteMeniu(meniuaux);
        System.out.println("Meniul a fost sters");
    }

    public Map<Integer, Meniu> getAllMeniu() {
        return meniuRepository.getAllMeniu();
    }

//    public int price(int index) {
//        int result = meniuRepository.price(index);
//        return result;
//    }
}
