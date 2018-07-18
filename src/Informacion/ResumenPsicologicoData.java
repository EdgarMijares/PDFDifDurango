package Informacion;

public class ResumenPsicologicoData {

    private String no_registro = "";

    private String nombre_victima = "";
    private String sexo = "";
    private String edad = "";
    private String fecha_ingreso = "";
    private String motivo_ingreso = "";
    private String descripcion = "";

    private TrabajadorData trabajador = new TrabajadorData();
    private DireccionCasaData direccion = new DireccionCasaData();

    public ResumenPsicologicoData() {
    }

    public ResumenPsicologicoData(String nombre_victima, String sexo, String edad, String fecha_ingreso, String motivo_ingreso, String descripcion, TrabajadorData trabajador, DireccionCasaData direccion) {
        this.nombre_victima = nombre_victima;
        this.sexo = sexo;
        this.edad = edad;
        this.fecha_ingreso = fecha_ingreso;
        this.motivo_ingreso = motivo_ingreso;
        this.descripcion = descripcion;
        this.trabajador = trabajador;
        this.direccion = direccion;
    }

    public ResumenPsicologicoData(String no_registro, String nombre_victima, String sexo, String edad, String fecha_ingreso, String motivo_ingreso, String descripcion, TrabajadorData trabajador, DireccionCasaData direccion) {
        this.no_registro = no_registro;
        this.nombre_victima = nombre_victima;
        this.sexo = sexo;
        this.edad = edad;
        this.fecha_ingreso = fecha_ingreso;
        this.motivo_ingreso = motivo_ingreso;
        this.descripcion = descripcion;
        this.trabajador = trabajador;
        this.direccion = direccion;
    }

    public String getNo_registro() {
        return no_registro;
    }

    public void setNo_registro(String no_registro) {
        this.no_registro = no_registro;
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

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getMotivo_ingreso() {
        return motivo_ingreso;
    }

    public void setMotivo_ingreso(String motivo_ingreso) {
        this.motivo_ingreso = motivo_ingreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
