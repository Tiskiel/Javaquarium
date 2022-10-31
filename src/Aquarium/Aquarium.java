package Aquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aquarium {

    private static Aquarium instance = null;
    private List<LivingBeing> livingBeingsList = new ArrayList<>();
    private List<Fishs> fishs = new ArrayList<>();
    private List<Seaweed> seaweeds = new ArrayList<>();

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



        Fishs bbFish = fishs.get(Randoms.rdm(fishs.size())).reproductionFishs(fishs.get(Randoms.rdm(fishs.size())));

        if(bbFish != null) {
            fishs.add(bbFish);
            System.out.println(bbFish + "est né");
        }

        List<ICarnivorous> carnivorous = fishs.stream()
                                                    .filter(carni -> carni instanceof ICarnivorous)
                                                        .map(carni -> (ICarnivorous)carni)
                                                            .toList();

        List<IHerbivore> herbivore = fishs.stream()
                                                    .filter(herbi -> herbi instanceof IHerbivore)
                                                        .map(herbi -> (IHerbivore)herbi)
                                                            .toList();


        Fishs carnivorousFighter = (Fishs)carnivorous.get(Randoms.rdm(carnivorous.size()));
        Fishs fishAttacked = fishs.get(Randoms.rdm(fishs.size()));

        carnivorousFighter.eating(fishAttacked);

        if(fishAttacked.getPv() <= 0) {
            fishs.remove(fishAttacked);
            System.out.println(fishAttacked.getName() + "est mort");
        }


    }
}
