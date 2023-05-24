package service;

import model.Bautura;
import repository.BauturaRepository;

import java.util.Map;
import java.util.Scanner;

public class BauturaService {
    private BauturaRepository bauturaRepository;

    public BauturaService() {
        this.bauturaRepository = new BauturaRepository();
    }

    public void addBautura(Bautura bautura) {
        bauturaRepository.addBautura(bautura);
        System.out.println("Bautura a fost adaugata");
    }

    public Bautura buildBautura(Scanner scanner) {
        System.out.println("Introduceti urmatoarele date separate prin '/': \npretul\n1, daca bautura e calda sau 0, daca aceasta e rece\ndenumirea\ndimensiunea (S/M/L/XL)");
        String str = scanner.nextLine();
        String[] info = str.split("/");
        Bautura b = new Bautura(Float.parseFloat(info[0]),Boolean.parseBoolean(info[1]), info[2], info[3]);
        return b;
    }

    public void updateBautura(Map<Integer, Bautura> bauturi, Scanner scanner) {
        System.out.println("Bauturi existente:");
        for (Map.Entry<Integer, Bautura> me : bauturi.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue());
        }
        System.out.println("Introduceti id-ul ales din lista de mai sus: ");
        String bauturaid = scanner.nextLine();
        System.out.println("Noul pret: ");
        Float price = Float.parseFloat(scanner.nextLine());
        Bautura bautura = bauturi.get(Integer.parseInt(bauturaid));
        bauturaRepository.updatePret(bautura, price);
        System.out.println("Pretul a fost modificat");
    }

    public void deleteBautura(Map<Integer, Bautura> bauturi, Scanner scanner) {
        System.out.println("Bauturi existente:");
        for (Map.Entry<Integer, Bautura> me : bauturi.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue());
        }
        System.out.println("Introduceti id-ul ales din lista de mai sus: ");
        String bauturaid = scanner.nextLine();
        Bautura bautura = bauturi.get(Integer.parseInt(bauturaid));
        bauturaRepository.deleteBautura(bautura);
        System.out.println("Bautura a fost stearsa");
    }

    public Map<Integer, Bautura> getByPret(Map<Integer, Bautura> bauturi, Scanner scanner) {
        System.out.println("Preturile existente:");
        for (Map.Entry<Integer, Bautura> me : bauturi.entrySet()) {
            System.out.println(me.getKey() + ". " + me.getValue().getPret()+ " lei");
        }
        System.out.println("Introduceti id-ul ales din lista de mai sus: ");
        String bauturaid = scanner.nextLine();
        Bautura bautura = bauturi.get(Integer.parseInt(bauturaid));
        return bauturaRepository.getByPret(bautura);
    }

    public Map<Integer, Bautura> getAllBauturi() {
        return bauturaRepository.getAllBauturi();
    }

    //public int readyTime(int index) {return bauturaRepository.readyTime(index);}

}