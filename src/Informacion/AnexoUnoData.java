package Informacion;

import java.util.ArrayList;

public class AnexoUnoData {

    private String folio = "";
    private String no_expediente = "";
    private String fecha = "";
    private String hora = "";

    private String nombre = "";
    private String fecha_nacimiento = "";
    private String lugar_nacimiento = "";
    private String nacionalidad = "";
    private String sexo = "";
    private String escolaridad = "";
    private String religion = "";
    private String estado_civil = "";
    private boolean discapacidad = false;
    private String tipo_discapacidad = "";
    private String idioma = "";
    private String etnia = "";
    private String etnia_cual = "";
    private String domicilio = "";
    private ArrayList<Familia> familia = new ArrayList<>();
    private String restricciones = "";

    private String motivo_evaluacion = "";

    private String entrevista = "";
    private boolean pruebas[];
    private boolean material[];

    private String apariencia_fisica = "";
    private String conducta_motriz = "";
    private String habla = "";
    private String socializacion = "";
    private String orientacion = "";
    private String conscienca = "";
    private String memoria = "";
    private String percepcion = "";
    private String pensamiento = "";
    private String afecto = "";
    private String inteligencia;

    private String interpretacion_de_tecnicas = "";
    private String concluciones = "";
    private String sugerencias = "";

    private TrabajadorData trabajador = new TrabajadorData();

    public AnexoUnoData(String folio, String no_expediente, String fecha, String hora, String nombre, String fecha_nacimiento, String lugar_nacimiento, String nacionalidad, String sexo, String escolaridad, String religion, String estado_civil, boolean discapacidad, String tipo_discapacidad, String idioma, String etnia, String etnia_cual, String domicilio, String restricciones, String motivo_evaluacion, String entrevista, boolean[] pruebas, boolean[] material, String apariencia_fisica, String conducta_motriz, String habla, String socializacion, String orientacion, String conscienca, String memoria, String percepcion, String pensamiento, String afecto, String inteligencia, String interpretacion_de_tecnicas, String concluciones, String sugerencias) {
        this.folio = folio;
        this.no_expediente = no_expediente;
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.lugar_nacimiento = lugar_nacimiento;
        this.nacionalidad = nacionalidad;
        this.sexo = sexo;
        this.escolaridad = escolaridad;
        this.religion = religion;
        this.estado_civil = estado_civil;
        this.discapacidad = discapacidad;
        this.tipo_discapacidad = tipo_discapacidad;
        this.idioma = idioma;
        this.etnia = etnia;
        this.etnia_cual = etnia_cual;
        this.domicilio = domicilio;
        this.restricciones = restricciones;
        this.motivo_evaluacion = motivo_evaluacion;
        this.entrevista = entrevista;
        this.pruebas = pruebas;
        this.material = material;
        this.apariencia_fisica = apariencia_fisica;
        this.conducta_motriz = conducta_motriz;
        this.habla = habla;
        this.socializacion = socializacion;
        this.orientacion = orientacion;
        this.conscienca = conscienca;
        this.memoria = memoria;
        this.percepcion = percepcion;
        this.pensamiento = pensamiento;
        this.afecto = afecto;
        this.inteligencia = inteligencia;
        this.interpretacion_de_tecnicas = interpretacion_de_tecnicas;
        this.concluciones = concluciones;
        this.sugerencias = sugerencias;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNo_expediente() {
        return no_expediente;
    }

    public void setNo_expediente(String no_expediente) {
        this.no_expediente = no_expediente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
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

    public String getEtnia_cual() {
        return etnia_cual;
    }

    public void setEtnia_cual(String etnia_cual) {
        this.etnia_cual = etnia_cual;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public ArrayList<Familia> getFamilia() {
        return familia;
    }

    public void setFamilia(ArrayList<Familia> familia) {
        this.familia = familia;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public String getMotivo_evaluacion() {
        return motivo_evaluacion;
    }

    public void setMotivo_evaluacion(String motivo_evaluacion) {
        this.motivo_evaluacion = motivo_evaluacion;
    }

    public String getEntrevista() {
        return entrevista;
    }

    public void setEntrevista(String entrevista) {
        this.entrevista = entrevista;
    }

    public boolean[] getPruebas() {
        return pruebas;
    }

    public void setPruebas(boolean[] pruebas) {
        this.pruebas = pruebas;
    }

    public boolean[] getMaterial() {
        return material;
    }

    public void setMaterial(boolean[] material) {
        this.material = material;
    }

    public String getApariencia_fisica() {
        return apariencia_fisica;
    }

    public void setApariencia_fisica(String apariencia_fisica) {
        this.apariencia_fisica = apariencia_fisica;
    }

    public String getConducta_motriz() {
        return conducta_motriz;
    }

    public void setConducta_motriz(String conducta_motriz) {
        this.conducta_motriz = conducta_motriz;
    }

    public String getHabla() {
        return habla;
    }

    public void setHabla(String habla) {
        this.habla = habla;
    }

    public String getSocializacion() {
        return socializacion;
    }

    public void setSocializacion(String socializacion) {
        this.socializacion = socializacion;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public String getConscienca() {
        return conscienca;
    }

    public void setConscienca(String conscienca) {
        this.conscienca = conscienca;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getPercepcion() {
        return percepcion;
    }

    public void setPercepcion(String percepcion) {
        this.percepcion = percepcion;
    }

    public String getPensamiento() {
        return pensamiento;
    }

    public void setPensamiento(String pensamiento) {
        this.pensamiento = pensamiento;
    }

    public String getAfecto() {
        return afecto;
    }

    public void setAfecto(String afecto) {
        this.afecto = afecto;
    }

    public String getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(String inteligencia) {
        this.inteligencia = inteligencia;
    }

    public String getInterpretacion_de_tecnicas() {
        return interpretacion_de_tecnicas;
    }

    public void setInterpretacion_de_tecnicas(String interpretacion_de_tecnicas) {
        this.interpretacion_de_tecnicas = interpretacion_de_tecnicas;
    }

    public String getConcluciones() {
        return concluciones;
    }

    public void setConcluciones(String concluciones) {
        this.concluciones = concluciones;
    }

    public String getSugerencias() {
        return sugerencias;
    }

    public void setSugerencias(String sugerencias) {
        this.sugerencias = sugerencias;
    }

    public TrabajadorData getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(TrabajadorData trabajador) {
        this.trabajador = trabajador;
    }
}

class Familia {

    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String parentesco;

    public Familia(String nombre, String apellido_paterno, String apellido_materno, String parentesco) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.parentesco = parentesco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}
