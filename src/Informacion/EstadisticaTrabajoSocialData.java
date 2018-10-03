package Informacion;

import java.util.ArrayList;

public class EstadisticaTrabajoSocialData {

    private String[] datos_mpales = {"", "", "", "", "", "","",""};
    private String[] datos_pmnna = {"", "", "", "", "", "","", ""};

    private String[] datos_primera_t2 = {"", "", "", "", "", "", "", "", ""};
    private String[] datos_segunda_t2 = {"", "", "", "", "", "", "", "", ""};
    private String[] datos_tercera_t2 = {"", "", "", "", "", "", "", "", ""};

    private String[] datos_primera_t3 = {"", "", "", "", "", "", "", "", ""};
    private String[] datos_segunda_t3 = {"", "", "", "", "", "", "", "", ""};
    private String[] datos_tercera_t3 = {"", "", "", "", "", "", "", "", ""};

    private ArrayList<String[]> vulneraciones_tabla_uno = new ArrayList<>();

    public EstadisticaTrabajoSocialData() { }

    public String[] getDatos_mpales() {
        return datos_mpales;
    }
    public String[] getDatos_pmnna() {
        return datos_pmnna;
    }

    public void setDatos_pmnna(String[] datos_pmnna) {
        this.datos_pmnna = datos_pmnna;
    }
    public void setDatos_mpales(String[] datos_mpales) {
        this.datos_mpales = datos_mpales;
    }
    public void setDatos_primera_t2(String[] datos_primera_t2) {
        this.datos_primera_t2 = datos_primera_t2;
    }
    public void setDatos_segunda_t2(String[] datos_segunda_t2) {
        this.datos_segunda_t2 = datos_segunda_t2;
    }
    public void setDatos_tercera_t2(String[] datos_tercera_t2) {
        this.datos_tercera_t2 = datos_tercera_t2;
    }
    public void setDatos_primera_t3(String[] datos_primera_t3) {
        this.datos_primera_t3 = datos_primera_t3;
    }
    public void setDatos_segunda_t3(String[] datos_segunda_t3) {
        this.datos_segunda_t3 = datos_segunda_t3;
    }
    public void setDatos_tercera_t3(String[] datos_tercera_t3) {
        this.datos_tercera_t3 = datos_tercera_t3;
    }

    public ArrayList<String[]> getVulneraciones_tabla_uno() {
        this.vulneraciones_tabla_uno.add(getPRIMERAVEZ_T3());
        this.vulneraciones_tabla_uno.add(getSUBSECUENTE_T3());
        this.vulneraciones_tabla_uno.add(getSEGUIMIENTO_T3());
        return vulneraciones_tabla_uno;
    }

    public String[] getPMNNA() {
        return new String[] {"PAMNNA", datos_pmnna[0], datos_pmnna[1], datos_pmnna[2], datos_pmnna[3],  datos_pmnna[4], datos_pmnna[5]};
    }
    public String[] getMPALES() {
        return new String[] {"DEL. MPALES", datos_mpales[0], datos_mpales[1], datos_mpales[2], datos_mpales[3], datos_mpales[4], datos_mpales[5]};
    }
    public String[] getPRIMERAVEZ_T2() {
        return new String[] {"1ERA VEZ",
                datos_primera_t2[0], datos_primera_t2[1], datos_primera_t2[2], datos_primera_t2[3], datos_primera_t2[4], datos_primera_t2[5],datos_primera_t2[6], datos_primera_t2[7], datos_primera_t2[8]};
    }
    public String[] getSUBSECUENTE_T2() {
        return new String[] {"SUBSECUENTE",
                datos_segunda_t2[0], datos_segunda_t2[1], datos_segunda_t2[2], datos_segunda_t2[3], datos_segunda_t2[4], datos_segunda_t2[5],datos_segunda_t2[6], datos_segunda_t2[7], datos_segunda_t2[8]};
    }
    public String[] getSEGUIMIENTO_T2() {
        return new String[] {"SEGUIMIENTO",
                datos_tercera_t2[0], datos_tercera_t2[1], datos_tercera_t2[2], datos_tercera_t2[3], datos_tercera_t2[4], datos_tercera_t2[5],datos_tercera_t2[6], datos_tercera_t2[7], datos_tercera_t2[8]};
    }
    public String[] getPRIMERAVEZ_T3() {
        return new String[] {"1ERA VEZ",
                datos_primera_t3[0], datos_primera_t3[1], datos_primera_t3[2], datos_primera_t3[3], datos_primera_t3[4], datos_primera_t3[5],datos_primera_t3[6], datos_primera_t3[7], datos_primera_t3[8]};
    }
    public String[] getSUBSECUENTE_T3() {
        return new String[] {"SUBSECUENTE",
                datos_segunda_t3[0], datos_segunda_t3[1], datos_segunda_t3[2], datos_segunda_t3[3], datos_segunda_t3[4], datos_segunda_t3[5],datos_segunda_t3[6], datos_segunda_t3[7], datos_segunda_t3[8]};
    }
    public String[] getSEGUIMIENTO_T3() {
        return new String[] {"SEGUIMIENTO",
                datos_tercera_t3[0], datos_tercera_t3[1], datos_tercera_t3[2], datos_tercera_t3[3], datos_tercera_t3[4], datos_tercera_t3[5],datos_tercera_t3[6], datos_tercera_t3[7], datos_tercera_t3[8]};
    }

    // INVOLUCRADOS
    private ArrayList<String[]> involucrados = new ArrayList<>();
    private String[] datos_involucrados_hombre = {"", ""};
    private String[] datos_involucrados_mujer = {"", ""};
    private String[] datos_involucrados_desconocido = {"", ""};

    public ArrayList<String[]> getInvolucrados() {
        this.involucrados.add(getDatos_involucrados_hombre());
        this.involucrados.add(getDatos_involucrados_mujer());
        this.involucrados.add(getDatos_involucrados_desconocido());
        return this.involucrados;
    }
    public void setDatos_involucrados_hombre(String[] datos_involucrados_hombre) {
        this.datos_involucrados_hombre = datos_involucrados_hombre;
    }
    public void setDatos_involucrados_mujer(String[] datos_involucrados_mujer) {
        this.datos_involucrados_mujer = datos_involucrados_mujer;
    }
    public void setDatos_involucrados_desconocido(String[] datos_involucrados_desconocido) {
        this.datos_involucrados_desconocido = datos_involucrados_desconocido;
    }

    public String[] getDatos_involucrados_hombre() {
        return new String[] {"HOMBRE",
                datos_involucrados_hombre[0], datos_involucrados_hombre[1]};
    }
    public String[] getDatos_involucrados_mujer() {
        return new String[] {"MUJER",
                datos_involucrados_mujer[0], datos_involucrados_mujer[1]};
    }
    public String[] getDatos_involucrados_desconocido() {
        return new String[] {"DESCONOCIDO",
                datos_involucrados_desconocido[0], datos_involucrados_desconocido[1]};
    }

    // INGRESOS Y EGRESOS A CENTROS DE ASISTENCIA SOLCIAL
    // INRGESOS
    private ArrayList<String[]> ingresos_centros = new ArrayList<>();
    private String[] datos_ingresos_micasa = {"","","",""};
    private String[] datos_ingresos_casahogar = {"","","",""};
    private String[] datos_ingresos_total = {"","","",""};

    public ArrayList<String[]> getIngresos_centros() {
        this.ingresos_centros.add(getDatos_ingresos_micasa());
        this.ingresos_centros.add(getDatos_ingresos_casahogar());
        this.ingresos_centros.add(getDatos_ingresos_total());
        return ingresos_centros;
    }
    public void setDatos_ingresos_casahogar(String[] datos_ingresos_casahogar) {
        this.datos_ingresos_casahogar = datos_ingresos_casahogar;
    }
    public void setDatos_ingresos_micasa(String[] datos_ingresos_micasa) {
        this.datos_ingresos_micasa = datos_ingresos_micasa;
    }

    public String[] getDatos_ingresos_micasa() {
        return new String[] {"MI CASA",
                datos_ingresos_micasa[0], datos_ingresos_micasa[1], datos_ingresos_micasa[2], datos_ingresos_micasa[3]};
    }
    public String[] getDatos_ingresos_casahogar() {
        return new String[] {"CASA HOGAR",
                datos_ingresos_casahogar[0], datos_ingresos_casahogar[1], datos_ingresos_casahogar[2], datos_ingresos_casahogar[3]};
    }
    public String[] getDatos_ingresos_total() {
        return new String[] {"TOTAL",
                autoSuma(this.getDatos_ingresos_casahogar()[1], this.getDatos_ingresos_micasa()[1]),
                autoSuma(this.getDatos_ingresos_casahogar()[2], this.getDatos_ingresos_micasa()[2]),
                autoSuma(this.getDatos_ingresos_casahogar()[3], this.getDatos_ingresos_micasa()[3]),
                autoSuma(this.getDatos_ingresos_casahogar()[4], this.getDatos_ingresos_micasa()[4]),
        };
    }

    // EGRESOS
    private ArrayList<String[]> egresos_centros = new ArrayList<>();
    private String[] datos_egresos_micasa = {"","","",""};
    private String[] datos_egresos_casahogar = {"","","",""};
    private String[] datos_egresos_total = {"","","",""};

    public ArrayList<String[]> getEgresos_centros() {
        this.egresos_centros.add(getDatos_egresos_micasa());
        this.egresos_centros.add(getDatos_egresos_casahogar());
        this.egresos_centros.add(getDatos_egresos_total());
        return egresos_centros;
    }
    public void setDatos_egresos_casahogar(String[] datos_egresos_casahogar) {
        this.datos_egresos_casahogar = datos_egresos_casahogar;
    }
    public void setDatos_egresos_micasa(String[] datos_egresos_micasa) {
        this.datos_egresos_micasa = datos_egresos_micasa;
    }

    public String[] getDatos_egresos_micasa() {
        return new String[] {"MI CASA",
                datos_egresos_micasa[0], datos_egresos_micasa[1], datos_egresos_micasa[2], datos_egresos_micasa[3]};
    }
    public String[] getDatos_egresos_casahogar() {
        return new String[] {"CASA HOGAR",
                datos_egresos_casahogar[0], datos_egresos_casahogar[1], datos_egresos_casahogar[2], datos_egresos_casahogar[3]};
    }
    public String[] getDatos_egresos_total() {
        return new String[] {"TOTAL",
                autoSuma(this.getDatos_egresos_casahogar()[1], this.getDatos_egresos_micasa()[1]),
                autoSuma(this.getDatos_egresos_casahogar()[2], this.getDatos_egresos_micasa()[2]),
                autoSuma(this.getDatos_egresos_casahogar()[3], this.getDatos_egresos_micasa()[3]),
                autoSuma(this.getDatos_egresos_casahogar()[4], this.getDatos_egresos_micasa()[4]),
        };
    }

    // VULNERACIONES
    private ArrayList<EstadisticaVulneracionesData> vulneraciones = new ArrayList<>();
    public ArrayList<EstadisticaVulneracionesData> getVulneraciones() {
        return vulneraciones;
    }
    public void setVulneraciones(ArrayList<EstadisticaVulneracionesData> vulneraciones) {
        this.vulneraciones = vulneraciones;
    }

    // ESTADISTICA EXPEDIENTES
    private ArrayList<EstadisticaExpendientesData> expendientesData = new ArrayList<>();
    public ArrayList<EstadisticaExpendientesData> getExpendientesData() {
        return expendientesData;
    }
    public void setExpendientesData(ArrayList<EstadisticaExpendientesData> expendientesData) {
        this.expendientesData = expendientesData;
    }

    private static String autoSuma(String a, String b){
        int x = Integer.parseInt((a.equals(""))? "0": a);
        int y = Integer.parseInt((b.equals(""))? "0": b);
        return String.valueOf(x + y);
    }
}
