package atividade.designpatterns;

public class Bird extends Animal {

    public Bird(String name, IGo movement) {
        super(name, movement);
    }

    @Override
    String go(){
        return "Bird "+ this.getMovement().go();
    }
}
