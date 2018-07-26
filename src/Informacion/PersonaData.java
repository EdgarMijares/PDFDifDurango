package Informacion;

public class PersonaData {

    private String nombre = "";
    private String edad = "";
    private String sexo = "";
    private String escolaridad = "";
    private String relacion = "";
    private String correo = "";
    private String telefono = "";
    private String celular = "";
    private String direccion = "";
    private String referencia = "";
    private String municipio = "";
    private String ocupacion = "";
    private String trabajo = "";
    private String estado_civil = "";

    public PersonaData() {
    }

    public PersonaData(String nombre, String edad, String sexo, String escolaridad, String relacion, String correo, String telefono, String celular, String direccion, String referencia, String municipio, String ocupacion, String trabajo, String estado_civil) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.escolaridad = escolaridad;
        this.relacion = relacion;
        this.correo = correo;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.referencia = referencia;
        this.municipio = municipio;
        this.ocupacion = ocupacion;
        this.trabajo = trabajo;
        this.estado_civil = estado_civil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }
}
