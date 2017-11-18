package domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aeronave {
	@Id
	@GeneratedValue
	private long id;
	private int capacidadeTotal;
    @Enumerated(EnumType.STRING)
	private ModeloAeronave modelo;
	
	public Aeronave() {
		
	}
	
	public Aeronave(long id, int capacidadeTotal, ModeloAeronave modelo) {
		super();
		this.id = id;
		this.capacidadeTotal = capacidadeTotal;
		this.modelo = modelo;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCapacidadeTotal() {
		return capacidadeTotal;
	}
	public void setCapacidadeTotal(int capacidadeTotal) {
		this.capacidadeTotal = capacidadeTotal;
	}
	public ModeloAeronave getModelo() {
		return modelo;
	}
	public void setModelo(ModeloAeronave modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Aeronave [id=" + id + ", capacidadeTotal=" + capacidadeTotal + ", modelo=" + modelo + "]";
	}

	
	
}
