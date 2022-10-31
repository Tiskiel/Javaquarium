package Aquarium;

public abstract class LivingBeing {
    private int pv = 10;
    private int age = 0;

    public LivingBeing(int pv, int age) {
        this.pv = pv;
        this.age = age;
    }

    public int getPv() {
        return pv;
    }

    protected void setPv(int pv) {
        this.pv = pv;
    }

    public int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }



}
