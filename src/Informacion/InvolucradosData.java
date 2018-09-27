package Informacion;

import java.util.ArrayList;

public class InvolucradosData {
    private String no_expediente = "";
    private String fecha = "";
    private String hora = "";

    private String nombre_asesor = "";
    private String cargo_asesor = "";
    private String fehca_oficio = "";

    private ArrayList<InformacionNinoData> victima = new ArrayList();
    private PersonaData custodio = new PersonaData();
    private ArrayList<PersonaData> agresor = new ArrayList();

    private boolean derechos[] = {
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, };
    private String derechos_otro = "";
    private String resena = "";
    private String observaciones = "";

    private String nombre_firma = "";
    private String cargo_firma = "";

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

    public String getNombre_asesor() {
        return nombre_asesor;
    }

    public void setNombre_asesor(String nombre_asesor) {
        this.nombre_asesor = nombre_asesor;
    }

    public String getCargo_asesor() {
        return cargo_asesor;
    }

    public void setCargo_asesor(String cargo_asesor) {
        this.cargo_asesor = cargo_asesor;
    }

    public String getFehca_oficio() {
        return fehca_oficio;
    }

    public void setFehca_oficio(String fehca_oficio) {
        this.fehca_oficio = fehca_oficio;
    }

    public ArrayList<InformacionNinoData> getVictima() {
        return victima;
    }

    public void setVictima(ArrayList<InformacionNinoData> victima) {
        this.victima = victima;
    }

    public PersonaData getCustodio() {
        return custodio;
    }

    public void setCustodio(PersonaData custodio) {
        this.custodio = custodio;
    }

    public ArrayList<PersonaData> getAgresor() {
        return agresor;
    }

    public void setAgresor(ArrayList<PersonaData> agresor) {
        this.agresor = agresor;
    }

    public boolean[] getDerechos() {
        return derechos;
    }

    public void setDerechos(boolean[] derechos) {
        this.derechos = derechos;
    }

    public String getDerechos_otro() {
        return derechos_otro;
    }

    public void setDerechos_otro(String derechos_otro) {
        this.derechos_otro = derechos_otro;
    }

    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombre_firma() {
        return nombre_firma;
    }

    public void setNombre_firma(String nombre_firma) {
        this.nombre_firma = nombre_firma;
    }

    public String getCargo_firma() {
        return cargo_firma;
    }

    public void setCargo_firma(String cargo_firma) {
        this.cargo_firma = cargo_firma;
    }
}
