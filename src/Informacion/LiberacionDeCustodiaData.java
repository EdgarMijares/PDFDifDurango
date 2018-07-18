package Informacion;

public class LiberacionDeCustodiaData {

    private String[] mes_texto = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    private String no_registro = "";
    private String victima = "";
    private String hora = "";
    private String dia = "";
    private String mes = "";
    private String ano = "";
    private String direccion = "";
    private String coordinador = "";
    private String responsable = "";
    private String parentesco = "";
    private String domicilio = "";
    private String telefono = "";
    private String ine = "";

    TrabajadorData trabajador = new TrabajadorData();
    DireccionCasaData direccion_casa = new DireccionCasaData();

    public LiberacionDeCustodiaData() {
    }

    public LiberacionDeCustodiaData(String no_registro, String victima, String hora, String dia, String mes, String ano, String direccion, String coordinador, String responsable, String parentesco, String domicilio, String telefono, String ine, TrabajadorData trabajador, DireccionCasaData direccion_casa) {
        this.no_registro = no_registro;
        this.victima = victima;
        this.hora = hora;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.direccion = direccion;
        this.coordinador = coordinador;
        this.responsable = responsable;
        this.parentesco = parentesco;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.ine = ine;
        this.trabajador = trabajador;
        this.direccion_casa = direccion_casa;
    }

    public String getNo_registro() {
        return no_registro;
    }

    public void setNo_registro(String no_registro) {
        this.no_registro = no_registro;
    }

    public String getVictima() {
        return victima;
    }

    public void setVictima(String victima) {
        this.victima = victima;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes_texto[mes];
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public TrabajadorData getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(TrabajadorData trabajador) {
        this.trabajador = trabajador;
    }

    public DireccionCasaData getDireccion_casa() {
        return direccion_casa;
    }

    public void setDireccion_casa(DireccionCasaData direccion_casa) {
        this.direccion_casa = direccion_casa;
    }
}
