package heranca;

public class Spell implements IWeapon {

	@Override
	public void damage(Personagem personagem) {
		personagem.setLife(personagem.getLife()-personagem.getLife()*0.23);

	}

}
