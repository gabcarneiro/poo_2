public class BandeiraTres extends Bandeira{

    public BandeiraTres() {
        double valorKm = Double.parseDouble(
                            PropertiesLoader.getProperty("valorKmBandeiraTres"));
        setValorKm(valorKm);
    }

}
