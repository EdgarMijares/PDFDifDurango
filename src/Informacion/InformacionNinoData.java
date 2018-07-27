package Informacion;

public class InformacionNinoData {

    private String nombre = "";
    private String edad = "";
    private String fecha_nacimiento = "";
    private String lugar_nacimiento = "";
    private String nacionalidad = "";
    private String sexo = "";
    private String idioma = "";
    private String etnia = "";
    private String religion = "";
    private boolean discapacidad = false;
    private String tipo_discapacidad = "";
    private String escolaridad = "";
    private String domicilio = "";

    public InformacionNinoData() {
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
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

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
