package Informacion;

public class EstadisticaVulneracionesData {

    private String vulneracion = "";
    private String expediente_mujer = "";
    private String expediente_hombre = "";
    private String expediente_desconocido = "";
    private String expediente_total = "";

    private String reporte_mujer = "";
    private String reporte_hombre = "";
    private String reporte_desconocido = "";
    private String reporte_total = "";

    public EstadisticaVulneracionesData() { }

    public EstadisticaVulneracionesData(String titulo,
                                        String expediente_mujer, String expediente_hombre, String expediente_desconocido,
                                        String reporte_mujer, String reporte_hombre, String reporte_desconocido) {
        this.vulneracion = titulo;
        this.expediente_mujer = expediente_mujer;
        this.expediente_hombre = expediente_hombre;
        this.expediente_desconocido = expediente_desconocido;
        this.expediente_total = expediente_total;
        this.reporte_mujer = reporte_mujer;
        this.reporte_hombre = reporte_hombre;
        this.reporte_desconocido = reporte_desconocido;
        this.reporte_total = reporte_total;
    }

    public String getVulneracion() {
        return vulneracion;
    }

    public void setVulneracion(String vulneracion) {
        this.vulneracion = vulneracion;
    }

    public String getExpediente_mujer() {
        return expediente_mujer;
    }

    public void setExpediente_mujer(String expediente_mujer) {
        this.expediente_mujer = expediente_mujer;
    }

    public String getExpediente_hombre() {
        return expediente_hombre;
    }

    public void setExpediente_hombre(String expediente_hombre) {
        this.expediente_hombre = expediente_hombre;
    }

    public String getExpediente_desconocido() {
        return expediente_desconocido;
    }

    public void setExpediente_desconocido(String expediente_desconocido) {
        this.expediente_desconocido = expediente_desconocido;
    }

    public String getExpediente_total() {
        return autoSuma(this.getExpediente_mujer(), this.getExpediente_hombre(), this.getExpediente_desconocido());
    }

    public String getReporte_mujer() {
        return reporte_mujer;
    }

    public void setReporte_mujer(String reporte_mujer) {
        this.reporte_mujer = reporte_mujer;
    }

    public String getReporte_hombre() {
        return reporte_hombre;
    }

    public void setReporte_hombre(String reporte_hombre) {
        this.reporte_hombre = reporte_hombre;
    }

    public String getReporte_desconocido() {
        return reporte_desconocido;
    }

    public void setReporte_desconocido(String reporte_desconocido) {
        this.reporte_desconocido = reporte_desconocido;
    }

    public String getReporte_total() {
        return autoSuma(this.getReporte_mujer(), this.getReporte_hombre(), this.getReporte_desconocido());
    }


    private static String autoSuma(String a, String b, String c){
        int x = Integer.parseInt((a.equals(""))? "0": a);
        int y = Integer.parseInt((b.equals(""))? "0": b);
        int z = Integer.parseInt((c.equals(""))? "0": c);
        return String.valueOf(x + y + z);
    }
}
