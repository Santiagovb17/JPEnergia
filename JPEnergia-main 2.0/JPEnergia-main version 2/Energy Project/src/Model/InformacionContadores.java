package Model;

public class InformacionContadores {
    private String numeroContador; // Número único del contador
    private String direccion; // Dirección donde se encuentra el contador
    private String ciudad; // Ciudad donde está ubicado el contador

    /**
     * Constructor para inicializar la información del contador.
     * @param numeroContador Número único del contador.
     * @param direccion Dirección donde se encuentra el contador.
     * @param ciudad Ciudad donde está ubicado el contador.
     */
    public InformacionContadores(String numeroContador, String direccion, String ciudad) {
        this.numeroContador = numeroContador;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    /**
     * Obtiene el número del contador.
     * @return Número del contador.
     */
    public String getNumeroContador() {
        return numeroContador;
    }

    /**
     * Obtiene la dirección del contador.
     * @return Dirección del contador.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Obtiene la ciudad del contador.
     * @return Ciudad del contador.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece el número del contador.
     * @param numeroContador Número único del contador.
     */
    public void setNumeroContador(String numeroContador) {
        this.numeroContador = numeroContador;
    }

    /**
     * Establece la dirección del contador.
     * @param direccion Dirección donde se encuentra el contador.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Establece la ciudad del contador.
     * @param ciudad Ciudad donde está ubicado el contador.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Representación en cadena del contador.
     * @return Información del contador en formato de texto.
     */
    @Override
    public String toString() {
        return "Contador [Número: " + numeroContador + 
               ", Dirección: " + direccion + 
               ", Ciudad: " + ciudad + "]";
    }

    // Atributo que guarda el historial de consumos del contador
    private ConsumoEnergia historial = new ConsumoEnergia();

    public ConsumoEnergia getHistorial() {
    return historial;
}

    // Devuelve el historial para acceder/modificar consumos
    public Object getId() {
        throw new UnsupportedOperationException("Aún no es compatible.");
    }


}