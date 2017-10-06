package atividade.designpatterns;

public class GoldFish extends Animal{

    public GoldFish(String name, IGo movement) {
        super(name, movement);
    }

    @Override
    String go(){
        return "Goldfish "+ this.getMovement().go();
    }
}
