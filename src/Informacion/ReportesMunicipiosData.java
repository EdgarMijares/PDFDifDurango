package Informacion;

public class ReportesMunicipiosData {
    private String municipio = "";
    private String nuevos_reportes = "";
    private String reportes_subsecunetes = "";
    private String expedientes_creados = "";

    public ReportesMunicipiosData(String municipio, String nuevos_reportes, String reportes_subsecunetes, String expedientes_creados) {
        this.municipio = municipio;
        this.nuevos_reportes = nuevos_reportes;
        this.reportes_subsecunetes = reportes_subsecunetes;
        this.expedientes_creados = expedientes_creados;
    }

    public String getMunicipio() {
        return municipio;
    }
    public String getNuevos_reportes() {
        return nuevos_reportes;
    }
    public String getReportes_subsecunetes() {
        return reportes_subsecunetes;
    }
    public String getExpedientes_creados() {
        return expedientes_creados;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public void setNuevos_reportes(String nuevos_reportes) {
        this.nuevos_reportes = nuevos_reportes;
    }
    public void setExpedientes_subsecunetes(String reportes_subsecunetes) {
        this.reportes_subsecunetes = reportes_subsecunetes;
    }
    public void setReportes_creados(String reportes_creados) {
        this.expedientes_creados = reportes_creados;
    }
}
