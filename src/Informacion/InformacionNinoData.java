package Informacion;

public class InformacionNinoData {


    private String nombre = "";
    private String apeliido_paterno = "";
    private String apeliido_materno = "";
    private String nombre_completo = nombre + " " + apeliido_paterno + " " + apeliido_materno;
    private String edad = "";
    private String sexo = "";
    private String escolaridad = "";
    private String relacion_agresor = "";
    private String domicilio = "";
    private String lugar_nacimiento = "";
    private String fecha_nacimiento = "";
    private String nacionalidad = "";
    private String religion = "";
    private String estado_civil = "";
    private boolean discapacidad = false;
    private String tipo_discapacidad = "";
    private String idioma = "";
    private String etnia = "";

    private String correo = "";
    private String telefono = "";
    private String celular = "";
    private String referencia = "";

    public InformacionNinoData() { }

    public InformacionNinoData(String nombre, String apeliido_paterno, String apeliido_materno, String edad,
            String sexo, String escolaridad, String relacion_agresor, String domicilio, String lugar_nacimiento,
            String fecha_nacimiento, String nacionalidad, String religion, String estado_civil, boolean discapacidad,
            String tipo_discapacidad, String idioma, String etnia, String correo, String telefono, String celular,
            String referencia) {

        this.nombre = nombre;
        this.apeliido_paterno = apeliido_paterno;
        this.apeliido_materno = apeliido_materno;
        this.nombre_completo = nombre + " " + apeliido_paterno + " " + apeliido_materno;
        this.edad = edad;
        this.sexo = sexo;
        this.escolaridad = escolaridad;
        this.relacion_agresor = relacion_agresor;
        this.domicilio = domicilio;
        this.lugar_nacimiento = lugar_nacimiento;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.religion = religion;
        this.estado_civil = estado_civil;
        this.discapacidad = discapacidad;
        this.tipo_discapacidad = tipo_discapacidad;
        this.idioma = idioma;
        this.etnia = etnia;
        this.correo = correo;
        this.telefono = telefono;
        this.celular = celular;
        this.referencia = referencia;

    }
    public InformacionNinoData(String nombre, String edad, String fecha_nacimiento, String lugar_nacimiento, String nacionalidad, String sexo, String idioma, String etnia, String religion, boolean discapacidad, String tipo_discapacidad, String escolaridad, String domicilio) {
        this.nombre = nombre;
        this.edad = edad;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.idioma = idioma;
        this.etnia = etnia;
        this.religion = religion;
        this.discapacidad = discapacidad;
        this.tipo_discapacidad = tipo_discapacidad;
        this.escolaridad = escolaridad;
        this.domicilio = domicilio;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApeliido_paterno() {
        return apeliido_paterno;
    }

    public void setApeliido_paterno(String apeliido_paterno) {
        this.apeliido_paterno = apeliido_paterno;
    }

    public String getApeliido_materno() {
        return apeliido_materno;
    }

    public void setApeliido_materno(String apeliido_materno) {
        this.apeliido_materno = apeliido_materno;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
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

    public String getRelacion_agresor() {
        return relacion_agresor;
    }

    public void setRelacion_agresor(String relacion_agresor) {
        this.relacion_agresor = relacion_agresor;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getTipo_discapacidad() {
        return tipo_discapacidad;
    }

    public void setTipo_discapacidad(String tipo_discapacidad) {
        this.tipo_discapacidad = tipo_discapacidad;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
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

public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
