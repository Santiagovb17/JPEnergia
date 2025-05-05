package Model;

public class ConsumoEnergia {
    private String dia;
    private int hora; // 0 - 23
    private double kwh;
    private String mes;
    private String numeroIdentificacionCliente;
    private String numeroContador;

    public ConsumoEnergia(String mes, String dia, int hora, double kwh, String numeroIdentificacionCliente, String numeroContador) {
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.kwh = kwh;
        this.numeroIdentificacionCliente = numeroIdentificacionCliente;
        this.numeroContador = numeroContador;
    }

    public double calcularCosto() {
        if (hora >= 0 && hora <= 6 && kwh >= 100 && kwh <= 300) {
            return kwh * 200;
        } else if (hora >= 7 && hora <= 17 && kwh > 300 && kwh <= 600) {
            return kwh * 300;
        } else if (hora >= 18 && hora <= 23 && kwh > 600 && kwh < 1000) {
            return kwh * 500;
        } else {
            return 0; // Consumo fuera de franjas definidas
        }
    }

    public String getMes() { return mes; }
    public String getDia() { return dia; }
    public int getHora() { return hora; }
    public double getKwh() { return kwh; }
    public String getNumeroIdentificacionCliente() { return numeroIdentificacionCliente; }
    public String getNumeroContador() { return numeroContador; }

    @Override
    public String toString() {
        return String.format("Mes: %s, Día: %s, Hora: %d, kWh: %.2f, Costo: %.2f, Cliente: %s, Contador: %s",
                mes, dia, hora, kwh, calcularCosto(), numeroIdentificacionCliente, numeroContador);
    }
}
