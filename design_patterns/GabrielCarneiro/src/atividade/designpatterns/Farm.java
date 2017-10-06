package atividade.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    private static Farm ourInstance = new Farm();

    public static Farm getInstance() {
        return ourInstance;
    }

    private Farm() {
    }

    private List<Animal> animals = new ArrayList<>();
    private AnimalFactory af;

    public void addAnimal(){
        animals.add(af.makeAnimal());
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
