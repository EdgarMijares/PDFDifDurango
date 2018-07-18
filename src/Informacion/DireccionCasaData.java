package Informacion;

public class DireccionCasaData {
    private String direccion_uno = "";
    private String getDireccion_dos = "";

    public DireccionCasaData() {
    }

    public DireccionCasaData(String direccion_uno, String getDireccion_dos) {
        this.direccion_uno = direccion_uno;
        this.getDireccion_dos = getDireccion_dos;
    }

    public String getDireccion_uno() {
        return direccion_uno;
    }

    public void setDireccion_uno(String direccion_uno) {
        this.direccion_uno = direccion_uno;
    }

    public String getGetDireccion_dos() {
        return getDireccion_dos;
    }

    public void setGetDireccion_dos(String getDireccion_dos) {
        this.getDireccion_dos = getDireccion_dos;
    }
}
