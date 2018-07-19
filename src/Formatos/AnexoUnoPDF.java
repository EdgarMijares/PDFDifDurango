package Formatos;

import Design.Default;
import Informacion.AnexoUnoData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AnexoUnoPDF {

    private static String[][] PRUEBAS = {
            {"HTP (HOUSE-TREE-PERSON)", "TEST QUE PERMITE AL SUJETO PROYECTAR CON MÁS FACILIDAD SUS ÁREAS DE CONFLICTO Y ELEMENTOS DE SU PERSONALIDAD."},
            {"TEST DEL ÁRBOL", "TEST PROYECTIVO QUE CONSISTE EN EL DIBUJO DE UN ÁRBOL, EN ESTE TODO NIÑO/ADOLESCENTE INFORMA ACERCA DE SÍ MISMO, DE SU EVOLUCIÓN PSICOSEXUAL " +
                    "Y DE SU RELACIÓN CON EL MUNDO EN EL QUE SE DESARROLLA "},
            {"TEST DE LA FAMILIA", "SE TRATA DE UNA PRUEBA DE PERSONALIDAD QUE PUEDE ADMINISTRARSE A LOS NIÑOS DE CINCO AÑOS HASTA LA ADOLESCENCIA, POSIBILITA LA LIBRE" +
                    "EXPRESIÓN DE LOS SENTIMIENTOS DE LOS MENORES HACIA SUS FAMILIARES, ESPECIALMENTE DE SUS PROGENITORES Y REFLEJA, ADEMÁS, LA SITUACIÓN EN LA QUE SE COLOCAN ELLOS" +
                    "MISMOS CON SU MEDIO DOMÉSTICO."},
            {"TEST DE MACHOVER", "PRUEBA GRÁFICA DONDE POR MEDIO DE LA FIGURA HUMANA SE EVALÚA LA PERSONALIDAD."},
            {"TEST DE APERCEPCIÓN INFANTIL", "PRUEBA PROYECTIVA, PERMITE CONOCER TANTO EL CONOCIMIENTO APERCEPTIVO COMO EL EXPRESIVO. "},
            {"TEST DE PERSONA BAJO LA LLUVIA.", "PRUEBA PROYECTIVA, PERMITE EVALUAR LA ANSIEDAD, TEMOR, DEFENSAS, ADAPTACIÓN, ETC. "},
            {"TEST GESTÁLTICO VISOMOTOR BENDER", "EXPLORA MADUREZ PERCEPTIVA, DETERIORO NEUROLÓGICO Y AJUSTE EMOCIONAL. "},
            {"OTRO", ""}
    };

    private static String[] MATERIAL = {"MEMORAMA", "ROMPECABEZAS(EN FUNCIÓN DE LAS EDADES", "CUENTOS", "JUGUETES(CARROS, PELUCHES, ANIMALITOS, MUÑECAS, ETC.", "TÍTERES", "MASA(PLAY DOH)"};

    private AnexoUnoData data;

    public AnexoUnoPDF(String nombre_reporte, String url_reporte, AnexoUnoData data) throws IOException, DocumentException {
        this.data = data;
        Default.HeaderTable header = new Default.HeaderTable(getHeader(), data.getNo_expediente());

        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), 30);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        document.open();
        document.add(getDatosExpendientes());
        document.add(getDatosGenerales());
        document.add(getEvaluacion());
        document.add(getTecnicas());
        document.add(getEstado());
        document.add(getResultados());
        document.add(getFirma());
        document.close();
        pdfWriter.setPageEvent(new Default.FooterTableCount());
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
    }

    private PdfPTable getHeader() throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(2);

        content.addCell(Default.celda());
        content.addCell(Default.celda());
        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/DIF_ESTATAL.png").toString(), 60, Element.ALIGN_LEFT)));
        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/GOBIERNO_ESTADO.png").toString(), 60, Element.ALIGN_RIGHT)));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getDatosExpendientes() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("\nANEXO I", Default.TITULO, Element.ALIGN_CENTER));
        content.addCell(Default.celda("Formato en materia Psicológica", Default.TITULO, Element.ALIGN_CENTER));

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

        datos.setTotalWidth(new float[] {45, 60});
        content_double.setTotalWidth(new float[] {50, 50});

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

        content.addCell(Default.celda("1. DATOS GENERALES", Default.TITULO));
        content.addCell(Default.celda("1.1 INFORMACIÓN DEL PACIENTE", Default.TITULO_CHICA));
        content.addCell(Default.celda());
        content.addCell(Default.celdaDobleChica("NOMBRE: ",             data.getNombre(),           new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("FECHA DE NACIMIENTO: ",data.getFecha_nacimiento(), new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("LUGAR DE NACIMIENTO: ",data.getLugar_nacimiento(), new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("NACIONALIDAD: ",       data.getNacionalidad(),     new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("GÉNERO",               data.getSexo(),             new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("ESCOLARIDAD: ",        data.getEscolaridad(),      new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("RELIGIÓN: ",           data.getReligion(),         new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("ESTADO CIVIL: ",       data.getEstado_civil(),     new float[] {27, 73}));

        PdfPTable discapaciad = new PdfPTable(4);
        discapaciad.addCell(Default.celda("DISCAPACIDAD:", Default.TITULO_CHICA, Element.ALIGN_LEFT));
        discapaciad.addCell(Default.checkTrueFalse(data.isDiscapacidad(), 90));

        discapaciad.addCell(Default.celda("¿CUÁL?", Default.TITULO_CHICA, Element.ALIGN_LEFT));
        discapaciad.addCell(Default.celda(data.getTipo_discapacidad(), Default.NORMAL_CHICA, Element.ALIGN_LEFT));

        discapaciad.setTotalWidth(new float[] {25,25,10,40});
        discapaciad.setWidthPercentage(100);
        content.addCell(Default.celda(discapaciad));

        content.addCell(Default.celdaDoble("IDIOMA y/o DIALECTO:",  data.getIdioma(), new float[]{27,73}));
        content.addCell(
                Default.celdaDoble(
                        Default.celdaDobleChica("GRUPO ÉTNICO:",    data.getEtnia(), new float[] {54, 46}),
                        Default.celdaDobleChica("¿CUÁL?",           data.getEtnia_cual(), new float[] {20,80})));

        content.addCell(Default.celdaDoble("DOMICILIO: ", data.getDomicilio(), new float[] {27,73}));
        content.addCell(Default.celda());
        content.addCell(Default.celda("PERSONAS PRESENTES EN LA EVALUACIÓN PSICOLÓGICA Y SU PARENTESCO:", Default.TITULO_CHICA));
        content.addCell(Default.createTable(new String[] {"Nombre(s)", "Apellido Paterno", "Apellido Materno", "Parentesco"}, data.getFamilia()));

        content.addCell(Default.celda("RESTRICCIONES EN LA EVALUACIÓN PSICOLÓGICA:", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getRestricciones(), Default.NORMAL_CHICA));

        content.setWidthPercentage(85);

        return content;
    }

    private PdfPTable getEvaluacion(){
        PdfPTable content = new PdfPTable(1);
        content.addCell(Default.celda("2. MOTIVO DE LA EVALUACIÓN PSICOLÓGICA:", Default.TITULO));
        content.addCell(Default.celda(data.getMotivo_evaluacion(), Default.NORMAL_CHICA));
        content.setWidthPercentage(85);
        return content;
    }

    private PdfPTable getTecnicas() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("3. TÉCNICAS UTILIZADAS", Default.TITULO));
        content.addCell(Default.celda("3.2 ENTREVISTA", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getEntrevista() + "\n ", Default.NORMAL_CHICA));
        content.addCell(Default.celda("3.3 PRUEBAS", Default.TITULO_CHICA));
        for(int i = 0; i < PRUEBAS.length; i++) {
            if (data.getPruebas()[i]) { content.addCell(Default.celdaDoble(PRUEBAS[i][0], PRUEBAS[i][1], new float[]{27, 73})); }
        }
        content.addCell(Default.celda("\n "));
        content.addCell(Default.celda("3.4 MATERIAL PSICOPEDAGÓGICO", Default.TITULO_CHICA));
        for(int i = 0; i < MATERIAL.length; i++) {
            if (data.getMaterial()[i]) { content.addCell(Default.celdaDoble("      > ", MATERIAL[i], new float[]{8, 97})); }
        }
        content.addCell(Default.celda());

        content.setWidthPercentage(85);
        return content;
    }

    private PdfPTable getEstado() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("4. ESTADO MENTAL Y ACTITUD HACIA LA EVALUACIÓN\n ", Default.TITULO));
        content.addCell(Default.celda("4.1 APARIENCIA FÍSICA", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getApariencia_fisica() + "\n ", Default.NORMAL_CHICA));
        content.addCell(Default.celda("4.2 CONDUCTA MOTRIZ", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getConducta_motriz() + "\n ", Default.NORMAL_CHICA));
        content.addCell(Default.celda("4.3 HABLA/LENGUAJE", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getHabla() + "\n ", Default.NORMAL_CHICA));
        content.addCell(Default.celda("4.4 SOCIALIZACIÓN", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getSocializacion() + "\n ", Default.NORMAL_CHICA));
        content.addCell(Default.celda("4.5 ORIENTACIÓN", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getOrientacion() + "\n ", Default.NORMAL_CHICA));
        content.addCell(Default.celda("4.6 CONSCIENCIA", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getConscienca() + "\n ", Default.NORMAL_CHICA));
        content.addCell(Default.celda("4.7 MEMORIA, ATENCIÓN Y CONCENTRACIÓN", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getMemoria() + "\n ", Default.NORMAL_CHICA));
        content.addCell(Default.celda("4.8 PERCEPCIÓN", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getPercepcion() + "\n ", Default.NORMAL_CHICA));
        content.addCell(Default.celda("4.9 PENSAMIENTO", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getPensamiento() + "\n ", Default.NORMAL_CHICA));
        content.addCell(Default.celda("4.10 AFECTO/EMOCIÓN", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getAfecto() + "\n ", Default.NORMAL_CHICA));
        content.addCell(Default.celda("4.11 INTELIGENCIA", Default.TITULO_CHICA));
        content.addCell(Default.celda(data.getInteligencia() + "\n ", Default.NORMAL_CHICA));

        content.setWidthPercentage(85);
        return content;
    }

    private PdfPTable getResultados() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("5. RESULTADOS E INTERPRETACIÓN DE LAS TÉCNICAS UTILIZADAS", Default.TITULO));
        content.addCell(Default.celda(data.getInterpretacion_de_tecnicas(), Default.NORMAL_CHICA));

        content.addCell(Default.celda("6. CONCLUSIONES", Default.TITULO));
        content.addCell(Default.celda(data.getConcluciones(), Default.NORMAL_CHICA));

        content.addCell(Default.celda("7. SUGERENCIAS", Default.TITULO));
        content.addCell(Default.celda(data.getSugerencias(), Default.NORMAL_CHICA));

        content.setWidthPercentage(85);
        return content;
    }

    private PdfPTable getFirma() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.firmaTrabajadorChica("NOMBRE DEL TRABAJADOR", "PSICÓLOGO"));
        content.addCell(Default.celda());
        content.addCell(Default.celda("Ciudad de México, a " + Default.fechaTexto(), Default.TITULO, Element.ALIGN_JUSTIFIED));

        content.setWidthPercentage(85);
        return content;
    }
}
