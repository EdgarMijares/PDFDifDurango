package Informacion;

import java.util.ArrayList;

public class InformeClinicoData {

    private String no_registro = "";

    private String fecha = "";
    private String nombre_victima = "";
    private String edad = "";
    private String sexo = "";
    private String fecha_nacimiento = "";
    private String fecha_ingreso = "";
    private String lugar_nacimiento = "";
    private String escolaridad = "";

    private String motivo_ingreso = "";
    private String perfil_clinico[];
    private String antecendetes = "";
    private String descripcion_victima = "";

    private String examen_mental = "";
    private String resultado_evaluacion = "";

    private String descripcion_recomencion = "";
    private String puntos_recomencion[];

    private TrabajadorData trabajador = new TrabajadorData();
    private DireccionCasaData direccion = new DireccionCasaData();

    public InformeClinicoData() {
    }

    public InformeClinicoData(String fecha, String nombre_victima, String edad, String sexo, String fecha_nacimiento, String fecha_ingreso, String lugar_nacimiento, String escolaridad, String motivo_ingreso, String[] perfil_clinico, String antecendetes, String descripcion_victima, String examen_mental, String resultado_evaluacion, String descripcion_recomencion, String[] puntos_recomencion) {
        this.fecha = fecha;
        this.nombre_victima = nombre_victima;
        this.edad = edad;
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_ingreso = fecha_ingreso;
        this.lugar_nacimiento = lugar_nacimiento;
        this.escolaridad = escolaridad;
        this.motivo_ingreso = motivo_ingreso;
        this.perfil_clinico = perfil_clinico;
        this.antecendetes = antecendetes;
        this.descripcion_victima = descripcion_victima;
        this.examen_mental = examen_mental;
        this.resultado_evaluacion = resultado_evaluacion;
        this.descripcion_recomencion = descripcion_recomencion;
        this.puntos_recomencion = puntos_recomencion;
    }

    public String getNo_registro() {
        return no_registro;
    }

    public void setNo_registro(String no_registro) {
        this.no_registro = no_registro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre_victima() {
        return nombre_victima;
    }

    public void setNombre_victima(String nombre_victima) {
        this.nombre_victima = nombre_victima;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getMotivo_ingreso() {
        return motivo_ingreso;
    }

    public void setMotivo_ingreso(String motivo_ingreso) {
        this.motivo_ingreso = motivo_ingreso;
    }

    public String[] getPerfil_clinico() {
        return perfil_clinico;
    }

    public void setPerfil_clinico(String[] perfil_clinico) {
        this.perfil_clinico = perfil_clinico;
    }

    public String getAntecendetes() {
        return antecendetes;
    }

    public void setAntecendetes(String antecendetes) {
        this.antecendetes = antecendetes;
    }

    public String getDescripcion_victima() {
        return descripcion_victima;
    }

    public void setDescripcion_victima(String descripcion_victima) {
        this.descripcion_victima = descripcion_victima;
    }

    public String getExamen_mental() {
        return examen_mental;
    }

    public void setExamen_mental(String examen_mental) {
        this.examen_mental = examen_mental;
    }

    public String getResultado_evaluacion() {
        return resultado_evaluacion;
    }

    public void setResultado_evaluacion(String resultado_evaluacion) {
        this.resultado_evaluacion = resultado_evaluacion;
    }

    public String getDescripcion_recomencion() {
        return descripcion_recomencion;
    }

    public void setDescripcion_recomencion(String descripcion_recomencion) {
        this.descripcion_recomencion = descripcion_recomencion;
    }

    public String[] getPuntos_recomencion() {
        return puntos_recomencion;
    }

    public void setPuntos_recomencion(String[] puntos_recomencion) {
        this.puntos_recomencion = puntos_recomencion;
    }

    public TrabajadorData getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(TrabajadorData trabajador) {
        this.trabajador = trabajador;
    }

    public DireccionCasaData getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionCasaData direccion) {
        this.direccion = direccion;
    }
}
