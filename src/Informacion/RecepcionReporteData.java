package Informacion;

import java.util.ArrayList;

public class RecepcionReporteData {

    private String folio = "";
    private String no_expediente = "";
    private String fecha = "";
    private String hora = "";

    private String recibio = "";
    private String no_oficio = "";
    private String fehca_oficio = "";
    private String quien_envia = "";

    private boolean anonimato[] = {false, false, false};
    private boolean medio_reporte[] = {false, false, false, false};

    private PersonaData denunciante = new PersonaData();
    private boolean estado_denunciante = false;
    private ArrayList<PersonaData> victima = new ArrayList();
    private PersonaData custodio = new PersonaData();
    private ArrayList<PersonaData> agresor = new ArrayList();

    private boolean derechos[] = {
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, };
    private String derechos_otro = "";
    private String resena = "";
    private String observaciones = "";

    private String firma = "";
    public RecepcionReporteData() {
    }

    public RecepcionReporteData(String folio, String no_expediente, String fecha, String hora, String recibio, String no_oficio, String fehca_oficio, String quien_envia, boolean[] anonimato, boolean[] medio_reporte, PersonaData denunciante, boolean estado_denunciante, ArrayList<PersonaData> victima, PersonaData custodio, ArrayList<PersonaData> agresor, boolean[] derechos, String derechos_otro, String resena, String observaciones) {
        this.folio = folio;
        this.no_expediente = no_expediente;
        this.fecha = fecha;
        this.hora = hora;
        this.recibio = recibio;
        this.no_oficio = no_oficio;
        this.fehca_oficio = fehca_oficio;
        this.quien_envia = quien_envia;
        this.anonimato = anonimato;
        this.medio_reporte = medio_reporte;
        this.denunciante = denunciante;
        this.estado_denunciante = estado_denunciante;
        this.victima = victima;
        this.custodio = custodio;
        this.agresor = agresor;
        this.derechos = derechos;
        this.derechos_otro = derechos_otro;
        this.resena = resena;
        this.observaciones = observaciones;
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

    public String getRecibio() {
        return recibio;
    }

    public void setRecibio(String recibio) {
        this.recibio = recibio;
    }

    public String getNo_oficio() {
        return no_oficio;
    }

    public void setNo_oficio(String no_oficio) {
        this.no_oficio = no_oficio;
    }

    public String getFehca_oficio() {
        return fehca_oficio;
    }

    public void setFehca_oficio(String fehca_oficio) {
        this.fehca_oficio = fehca_oficio;
    }

    public String getQuien_envia() {
        return quien_envia;
    }

    public void setQuien_envia(String quien_envia) {
        this.quien_envia = quien_envia;
    }

    public boolean[] getAnonimato() {
        return anonimato;
    }

    public void setAnonimato(boolean[] anonimato) {
        this.anonimato = anonimato;
    }

    public boolean[] getMedio_reporte() {
        return medio_reporte;
    }

    public void setMedio_reporte(boolean[] medio_reporte) {
        this.medio_reporte = medio_reporte;
    }

    public PersonaData getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(PersonaData denunciante) {
        this.denunciante = denunciante;
    }

    public boolean isEstado_denunciante() {
        return estado_denunciante;
    }

    public void setEstado_denunciante(boolean estado_denunciante) {
        this.estado_denunciante = estado_denunciante;
    }

    public ArrayList<PersonaData> getVictima() {
        return victima;
    }

    public void setVictima(ArrayList<PersonaData> victima) {
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

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
}
