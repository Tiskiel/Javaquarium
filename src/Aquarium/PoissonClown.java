package Aquarium;

public class PoissonClown extends Fishs implements ICarnivorous{

    ESexualOrientation sexualOrientation = ESexualOrientation.hermaphroditeOpportuniste;

    private String sexe;
    private String name;

    public PoissonClown(int pv, int age, String sexe, String name) {
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
            return new PoissonClown(10, 0, Randoms.rand2() == 1 ? "M" : "F", "bbPoissonClown");
        }

        return null;
    }

    @Override
    public void eating(LivingBeing toBeEat) {
        if(this == toBeEat || this.getPv() > 5 || toBeEat instanceof Seaweed || toBeEat instanceof PoissonClown) return;

        toBeEat.setPv(toBeEat.getPv() - 4);
        this.setPv(this.getPv() + 5);

    }
}
