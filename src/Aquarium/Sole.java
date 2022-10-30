package Aquarium;

public class Sole extends LivingBeing implements IHerbivore, IReproduction{

    ESexualOrientation sexualOrientation = ESexualOrientation.hermaphroditeOpportuniste;

    private String sexe;
    private String name;

    public Sole(int pv, int age, String sexe, String name) {
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
}
