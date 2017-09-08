public class BandeiraDois extends Bandeira{

    public BandeiraDois() {
        double valorKm = Double.parseDouble(
                PropertiesLoader.getProperty("valorKmBandeiraDois"));
        setValorKm(valorKm);
    }

}
