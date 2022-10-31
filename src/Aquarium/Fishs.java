package Aquarium;

import java.time.LocalDate;

public abstract class Fishs extends LivingBeing {
    public Fishs(int pv, int age) {
        super(pv, age);
    }

    abstract void eating(LivingBeing toBeEat);
    abstract String getName();
    abstract String getSex();

    abstract Fishs reproductionFishs(Fishs fish);
}

