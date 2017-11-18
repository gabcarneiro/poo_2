package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class OverbookingPadrao implements IOverbookingPolicy {

	double porcentagemOverbookingPadrao = 0.10;

	@Override
	public boolean aplicarOverbooking(Passageiro passageiro, Voo voo) {

		int capacidadeAeronave = voo.getAeronave().getCapacidadeTotal();
		int ocupacaoAtual = voo.getOcupacaoAtual();
		int limiteDePassageiros = (int) (capacidadeAeronave + (capacidadeAeronave * porcentagemOverbookingPadrao));

		if (ocupacaoAtual < limiteDePassageiros) {
			voo.getReservas().add(passageiro);
			voo.setOcupacaoAtual(voo.getOcupacaoAtual() + 1);
			return true;
		}
		return false;
	}

	public void efetuaCancelamentosPadrao(Voo v) {
		
		int qunatidadeCancelamentosNecessarios;
		List<Passageiro> listaDeCancelados = new ArrayList();

		qunatidadeCancelamentosNecessarios = v.getOcupacaoAtual() - v.getAeronave().getCapacidadeTotal();

		List<Passageiro> listaDePassageiros = v.getReservas();
		Collections.reverse(listaDePassageiros);

		while (qunatidadeCancelamentosNecessarios > 0) {
			for (Passageiro p : listaDePassageiros) {
				if (p.getCategoria() != Categoria.VIP && !listaDeCancelados.contains(p)) {
					listaDeCancelados.add(p);
					qunatidadeCancelamentosNecessarios--;
					break;
				}
			}
		}
		
		for (Passageiro passageiroRemover : listaDeCancelados) {
			v.efetuaCancelamento(passageiroRemover, "Overbooking Padrao");
		}
	}

}
