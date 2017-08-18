package heranca;

public abstract class Personagem {
	
	protected String name;
	protected int stamina;
	protected double life;
	protected IWeapon weapon;

	public Personagem(String name, int stamina, double life, IWeapon weapon) {
		super();
		this.name = name;
		this.stamina = stamina;
		this.life = life;
		this.weapon = weapon;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public double getLife() {
		return life;
	}

	public void setLife(double life) {
		this.life = life;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeapon(IWeapon weapon) {
		this.weapon = weapon;
	}

	public IWeapon getWepon() { return weapon; }

	public String getName() {
		return name;
	}


	public abstract void attack(Personagem personagem);
	
	

}
