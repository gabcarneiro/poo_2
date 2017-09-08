public class BandeiraUm extends Bandeira{

    public BandeiraUm() {
        double valorKm = Double.parseDouble(
                PropertiesLoader.getProperty("valorKmBandeiraUm"));
        setValorKm(valorKm);
    }

}
