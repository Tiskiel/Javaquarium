package Aquarium;

public class Merou extends Fishs implements ICarnivorous{

    ESexualOrientation sexualOrientation = ESexualOrientation.hermaphroditeByAge;

    private String sexe;
    private String name;

    public Merou(int pv, int age, String sexe, String name) {
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
                && (this.getClass() == fish.getClass())){
            return new Merou(10, 0, "M", "bbMerou");
        }
        return null;
    }

    @Override
    public void eating(LivingBeing toBeEat) {
        if(this == toBeEat || this.getPv() > 5 || toBeEat instanceof Seaweed || toBeEat instanceof Merou) return;

        toBeEat.setPv(toBeEat.getPv() - 4);
        this.setPv(this.getPv() + 5);

    }
}
