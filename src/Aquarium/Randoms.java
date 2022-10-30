package Aquarium;

import java.util.Random;

public abstract class Randoms {
    private static Random rdm = new Random();
    private static int randomized = rdm.nextInt(2);

    public static int rand2() {
        return randomized;
    }
}
