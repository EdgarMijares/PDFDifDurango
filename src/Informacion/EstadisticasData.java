package Informacion;

import java.util.ArrayList;

public class EstadisticasData {

    private String titulo = "";
    private ArrayList<TablaEstadisticasData> datos = new ArrayList<>();

    public EstadisticasData() { }

    public EstadisticasData(String titulo, ArrayList<TablaEstadisticasData> datos) {
        this.titulo = titulo;
        this.datos = datos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<TablaEstadisticasData> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<TablaEstadisticasData> datos) {
        this.datos = datos;
    }
}
