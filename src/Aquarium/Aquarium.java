package Aquarium;

public class Aquarium {

    private static Aquarium instance = null;

    public static Aquarium getInstance() {
        if(instance == null)
            instance = new Aquarium();
        return instance;
    }

    private Aquarium() {

    }

    public void cycleLife(){

    }
}
