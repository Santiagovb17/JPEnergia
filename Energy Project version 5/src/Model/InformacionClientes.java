package Model;

public class InformacionClientes {
    private String numeroIdentificacion; // Número único de identificación del cliente
    private String tipoIdentificacion; // Tipo de identificación (Cedula, Pasaporte, etc.)
    private String correoElectronico; // Correo electrónico del cliente
    private String direccionFisica; // Dirección física del cliente

    /**
     * Constructor para inicializar la información del cliente.
     * @param numeroIdentificacion Número único de identificación.
     * @param tipoIdentificacion Tipo de identificación.
     * @param correoElectronico Correo electrónico del cliente.
     * @param direccionFisica Dirección física del cliente.
     */
    public InformacionClientes(String numeroIdentificacion, String tipoIdentificacion, 
                             String correoElectronico, String direccionFisica) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.correoElectronico = correoElectronico;
        this.direccionFisica = direccionFisica;
    }

    /**
     * Obtiene el número de identificación del cliente.
     * @return Número de identificación.
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * Obtiene el tipo de identificación del cliente.
     * @return Tipo de identificación.
     */
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     * @return Correo electrónico.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Obtiene la dirección física del cliente.
     * @return Dirección física.
     */
    public String getDireccionFisica() {
        return direccionFisica;
    }

    /**
     * Establece el número de identificación del cliente.
     * @param numeroIdentificacion Número único de identificación.
     * @throws IllegalArgumentException Si el número de identificación está vacío.
     */
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        if (numeroIdentificacion == null || numeroIdentificacion.isEmpty()) {
            throw new IllegalArgumentException("El número de identificación no puede estar vacío");
        }
        this.numeroIdentificacion = numeroIdentificacion;
    }

    /**
     * Establece el tipo de identificación del cliente.
     * @param tipoIdentificacion Tipo de identificación.
     */
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    /**
     * Establece el correo electrónico del cliente.
     * @param correoElectronico Correo electrónico.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Establece la dirección física del cliente.
     * @param direccionFisica Dirección física.
     */
    public void setDireccionFisica(String direccionFisica) {
        this.direccionFisica = direccionFisica;
    }
}