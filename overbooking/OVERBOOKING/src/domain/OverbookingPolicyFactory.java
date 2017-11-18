package domain;

public class OverbookingPolicyFactory {

	public static IOverbookingPolicy makeOverbookingPolicy(Passageiro passageiro) {

		IOverbookingPolicy overbookingPolicy = null;
		Categoria categoria = passageiro.getCategoria();

		if (categoria.equals(Categoria.COMUM)) {
			overbookingPolicy = new OverbookingPadrao();
		} else if (categoria.equals(Categoria.VIP)) {
			overbookingPolicy = new OverbookingVip();
		}
		return overbookingPolicy;
	}

}
