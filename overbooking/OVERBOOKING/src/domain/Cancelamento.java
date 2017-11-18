package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cancelamento {
	
	@Id
	@GeneratedValue
	private long id;
	@OneToOne
	private Passageiro passageiro;
	private String overbooking;
	
	
	
	public Cancelamento() {
		
	}
	
	public Cancelamento(long id, Passageiro passageiro, String overbooking) {
		super();
		this.id = id;
		this.passageiro = passageiro;
		this.overbooking = overbooking;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	
	public String getOverbooking() {
		return overbooking;
	}
	public void setOverbooking(String overbooking) {
		this.overbooking = overbooking;
	}

	@Override
	public String toString() {
		return "Cancelamento [id=" + id + ", passageiro=" + passageiro + ", overbooking=" + overbooking + "]";
	}
	
	
}
