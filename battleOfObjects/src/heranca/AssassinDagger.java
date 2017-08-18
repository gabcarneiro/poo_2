package heranca;

public class AssassinDagger implements IWeapon {

    @Override
    public void damage(Personagem personagem) {
        personagem.setLife(personagem.getLife()-personagem.getLife()*0.30);

    }

}
