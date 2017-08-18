package heranca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tester {

	public static void main(String[] args) {

		Personagem knight = new Knight("Lord Stark", 100, 100, new Sword());

		Personagem sniper = new Sniper("Vasili Zaitzev", 100, 100, new AwpRifle());

		Personagem wizzard = new Wizzard("Oronin", 100, 100, new Spell());

		Personagem assassin = new Assassin("Talon",100, 100, new AssassinDagger());

		Personagem barbarian = new Barbarian("Jadgasgelf", 100, 100, new WarAxe());

		List<Personagem> characters = new ArrayList<>();

		Random randomGenerator = new Random();

		characters.add(knight);
		characters.add(sniper);
		characters.add(wizzard);
		characters.add(barbarian);
		characters.add(assassin);

		while (characters.size() > 1) {
			int bound = characters.size();

			int p1 = randomGenerator.nextInt(bound);
			int p2 = randomGenerator.nextInt(bound);

			while(p1 == p2){
				p2 = randomGenerator.nextInt(bound);
			}

			characters.get(p1).attack(characters.get(p2));

			if ((int) characters.get(p2).getLife() <= 0){
				characters.remove(p2);
			}

		}

		Personagem survivor = characters.get(0);

		System.out.println(survivor.getName() + " is the last man remaining!");
	}

}
