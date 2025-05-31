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

    // Método calcularCosto eliminado por duplicidad

    public String getMes() { return mes; }
    public String getDia() { return dia; }
    public int getHora() { return hora; }
    public double getKwh() { return kwh; }
    public String getNumeroIdentificacionCliente() { return numeroIdentificacionCliente; }
    public String getNumeroContador() { return numeroContador; }

    @Override
    public String toString() {
        try {
            return String.format("Mes: %s, Día: %s, Hora: %d, kWh: %.2f, Costo: %.2f, Cliente: %s, Contador: %s",
                    mes, dia, hora, kwh, calcularCosto(), numeroIdentificacionCliente, numeroContador);
        } catch (Exception e) {
            return String.format("Mes: %s, Día: %s, Hora: %d, kWh: %.2f [Cálculo de costo falló], Cliente: %s, Contador: %s",
                    mes, dia, hora, kwh, numeroIdentificacionCliente, numeroContador);
        }
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }
    public double calcularCosto() {
    if (hora >= 0 && hora <= 6) {
        // Madrugada (00-06h)
            return kwh * 200;
    } else if (hora >= 7 && hora <= 17) {
        // Día (07-17h)
        return kwh * 300;
    } else if (hora >= 18 && hora <= 23) {
        // Noche (18-23h)
        return kwh * 500;
    }
    return 0;
}
}
