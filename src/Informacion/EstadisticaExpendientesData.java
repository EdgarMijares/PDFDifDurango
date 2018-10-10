package Informacion;

public class EstadisticaExpendientesData {
    private String asesor = "";
    private String comprobados = "";
    private String no_comprobados ="";
    private String falsos = "";
    private String no_favorable = "";
    private String favorable = "";
    private String antes_actualizados = "";
    private String actualizados = "";
    private String sin_resultado = "";
    private String total_asignados = "";

    public EstadisticaExpendientesData(String asesor, String comprobados, String no_comprobados,
                                       String falsos, String no_favorable, String favorable, String antes_actualizados,
                                       String actualizados, String sin_resultado) {
        this.asesor = asesor;
        this.comprobados = comprobados;
        this.no_comprobados = no_comprobados;
        this.falsos = falsos;
        this.no_favorable = no_favorable;
        this.favorable = favorable;
        this.antes_actualizados = antes_actualizados;
        this.actualizados = actualizados;
        this.sin_resultado = sin_resultado;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }
    public void setComprobados(String comprobados) {
        this.comprobados = comprobados;
    }
    public void setNo_comprobados(String no_comprobados) {
        this.no_comprobados = no_comprobados;
    }
    public void setFalsos(String falsos) {
        this.falsos = falsos;
    }
    public void setNo_favorable(String no_favorable) {
        this.no_favorable = no_favorable;
    }
    public void setFavorable(String favorable) {
        this.favorable = favorable;
    }
    public void setAntes_actualizados(String antes_actualizados) {
        this.antes_actualizados = antes_actualizados;
    }
    public void setActualizados(String actualizados) {
        this.actualizados = actualizados;
    }
    public void setSin_resultado(String sin_resultado) {
        this.sin_resultado = sin_resultado;
    }

    public String getAsesor() {
        return asesor;
    }
    public String getComprobados() {
        return comprobados;
    }
    public String getNo_comprobados() {
        return no_comprobados;
    }
    public String getFalsos() {
        return falsos;
    }
    public String getNo_favorable() {
        return no_favorable;
    }
    public String getFavorable() {
        return favorable;
    }
    public String getAntes_actualizados() {
        return antes_actualizados;
    }
    public String getActualizados() {
        return actualizados;
    }
    public String getSin_resultado() {
        return sin_resultado;
    }
    public String getTotal_asignados() {
        return sumar(getComprobados(), getNo_comprobados(), getFalsos(), getNo_favorable(), getFavorable(),
                getAntes_actualizados(), getActualizados(), getSin_resultado());
    }

    private String sumar(String a, String b, String c, String d, String e, String f, String g, String h) {
        int m = Integer.parseInt((a.equals("")? "0": a));
        int n = Integer.parseInt((a.equals("")? "0": b));
        int o = Integer.parseInt((a.equals("")? "0": c));
        int p = Integer.parseInt((a.equals("")? "0": d));
        int q = Integer.parseInt((a.equals("")? "0": e));
        int r = Integer.parseInt((a.equals("")? "0": f));
        int s = Integer.parseInt((a.equals("")? "0": g));
        int t = Integer.parseInt((a.equals("")? "0": h));

        return String.valueOf(m + n + o + p + q+ r + s + t);
    }
}
