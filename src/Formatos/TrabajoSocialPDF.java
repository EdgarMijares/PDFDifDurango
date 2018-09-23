package Formatos;

import Design.Default;
import Informacion.InformacionNinoData;
import Informacion.TrabajoSocialData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;

import static Design.Default.*;
import static Design.Default.celda;

public class TrabajoSocialPDF {
    TrabajoSocialData data;
    DecimalFormat moneda = new DecimalFormat("$ #.00");

    private static String LISTA_DE_DERECHOS[] = {
            "Derecho a la vida, a la supervivencia y al desarrollo",
            "Derecho de prioridad\n",
            "Derecho a la identidad",
            "Derecho a vivir en familia",
            "Derecho a la igualdad sustantiva",
            "Derecho a no ser discriminado",
            "Derecho a vivr en condiciones de bienestar y a un sano desarrollo integral",
            "Derecho a una vida libre de violencia y a la integridad personal",
            "Derecho a la protección de la salud y a la seguridad social",
            "Derecho a la inclusión de niñas, niños y adolescentes con discapacidad",
            "Derecho a la educación",
            "Derecho al descanso y al esparcimiento",
            "Derecho a la libertad de convicciones éticas, pensamiento, conciencia, religión y cultura",
            "Derecho a la libertad de expresión de acceso a la información",
            "Derecho de participación",
            "Derecho de asociación y reunió",
            "Derecho a la intimidad",
            "Derecho a la seguridad jurídica y al debido proceso",
            "Derechos de niñas, niños y adolescentes migrantes",
            "Derecho de acceso a las tecnologías de la información y comunicación así como a los " +
                    "servicios de radiodifusión y telecuminicaciones, incluido el de banda ancha e internet, en términos" +
                    "de lo previsto en la Ley Federal de Telecomunicaciones y Radiodifusión. Para tales efectos, el estado " +
                    "establecerá condiciones de competecia efectiva en la presentación de dicho servicios"
    };

    public TrabajoSocialPDF (String nombre_reporte, String url_reporte, TrabajoSocialData data) throws IOException, DocumentException {
        this.data = data;
        Default.HeaderTable header = new Default.HeaderTable(getHeader());

        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), 30);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        document.open();
        document.add(getDatosExpendientes());
        document.add(getDatosGenerales());
        document.add(getValoracion());
        document.add(getTecnicasUtilizadas());
        document.add(getEstrucutraFamiliar());
        document.add(getDinamicaFamiliar());
        document.add(getSituacionEconomica());
        document.add(getVivienda());
        document.add(getAntencedentes());
        document.add(getEntrevista());
        document.add(getDiagnostico());
        document.add(getPlanDeAccion());
        document.add(getObservaciones());
        document.add(getVulneraciones());
        document.close();

        pdfWriter.setPageEvent(new Default.FooterTableCount());
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
    }

    private PdfPTable getHeader() throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(2);

        content.addCell(Default.celda());
        content.addCell(Default.celda());
        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/DIF_ESTATAL.png").toString(), 50, Element.ALIGN_LEFT)));
        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/GOBIERNO_ESTADO.png").toString(), 50, Element.ALIGN_RIGHT)));

        content.setWidthPercentage(80);
        return content;
    }

    private PdfPTable getDatosExpendientes() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("\nANEXO II", Default.TITULO, Element.ALIGN_CENTER));
        content.addCell(Default.celda("Formato en materia de Trabajo Social", Default.TITULO, Element.ALIGN_CENTER));

        PdfPTable content_double = new PdfPTable(2);
        PdfPTable datos = new PdfPTable(2);

        datos.addCell(Default.celda("#", Default.TITULO, Element.ALIGN_RIGHT));
        datos.addCell(Default.celda(data.getFolio(), Element.ALIGN_LEFT));
        datos.addCell(Default.celda("N° De Expediente:", Default.TITULO, Element.ALIGN_RIGHT));
        datos.addCell(Default.celda(data.getNo_expediente(), Element.ALIGN_LEFT));
        datos.addCell(Default.celda("Fecha:", Default.TITULO, Element.ALIGN_RIGHT));
        datos.addCell(Default.celda(data.getFecha(), Element.ALIGN_LEFT));
        datos.addCell(Default.celda("Hora:", Default.TITULO, Element.ALIGN_RIGHT));
        datos.addCell(Default.celda(data.getHora(), Element.ALIGN_LEFT));

        datos.setTotalWidth(new float[]{45, 60});
        content_double.setTotalWidth(new float[]{50, 50});

        content.setWidthPercentage(100);
        content_double.setWidthPercentage(100);
        datos.setWidthPercentage(100);

        content_double.addCell(Default.celda());
        content_double.addCell(Default.celda(datos));
        content.addCell(Default.celda(content_double));

        return content;
    }

    private PdfPTable getDatosGenerales() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("I. DATOS GENERALES\n    I.I NIÑA, NIÑO O ADOLESENTE", Default.TITULO));
//        content.addCell(Default.celda());
        for (InformacionNinoData info: data.getInformacionNinoData()){
            content.addCell(Default.celdaTriple(
                    Default.celdaDoble("NOMBRE:", info.getNombre(), new float[] {21,79}),
                    Default.celdaDoble("EDAD:", info.getEdad(), new float[] {40,60}),
                    Default.celdaDoble("GÉNERO:", info.getSexo(), new float[] {40,60}),
                    new float[] {50, 20 , 30}
            ));
            content.addCell(Default.celdaDoble(
                    Default.celdaDoble("FECHA DE NACIMIENTO:", info.getFecha_nacimiento().toUpperCase(), new float[] {65, 35}),
                    Default.celdaDoble("LUGAR DE NACIMIENTO:", info.getLugar_nacimiento().toUpperCase(), new float[] {43, 57}),
                    new float[] {40, 60}
            ));
            content.addCell(Default.celdaTriple(
                    Default.celdaDoble("NACIONALIDAD:", info.getNacionalidad(), new float[] {50,50}),
                    Default.celdaDoble("IDIOMA:", info.getIdioma(), new float[] {35,65}),
                    Default.celdaDoble("GRUPO ÉTNICO:", info.getEtnia(), new float[] {50,50}),
                    new float[] {33, 25, 42}
            ));
            PdfPTable discapaciad = new PdfPTable(4);
            discapaciad.addCell(Default.celda("DISCAPACIDAD:", Default.TITULO_CHICA, Element.ALIGN_LEFT));
            discapaciad.addCell(Default.checkTrueFalse(info.isDiscapacidad(), 80));

            discapaciad.addCell(Default.celda("¿CUÁL?", Default.TITULO_CHICA, Element.ALIGN_LEFT));
            discapaciad.addCell(Default.celda(info.getTipo_discapacidad(), Default.NORMAL_CHICA, Element.ALIGN_JUSTIFIED));
            discapaciad.setTotalWidth(new float[] {18,32,10,40});
            discapaciad.setWidthPercentage(100);
            content.addCell(Default.celdaDoble(
                    Default.celdaDoble("RELIGIÓN:", info.getReligion(), new float[] {25,75}),
                    Default.celdaDoble("ESCOLARIDAD:", info.getEscolaridad(), new float[] {33,67}),
                    new float[] {50,50}
            ));
            content.addCell(Default.celda(discapaciad));
            content.addCell(Default.celdaDoble("DOMICILIO:", info.getDomicilio(), new float[] {13, 87}));
        }
        content.addCell(Default.celda());
        content.addCell(Default.celda("    I.II MADRE, PADRE O TUTOR", Default.TITULO));

        content.addCell(Default.celdaTriple(
                Default.celdaDoble("NOMBRE:", data.getNombre_tutor(), new float[] {21,79}),
                Default.celdaDoble("EDAD:", data.getEdad_tutor(), new float[] {50,50}),
                Default.celdaDoble("PARENTESCO:", data.getParentesco(), new float[] {45,55}),
                new float[] {50, 15 , 35}
        ));

        content.addCell(Default.celdaTriple(
                Default.celdaDoble("ESTADO CIVIL:", data.getEstado_civil(), new float[] {50,50}),
                Default.celdaDoble("TÉLEFONO:", data.getTelefono(), new float[] {35,65}),
                Default.celdaDoble("IDIOMA:", data.getIdioma_tutor(), new float[] {35,65}),
                new float[] {35, 35, 30}
        ));

        content.addCell(Default.celdaTriple(
                Default.celdaDoble("GRUPO ÉTNICO:", data.getEtnia_tutor(), new float[] {50,50}),
                Default.celdaDoble("RELIGÓN:", data.getReligion_tutor(), new float[] {35,65}),
                Default.celdaDoble("ESCOLARIDAD:", data.getEscolaridad_tutor(), new float[] {45,55}),
                new float[] {35, 30, 35}
        ));

        PdfPTable discapaciad = new PdfPTable(4);
        discapaciad.addCell(Default.celda("DISCAPACIDAD:", Default.TITULO_CHICA, Element.ALIGN_LEFT));
        discapaciad.addCell(Default.checkTrueFalse(data.isDiscapacidad_tutor(), 80));

        discapaciad.addCell(Default.celda("¿CUÁL?", Default.TITULO_CHICA, Element.ALIGN_LEFT));
        discapaciad.addCell(Default.celda(data.getTipo_discapacidad_tutor(), Default.NORMAL_CHICA, Element.ALIGN_JUSTIFIED));
        discapaciad.setTotalWidth(new float[] {18,32,10,40});
        discapaciad.setWidthPercentage(100);
        content.addCell(Default.celda(discapaciad));
        content.addCell(Default.celdaDoble("DOMICILIO:", data.getDomicilio_tutor(), new float[] {13, 87}));

        content.setWidthPercentage(90);

        return content;
    }

    private PdfPTable getValoracion() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("II. VALORACIÓN", Default.TITULO));
        content.addCell(Default.celdaTriple(
                Default.opcion("INICIAL", true, new float[] {20, 80}),
                Default.opcion("SUBSECUENTE", true, new float[] {20, 80}),
                Default.opcion("SEGUIMIENTO DE CASO", true, new float[] {20, 80})
        ));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getTecnicasUtilizadas() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("III. TÉCNICAS UTILIZADAS", Default.TITULO));
        content.addCell(Default.celdaDoble(
                Default.opcion("ENTREVISTA", data.getTecnicas()[0], new float[] {10, 90}),
                Default.opcion("OBSERVACIÓN", data.getTecnicas()[1], new float[] {10, 90})
        ));
        content.addCell(Default.celdaDoble(
                Default.opcion("VISITA DOMICILIARIA", data.getTecnicas()[2], new float[] {10, 90}),
                Default.opcion("MIXTA", data.getTecnicas()[3], new float[] {10, 90})
        ));
        content.addCell(Default.celdaDoble(
                Default.opcion("COLATERAL", data.getColateral(), new float[] {20, 80}),
                Default.opcion("DIRECTA", data.getDirecta(), new float[] {20, 80})
        ));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getEstrucutraFamiliar() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("        IV. ESTRUCTURA FAMILIAR", Default.TITULO));
        content.addCell(Default.celda());
        content.addCell(Default.createTableFamilaDetallada(new String[] {"NOMBRE", "PARENTESCO", "EDAD", "SEXO", "ESTADO CIVIL", "ESCOLARIDAD", "OCUPACIÓN"}, data.getFamilia()));

        content.setWidthPercentage(100);
        return content;
    }

    private PdfPTable getDinamicaFamiliar() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("V. DINÁMICA FAMILIAR", Default.TITULO));
        content.addCell(Default.celda(data.getDinamica_familiar(), Element.ALIGN_JUSTIFIED));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getFamiliograma() throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda(Default.createImageWidth(data.getFamiliograma(), 300)));
        content.setWidthPercentage(90);

        return content;
    }

    private PdfPTable getSituacionEconomica() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("VII. SITUACIÓN ECONOMICA", Default.TITULO));

        PdfPTable ingresos = new PdfPTable(2);
        ingresos.addCell(Default.celda("PADRE", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        ingresos.addCell(Default.celda(String.valueOf(moneda.format(data.getIngresos_padre())), Default.NORMAL_CHICA));
        ingresos.addCell(Default.celda("MADRE", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        ingresos.addCell(Default.celda(String.valueOf(moneda.format(data.getIngresos_madre())), Default.NORMAL_CHICA));
        ingresos.addCell(Default.celda("HERMANO(A)", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        ingresos.addCell(Default.celda(String.valueOf(moneda.format(data.getIngresos_hermano())), Default.NORMAL_CHICA));
        ingresos.addCell(Default.celda("OTROS", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        ingresos.addCell(Default.celda(String.valueOf(moneda.format(data.getIngresos_otros())), Default.NORMAL_CHICA));
        ingresos.addCell(Default.celda("TOTAL", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        ingresos.addCell(Default.celda(String.valueOf(moneda.format(data.getIngresos_total())), Default.NORMAL_CHICA));

        PdfPTable egresos = new PdfPTable(2);
        egresos.addCell(Default.celda("ALIMENTACIÓN", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        egresos.addCell(Default.celda(String.valueOf(moneda.format(data.getEgresos_alimentacion())), Default.NORMAL_CHICA));
        egresos.addCell(Default.celda("EDUCACIÓN", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        egresos.addCell(Default.celda(String.valueOf(moneda.format(data.getEgresos_educacion())), Default.NORMAL_CHICA));
        egresos.addCell(Default.celda("SALUD", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        egresos.addCell(Default.celda(String.valueOf(moneda.format(data.getEgresos_salud())), Default.NORMAL_CHICA));
        egresos.addCell(Default.celda("VESTIDO", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        egresos.addCell(Default.celda(String.valueOf(moneda.format(data.getEgresos_vestido())), Default.NORMAL_CHICA));
        egresos.addCell(Default.celda("SERVICIOS", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        egresos.addCell(Default.celda(String.valueOf(moneda.format(data.getEgresos_servicios())), Default.NORMAL_CHICA));
        egresos.addCell(Default.celda("TRANSPORTE", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        egresos.addCell(Default.celda(String.valueOf(moneda.format(data.getEgresos_transporte())), Default.NORMAL_CHICA));
        egresos.addCell(Default.celda("RENTA", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        egresos.addCell(Default.celda(String.valueOf(moneda.format(data.getEgresos_renta())), Default.NORMAL_CHICA));
        egresos.addCell(Default.celda("TOTAL", Default.TITULO_CHICA, Element.ALIGN_RIGHT));
        egresos.addCell(Default.celda(String.valueOf(moneda.format(data.getEgresos_total())), Default.NORMAL_CHICA));

        content.addCell(Default.celdaDoble(
                Default.celda("INGRESOS(MENSUAL)", Default.TITULO_CHICA, Element.ALIGN_CENTER),
                Default.celda("EGRESOS(MENSUAL)", Default.TITULO_CHICA, Element.ALIGN_CENTER)));
        content.addCell(Default.celdaDoble(Default.celda(ingresos),Default.celda(egresos)));

        content.addCell(Default.celdaDoble(
                Default.celda("SUPERÁVIT", Default.TITULO_CHICA, Element.ALIGN_RIGHT),
                Default.celda(moneda.format(data.getSuperavit()), Default.NORMAL_CHICA)));

        content.addCell(Default.celdaDoble(
                Default.celda("DEFICIT", Default.TITULO_CHICA, Element.ALIGN_RIGHT),
                Default.celda(moneda.format(data.getDeficit()), Default.NORMAL_CHICA)));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getVivienda() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("VII.III. VIVIENDA", Default.TITULO));
        content.addCell(Default.celdaTriple(
                Default.opcion("PROPIA", (data.getVivienda() == 0) ? true : false, new float[] {20, 80}),
                Default.opcion("RENTADA", (data.getVivienda() == 1) ? true : false, new float[] {20, 80}),
                Default.opcion("PRESTADA", (data.getVivienda() == 2) ? true : false, new float[] {20, 80})
        ));

        content.addCell(Default.celda("VII.IV. TIPO DE VIVIENDA", Default.TITULO));
        content.addCell(Default.celdaTriple(
                Default.opcion("CASA SOLA", (data.getTipo_vivienda() == 0) ? true : false, new float[] {20, 80}),
                Default.opcion("DEPARTAMENTO", (data.getTipo_vivienda() == 1) ? true : false, new float[] {20, 80}),
                Default.opcion("VECINDAD", (data.getTipo_vivienda() == 2) ? true : false, new float[] {20, 80})
        ));
        content.addCell(Default.celdaTriple(
                Default.opcion("IMPROVISADO", (data.getTipo_vivienda() == 3) ? true : false, new float[] {20, 80}),
                Default.opcion("OTRO", (data.getTipo_vivienda() == 4) ? true : false, new float[] {20, 80}),
                Default.celda()
        ));
        content.setWidthPercentage(90);

        content.addCell(Default.celda("VII.V. ZONA", Default.TITULO));
        content.addCell(Default.celdaDoble(
                Default.opcion("RURAL", (data.getZona_vivienda() == 0) ? true : false, new float[] {20, 80}),
                Default.opcion("URBANA", (data.getZona_vivienda() == 1) ? true : false, new float[] {20, 80})
        ));

        content.addCell(Default.celda("VII.VI. DISRIBUCIÓN", Default.TITULO));
        content.addCell(Default.celdaDoble(
                Default.celdaDoble(
                        Default.opcion("SALA", data.getDistribucion()[0], new float[] {20,80}),
                        Default.opcion("COMEDOR", data.getDistribucion()[1], new float[] {20,80})
                ),
                Default.celdaDoble(
                        Default.opcion("COCINA", data.getDistribucion()[2], new float[] {20,80}),
                        Default.opcion("BAÑO", data.getDistribucion()[3], new float[] {20,80})
                )
        ));
        content.addCell(Default.celdaTriple(
                Default.celdaDobleChica("HABITACIONES", data.getHabitaciones()[0], new float[] {70,30}),
                Default.celdaDobleChica("RECAMARAS", data.getHabitaciones()[1], new float[] {70,30}),
                Default.celdaDobleChica("HACINAMIENTO", data.getHabitaciones()[2], new float[] {70,30})
        ));

        content.addCell(Default.celda("V.II.VII. MATERIAL DE VIVIENDA", Default.TITULO));
        content.addCell(Default.celda("PISO:", Default.TITULO_CHICA));
        content.addCell(Default.celdaDoble(
                Default.celdaDoble(
                        Default.opcion("TIERRA", data.getMaterial_piso()[0]),
                        Default.opcion("CONCRETO", data.getMaterial_piso()[1])
                ),
                Default.celdaDoble(
                        Default.opcion("PIEDRA", data.getMaterial_piso()[0]),
                        Default.opcion("MADERA", data.getMaterial_piso()[1])
                )
        ));
        content.addCell(Default.celdaDobleChica("OTRO", data.getMaterial_piso_otro(), new float[] {8, 92}));

        content.addCell(Default.celda("MUROS:", Default.TITULO_CHICA));
        content.addCell(Default.celdaDoble(
                Default.celdaDoble(
                        Default.opcion("ADOBE", data.getMaterial_muros()[0]),
                        Default.opcion("CARTÓN", data.getMaterial_muros()[1])
                ),
                Default.celdaDoble(
                        Default.opcion("TABIQUE", data.getMaterial_muros()[0]),
                        Default.opcion("MADERA", data.getMaterial_muros()[1])
                )
        ));
        content.addCell(Default.celdaDobleChica("OTRO", data.getMaterial_muros_otro(), new float[] {8, 92}));

        content.addCell(Default.celda("TECHO:", Default.TITULO_CHICA));
        content.addCell(Default.celdaDoble(
                Default.celdaDoble(
                        Default.opcion("LAMINA", data.getMaterial_techo()[0]),
                        Default.opcion("CARTÓN", data.getMaterial_techo()[1])
                ),
                Default.celdaDoble(
                        Default.opcion("CONCRETO", data.getMaterial_techo()[0]),
                        Default.opcion("MADERA", data.getMaterial_techo()[1])
                )
        ));
        content.addCell(Default.celdaDobleChica("OTRO", data.getMaterial_techo_otro(), new float[] {8, 92}));

        content.addCell(Default.celda("VII.VIII. SERVICIOS PÚBLICOS", Default.TITULO));
        content.addCell(Default.celdaDoble(
                Default.celdaDoble(
                        Default.opcion("AGUA POTABLE", data.getServicios_publicos()[0]),
                        Default.opcion("ELECTRICIDAD", data.getServicios_publicos()[1])
                ),
                Default.celdaDoble(
                        Default.opcion("DRENAJE", data.getServicios_publicos()[2]),
                        Default.opcion("ALUMBRADO PÚBLICO", data.getServicios_publicos()[3])
                )
        ));
        content.addCell(Default.celdaDoble(
                Default.celdaDoble(
                        Default.celda(),
                        Default.opcion("PAVIMENTACIÓN", data.getServicios_publicos()[4])
                ),
                Default.celdaDoble(
                        Default.opcion("SERVICIO DE LIMPIEZA", data.getServicios_publicos()[5]),
                        Default.celda()
                )
        ));

        return content;
    }

    private PdfPTable getAntencedentes() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("VIII. ANTECEDENTES Y DESCRIPCIÓN DE LA PROBLEMÁTICA", Default.TITULO));
        content.addCell(Default.celda(data.getDescripcion_problematica()));

        return content;
    }

    private PdfPTable getEntrevista() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("IX. ENTREVISTA CON NIÑA, NIÑO O ADOLESCENTE", Default.TITULO));
        content.addCell(Default.celda(data.getEntrevista_nino()));

        return content;
    }

    private PdfPTable getDiagnostico() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("X DIAGNÓSTICO SOCIAL", Default.TITULO));
        content.addCell(Default.celda(data.getDiagnostico_social()));

        return content;
    }

    private PdfPTable getPlanDeAccion() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("XI. PLAN DE ACCIÓN", Default.TITULO));
        content.addCell(Default.celda(data.getPlan_de_accion()));

        return content;
    }

    private PdfPTable getObservaciones() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("XII. OBSERVACIONES", Default.TITULO));
        content.addCell(Default.celda(data.getObservaciones()));

        return content;
    }

    private PdfPTable getVulneraciones() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(rellenoColor());
        content.addCell(celda("CLASIFICACIÓN DE VULNERACIÓN DE DERECHOS", TITULO));
        for (int i = 0; i < LISTA_DE_DERECHOS.length; i++) {
            if (data.getDerechos()[i]){
                content.addCell(Default.opcion(LISTA_DE_DERECHOS[i], true, new float[] {3, 97}));
            }
        }
        content.addCell(data.getDerechos_otro());
        content.addCell(celda());

        content.setWidthPercentage(90);
        return content;
    }
}