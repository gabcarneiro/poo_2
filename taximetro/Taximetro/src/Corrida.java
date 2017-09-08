public class Corrida {

    public static final double TAXA_FIXA = 4.75;
    private double taxaPorPassageiro;
    private double kmPercorridos;
    private Bandeira bandeira;
    private int quantidadePassageiros;


    public Corrida(double distanciaKmPercorridos, int quantidadePassageiros){
        this.bandeira = BandeiraFactory.makeBandeira();
        this.kmPercorridos = distanciaKmPercorridos;
        this.quantidadePassageiros = quantidadePassageiros;
        this.taxaPorPassageiro = Double.parseDouble(
                    PropertiesLoader.getProperty("valorTaxaExtraPorPassageiro"));
    }


    public double calcularValorCorrida(){
       return CalculadoraValorCorrida.calcular(this);
    };

    public double getTaxaPorPassageiro() {
        return taxaPorPassageiro;
    }

    public void setTaxaPorPassageiro(double taxaPorPassageiro) {
        this.taxaPorPassageiro = taxaPorPassageiro;
    }

    public double getKmPercorridos() {
        return kmPercorridos;
    }

    public void setKmPercorridos(double kmPercorridos) {
        this.kmPercorridos = kmPercorridos;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    public int getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    public void setQuantidadePassageiros(int quantidadePassageiros) {
        this.quantidadePassageiros = quantidadePassageiros;
    }
}
