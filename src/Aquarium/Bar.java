package Aquarium;

import java.util.Random;

public class Bar extends Fishs implements IHerbivore{

    ESexualOrientation sexualOrientation = ESexualOrientation.hermaphroditeByAge;

    Random rdm = new Random();

    private String sexe;
    private String name;

    public Bar(int pv, int age, String sexe, String name) {
        super(pv, age);
        this.setSexe(sexe);
        this.setName(name);
    }

    public void setSexe(String sexe) {
        if(sexe == "M" || sexe == "F")
            this.sexe = sexe;
    }

    private void setName(String name) {
        if(name != "") {
            this.name = name;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSex() {
        return sexe;
    }


    public Fishs reproductionFishs(Fishs fish) {
        if(this.getAge() >= 10 && this.getSex() == "M"){
            this.setSexe("F");
        }

        if((this.getSex() == "M" && fish.getSex() == "F")
                && (this != fish)
                    && (this.getPv() >= 5)
                        && (fish instanceof Bar)){
            return new Bar(10, 0, "M", "bbBar");
        }
        return null;
    }

    @Override
    public void eating(LivingBeing toBeEat) {
        if(this.getPv() > 5 || !(toBeEat instanceof Seaweed)) return;

        toBeEat.setPv(toBeEat.getPv() - 2);
        this.setPv(this.getPv() + 3);

    }
}
