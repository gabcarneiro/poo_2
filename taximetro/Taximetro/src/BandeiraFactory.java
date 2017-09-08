import java.util.Calendar;

public class BandeiraFactory {

    public static Bandeira makeBandeira() {

        Calendar c = Calendar.getInstance();
        int horarioPartida = c.get(Calendar.HOUR_OF_DAY);
        int diaSemana = c.get(Calendar.DAY_OF_WEEK);

        if (diaSemana==1 && Boolean.valueOf(PropertiesLoader.getProperty("bandeiraTres"))){
            return new BandeiraTres();
        }
        else if ((horarioPartida >= 0 && horarioPartida <= 6)
                || (horarioPartida >=22 && horarioPartida <=23)) {
            return new BandeiraDois();
        }
        else return new BandeiraUm();

    }

}
