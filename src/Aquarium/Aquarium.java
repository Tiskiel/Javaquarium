package Aquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aquarium {

    private static Aquarium instance = null;
    protected List<LivingBeing> livingBeingsList = new ArrayList<>();
    protected List<Fishs> fishs = new ArrayList<>();
    protected List<Seaweed> seaweeds = new ArrayList<>();

    public static Aquarium getInstance() {
        return instance == null ? instance = new Aquarium() : instance;
    }

    private Aquarium() {

    }



    public void populateAquarium(LivingBeing toAdd) {
        if(toAdd == null) return;

        if(toAdd instanceof Seaweed) {
            seaweeds.add((Seaweed) toAdd);
        }

        if(toAdd instanceof Fishs) {
            fishs.add((Fishs) toAdd);
        }
    }

    public void generateGeneralList() {
        livingBeingsList.addAll(fishs);
        livingBeingsList.addAll(seaweeds);
    }

    public void cycleLife(){

        System.out.println(fishs);

        List<Fishs> carnivorous = fishs.stream()
                                            .filter(carni -> carni instanceof ICarnivorous)
                                                .map(carni -> carni)
                                                    .toList();

        List<Fishs> herbivore = fishs.stream()
                                            .filter(herbi -> herbi instanceof IHerbivore)
                                                .map(herbi -> herbi)
                                                    .toList();

        for (Fishs fish : fishs) {

            Fishs bbFish = fish.reproductionFishs(fishs.get(Randoms.rdm(fishs.size())));

            if(bbFish != null) {
                fishs.add(bbFish);
                System.out.println(bbFish + " est né");
            }
        }

        for (Seaweed seaweed : seaweeds) {

            Seaweed bbSeaweed = seaweed.reproduction();

            if (bbSeaweed != null) {
                seaweeds.add(bbSeaweed);
                System.out.println(bbSeaweed + " est né");
            }

        }


        for (Fishs carni : carnivorous) {

            Fishs fishAttacked = fishs.get(Randoms.rdm(fishs.size()));
            System.out.println(carni + " " + "attaque " + fishAttacked);
            carni.eating(fishAttacked);

            if (fishAttacked.getPv() <= 0) {
                fishs.remove(fishAttacked);
                System.out.println(fishAttacked.getName() + " " + "est mort");
            }
        }

        for (Fishs herbi : herbivore) {

            Seaweed seaweedAttacked = seaweeds.get(Randoms.rdm(seaweeds.size()));

            herbi.eating(seaweeds.get(Randoms.rdm(seaweeds.size())));
            System.out.println(herbi + " " + "mange " + seaweedAttacked);

            if (seaweedAttacked.getPv() <= 0){
                seaweeds.remove(seaweedAttacked);
                System.out.println(seaweedAttacked + " " + " a été mangée");
            }

        }

        generateGeneralList();

        for (LivingBeing livingBeing : livingBeingsList) {
            livingBeing.setAge(livingBeing.getAge() + 1);

            if (livingBeing instanceof Fishs) {
                livingBeing.setPv(livingBeing.getPv() - 1);
            }

            if (livingBeing.getPv() <= 0) {
                livingBeingsList.remove(livingBeing);
                System.out.println(livingBeing + " est mort de quelque chose");
            }

            if (livingBeing.getAge() >= 20) {
                livingBeingsList.remove(livingBeing);
                System.out.println(livingBeing + " est mort de viellesse");
            }
        }

    }
}
