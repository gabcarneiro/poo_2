package domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Voo {
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Aeronave aeronave;
	private String origem;
	private String destino;
	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
	private List<Passageiro> reservas = new ArrayList();
	@OneToMany(cascade = CascadeType.ALL)
	private List<Cancelamento> cancelamentos = new ArrayList();
	private int ocupacaoAtual = 0;
	
	
	public Voo(long id, Aeronave aeronave, String origem, String destino, List<Passageiro> reservas,
			List<Cancelamento> cancelamentos, int ocupacaoAtual) {
		super();
		this.id = id;
		this.aeronave = aeronave;
		this.origem = origem;
		this.destino = destino;
		this.reservas = reservas;
		this.cancelamentos = cancelamentos;
		this.ocupacaoAtual = ocupacaoAtual;
	}


	public Voo() {}
	
	public int reservaPoltrona(Passageiro passageiro){
		if (ocupacaoAtual < aeronave.getCapacidadeTotal() && !passageiroEstaNoVoo(passageiro)) {
			reservas.add(passageiro);
			ocupacaoAtual++;
		} else {
			if (!OverbookingPolicyFactory.makeOverbookingPolicy(passageiro).
					aplicarOverbooking(passageiro, this)) {
				throw new  UnsupportedOperationException("Reserva indisponivel!");
			}
		}
		return reservas.indexOf(passageiro);
	}

	public void removeReserva (Passageiro passageiro) {
		if (reservas.contains(passageiro)) {
			reservas.remove(passageiro);
			ocupacaoAtual--;
		} else {
			throw new UnsupportedOperationException("O passageiro não está cadastrado no voo!");
		}
	}
	
	public void efetuaCancelamento(Passageiro passageiro, String motivo) {
		if (reservas.contains(passageiro)) {
			Cancelamento cancelamento = new Cancelamento();
			cancelamento.setOverbooking(motivo);
			cancelamento.setPassageiro(passageiro);
			cancelamentos.add(cancelamento);
			removeReserva(passageiro);
		} 
	}
	
	private boolean passageiroEstaNoVoo(Passageiro passageiro){
		return (reservas.contains(passageiro))?true:false;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Aeronave getAeronave() {
		return aeronave;
	}
	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public List<Passageiro> getReservas() {
		return reservas;
	}
	public void setReservas(List<Passageiro> reservas) {
		this.reservas = reservas;
	}
	public int getOcupacaoAtual() {
		return ocupacaoAtual;
	}
	public void setOcupacaoAtual(int ocupcacaoAtual) {
		this.ocupacaoAtual = ocupcacaoAtual;
	}

	public List<Cancelamento> getCancelamentos() {
		return cancelamentos;
	}

	public void setCancelamentos(List<Cancelamento> cancelamentos) {
		this.cancelamentos = cancelamentos;
	}


	@Override
	public String toString() {
		return "Voo [id=" + id + ", aeronave=" + aeronave + ", origem=" + origem + ", destino=" + destino
				+ ", ocupacaoAtual=" + ocupacaoAtual + "]";
	}
	
	
	
	
	
}
