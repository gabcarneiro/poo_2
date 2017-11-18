

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import persistence.AeronaveDAO;
import persistence.JPAUtil;
import persistence.PassageiroDAO;
import persistence.VooDAO;
import domain.Aeronave;
import domain.Cancelamento;
import domain.Categoria;
import domain.ModeloAeronave;
import domain.Passageiro;
import domain.Voo;;

public class TesterDAO {

	public static void main(String[] args) {
	
		Passageiro[] vetorPassageiro = new Passageiro[20];
		
		Aeronave a1 = new Aeronave();
		a1.setCapacidadeTotal(20);
		a1.setModelo(ModeloAeronave.BOEING272);

		new AeronaveDAO().save(a1);
		
		Voo voo = new Voo();
		voo.setAeronave(a1);
		
		new VooDAO().save(voo);
		
		for (int i = 0; i < vetorPassageiro.length; i++) {
			vetorPassageiro[i] = new Passageiro();
			vetorPassageiro [i].setCategoria(Categoria.COMUM);
			vetorPassageiro[i].setCpf(String.valueOf(i));
			
			new PassageiroDAO().save(vetorPassageiro[i]);
			
			Voo v1 = new VooDAO().find(new Long(1));
			
			v1.reservaPoltrona(vetorPassageiro[i]);
		
			new VooDAO().update(v1);

		}
		
		
		Voo v2 = new VooDAO().find(new Long(1));
		
		
		Passageiro p1 = new Passageiro();
		p1.setCpf("666.666.666-43");
		p1.setCategoria(Categoria.COMUM);
		p1.setNome("Joelma");
		
		
		new PassageiroDAO().save(p1);
		v2.reservaPoltrona(p1);
		
		Passageiro p2 = new Passageiro();
		p2.setCpf("444.666.666-43");
		p2.setCategoria(Categoria.COMUM);
		p2.setNome("Ximbinha");
		
		new PassageiroDAO().save(p2);
		
		v2.reservaPoltrona(p2);
		new VooDAO().update(v2);
		
		
		
		Passageiro p3 = new Passageiro();
		p3.setCpf("555.666.666-43");
		p3.setCategoria(Categoria.VIP);
		p3.setNome("Belem");
		
		new PassageiroDAO().save(p3);
		
		v2.reservaPoltrona(p3);
		
		new VooDAO().update(v2);
		
		for (Passageiro passageiro : v2.getReservas()) {
			System.out.println(passageiro);
		}
		

		
		//for (int i = 0; i < vetorPassageiro.length; i++) {
		///	Passageiro pass = new PassageiroDAO().find(new Long(i));
		//	voo.reservaPoltrona(pass);
		//	
		//}
		
		
	
	
	}

}
