package Informacion;

import java.util.ArrayList;

public class EstadisticasData {

    private String periodo = "";
    private String trabajador = "";
    private ArrayList<TablaEstadisticasData> datos = new ArrayList<>();

    public EstadisticasData() { }

    public EstadisticasData(String periodo, String trabajador, ArrayList<TablaEstadisticasData> datos) {
        this.datos = datos;
        this.periodo = periodo;
        this.trabajador = trabajador;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    public ArrayList<TablaEstadisticasData> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<TablaEstadisticasData> datos) {
        this.datos = datos;
    }
}

