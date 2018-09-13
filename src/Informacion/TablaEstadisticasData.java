package Informacion;

import java.util.ArrayList;

public class TablaEstadisticasData {
    private String titulo = "";
    private ArrayList<String> columna_izquierda = new ArrayList<>();
    private ArrayList<String> columna_derecha = new ArrayList<>();

    public TablaEstadisticasData() {    }

    public TablaEstadisticasData(String titulo, ArrayList<String> columna_izquierda, ArrayList<String> columna_derecha) {
        this.titulo = titulo;
        this.columna_izquierda = columna_izquierda;
        this.columna_derecha = columna_derecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getColumna_izquierda() {
        return columna_izquierda;
    }

    public void setColumna_izquierda(ArrayList<String> columna_izquierda) {
        this.columna_izquierda = columna_izquierda;
    }

    public ArrayList<String> getColumna_derecha() {
        return columna_derecha;
    }

    public void setColumna_derecha(ArrayList<String> columna_derecha) {
        this.columna_derecha = columna_derecha;
    }
}
