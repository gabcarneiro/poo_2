package domain;

public interface IOverbookingPolicy {

	boolean aplicarOverbooking(Passageiro passageiro, Voo voo);

}
