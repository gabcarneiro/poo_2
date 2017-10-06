package atividade.designpatterns;

public abstract class Animal {

    private String name;
    private IGo movement;

    abstract String go();

    public Animal(String name, IGo movement) {
        this.name = name;
        this.movement = movement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IGo getMovement() {
        return movement;
    }

    public void setMovement(IGo movement) {
        this.movement = movement;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
