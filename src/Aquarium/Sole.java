package Aquarium;

public class Sole extends Fishs implements IHerbivore{

    ESexualOrientation sexualOrientation = ESexualOrientation.hermaphroditeOpportuniste;

    private String sexe;
    private String name;

    public Sole(int pv, int age, String sexe, String name) {
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
        if(this.getClass() != fish.getClass() || this.getPv() < 5)
            return null;

        if(this.sexe != fish.getSex()) {
            return new Sole(10, 0, Randoms.rand2() == 1 ? "M" : "F", "bbSole");
        }

        if(this.sexe == fish.getSex() && this.sexe == "M") {
            this.setSexe("F");
            return new Sole(10, 0, Randoms.rand2() == 1 ? "M" : "F", "bbSole");
        }

        if(this.sexe == fish.getSex() && this.sexe == "F") {
            this.setSexe("M");
            return new Sole(10, 0, Randoms.rand2() == 1 ? "M" : "F", "bbSole");
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
