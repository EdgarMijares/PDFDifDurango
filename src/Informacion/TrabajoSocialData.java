package Informacion;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TrabajoSocialData {

    // INFORMACION DOCUMENTO
    private String folio = "";
    private String no_expediente = "";
    private String fecha = "";
    private String hora = "";

    // INFORMACION NINO
    private ArrayList<InformacionNinoData> informacionNinoData = new ArrayList();

    // INFORMACION TECNICAS
    private String nombre_tutor = "";
    private String edad_tutor = "";
    private String parentesco = "";
    private String estado_civil = "";
    private String telefono = "";
    private String idioma_tutor = "";
    private String etnia_tutor = "";
    private String religion_tutor = "";
    private boolean discapacidad_tutor = false;
    private String tipo_discapacidad_tutor = "";
    private String escolaridad_tutor = "";
    private String domicilio_tutor = "";

    // INFORMACION VALORACIÓN
    private int valoracion = 0;

    // INFORMACION TECNICAS
    private boolean tecnicas[] = {false, false, false, false};
    private String colateral = "";
    private String directa = "";

    // INFORMACION FAMILIAR
    private ArrayList<Familia> familia = new ArrayList<>();
    private String dinamica_familiar = "";
    private String familiograma = "";

    // INFORMACION ECONOMICA
    private double ingresos_padre = 0;
    private double ingresos_madre = 0;
    private double ingresos_hermano = 0;
    private double ingresos_otros = 0;
    private double ingresos_total = 0;

    private double egresos_alimentacion = 0;
    private double egresos_educacion = 0;
    private double egresos_salud = 0;
    private double egresos_vestido = 0;
    private double egresos_servicios = 0;
    private double egresos_transporte = 0;
    private double egresos_renta = 0;
    private double egresos_otros = 0;
    private double egresos_total = 0;

    private double superavit = 0;
    private double deficit = 0;

    // INFORMACION VIVIENDA
    private int vivienda = 0;
    private int tipo_vivienda = 0;
    private int zona_vivienda = 0;
    private boolean distribucion[];
    private String habitaciones[];
    private boolean material_piso[];
    private boolean material_muros[];
    private boolean material_techo[];
    private boolean servicios_publicos[];

    private String material_piso_otro = "";
    private String material_muros_otro = "";
    private String material_techo_otro = "";

    // INFORMACION REPORTE
    private String descripcion_problematica = "";
    private String entrevista_nino = "";
    private String diagnostico_social = "";
    private String plan_de_accion = "";
    private String observaciones = "";
    private String resultado = "";

    private boolean derechos[] = {
            false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false, false, };
    private String derechos_otro = "";

    // INFORMACION TRABAJADOR
    private String trabajador_social = "";

    public TrabajoSocialData() {
        super();
    }

    public TrabajoSocialData(String folio, String no_expediente, String fecha, String hora, ArrayList<InformacionNinoData> informacionNinoData, String nombre_tutor, String edad_tutor, String parentesco, String estado_civil, String telefono, String idioma_tutor, String etnia_tutor, String religion_tutor, boolean discapacidad_tutor, String tipo_discapacidad_tutor, String escolaridad_tutor, String domicilio_tutor, int valoracion, boolean[] tecnicas, ArrayList<Familia> familia, String dinamica_familiar, String familiograma, double ingresos_padre, double ingresos_madre, double ingresos_hermano, double ingresos_otros, double ingresos_total, double egresos_alimentacion, double egresos_educacion, double egresos_salud, double egresos_vestido, double egresos_servicios, double egresos_transporte, double egresos_renta, double egresos_otros, double egresos_total, double superavit, double deficit, int vivienda, int tipo_vivienda, int zona_vivienda, boolean[] distribucion, String[] habitaciones, boolean[] material_piso, boolean[] material_muros, boolean[] material_techo, boolean[] servicios_publicos, String material_piso_otro, String material_muros_otro, String material_techo_otro, String descripcion_problematica, String entrevista_nino, String diagnostico_social, String plan_de_accion, String observaciones, String trabajador_social) {
        this.folio = folio;
        this.no_expediente = no_expediente;
        this.fecha = fecha;
        this.hora = hora;
        this.informacionNinoData = informacionNinoData;
        this.nombre_tutor = nombre_tutor;
        this.edad_tutor = edad_tutor;
        this.parentesco = parentesco;
        this.estado_civil = estado_civil;
        this.telefono = telefono;
        this.idioma_tutor = idioma_tutor;
        this.etnia_tutor = etnia_tutor;
        this.religion_tutor = religion_tutor;
        this.discapacidad_tutor = discapacidad_tutor;
        this.tipo_discapacidad_tutor = tipo_discapacidad_tutor;
        this.escolaridad_tutor = escolaridad_tutor;
        this.domicilio_tutor = domicilio_tutor;
        this.valoracion = valoracion;
        this.tecnicas = tecnicas;
        this.familia = familia;
        this.dinamica_familiar = dinamica_familiar;
        this.familiograma = familiograma;
        this.ingresos_padre = ingresos_padre;
        this.ingresos_madre = ingresos_madre;
        this.ingresos_hermano = ingresos_hermano;
        this.ingresos_otros = ingresos_otros;
        this.ingresos_total = ingresos_total;
        this.egresos_alimentacion = egresos_alimentacion;
        this.egresos_educacion = egresos_educacion;
        this.egresos_salud = egresos_salud;
        this.egresos_vestido = egresos_vestido;
        this.egresos_servicios = egresos_servicios;
        this.egresos_transporte = egresos_transporte;
        this.egresos_renta = egresos_renta;
        this.egresos_otros = egresos_otros;
        this.egresos_total = egresos_total;
        this.superavit = superavit;
        this.deficit = deficit;
        this.vivienda = vivienda;
        this.tipo_vivienda = tipo_vivienda;
        this.zona_vivienda = zona_vivienda;
        this.distribucion = distribucion;
        this.habitaciones = habitaciones;
        this.material_piso = material_piso;
        this.material_muros = material_muros;
        this.material_techo = material_techo;
        this.servicios_publicos = servicios_publicos;
        this.material_piso_otro = material_piso_otro;
        this.material_muros_otro = material_muros_otro;
        this.material_techo_otro = material_techo_otro;
        this.descripcion_problematica = descripcion_problematica;
        this.entrevista_nino = entrevista_nino;
        this.diagnostico_social = diagnostico_social;
        this.plan_de_accion = plan_de_accion;
        this.observaciones = observaciones;
        this.trabajador_social = trabajador_social;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNo_expediente() {
        return no_expediente;
    }

    public void setNo_expediente(String no_expediente) {
        this.no_expediente = no_expediente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public ArrayList<InformacionNinoData> getInformacionNinoData() {
        return informacionNinoData;
    }

    public void setInformacionNinoData(ArrayList<InformacionNinoData> informacionNinoData) {
        this.informacionNinoData = informacionNinoData;
    }

    public String getNombre_tutor() {
        return nombre_tutor;
    }

    public void setNombre_tutor(String nombre_tutor) {
        this.nombre_tutor = nombre_tutor;
    }

    public String getEdad_tutor() {
        return edad_tutor;
    }

    public void setEdad_tutor(String edad_tutor) {
        this.edad_tutor = edad_tutor;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdioma_tutor() {
        return idioma_tutor;
    }

    public void setIdioma_tutor(String idioma_tutor) {
        this.idioma_tutor = idioma_tutor;
    }

    public String getEtnia_tutor() {
        return etnia_tutor;
    }

    public void setEtnia_tutor(String etnia_tutor) {
        this.etnia_tutor = etnia_tutor;
    }

    public String getReligion_tutor() {
        return religion_tutor;
    }

    public void setReligion_tutor(String religion_tutor) {
        this.religion_tutor = religion_tutor;
    }

    public boolean getDiscapacidad_tutor() {
        return discapacidad_tutor;
    }

    public void setDiscapacidad_tutor(boolean discapacidad_tutor) {
        this.discapacidad_tutor = discapacidad_tutor;
    }

    public String getTipo_discapacidad_tutor() {
        return tipo_discapacidad_tutor;
    }

    public void setTipo_discapacidad_tutor(String tipo_discapacidad_tutor) {
        this.tipo_discapacidad_tutor = tipo_discapacidad_tutor;
    }

    public String getEscolaridad_tutor() {
        return escolaridad_tutor;
    }

    public void setEscolaridad_tutor(String escolaridad_tutor) {
        this.escolaridad_tutor = escolaridad_tutor;
    }

    public String getDomicilio_tutor() {
        return domicilio_tutor;
    }

    public void setDomicilio_tutor(String domicilio_tutor) {
        this.domicilio_tutor = domicilio_tutor;
    }

    public int isValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public boolean[] getTecnicas() {
        return tecnicas;
    }

    public void setTecnicas(boolean[] tecnicas) {
        this.tecnicas = tecnicas;
    }

    public String getColateral() {
        return colateral;
    }

    public void setColateral(String colateral) {
        this.colateral = colateral;
    }

    public String getDirecta() {
        return directa;
    }

    public void setDirecta(String directa) {
        this.directa = directa;
    }

    public ArrayList<Familia> getFamilia() {
        return familia;
    }

    public void setFamilia(ArrayList<Familia> familia) {
        this.familia = familia;
    }

    public String getDinamica_familiar() {
        return dinamica_familiar;
    }

    public void setDinamica_familiar(String dinamica_familiar) {
        this.dinamica_familiar = dinamica_familiar;
    }

    public String getFamiliograma() {
        return familiograma;
    }

    public void setFamiliograma(String familiograma) {
        this.familiograma = familiograma;
    }

    public double getIngresos_padre() {
        return ingresos_padre;
    }

    public void setIngresos_padre(double ingresos_padre) {
        this.ingresos_padre = ingresos_padre;
    }

    public double getIngresos_madre() {
        return ingresos_madre;
    }

    public void setIngresos_madre(double ingresos_madre) {
        this.ingresos_madre = ingresos_madre;
    }

    public double getIngresos_hermano() {
        return ingresos_hermano;
    }

    public void setIngresos_hermano(double ingresos_hermano) {
        this.ingresos_hermano = ingresos_hermano;
    }

    public double getIngresos_otros() {
        return ingresos_otros;
    }

    public void setIngresos_otros(double ingresos_otros) {
        this.ingresos_otros = ingresos_otros;
    }

    public BigDecimal getIngresos_total() {
        BigDecimal total = new BigDecimal(0);
        total = total.add(BigDecimal.valueOf(this.ingresos_padre));
        total = total.add(BigDecimal.valueOf(this.ingresos_madre));
        total = total.add(BigDecimal.valueOf(this.ingresos_hermano));
        total = total.add(BigDecimal.valueOf(this.ingresos_otros));
        return total;
    }


    public double getEgresos_alimentacion() {
        return egresos_alimentacion;
    }

    public void setEgresos_alimentacion(double egresos_alimentacion) {
        this.egresos_alimentacion = egresos_alimentacion;
    }

    public double getEgresos_educacion() {
        return egresos_educacion;
    }

    public void setEgresos_educacion(double egresos_educacion) {
        this.egresos_educacion = egresos_educacion;
    }

    public double getEgresos_salud() {
        return egresos_salud;
    }

    public void setEgresos_salud(double egresos_salud) {
        this.egresos_salud = egresos_salud;
    }

    public double getEgresos_vestido() {
        return egresos_vestido;
    }

    public void setEgresos_vestido(double egresos_vestido) {
        this.egresos_vestido = egresos_vestido;
    }

    public double getEgresos_servicios() {
        return egresos_servicios;
    }

    public void setEgresos_servicios(double egresos_servicios) {
        this.egresos_servicios = egresos_servicios;
    }

    public double getEgresos_transporte() {
        return egresos_transporte;
    }

    public void setEgresos_transporte(double egresos_transporte) {
        this.egresos_transporte = egresos_transporte;
    }

    public double getEgresos_renta() {
        return egresos_renta;
    }

    public void setEgresos_renta(double egresos_renta) {
        this.egresos_renta = egresos_renta;
    }

    public double getEgresos_otros() {
        return egresos_otros;
    }

    public void setEgresos_otros(double egresos_otros) {
        this.egresos_otros = egresos_otros;
    }

    public BigDecimal getEgresos_total() {
        BigDecimal total = new BigDecimal(0);
        total = total.add(BigDecimal.valueOf(getEgresos_alimentacion()));
        total = total.add(BigDecimal.valueOf(getEgresos_educacion()));
        total = total.add(BigDecimal.valueOf(getEgresos_salud()));
        total = total.add(BigDecimal.valueOf(getEgresos_vestido()));
        total = total.add(BigDecimal.valueOf(getEgresos_servicios()));
        total = total.add(BigDecimal.valueOf(getEgresos_transporte()));
        total = total.add(BigDecimal.valueOf(getEgresos_renta()));
        total = total.add(BigDecimal.valueOf(getEgresos_otros()));

        return total;
    }

    public BigDecimal getSuperavit() {
        BigDecimal total = new BigDecimal(0);
        total = total.add(getIngresos_total());
        total = total.subtract(getEgresos_total());
        return total;
    }


    public BigDecimal getDeficit() {
        BigDecimal total = new BigDecimal(0);
        total = total.add(getEgresos_total());
        total = total.subtract(getIngresos_total());
        return total;
    }


    public int getVivienda() {
        return vivienda;
    }

    public void setVivienda(int vivienda) {
        this.vivienda = vivienda;
    }

    public int getTipo_vivienda() {
        return tipo_vivienda;
    }

    public void setTipo_vivienda(int tipo_vivienda) {
        this.tipo_vivienda = tipo_vivienda;
    }

    public int getZona_vivienda() {
        return zona_vivienda;
    }

    public void setZona_vivienda(int zona_vivienda) {
        this.zona_vivienda = zona_vivienda;
    }

    public boolean isDiscapacidad_tutor() {
        return discapacidad_tutor;
    }

    public boolean[] getDistribucion() {
        return distribucion;
    }

    public void setDistribucion(boolean[] distribucion) {
        this.distribucion = distribucion;
    }

    public String[] getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(String[] habitaciones) {
        this.habitaciones = habitaciones;
    }

    public boolean[] getMaterial_piso() {
        return material_piso;
    }

    public void setMaterial_piso(boolean[] material_piso) {
        this.material_piso = material_piso;
    }

    public boolean[] getMaterial_muros() {
        return material_muros;
    }

    public void setMaterial_muros(boolean[] material_muros) {
        this.material_muros = material_muros;
    }

    public boolean[] getMaterial_techo() {
        return material_techo;
    }

    public void setMaterial_techo(boolean[] material_techo) {
        this.material_techo = material_techo;
    }

    public boolean[] getServicios_publicos() {
        return servicios_publicos;
    }

    public void setServicios_publicos(boolean[] servicios_publicos) {
        this.servicios_publicos = servicios_publicos;
    }

    public String getMaterial_piso_otro() {
        return material_piso_otro;
    }

    public void setMaterial_piso_otro(String material_piso_otro) {
        this.material_piso_otro = material_piso_otro;
    }

    public String getMaterial_muros_otro() {
        return material_muros_otro;
    }

    public void setMaterial_muros_otro(String material_muros_otro) {
        this.material_muros_otro = material_muros_otro;
    }

    public String getMaterial_techo_otro() {
        return material_techo_otro;
    }

    public void setMaterial_techo_otro(String material_techo_otro) {
        this.material_techo_otro = material_techo_otro;
    }

    public String getDescripcion_problematica() {
        return descripcion_problematica;
    }

    public void setDescripcion_problematica(String descripcion_problematica) {
        this.descripcion_problematica = descripcion_problematica;
    }

    public String getEntrevista_nino() {
        return entrevista_nino;
    }

    public void setEntrevista_nino(String entrevista_nino) {
        this.entrevista_nino = entrevista_nino;
    }

    public String getDiagnostico_social() {
        return diagnostico_social;
    }

    public void setDiagnostico_social(String diagnostico_social) {
        this.diagnostico_social = diagnostico_social;
    }

    public String getPlan_de_accion() {
        return plan_de_accion;
    }

    public void setPlan_de_accion(String plan_de_accion) {
        this.plan_de_accion = plan_de_accion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean[] getDerechos() {
        return derechos;
    }

    public void setDerechos(boolean[] derechos) {
        this.derechos = derechos;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getDerechos_otro() {
        return derechos_otro;
    }

    public void setDerechos_otro(String derechos_otro) {
        this.derechos_otro = derechos_otro;
    }

    public String getTrabajador_social() {
        return trabajador_social;
    }

    public void setTrabajador_social(String trabajador_social) {
        this.trabajador_social = trabajador_social;
    }
}
