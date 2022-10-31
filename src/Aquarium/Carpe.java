package Aquarium;

public class Carpe extends Fishs implements IHerbivore{

    ESexualOrientation sexualOrientation = ESexualOrientation.monoSexue;

    private String sexe;
    private String name;

    public Carpe(int pv, int age, String sexe, String name) {
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

        if(!(fish instanceof Carpe) || this == fish) return null;

        if(this.getSex() == "M" && fish.getSex() == "F" && this.getPv() >= 5){
            return new Carpe(10, 0, Randoms.rand2() == 1 ? "F" : "M", "bbBar");
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
