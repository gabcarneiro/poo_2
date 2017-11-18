

import java.util.List;
import domain.OverbookingPadrao;

import domain.Aeronave;
import domain.Cancelamento;
import domain.Categoria;
import domain.ModeloAeronave;
import domain.Passageiro;
import domain.Voo;

public class TesteSemDAO {

	public static void main(String[] args) {
		
		Passageiro[] vetorPassageiro = new Passageiro[20];
		
		for (int i = 0; i < vetorPassageiro.length; i++) {
			vetorPassageiro[i] = new Passageiro();
			vetorPassageiro [i].setCategoria(Categoria.COMUM);
			vetorPassageiro[i].setCpf(String.valueOf(i));
		} 
		
		Aeronave a1 = new Aeronave(1, 20, ModeloAeronave.BOEING272);
		
		Voo v1 = new Voo();
		v1.setAeronave(a1);
		
		for (Passageiro passageiro : vetorPassageiro) {
			v1.reservaPoltrona(passageiro);
		}
		
		Passageiro p2 = new Passageiro();
		p2.setCategoria(Categoria.COMUM);
		
		Passageiro p3 = new Passageiro();
		p3.setCategoria(Categoria.VIP);
		p3.setCpf("555.444.333-22");
		
		v1.reservaPoltrona(new Passageiro("Ximbinha", "666.666.666-55", Categoria.COMUM));
		
		v1.reservaPoltrona(p2);
		
		v1.reservaPoltrona(p3);

		System.out.println("Reservas padrao -> " + v1.getReservas().size());
		
		
		for (Passageiro passageiro : v1.getReservas()) {
			System.out.print(v1.getReservas().indexOf(passageiro) + " ");
			System.out.println(passageiro.getCategoria());
		}
		
		new OverbookingPadrao().efetuaCancelamentosPadrao(v1);
		
		List <Cancelamento> lista = v1.getCancelamentos();
		for (Cancelamento cancelamento : lista) {
			System.out.println(cancelamento);
		}

		System.out.println("Num reservas após cancelamentos -> " + v1.getReservas().size());

	}

}
