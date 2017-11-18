package domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passageiro {
	
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String cpf;
    @Enumerated(EnumType.STRING)
	private Categoria categoria;

    
	public Passageiro() {
		
	}

    public Passageiro(String nome, String cpf, Categoria categoria) {
        this.nome = nome;
        this.cpf = cpf;
        this.categoria = categoria;
    }

	public Passageiro(long id, String nome, String cpf, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.categoria = categoria;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Passageiro [nome=" + nome + ", cpf=" + cpf + ", categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passageiro other = (Passageiro) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	
    
	
	
	
	
	
	
}
