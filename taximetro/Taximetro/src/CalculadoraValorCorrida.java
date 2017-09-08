public class CalculadoraValorCorrida {

    public static double calcular(Corrida corrida){

        double valorCorrida = Corrida.TAXA_FIXA +
                (corrida.getBandeira().getValorKm() * corrida.getKmPercorridos());

        if (Boolean.valueOf(PropertiesLoader.getProperty("taxaExtraPorPassageiro")))
            return valorCorrida + calculaTaxaExtra(corrida);

        return valorCorrida;

    }

    private static double calculaTaxaExtra(Corrida corrida) {

        double taxaExtra = 0;

        double valorPorPassageiro = corrida.getKmPercorridos() * corrida.getTaxaPorPassageiro();

        if (corrida.getQuantidadePassageiros() > 1)
            taxaExtra = valorPorPassageiro * corrida.getQuantidadePassageiros() - valorPorPassageiro;

        return taxaExtra;

    }

}
