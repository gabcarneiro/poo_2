package atividade.designpatterns;

public class Pig extends Animal {

    public Pig(String name, IGo movement) {
        super(name, movement);
    }

    @Override
    String go(){
        return "Pig "+ this.getMovement().go();
    }
}
