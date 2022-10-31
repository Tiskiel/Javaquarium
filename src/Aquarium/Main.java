package Aquarium;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Seaweed sw1 = new Seaweed(15,0);
        Seaweed sw2 = new Seaweed(10,11);
        Seaweed sw3 = new Seaweed(22,10);
        Seaweed sw4 = new Seaweed(5,5);

        Carpe f1 = new Carpe(15,2,"F", "Praline");
        Carpe f2 = new Carpe(13,2,"F", "Pralinette");
        Carpe f3 = new Carpe(11,2,"M", "Perlo");
        Carpe f4 = new Carpe(8,2,"M", "Anakin");

        Bar b1 = new Bar(15, 2, "F", "Fifi");
        Bar b2 = new Bar(12, 12, "F", "Fifille");
        Bar b3 = new Bar(9, 8, "M", "Fifo");
        Bar b4 = new Bar(5, 7, "M", "Filou");

        Merou m1 = new Merou(15, 2, "F", "Fivette");
        Merou m2 = new Merou(8, 8, "F", "Lira");
        Merou m3 = new Merou(5, 6, "M", "kikou");
        Merou m4 = new Merou(12, 5, "M", "Fior");

        PoissonClown pc1 = new PoissonClown(15, 2, "F", "jikette");
        PoissonClown pc2 = new PoissonClown(11, 12, "F", "jinette");
        PoissonClown pc3 = new PoissonClown(8, 7, "M", "jin");
        PoissonClown pc4 = new PoissonClown(9, 8, "M", "jikot");

        Sole s1 = new Sole(11, 2, "F", "Jiji");
        Sole s2 = new Sole(9, 11, "F", "hermione");
        Sole s3 = new Sole(8, 8, "M", "Valentino");
        Sole s4 = new Sole(5, 5, "M", "Rockette");

        Thon t1 = new Thon(5, 8, "F", "Henriette");
        Thon t2 = new Thon(14, 7, "F", "Erza");
        Thon t3 = new Thon(8, 6, "M", "Limule");
        Thon t4 = new Thon(15, 11, "M", "Natsu");

        Aquarium aquarium = Aquarium.getInstance();

        aquarium.populateAquarium(sw1);
        aquarium.populateAquarium(sw2);
        aquarium.populateAquarium(sw3);
        aquarium.populateAquarium(sw4);

        aquarium.populateAquarium(f1);
        aquarium.populateAquarium(f2);
        aquarium.populateAquarium(f3);
        aquarium.populateAquarium(f4);

        aquarium.populateAquarium(b1);
        aquarium.populateAquarium(b2);
        aquarium.populateAquarium(b3);
        aquarium.populateAquarium(b4);

        aquarium.populateAquarium(m1);
        aquarium.populateAquarium(m2);
        aquarium.populateAquarium(m3);
        aquarium.populateAquarium(m4);

        aquarium.populateAquarium(pc1);
        aquarium.populateAquarium(pc2);
        aquarium.populateAquarium(pc3);
        aquarium.populateAquarium(pc4);

        aquarium.populateAquarium(s1);
        aquarium.populateAquarium(s2);
        aquarium.populateAquarium(s3);
        aquarium.populateAquarium(s4);

        aquarium.populateAquarium(t1);
        aquarium.populateAquarium(t2);
        aquarium.populateAquarium(t3);
        aquarium.populateAquarium(t4);

        System.out.println("Welcome to your simulation, enter number of life cycle you want try !");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        for (int i = 0; i < choice; i++) {
            aquarium.cycleLife();
        }


    }
}
