package Aquarium;

public class Seaweed extends LivingBeing{


    public Seaweed(int pv, int age) {
        super(pv, age);
    }
    public LivingBeing reproduction() {
        if(this.getPv() == 10) {
            this.setPv(this.getPv() / 2);
            return new Seaweed(this.getPv()/2, 0);
        }
        return null;
    }

}
