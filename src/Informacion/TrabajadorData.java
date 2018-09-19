package Informacion;

public class TrabajadorData {
    private String nombre;
    private String cargo;
    private String cedula;

    public TrabajadorData() {
    }

    public TrabajadorData(String nombre) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.cedula = cedula;
    }

    public TrabajadorData(String nombre, String cargo, String cedula) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
