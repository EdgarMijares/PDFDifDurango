package Formatos;

import Informacion.Familia;
import Informacion.InformacionNinoData;
import Informacion.TrabajoSocialData;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.text.DecimalFormat;

import static Formatos.DefaultV1.*;

public class TrabajoSocialPDF {
    TrabajoSocialData informacion;

    public class HeaderTable extends PdfPageEventHelper {
        protected PdfPTable table;
        protected float tableHeight;

        public HeaderTable() throws IOException, BadElementException {
            table = new PdfPTable(1);
            table.setTotalWidth(523);
            table.setLockedWidth(true);
            table.addCell(celda(" "));
            table.addCell(celda(" "));
            table.addCell(borrarBordesTable(header()));
            Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            font.setColor(200,200,200);
            table.addCell(celda("________________________________________________________________________", Element.ALIGN_CENTER, font));
            tableHeight = table.getTotalHeight();
        }

        public float getTableHeight() {
            return tableHeight;
        }

        public void onEndPage(PdfWriter writer, Document document) {
            table.writeSelectedRows(0, -1,
                    document.left(),
                    document.top() + ((document.topMargin() + tableHeight) / 2),
                    writer.getDirectContent());
        }
    }

    public class FooterTable extends PdfPageEventHelper {
        protected PdfPTable footer;
        public FooterTable(PdfPTable footer) {
            this.footer = footer;
        }
        public void onEndPage(PdfWriter writer, Document document) {
            footer.writeSelectedRows(0, -1, 36, 55, writer.getDirectContent());
        }
    }

    DecimalFormat formatoMoneda = new DecimalFormat("#,##0.00");

    public TrabajoSocialPDF(TrabajoSocialData informacion, String nombre_reporte, String url_reporte) throws IOException, DocumentException {
        this.informacion = informacion;
        HeaderTable header = new HeaderTable();
        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), 55);

        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));
        pdfWriter.setPageEvent(header);
        pdfWriter.setPageEvent(new FooterTable(footer()));
        document.open();
        document.add(paginaUno());
        document.add(paginaDos());
        document.add(paginaTres());
        document.add(paginaCuatro());
        document.add(paginaCinco());
        document.add(paginaSeis());
        document.add(firmaTrabajadorSocial());

        document.close();
//        subirReporte(url_reporte, nombre_reporte + "pdf");
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
    }

    private void subirReporte(String url_reporte, String destino_reporte) throws IOException {
        Path origen = FileSystems.getDefault().getPath(url_reporte);
        Path destino = FileSystems.getDefault().getPath("\\\\URLSERVIDOR\\CARPETA\\" + destino_reporte);
        Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        JOptionPane.showMessageDialog(null, "Anexo II, En materia de Trabajo Social, fue creado con exito.", "Crear reporte.", JOptionPane.INFORMATION_MESSAGE);
    }

    private PdfPTable header() throws IOException, BadElementException{
        Image salud = createImageHeight("http://contextodedurango.com.mx/noticias/wp-content/uploads/2017/09/DIF-2.png", 50);
        Image dif = createImageHeight("https://contextodedurango.com.mx/noticias/wp-content/uploads/2017/09/gobierno-del-estado.png", 50);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        PdfPCell cell_salud = new PdfPCell(salud);
        PdfPCell cell_dif = new PdfPCell(dif);

        cell_salud.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell_dif.setHorizontalAlignment(Element.ALIGN_CENTER);

        cell_salud.setBorder(0);
        cell_dif.setBorder(0);

        table.addCell(cell_salud);
        table.addCell(cell_dif);

        Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        font.setColor(200,200,200);

        return table;
    }

    private PdfPTable footer() {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(530);

        PdfPTable linea_uno = new PdfPTable(2);


        table.addCell(celda("______________________________________________________________________________", Element.ALIGN_CENTER));
        linea_uno.addCell(celda("TRABAJO SOCIAL " + informacion.getFecha(), NORMAL_CHICA));
        linea_uno.addCell(celda(informacion.getNo_expediente() + "   ", Element.ALIGN_RIGHT, NORMAL_CHICA));

        table.addCell(borrarBordesTable(linea_uno));

        return table;
    }

    private Paragraph firmaTrabajadorSocial() {
        Paragraph paragraph = new Paragraph();

        PdfPTable content = new PdfPTable(1);

        content.addCell(celda(" "));
        content.addCell(celda(" "));
        content.addCell(celda(" "));
        content.addCell(celda("___________________________", Element.ALIGN_CENTER));
        content.addCell(celda(informacion.getTrabajador_social(), Element.ALIGN_CENTER));

        paragraph.add(content);
        return paragraph;
    }

    private Paragraph paginaUno() throws DocumentException {
        Paragraph paragraph = new Paragraph();

        paragraph.setAlignment(Element.ALIGN_CENTER);

        paragraph.add(new Chunk("Anexo II\n\nFormato en materia de Trabajo Social\n", TITULO));
        paragraph.add(paginaUnoSeccionUno());
        paragraph.add(Chunk.NEWLINE);
        for (InformacionNinoData informacionNinoData : informacion.getInformacionNinoData()) {
            paragraph.add(informacionNino(informacionNinoData));
        }
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(informacionTutor());

        return paragraph;
    }

    private Paragraph paginaDos() throws DocumentException {
        Paragraph paragraph = new Paragraph();

        PdfPTable content = new PdfPTable(1);
        PdfPTable linea_uno = new PdfPTable(1);
        PdfPTable linea_dos = new PdfPTable(1);
        PdfPTable linea_tres = new PdfPTable(7);

        linea_uno.addCell(celda(checkValoracion(informacion.isValaracion()), Element.ALIGN_CENTER));
        linea_dos.addCell(celda(checkTecnicas(
                informacion.getTecnicas()[0],
                informacion.getTecnicas()[1],
                informacion.getTecnicas()[2],
                informacion.getTecnicas()[3]), Element.ALIGN_CENTER));

        linea_tres.addCell(celda("NOMBRE",      Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        linea_tres.addCell(celda("PARENTESCO",  Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        linea_tres.addCell(celda("EDAD",        Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        linea_tres.addCell(celda("SEXO",        Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        linea_tres.addCell(celda("ESTADO CIVIL",Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        linea_tres.addCell(celda("ESCOLARIDAD", Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        linea_tres.addCell(celda("OCUPACIÓN",   Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));

        for (Familia d : informacion.getFamilia()) {
            linea_tres.addCell(celda(d.getNombre(), NORMAL_CHICA, false));
            linea_tres.addCell(celda(d.getParentesco(), NORMAL_CHICA, false));
            linea_tres.addCell(celda(d.getEdad(), NORMAL_CHICA, false));
            linea_tres.addCell(celda(d.getSexo(), NORMAL_CHICA, false));
            linea_tres.addCell(celda(d.getEstado_civil(), NORMAL_CHICA, false));
            linea_tres.addCell(celda(d.getEscolaridad(), NORMAL_CHICA, false));
            linea_tres.addCell(celda(d.getOcupacion(), NORMAL_CHICA, false));
        }

        content.addCell(celda("                II. VALORACÓN\n\n", TITULO));
        content.addCell(borrarBordesTable(linea_uno));

        content.addCell(celda("\n                III. TÉCNICAS UTILIZADAS\n\n", TITULO));
        content.addCell(borrarBordesTable(linea_dos));

        content.addCell(celda("\n                IV. ESTRUCTURA FAMILIAR\n\n", TITULO));

        content.setWidthPercentage(100);

        linea_tres.setTotalWidth(new float[]{25,15,7,7,15,15,15});
        linea_tres.setWidthPercentage(100);

        paragraph.add(content);
        paragraph.add(linea_tres);

        return paragraph;
    }

    private Paragraph paginaTres() throws IOException, BadElementException {
        Paragraph paragraph = new Paragraph();

        PdfPTable content = new PdfPTable(1);

        content.addCell(celda("\n\n            V. DINÁMICA FAMILIAR\n\n", TITULO));
        content.addCell(celda(informacion.getDinamica_familiar()));

        content.addCell(celda("\n\n            VI. FAMILIOGRAMA\n\n", TITULO));
        if(!informacion.getFamiliograma().equals(""))
            content.addCell(celda(createImageWidth(informacion.getFamiliograma(), 300)));

        content.setWidthPercentage(100);
        paragraph.add(content);
        return paragraph;
    }

    private Paragraph paginaCuatro() throws DocumentException {
        Paragraph paragraph = new Paragraph();

        PdfPTable content = new PdfPTable(1);

        PdfPTable titulo = new PdfPTable(2);
        PdfPTable linea_uno = new PdfPTable(2);

        PdfPTable situacion_ingresos = new PdfPTable(2);

        content.addCell(celda("\n\n            VII. SITUACION ECONOMICA", TITULO));
        titulo.addCell(celda("\n               VII.I. INGRESO (MENSUAL)\n\n", TITULO));

        situacion_ingresos.addCell(celda("Padre:",      Element.ALIGN_RIGHT, TITULO));
        situacion_ingresos.addCell(celda("$" + formatoMoneda.format(informacion.getIngresos_padre()), Element.ALIGN_LEFT, SUBRAYADO));
        situacion_ingresos.addCell(celda("Madre:",      Element.ALIGN_RIGHT, TITULO));
        situacion_ingresos.addCell(celda("$" + formatoMoneda.format(informacion.getIngresos_madre()), Element.ALIGN_LEFT, SUBRAYADO));
        situacion_ingresos.addCell(celda("Hermano(a):", Element.ALIGN_RIGHT, TITULO));
        situacion_ingresos.addCell(celda("$" + formatoMoneda.format(informacion.getIngresos_hermano()), Element.ALIGN_LEFT, SUBRAYADO));
        situacion_ingresos.addCell(celda("Otros:",      Element.ALIGN_RIGHT, TITULO));
        situacion_ingresos.addCell(celda("$" + formatoMoneda.format(informacion.getIngresos_otros()), Element.ALIGN_LEFT, SUBRAYADO));
        situacion_ingresos.addCell(celda("TOTAL:",      Element.ALIGN_RIGHT, TITULO));
        situacion_ingresos.addCell(celda("$" + formatoMoneda.format(informacion.getIngresos_total()), Element.ALIGN_LEFT, SUBRAYADO));

        PdfPTable situacion_egresos = new PdfPTable(2);

        titulo.addCell(celda("\n            VII.II. EGRESO (MENSUAL):\n\n", TITULO));
        situacion_egresos.addCell(celda("Alimentación:", Element.ALIGN_RIGHT, TITULO));
        situacion_egresos.addCell(celda("$" + formatoMoneda.format(informacion.getEgresos_alimentacion()), Element.ALIGN_LEFT, SUBRAYADO));
        situacion_egresos.addCell(celda("Educación:",   Element.ALIGN_RIGHT, TITULO));
        situacion_egresos.addCell(celda("$" + formatoMoneda.format(informacion.getEgresos_educacion()), Element.ALIGN_LEFT, SUBRAYADO));
        situacion_egresos.addCell(celda("Salud:",       Element.ALIGN_RIGHT, TITULO));
        situacion_egresos.addCell(celda("$" + formatoMoneda.format(informacion.getEgresos_salud()), Element.ALIGN_LEFT, SUBRAYADO));
        situacion_egresos.addCell(celda("Vestido:",     Element.ALIGN_RIGHT, TITULO));
        situacion_egresos.addCell(celda("$" + formatoMoneda.format(informacion.getEgresos_vestido()), Element.ALIGN_LEFT, SUBRAYADO));
        situacion_egresos.addCell(celda("Servicios:",   Element.ALIGN_RIGHT, TITULO));
        situacion_egresos.addCell(celda("$" + formatoMoneda.format(informacion.getEgresos_servicios()), Element.ALIGN_LEFT, SUBRAYADO));
        situacion_egresos.addCell(celda("Transporte:",  Element.ALIGN_RIGHT, TITULO));
        situacion_egresos.addCell(celda("$" + formatoMoneda.format(informacion.getEgresos_transporte()), Element.ALIGN_LEFT, SUBRAYADO));
        situacion_egresos.addCell(celda("Renta:",       Element.ALIGN_RIGHT, TITULO));
        situacion_egresos.addCell(celda("$" + formatoMoneda.format(informacion.getEgresos_renta()), Element.ALIGN_LEFT, SUBRAYADO));
        situacion_egresos.addCell(celda("Otros:",       Element.ALIGN_RIGHT, TITULO));
        situacion_egresos.addCell(celda("$" + formatoMoneda.format(informacion.getEgresos_otros()), Element.ALIGN_LEFT, SUBRAYADO));
        situacion_egresos.addCell(celda("TOTAL:",       Element.ALIGN_RIGHT, TITULO));
        situacion_egresos.addCell(celda("$" + formatoMoneda.format(informacion.getEgresos_total()), Element.ALIGN_LEFT, SUBRAYADO));

        titulo.addCell(celda("\n            VII.II. EGRESO (MENSUAL):\n\n", TITULO));

        linea_uno.addCell(borrarBordesTable(situacion_ingresos));
        linea_uno.addCell(borrarBordesTable(situacion_egresos));

        PdfPTable totales = new PdfPTable(2);
        totales.addCell(celda(" "));
        totales.addCell(celda(" "));
        totales.addCell(celda("SUPERÁVIT:", Element.ALIGN_RIGHT, TITULO));
        totales.addCell(celda("$" + formatoMoneda.format(informacion.getSuperavit()), Element.ALIGN_LEFT, SUBRAYADO));
        totales.addCell(celda("DÉFICIT:",   Element.ALIGN_RIGHT, TITULO));
        totales.addCell(celda("$" + formatoMoneda.format(informacion.getDeficit()), Element.ALIGN_LEFT, SUBRAYADO));

        PdfPTable distribucion = new PdfPTable(6);
        distribucion.addCell(celda(" "));
        distribucion.addCell(celda(" "));
        distribucion.addCell(celda(" "));
        distribucion.addCell(celda(" "));
        distribucion.addCell(celda(" "));
        distribucion.addCell(celda(" "));
        distribucion.addCell(celda("Habitaciones:", Element.ALIGN_RIGHT));
        distribucion.addCell(celda(informacion.getHabitaciones()[0], SUBRAYADO));
        distribucion.addCell(celda("Recamaras:", Element.ALIGN_RIGHT));
        distribucion.addCell(celda(informacion.getHabitaciones()[1], SUBRAYADO));
        distribucion.addCell(celda("Hacinamiento:", Element.ALIGN_RIGHT));
        distribucion.addCell(celda(informacion.getHabitaciones()[2], SUBRAYADO));

        distribucion.setTotalWidth(new float[] {20, 10, 20, 10, 20, 10});

        content.addCell(borrarBordesTable(titulo));
        content.addCell(borrarBordesTable(linea_uno));
        content.addCell(borrarBordesTable(totales));

        content.addCell(celda("\n            VII.III. VIVIENDA:\n\n", TITULO));
        content.addCell(celda(checkVivienda(informacion.getVivienda()), Element.ALIGN_CENTER));

        content.addCell(celda("\n            VII.IV. TIPO DE VIVIENDA:\n\n", TITULO));
        content.addCell(celda(checkTipoVivienda(informacion.getTipo_vivienda()), Element.ALIGN_CENTER));

        content.addCell(celda("\n            VII.V. ZONA:\n\n", TITULO));
        content.addCell(celda(checkZona(informacion.getZona_vivienda()), Element.ALIGN_CENTER));

        content.addCell(celda("\n            VII.VI. DISTRIBUCIÒN:\n\n", TITULO));
        content.addCell(celda(checkDistribucion(
                informacion.getDistribucion()[0],
                informacion.getDistribucion()[1],
                informacion.getDistribucion()[2],
                informacion.getDistribucion()[3]), Element.ALIGN_CENTER));
        content.addCell(borrarBordesTable(distribucion));

        content.addCell(celda("\n            VII.VIII. MATERIAL DE LA VIVIENDA:\n\n", TITULO));
        content.addCell(celda(checkMaterialPisos(
                informacion.getMaterial_piso()[0],
                informacion.getMaterial_piso()[1],
                informacion.getMaterial_piso()[2],
                informacion.getMaterial_piso()[3],
                informacion.getMaterial_piso_otro()), Element.ALIGN_CENTER));

        content.addCell(celda(checkMaterialMuro(
                informacion.getMaterial_muros()[0],
                informacion.getMaterial_muros()[1],
                informacion.getMaterial_muros()[2],
                informacion.getMaterial_muros()[3],
                informacion.getMaterial_muros_otro()), Element.ALIGN_CENTER));

        content.addCell(celda(checkMaterialTecho(
                informacion.getMaterial_techo()[0],
                informacion.getMaterial_techo()[1],
                informacion.getMaterial_techo()[2],
                informacion.getMaterial_techo()[3],
                informacion.getMaterial_techo_otro()), Element.ALIGN_CENTER));

        content.setWidthPercentage(100);
        paragraph.add(content);

        return paragraph;
    }

    private Paragraph paginaCinco() {
        Paragraph paragraph = new Paragraph();

        PdfPTable content = new PdfPTable(1);

        content.addCell(celda("\n            VII.VIII. SERVICIOS PÚBLICOS:\n\n", TITULO));
        content.addCell(celda(checkServiciosPublicos(
                informacion.getServicios_publicos()[0],
                informacion.getServicios_publicos()[1],
                informacion.getServicios_publicos()[2],
                informacion.getServicios_publicos()[3],
                informacion.getServicios_publicos()[4],
                informacion.getServicios_publicos()[5]
        ), Element.ALIGN_CENTER));

        content.addCell(celda("\n\n            VIII. ANTECEDENTES Y DESCRIPCIÓN DE LA PROBLEMÁTICA:\n\n", TITULO));
        content.addCell(celda(informacion.getDescripcion_problematica()));

        content.addCell(celda("\n\n            IX. ENTREVISTA CON NIÑA, NIÑO O ADOLESCENTE:\n\n", TITULO));
        content.addCell(celda(informacion.getEntrevista_nino()));

        content.setWidthPercentage(100);
        paragraph.add(content);

        return paragraph;
    }

    private Paragraph paginaSeis() {
        Paragraph paragraph = new Paragraph();

        PdfPTable content = new PdfPTable(1);

        content.addCell(celda("\n\n            X. DIAGNÓSTICO SOCIAL:\n\n", TITULO));
        content.addCell(celda(informacion.getDiagnostico_social()));

        content.addCell(celda("\n\n            XI. PLAN DE ACCIÓN:\n\n", TITULO));
        content.addCell(celda(informacion.getPlan_de_accion()));

        content.addCell(celda("\n\n            XII. OBSERVACIONES:\n\n", TITULO));
        content.addCell(celda(informacion.getObservaciones()));

        content.setWidthPercentage(100);
        paragraph.add(content);

        return paragraph;
    }

    private PdfPTable paginaUnoSeccionUno() throws DocumentException {
        PdfPTable table = new PdfPTable(2);

        Paragraph p = new Paragraph(new Chunk("I. DATOS GENERALES\n\n    I.I. NIÑA, NIÑO O ADOLESENTE", TITULO));
        PdfPCell tituloDatosGenerales = new PdfPCell(p);
        tituloDatosGenerales.setVerticalAlignment(Element.ALIGN_BOTTOM);

        PdfPCell infoGeneral = new PdfPCell();
        PdfPTable tablaInfoGeneral = new PdfPTable(2);
        tablaInfoGeneral.setHorizontalAlignment(Element.ALIGN_RIGHT);
        tablaInfoGeneral.addCell(celda("#: ", Element.ALIGN_RIGHT, TITULO));
        tablaInfoGeneral.addCell(celda(informacion.getFolio()));

        tablaInfoGeneral.addCell(celda("N° de Expediente: ", Element.ALIGN_RIGHT, TITULO));
        tablaInfoGeneral.addCell(celda(informacion.getNo_expediente()));

        tablaInfoGeneral.addCell(celda("Fecha: ", Element.ALIGN_RIGHT, TITULO));
        tablaInfoGeneral.addCell(celda(informacion.getFecha()));

        tablaInfoGeneral.addCell(celda("Hora: ", Element.ALIGN_RIGHT, TITULO));
        tablaInfoGeneral.addCell(celda(informacion.getHora()));

        tablaInfoGeneral.setWidthPercentage(110);
        infoGeneral.addElement(tablaInfoGeneral);

        tituloDatosGenerales.setBorder(0);
        infoGeneral.setBorder(0);

        table.setWidthPercentage(100);
        table.setTotalWidth(new float[] {40, 65});

        table.addCell(tituloDatosGenerales);
        table.addCell(infoGeneral);
        return table;
    }

    private PdfPTable informacionNino(InformacionNinoData informacionNinoData) throws DocumentException {
        PdfPTable table = new PdfPTable(1);

        PdfPTable linea_uno = new PdfPTable(4);
        PdfPTable linea_dos = new PdfPTable(4);
        PdfPTable linea_tres = new PdfPTable(6);
        PdfPTable linea_cuatro = new PdfPTable(4);
        PdfPTable linea_cinco = new PdfPTable(4);
        PdfPTable linea_seis = new PdfPTable(4);

        // LINEA UNO
        linea_uno.addCell(celda("Nombre:", TITULO));
        linea_uno.addCell(celda(informacionNinoData.getNombre(), SUBRAYADO));

        linea_uno.addCell(celda("Edad:", TITULO));
        linea_uno.addCell(celda(informacionNinoData.getEdad(), SUBRAYADO));

        // LINEA DOS
        linea_dos.addCell(celda("Fecha de Nacimiento:", TITULO));
        linea_dos.addCell(celda(informacionNinoData.getFecha_nacimiento(), SUBRAYADO));

        linea_dos.addCell(celda("Lugar de Nacimiento:", TITULO));
        linea_dos.addCell(celda(informacionNinoData.getLugar_nacimiento(), SUBRAYADO));

        // LINEA TRES
        linea_tres.addCell(celda("Nacionalidad:", TITULO));
        linea_tres.addCell(celda(informacionNinoData.getNacionalidad(), SUBRAYADO));

        linea_tres.addCell(celda("Género:", TITULO));
        linea_tres.addCell(celda(informacionNinoData.getSexo(), SUBRAYADO));

        linea_tres.addCell(celda("Idioma:", TITULO));
        linea_tres.addCell(celda(informacionNinoData.getIdioma(), SUBRAYADO));

        // LINEA CUATRO
        linea_cuatro.addCell(celda("Grupo Étnico:", TITULO));
        linea_cuatro.addCell(celda(informacionNinoData.getEtnia(), SUBRAYADO));

        linea_cuatro.addCell(celda("Religión:", TITULO));
        linea_cuatro.addCell(celda(informacionNinoData.getReligion(), SUBRAYADO));

        // LINEA CINCO
        linea_cinco.addCell(celda("Discapacidad:", TITULO));
        linea_cinco.addCell(celda(checkSiNo(informacionNinoData.isDiscapacidad()), NORMAL));

        linea_cinco.addCell(celda("¿Cuál?", TITULO));
        linea_cinco.addCell(celda(informacionNinoData.getTipo_discapacidad(), NORMAL));

        // LINEA SEIS
        linea_seis.addCell(celda("Escolaridad:", TITULO));
        linea_seis.addCell(celda(informacionNinoData.getEscolaridad(), SUBRAYADO));

        linea_seis.addCell(celda("Domicilio:", TITULO));
        linea_seis.addCell(celda(informacionNinoData.getDomicilio()));

        linea_uno.setTotalWidth(new float[]     {15, 65, 10, 10});
        linea_dos.setTotalWidth(new float[]     {28, 15, 27, 30});
        linea_tres.setTotalWidth(new float[]    {20, 20, 15, 15, 15, 15});
        linea_cuatro.setTotalWidth(new float[]  {25, 25, 25, 25});
        linea_cinco.setTotalWidth(new float[]   {20, 15, 10, 55});
        linea_seis.setTotalWidth(new float[]    {16, 29, 15, 40});

        table.setWidthPercentage(90);

        table.addCell(borrarBordesTable(linea_uno));
        table.addCell(celda(" "));
        table.addCell(borrarBordesTable(linea_dos));
        table.addCell(celda(" "));
        table.addCell(borrarBordesTable(linea_tres));
        table.addCell(celda(" "));
        table.addCell(borrarBordesTable(linea_cuatro));
        table.addCell(celda(" "));
        table.addCell(borrarBordesTable(linea_cinco));
        table.addCell(celda(" "));
        table.addCell(borrarBordesTable(linea_seis));

        return table;
    }

    private PdfPTable informacionTutor() throws DocumentException {
        PdfPTable table = new PdfPTable(1);

        PdfPTable titulo = new PdfPTable(1);
        PdfPTable linea_uno = new PdfPTable(4);
        PdfPTable linea_dos = new PdfPTable(6);
        PdfPTable linea_tres = new PdfPTable(6);
        PdfPTable linea_cuatro = new PdfPTable(4);
        PdfPTable linea_cinco = new PdfPTable(4);
        PdfPTable linea_seis = new PdfPTable(4);

        // TITULO
        titulo.addCell(celda("    I.II. MADRE, PADRE O TUTOR:", TITULO));

        // LINEA UNO
        linea_uno.addCell(celda("Nombre:", TITULO));
        linea_uno.addCell(celda(informacion.getNombre_tutor(), SUBRAYADO));

        linea_uno.addCell(celda("Edad:", TITULO));
        linea_uno.addCell(celda(informacion.getEdad_tutor(), SUBRAYADO));

        // LINEA DOS
        linea_dos.addCell(celda("Parentesco:", TITULO));
        linea_dos.addCell(celda(informacion.getParentesco(), SUBRAYADO));

        linea_dos.addCell(celda("Estado Civil:", TITULO));
        linea_dos.addCell(celda(informacion.getEstado_civil(), SUBRAYADO));

        linea_dos.addCell(celda("Teléfono:", TITULO));
        linea_dos.addCell(celda(informacion.getTelefono(), SUBRAYADO));

        // LINEA TRES
        linea_tres.addCell(celda("Idioma:", TITULO));
        linea_tres.addCell(celda(informacion.getIdioma_tutor(), SUBRAYADO));

        linea_tres.addCell(celda("Grupo Étnico:", TITULO));
        linea_tres.addCell(celda(informacion.getEtnia_tutor(), SUBRAYADO));

        linea_tres.addCell(celda("Religión:", TITULO));
        linea_tres.addCell(celda(informacion.getReligion_tutor(), SUBRAYADO));

        // LINEA CUATRO
        linea_cuatro.addCell(celda("Discapacidad:", TITULO));
        linea_cuatro.addCell(celda(checkSiNo(informacion.isDiscapacidad_tutor()), NORMAL));

        linea_cuatro.addCell(celda("¿Cuál?", TITULO));
        linea_cuatro.addCell(celda(informacion.getTipo_discapacidad_tutor(), NORMAL));

        // LINEA CINCO
        linea_cinco.addCell(celda("Escolaridad:", TITULO));
        linea_cinco.addCell(celda(informacion.getEscolaridad_tutor(), SUBRAYADO));

        linea_cinco.addCell(celda("Domicilio:", TITULO));
        linea_cinco.addCell(celda(informacion.getDomicilio_tutor()));

        linea_uno.setTotalWidth(new float[] {15, 65, 10, 10});
        linea_dos.setTotalWidth(new float[] {16, 14, 18, 12, 15, 25});
        linea_tres.setTotalWidth(new float[] {10, 15, 20, 15, 15, 15});
        linea_cuatro.setTotalWidth(new float[] {20, 15, 10, 55});
        linea_cinco.setTotalWidth(new float[] {16, 29, 15, 40});

        table.setWidthPercentage(90);

        titulo.setWidthPercentage(100);
        linea_uno.setWidthPercentage(100);
        linea_dos.setWidthPercentage(100);
        linea_tres.setWidthPercentage(100);
        linea_cuatro.setWidthPercentage(100);
        linea_cinco.setWidthPercentage(100);
        linea_seis.setWidthPercentage(100);

        table.addCell(borrarBordesTable(titulo));
        table.addCell(celda(" "));
        table.addCell(borrarBordesTable(linea_uno));
        table.addCell(celda(" "));
        table.addCell(borrarBordesTable(linea_dos));
        table.addCell(celda(" "));
        table.addCell(borrarBordesTable(linea_tres));
        table.addCell(celda(" "));
        table.addCell(borrarBordesTable(linea_cuatro));
        table.addCell(celda(" "));
        table.addCell(borrarBordesTable(linea_cinco));
        table.addCell(celda(" "));
        table.addCell(borrarBordesTable(linea_seis));

        return table;
    }
}

class DefaultV1 {

    public static Font TITULO = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    public static Font NORMAL = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
    public static Font NORMAL_CHICA = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);
    public static Font SUBRAYADO = new Font(Font.FontFamily.HELVETICA, 12, Font.UNDERLINE);

    public static PdfPCell borrarBordesTable(PdfPTable table) {
        PdfPCell cell = new PdfPCell(table);
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(String text, int posicion, Font tipo){
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(text, tipo)));
        cell.setHorizontalAlignment(posicion);
        cell.setBorder(0);
        cell.setFixedHeight(20f);
        return cell;
    }

    public static PdfPCell celda(double text, int posicion, Font tipo){
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(String.valueOf(text), tipo)));
        cell.setHorizontalAlignment(posicion);
        cell.setBorder(0);
        cell.setFixedHeight(20f);
        return cell;
    }

    public static PdfPCell celda(String text, int posicion, int border, Font tipo){
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(text, tipo)));
        cell.setHorizontalAlignment(posicion);
//        cell.setBorder(border);
        cell.setFixedHeight(20f);
        return cell;
    }

    public static PdfPCell celda(String text, Font tipo){
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(text, tipo)));
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(String text, Font tipo, boolean borde){
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(text, tipo)));
        if (borde) cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(String text, int posicion, int border){
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(text, NORMAL)));
        cell.setHorizontalAlignment(posicion);
        cell.setBorder(border);
        return cell;
    }

    public static PdfPCell celda(String text, int posicion){
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(text, NORMAL)));
        cell.setHorizontalAlignment(posicion);
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(String text){
        PdfPCell cell = new PdfPCell(Phrase.getInstance(String.valueOf(new Chunk(text, NORMAL))));
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(Image image){
        PdfPCell cell = new PdfPCell(image);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(0);
        return cell;
    }

    public static Image createImage(String ruta, float escala) throws IOException, BadElementException {
        Image image = Image.getInstance(ruta);
        image.scaleAbsoluteHeight((float) (image.getScaledHeight() * (escala/100)));
        image.scaleAbsoluteWidth((float) (image.getScaledWidth() * (escala/100)));
        return image;
    }

    public static Image createImage(String ruta, int altura, int largo) throws IOException, BadElementException {
        Image image = Image.getInstance(ruta);
        image.scaleAbsoluteHeight((float) (altura));
        image.scaleAbsoluteWidth((float) (largo));
        return image;
    }

    public static Image createImageWidth(String ruta, int largo) throws IOException, BadElementException {
        Image image = Image.getInstance(ruta);
        if(largo > 300) {largo = 300;}
        float height = (image.getHeight() / image.getWidth()) * largo;

        image.scaleAbsoluteWidth(largo);
        image.scaleAbsoluteHeight(height);
        return image;
    }

    public static Image createImageHeight(String ruta, int alto) throws IOException, BadElementException {
        Image image = Image.getInstance(ruta);
        if(alto > 300) {alto = 300;}
        float width = (image.getWidth() / image.getHeight()) * alto;

        image.scaleAbsoluteWidth(width);
        image.scaleAbsoluteHeight(alto);
        return image;
    }

    public static String checkSiNo(boolean is) {
        return is? "Si:(X) No:(  )" : "Si:(  ) No:(X)";
    }

    public static String checkValoracion(boolean is) {
        return is? "Inicial:(X)                                Seguimiento de caso:(  )" : "Inicial:(   )                                Seguimiento de caso:(X)";
    }

    public static String checkTecnicas(boolean entrevista, boolean observacion, boolean visita, boolean mixta) {
        String msg = "";

        if(entrevista) msg+= "Entrevista: (X)"; else msg += "Entrevista: (  )";
        msg += "      ";
        if(observacion) msg+= "Observacion: (X)"; else msg += "Observacion: (  )";
        msg += "      ";
        if(visita) msg+= "Visita Domiciliaria: (X)"; else msg += "Visita Domiciliaria: (  )";
        msg += "      ";
        if(mixta) msg+= "Mixta: (X)"; else msg += "Mixta: (  )";

        return msg;
    }

    public static String checkVivienda(int tipo) {
        switch (tipo) {
            case 0:{
                return "Propia: (X)      Renta: (  )      Prestada: (  )";
            }
            case 1:{
                return "Propia: (  )      Renta: (X)      Prestada: (  )";
            }
            case 2:{
                return "Propia: (  )      Renta: (  )      Prestada: (X)";
            }
            default: {
                return "";
            }
        }
    }

    public static String checkTipoVivienda(int tipo) {
        switch (tipo) {
            case 0:{
                return "Casa sola: (X)      Departamento: (  )      Vecindad: (  )      Improvisado: (  )      Otro: (  )";
            }
            case 1:{
                return "Casa sola: (  )      Departamento: (X)      Vecindad: (  )      Improvisado: (  )      Otro: (  )";
            }
            case 2:{
                return "Casa sola: (  )      Departamento: (  )      Vecindad: (X)      Improvisado: (  )      Otro: (  )";
            }
            case 3:{
                return "Casa sola: (  )      Departamento: (  )      Vecindad: (  )      Improvisado: (X)      Otro: (  )";
            }
            case 4:{
                return "Casa sola: (  )      Departamento: (  )      Vecindad: (  )      Improvisado: (  )      Otro: (X)";
            }
            default: {
                return "";
            }
        }
    }

    public static String checkZona(int tipo) {
        switch (tipo) {
            case 0:{
                return "Rural: (X)                  Urbana: (  )";
            }
            case 1:{
                return "Rural: (  )                  Urbana: (X)";
            }
            default: {
                return "";
            }
        }
    }

    public static String checkDistribucion(boolean sala, boolean comedor, boolean cocina, boolean bano) {
        String msg = "";

        if(sala) msg+= "Sala: (X)"; else msg += "Sala: (  )";
        msg += "      ";
        if(comedor) msg+= "Comedor: (X)"; else msg += "Comedor: (  )";
        msg += "      ";
        if(cocina) msg+= "Cocina: (X)"; else msg += "Cocina: (  )";
        msg += "      ";
        if(bano) msg+= "Baño: (X)"; else msg += "Baño: (  )";

        return msg;
    }

    public static String checkMaterialPisos(boolean tierra, boolean concreto, boolean piedra, boolean madera, String otro) {
        String msg = "PISO: ";

        if(tierra) msg+= "Tierra: (X)"; else msg += "Tierra: (  )";
        msg += "      ";
        if(concreto) msg+= "Concreto: (X)"; else msg += "Concreto: (  )";
        msg += "      ";
        if(piedra) msg+= "Mosaico: (X)"; else msg += "Mosaico: (  )";
        msg += "      ";
        if(madera) msg+= "Madera: (X)"; else msg += "Madera: (  )";
        msg += "      Otro: ";
        if(!otro.equals("")) msg+= otro;

        return msg;
    }

    public static String checkMaterialMuro(boolean adobe, boolean carton, boolean tabique, boolean madera, String otro) {
        String msg = "MUROS: ";

        if(adobe) msg+= "Adobe: (X)"; else msg += "Adobe: (  )";
        msg += "      ";
        if(carton) msg+= "Cartón: (X)"; else msg += "Cartón: (  )";
        msg += "      ";
        if(tabique) msg+= "Ladrillo: (X)"; else msg += "Ladrillo: (  )";
        msg += "      ";
        if(madera) msg+= "Madera: (X)"; else msg += "Madera: (  )";
        msg += "      Otro: ";
        if(!otro.equals("")) msg+= otro;

        return msg;
    }

    public static String checkMaterialTecho(boolean lamina, boolean carton, boolean concreto, boolean madera, String otro) {
        String msg = "TECHO: ";

        if(lamina) msg+= "Lamina: (X)"; else msg += "Lamina: (  )";
        msg += "      ";
        if(carton) msg+= "Cartón: (X)"; else msg += "Cartón: (  )";
        msg += "      ";
        if(concreto) msg+= "Concreto: (X)"; else msg += "Concreto: (  )";
        msg += "      ";
        if(madera) msg+= "Madera: (X)"; else msg += "Madera: (  )";
        msg += "      Otro: ";
        if(!otro.equals("")) msg+= otro;

        return msg;
    }

    public static String checkServiciosPublicos(boolean agua, boolean electricidad, boolean drenaje, boolean alumbrado, boolean pavimentacion, boolean limpieza) {
        String msg = "";

        if(agua) msg+= "Agua Potable: (X)"; else msg += "Agua Potable: (  )";
        msg += "      ";
        if(electricidad) msg+= "Electricidad: (X)"; else msg += "Electricidad: (  )";
        msg += "      ";
        if(drenaje) msg+= "Drenaje: (X)"; else msg += "Drenaje: (  )";
        msg += "\n\n";
        if(alumbrado) msg+= "Alumbrado Público: (X)"; else msg += "Alumbrado Público: (  )";
        msg += "      ";
        if(pavimentacion) msg+= "Pavimentación: (X)"; else msg += "Pavimentación: (  )";
        msg += "      ";
        if(limpieza) msg+= "Servicio de Limpieza: (X)"; else msg += "Servicio de Limpieza: (  )";

        return msg;
    }
}
