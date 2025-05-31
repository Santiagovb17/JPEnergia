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
        if (numeroIdentificacion == null || numeroIdentificacion.isEmpty()) {
            throw new IllegalArgumentException("El número de identificación no puede estar vacío");
        }
        if (tipoIdentificacion == null || tipoIdentificacion.isEmpty()) {
            throw new IllegalArgumentException("El tipo de identificación no puede estar vacío");
        }
        if (correoElectronico == null || correoElectronico.isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede estar vacío");
        }
        if (direccionFisica == null || direccionFisica.isEmpty()) {
            throw new IllegalArgumentException("La dirección física no puede estar vacía");
        }
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
     * @throws IllegalArgumentException Si el tipo de identificación está vacío.
     */
    public void setTipoIdentificacion(String tipoIdentificacion) {
        if (tipoIdentificacion == null || tipoIdentificacion.isEmpty()) {
            throw new IllegalArgumentException("El tipo de identificación no puede estar vacío");
        }
        this.tipoIdentificacion = tipoIdentificacion;
    }

    /**
     * Establece el correo electrónico del cliente.
     * @param correoElectronico Correo electrónico.
     * @throws IllegalArgumentException Si el correo electrónico está vacío.
     */
    public void setCorreoElectronico(String correoElectronico) {
        if (correoElectronico == null || correoElectronico.isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico no puede estar vacío");
        }
        this.correoElectronico = correoElectronico;
    }

    /**
     * Establece la dirección física del cliente.
     * @param direccionFisica Dirección física.
     * @throws IllegalArgumentException Si la dirección física está vacía.
     */
    public void setDireccionFisica(String direccionFisica) {
        if (direccionFisica == null || direccionFisica.isEmpty()) {
            throw new IllegalArgumentException("La dirección física no puede estar vacía");
        }
        this.direccionFisica = direccionFisica;
    }
    
}