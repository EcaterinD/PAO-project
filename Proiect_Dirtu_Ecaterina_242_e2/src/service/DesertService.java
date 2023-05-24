package service;

import model.Desert;
import repository.DesertRepository;

import java.util.Map;
import java.util.Scanner;

public class DesertService {
    private DesertRepository desertRepository;

    public DesertService() {
        this.desertRepository = new DesertRepository();
    }

    public void addDesert(Desert desert) {
        desertRepository.addDesert(desert);
        System.out.println("Desertul a fost adaugat");
    }

    public Desert buildDesert(Scanner scanner) {
        System.out.println("Introduceti urmatoarele date separate prin '/':\npretul\ntimpul de preparare in minute\ngramajul total\ntipul desertului (inghetata sau prajitura)\naroma\n1, daca doriti topping sau 0, daca nu");
        String str = scanner.nextLine();
        String[] details = str.split("/");
        return new Desert(Float.parseFloat(details[0]),Integer.parseInt(details[1]),Integer.parseInt(details[2]), details[3], details[4], Boolean.parseBoolean(details[5]));
    }

    public void updateDesert(Map<Integer, Desert> desert, Scanner scanner) {
        System.out.println("Deserturi existente:");
        for (Map.Entry<Integer, Desert> me : desert.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue());
        }
        System.out.println("Introduceti id-ul ales din lista de mai sus: ");
        String desertid = scanner.nextLine();
        System.out.println("Noul pret: ");
        Float price = Float.parseFloat(scanner.nextLine());
        Desert desertaux = desert.get(Integer.parseInt(desertid));
        desertRepository.updatePret(desertaux, price);
        System.out.println("Pretul a fost modificat");
    }

    public void deleteDesert(Map<Integer, Desert> desert, Scanner scanner) {
        System.out.println("Deserturi existente:");
        for (Map.Entry<Integer, Desert> me : desert.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue());
        }
        System.out.println("Introduceti id-ul ales din lista de mai sus: ");
        String desertid = scanner.nextLine();
        Desert desertaux = desert.get(Integer.parseInt(desertid));
        desertRepository.deleteDesert(desertaux);
        System.out.println("Desertul a fost sters");
    }

    public Map<Integer, Desert> getAllDesert() {
        return desertRepository.getAllDesert();
    }
}