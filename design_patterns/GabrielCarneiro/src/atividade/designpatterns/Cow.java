package atividade.designpatterns;

public class Cow extends Animal{

    public Cow(String name, IGo movement) {
        super(name, movement);
    }

    @Override
    String go(){
        return "Cow "+ this.getMovement().go();
    }
}
