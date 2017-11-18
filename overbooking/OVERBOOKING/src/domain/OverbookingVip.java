package domain;

import java.util.Collections;
import java.util.List;

public class OverbookingVip implements IOverbookingPolicy {

	public int poltrona;
	
	@Override
	public boolean aplicarOverbooking(Passageiro p, Voo v) {

		if (!new OverbookingPadrao().aplicarOverbooking(p, v)) {
			int capacidadeAeronave = v.getAeronave().getCapacidadeTotal();
			int ocupacaoAtual = v.getOcupacaoAtual();
			int limitePassageirosVip = (int) (capacidadeAeronave + (capacidadeAeronave * 0.5));

			int vipCont = 0;
			for (Passageiro passageiro : v.getReservas()) {
				if (passageiro.getCategoria() == Categoria.VIP)
					vipCont++;
			}

			if (vipCont < limitePassageirosVip) {
				List<Passageiro> listaReversa = v.getReservas();
				Collections.reverse(listaReversa);
				for (Passageiro pass : listaReversa) {
					if (pass.getCategoria() != Categoria.VIP) {
						Collections.reverse(listaReversa);
						v.getReservas().set(v.getReservas().indexOf(pass), p);
						v.efetuaCancelamento(pass, "Overbooking Vip");
						return true;
					}
				}
			}
		}
		return false;
	}
	

	
}
