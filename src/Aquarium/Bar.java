package Aquarium;

import java.util.Random;

public class Bar extends LivingBeing implements IHerbivore, IReproduction{

    ESexualOrientation sexualOrientation = ESexualOrientation.hermaphroditeByAge;

    Random rdm = new Random();

    private String sexe;
    private String name;

    public Bar(int pv, int age, String sexe, String name) {
        super(pv, age);
        this.setSexe(sexe);
        this.setName(name);
    }

    @Override
    public void eating(LivingBeing toBeEat) {

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

    @Override
    public LivingBeing reproduction() {
        return null;
    }

    public LivingBeing reproduction(IFishs fish) {
        if(this.getAge() >= 10 && this.getSex() == "M"){
            this.setSexe("F");
        }

        if((this.getSex() == "M" && fish.getSex() == "F")
                && (this != fish)
                    && (this.getPv() >= 5)
                        && (this.getClass() == fish.getClass())){
            return new Bar(10, 0, Randoms.rand2() == 1 ? "F" : "M", "bbBar");
        }
        return null;
    }
}
