package Formatos;

import Design.Default;
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

    public AnexoUnoPDF(String nombre_reporte, String url_reporte) throws IOException, DocumentException {
        Default.HeaderTable header = new Default.HeaderTable(getHeader(), "DIF/PPNNA-040-019/2018");

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
        datos.addCell(Default.celda("123", Element.ALIGN_LEFT));
        datos.addCell(Default.celda("N° De Expediente:", Default.TITULO, Element.ALIGN_RIGHT));
        datos.addCell(Default.celda("DIF/PPNNA-040-019/2018", Element.ALIGN_LEFT));
        datos.addCell(Default.celda("Fecha:", Default.TITULO, Element.ALIGN_RIGHT));
        datos.addCell(Default.celda("18/07/2018", Element.ALIGN_LEFT));
        datos.addCell(Default.celda("Hora:", Default.TITULO, Element.ALIGN_RIGHT));
        datos.addCell(Default.celda("12:31", Element.ALIGN_LEFT));

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
        content.addCell(Default.celdaDobleChica("NOMBRE: ",             "EDGAR CIPRIANO MIJARES CEJAS", new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("FECHA DE NACIMIENTO: ","06/08/1994",   new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("LUGAR DE NACIMIENTO: ","Durango Durango Mexico",       new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("NACIONALIDAD: ",       "Mexicana",     new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("GÉNERO",               "Masculino",    new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("ESCOLARIDAD: ",        "9no semestre de licenciatura", new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("RELIGIÓN: ",           "Catolico",     new float[] {27, 73}));
        content.addCell(Default.celdaDobleChica("ESTADO CIVIL: ",       "Soltero",      new float[] {27, 73}));

        PdfPTable discapaciad = new PdfPTable(4);
        discapaciad.addCell(Default.celda("DISCAPACIDAD:", Default.TITULO_CHICA, Element.ALIGN_LEFT));
        discapaciad.addCell(Default.checkTrueFalse(true, 90));
        discapaciad.addCell(Default.celda("¿CUÁL?", Default.TITULO_CHICA, Element.ALIGN_LEFT));
        discapaciad.addCell(Default.celda(" ", Default.NORMAL_CHICA, Element.ALIGN_LEFT));
        discapaciad.setTotalWidth(new float[] {25,25,10,40});
        discapaciad.setWidthPercentage(100);
        content.addCell(Default.celda(discapaciad));

        content.addCell(Default.celdaDoble("IDIOMA y/o DIALECTO:", "ESPAÑOL", new float[]{27,73}));
        content.addCell(
                Default.celdaDoble(
                        Default.celdaDobleChica("GRUPO ÉTNICO:", "ESPAÑOL", new float[] {54, 46}),
                        Default.celdaDobleChica("¿CUÁL?", "X", new float[] {20,80})));

        content.addCell(Default.celdaDoble("DOMICILIO: ", "", new float[] {27,73}));
        content.addCell(Default.celda());
        content.addCell(Default.celda("PERSONAS PRESENTES EN LA EVALUACIÓN PSICOLÓGICA Y SU PARENTESCO:", Default.TITULO_CHICA));
        content.addCell(Default.createTable(new String[] {"Nombre(s)", "Apellido Paterno", "Apellido Materno", "Parentesco"}, null));
        content.addCell(Default.celda());
        content.addCell(Default.celda("RESTRICCIONES EN LA EVALUACIÓN PSICOLÓGICA:", Default.TITULO_CHICA));
        content.addCell(Default.celda(""));

        content.setWidthPercentage(85);

        return content;
    }

    private PdfPTable getEvaluacion(){
        PdfPTable content = new PdfPTable(1);
        content.addCell(Default.celda("2. MOTIVO DE LA EVALUACIÓN PSICOLÓGICA:", Default.TITULO));
        content.addCell(Default.celda());
        content.setWidthPercentage(85);
        return content;
    }

    private PdfPTable getTecnicas() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("3. TÉCNICAS UTILIZADAS", Default.TITULO));
        content.addCell(Default.celda("3.2 ENTREVISTA", Default.TITULO_CHICA));
        content.addCell(Default.celda());
        content.addCell(Default.celda("3.3 PRUEBAS", Default.TITULO_CHICA));
        boolean t[] = new boolean[PRUEBAS.length];
        for(int i = 0; i < PRUEBAS.length; i++) {
            t[i] = true;
            if (t[i]) { content.addCell(Default.celdaDoble(PRUEBAS[i][0], PRUEBAS[i][1], new float[]{27, 73})); }
        }
        content.addCell(Default.celda());
        content.addCell(Default.celda("3.4 MATERIAL PSICOPEDAGÓGICO", Default.TITULO_CHICA));
        for(int i = 0; i < MATERIAL.length; i++) {
            if (t[i]) { content.addCell(Default.celda(MATERIAL[i], Default.NORMAL_CHICA)); }
        }
        content.addCell(Default.celda());

        content.setWidthPercentage(85);
        return content;
    }

    private PdfPTable getEstado() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("4. ESTADO MENTAL Y ACTITUD HACIA LA EVALUACIÓN\n ", Default.TITULO));
        content.addCell(Default.celda("4.1 APARIENCIA FÍSICA\n ", Default.TITULO_CHICA));
//        content.addCell(Default.celda());
        content.addCell(Default.celda("4.2 CONDUCTA MOTRIZ\n ", Default.TITULO_CHICA));
//        content.addCell(Default.celda());
        content.addCell(Default.celda("4.3 HABLA/LENGUAJE\n ", Default.TITULO_CHICA));
//        content.addCell(Default.celda());
        content.addCell(Default.celda("4.4 SOCIALIZACIÓN\n ", Default.TITULO_CHICA));
//        content.addCell(Default.celda());
        content.addCell(Default.celda("4.5 ORIENTACIÓN\n ", Default.TITULO_CHICA));
//        content.addCell(Default.celda());
        content.addCell(Default.celda("4.6 CONSCIENCIA\n ", Default.TITULO_CHICA));
//        content.addCell(Default.celda());
        content.addCell(Default.celda("4.7 MEMORIA, ATENCIÓN Y CONCENTRACIÓN\n ", Default.TITULO_CHICA));
//        content.addCell(Default.celda());
        content.addCell(Default.celda("4.8 PERCEPCIÓN\n ", Default.TITULO_CHICA));
//        content.addCell(Default.celda());
        content.addCell(Default.celda("4.9 PENSAMIENTO\n ", Default.TITULO_CHICA));
//        content.addCell(Default.celda());
        content.addCell(Default.celda("4.10 AFECTO/EMOCIÓN\n ", Default.TITULO_CHICA));
//        content.addCell(Default.celda());
        content.addCell(Default.celda("4.11 INTELIGENCIA\n ", Default.TITULO_CHICA));
//        content.addCell(Default.celda());

        content.setWidthPercentage(85);
        return content;
    }

    private PdfPTable getResultados() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("5. RESULTADOS E INTERPRETACIÓN DE LAS TÉCNICAS UTILIZADAS", Default.TITULO));
        content.addCell(Default.celda());

        content.addCell(Default.celda("6. CONCLUSIONES", Default.TITULO));
        content.addCell(Default.celda());

        content.addCell(Default.celda("7. SUGERENCIAS", Default.TITULO));
        content.addCell(Default.celda());

        content.setWidthPercentage(85);
        return content;
    }

    private PdfPTable getFirma() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.firmaTrabajadorChica("NOMBRE DEL TRABAJADOR", "PSICÓLOGO"));
        content.addCell(Default.celda());
        content.addCell(Default.celda("Ciudad de México, a " + Default.fechaTexto(), Default.TITULO, Element.ALIGN_JUSTIFIED));

        content.setWidthPercentage(85);
        return content;
    }
}
