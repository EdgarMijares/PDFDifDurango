package Informacion;

public class EstadisticaTrabajoSocialData {

    private String[] datos_mpales = {"", "", "", "", "", "","",""};
    private String[] datos_pmnna = {"", "", "", "", "", "","", ""};

    private String[] datos_primera_t2 = {"", "", "", "", "", "", "", "", ""};
    private String[] datos_segunda_t2 = {"", "", "", "", "", "", "", "", ""};
    private String[] datos_tercera_t2 = {"", "", "", "", "", "", "", "", ""};

    private String[] datos_primera_t3 = {"", "", "", "", "", "", "", "", ""};
    private String[] datos_segunda_t3 = {"", "", "", "", "", "", "", "", ""};
    private String[] datos_tercera_t3 = {"", "", "", "", "", "", "", "", ""};
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
}
