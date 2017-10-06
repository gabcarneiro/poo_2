package atividade.designpatterns;

import java.util.Random;

public class AnimalFactory {

    public static Animal makeAnimal() {
        Random randomGenerator = new Random();

        int num = randomGenerator.nextInt(4); ;
        if (num == 0)
            return new Bird("Bird", new GoByFlying());
        else if (num == 1 )
            return new Cow("Cow", new GoByWalking());
        else if (num == 2)
            return new GoldFish("GoldFish", new GoBySwimming());
        else
            return new Pig("Pig", new GoByWalking());

    }

}
