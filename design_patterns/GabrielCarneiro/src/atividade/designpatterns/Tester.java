package atividade.designpatterns;

public class Tester {
    public static void main(String[] args) {

    Farm farm = Farm.getInstance();

        farm.addAnimal();
        farm.addAnimal();
        farm.addAnimal();
        farm.addAnimal();


    System.out.println(farm.getAnimals());

    System.out.println(farm.getAnimals().get(0).go());

    }
}
