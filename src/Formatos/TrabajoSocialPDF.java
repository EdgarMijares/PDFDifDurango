package Formatos;

import Informacion.Familia;
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

public class TrabajoSocialPDF {
    TrabajoSocialData informacion;

    public class HeaderTable extends PdfPageEventHelper {
        protected PdfPTable table;
        protected float tableHeight;

        public HeaderTable() throws IOException, BadElementException {
            table = new PdfPTable(1);
            table.setTotalWidth(523);
            table.setLockedWidth(true);
            table.addCell(Default.celda(" "));
            table.addCell(Default.celda(" "));
            table.addCell(Default.borrarBordesTable(header()));
            Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            font.setColor(200,200,200);
            table.addCell(Default.celda("________________________________________________________________________", Element.ALIGN_CENTER, font));
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
        Image salud = Default.createImageHeight("http://contextodedurango.com.mx/noticias/wp-content/uploads/2017/09/DIF-2.png", 50);
        Image dif = Default.createImageHeight("https://contextodedurango.com.mx/noticias/wp-content/uploads/2017/09/gobierno-del-estado.png", 50);

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


        table.addCell(Default.celda("______________________________________________________________________________", Element.ALIGN_CENTER));
        linea_uno.addCell(Default.celda("TRABAJO SOCIAL " + informacion.getFecha(), Default.NORMAL_CHICA));
        linea_uno.addCell(Default.celda(informacion.getNo_expediente() + "   ", Element.ALIGN_RIGHT, Default.NORMAL_CHICA));

        table.addCell(Default.borrarBordesTable(linea_uno));

        return table;
    }

    private Paragraph firmaTrabajadorSocial() {
        Paragraph paragraph = new Paragraph();

        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda(" "));
        content.addCell(Default.celda(" "));
        content.addCell(Default.celda(" "));
        content.addCell(Default.celda("___________________________", Element.ALIGN_CENTER));
        content.addCell(Default.celda(informacion.getTrabajador_social(), Element.ALIGN_CENTER));

        paragraph.add(content);
        return paragraph;
    }

    private Paragraph paginaUno() throws DocumentException {
        Paragraph paragraph = new Paragraph();

        paragraph.setAlignment(Element.ALIGN_CENTER);

        paragraph.add(new Chunk("Anexo II\n\nFormato en materia de Trabajo Social\n", Default.TITULO));
        paragraph.add(paginaUnoSeccionUno());
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(informacionNino());
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

        linea_uno.addCell(Default.celda(Default.checkValoracion(informacion.isValaracion()), Element.ALIGN_CENTER));
        linea_dos.addCell(Default.celda(Default.checkTecnicas(
                informacion.getTecnicas()[0],
                informacion.getTecnicas()[1],
                informacion.getTecnicas()[2],
                informacion.getTecnicas()[3]), Element.ALIGN_CENTER));

        linea_tres.addCell(Default.celda("NOMBRE",      Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        linea_tres.addCell(Default.celda("PARENTESCO",  Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        linea_tres.addCell(Default.celda("EDAD",        Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        linea_tres.addCell(Default.celda("SEXO",        Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        linea_tres.addCell(Default.celda("ESTADO CIVIL",Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        linea_tres.addCell(Default.celda("ESCOLARIDAD", Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        linea_tres.addCell(Default.celda("OCUPACIÓN",   Element.ALIGN_CENTER, 10, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));

        for (Familia d : informacion.getFamilia()) {
            linea_tres.addCell(Default.celda(d.getNombre(), Default.NORMAL_CHICA, false));
            linea_tres.addCell(Default.celda(d.getParentesco(), Default.NORMAL_CHICA, false));
            linea_tres.addCell(Default.celda(d.getEdad(), Default.NORMAL_CHICA, false));
            linea_tres.addCell(Default.celda(d.getSexo(), Default.NORMAL_CHICA, false));
            linea_tres.addCell(Default.celda(d.getEstado_civil(), Default.NORMAL_CHICA, false));
            linea_tres.addCell(Default.celda(d.getEscolaridad(), Default.NORMAL_CHICA, false));
            linea_tres.addCell(Default.celda(d.getOcupacion(), Default.NORMAL_CHICA, false));
        }

        content.addCell(Default.celda("                II. VALORACÓN\n\n", Default.TITULO));
        content.addCell(Default.borrarBordesTable(linea_uno));

        content.addCell(Default.celda("\n                III. TÉCNICAS UTILIZADAS\n\n", Default.TITULO));
        content.addCell(Default.borrarBordesTable(linea_dos));

        content.addCell(Default.celda("\n                IV. ESTRUCTURA FAMILIAR\n\n", Default.TITULO));

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

        content.addCell(Default.celda("\n\n            V. DINÁMICA FAMILIAR\n\n", Default.TITULO));
        content.addCell(Default.celda(informacion.getDinamica_familiar()));

        content.addCell(Default.celda("\n\n            VI. FAMILIOGRAMA\n\n", Default.TITULO));
        if(!informacion.getFamiliograma().equals(""))
            content.addCell(Default.celda(Default.createImageWidth(informacion.getFamiliograma(), 300)));

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

        content.addCell(Default.celda("\n\n            VII. SITUACION ECONOMICA", Default.TITULO));
        titulo.addCell(Default.celda("\n               VII.I. INGRESO (MENSUAL)\n\n", Default.TITULO));

        situacion_ingresos.addCell(Default.celda("Padre:",      Element.ALIGN_RIGHT, Default.TITULO));
        situacion_ingresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getIngresos_padre()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        situacion_ingresos.addCell(Default.celda("Madre:",      Element.ALIGN_RIGHT, Default.TITULO));
        situacion_ingresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getIngresos_madre()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        situacion_ingresos.addCell(Default.celda("Hermano(a):", Element.ALIGN_RIGHT, Default.TITULO));
        situacion_ingresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getIngresos_hermano()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        situacion_ingresos.addCell(Default.celda("Otros:",      Element.ALIGN_RIGHT, Default.TITULO));
        situacion_ingresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getIngresos_otros()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        situacion_ingresos.addCell(Default.celda("TOTAL:",      Element.ALIGN_RIGHT, Default.TITULO));
        situacion_ingresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getIngresos_total()), Element.ALIGN_LEFT, Default.SUBRAYADO));

        PdfPTable situacion_egresos = new PdfPTable(2);

        titulo.addCell(Default.celda("\n            VII.II. EGRESO (MENSUAL):\n\n", Default.TITULO));
        situacion_egresos.addCell(Default.celda("Alimentación:", Element.ALIGN_RIGHT, Default.TITULO));
        situacion_egresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getEgresos_alimentacion()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        situacion_egresos.addCell(Default.celda("Educación:",   Element.ALIGN_RIGHT, Default.TITULO));
        situacion_egresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getEgresos_educacion()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        situacion_egresos.addCell(Default.celda("Salud:",       Element.ALIGN_RIGHT, Default.TITULO));
        situacion_egresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getEgresos_salud()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        situacion_egresos.addCell(Default.celda("Vestido:",     Element.ALIGN_RIGHT, Default.TITULO));
        situacion_egresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getEgresos_vestido()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        situacion_egresos.addCell(Default.celda("Servicios:",   Element.ALIGN_RIGHT, Default.TITULO));
        situacion_egresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getEgresos_servicios()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        situacion_egresos.addCell(Default.celda("Transporte:",  Element.ALIGN_RIGHT, Default.TITULO));
        situacion_egresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getEgresos_transporte()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        situacion_egresos.addCell(Default.celda("Renta:",       Element.ALIGN_RIGHT, Default.TITULO));
        situacion_egresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getEgresos_renta()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        situacion_egresos.addCell(Default.celda("Otros:",       Element.ALIGN_RIGHT, Default.TITULO));
        situacion_egresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getEgresos_otros()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        situacion_egresos.addCell(Default.celda("TOTAL:",       Element.ALIGN_RIGHT, Default.TITULO));
        situacion_egresos.addCell(Default.celda("$" + formatoMoneda.format(informacion.getEgresos_total()), Element.ALIGN_LEFT, Default.SUBRAYADO));

        titulo.addCell(Default.celda("\n            VII.II. EGRESO (MENSUAL):\n\n", Default.TITULO));

        linea_uno.addCell(Default.borrarBordesTable(situacion_ingresos));
        linea_uno.addCell(Default.borrarBordesTable(situacion_egresos));

        PdfPTable totales = new PdfPTable(2);
        totales.addCell(Default.celda(" "));
        totales.addCell(Default.celda(" "));
        totales.addCell(Default.celda("SUPERÁVIT:", Element.ALIGN_RIGHT, Default.TITULO));
        totales.addCell(Default.celda("$" + formatoMoneda.format(informacion.getSuperavit()), Element.ALIGN_LEFT, Default.SUBRAYADO));
        totales.addCell(Default.celda("DÉFICIT:",   Element.ALIGN_RIGHT, Default.TITULO));
        totales.addCell(Default.celda("$" + formatoMoneda.format(informacion.getDeficit()), Element.ALIGN_LEFT, Default.SUBRAYADO));

        PdfPTable distribucion = new PdfPTable(6);
        distribucion.addCell(Default.celda(" "));
        distribucion.addCell(Default.celda(" "));
        distribucion.addCell(Default.celda(" "));
        distribucion.addCell(Default.celda(" "));
        distribucion.addCell(Default.celda(" "));
        distribucion.addCell(Default.celda(" "));
        distribucion.addCell(Default.celda("Habitaciones:", Element.ALIGN_RIGHT));
        distribucion.addCell(Default.celda(informacion.getHabitaciones()[0], Default.SUBRAYADO));
        distribucion.addCell(Default.celda("Recamaras:", Element.ALIGN_RIGHT));
        distribucion.addCell(Default.celda(informacion.getHabitaciones()[1], Default.SUBRAYADO));
        distribucion.addCell(Default.celda("Hacinamiento:", Element.ALIGN_RIGHT));
        distribucion.addCell(Default.celda(informacion.getHabitaciones()[2], Default.SUBRAYADO));

        distribucion.setTotalWidth(new float[] {20, 10, 20, 10, 20, 10});

        content.addCell(Default.borrarBordesTable(titulo));
        content.addCell(Default.borrarBordesTable(linea_uno));
        content.addCell(Default.borrarBordesTable(totales));

        content.addCell(Default.celda("\n            VII.III. VIVIENDA:\n\n", Default.TITULO));
        content.addCell(Default.celda(Default.checkVivienda(informacion.getVivienda()), Element.ALIGN_CENTER));

        content.addCell(Default.celda("\n            VII.IV. TIPO DE VIVIENDA:\n\n", Default.TITULO));
        content.addCell(Default.celda(Default.checkTipoVivienda(informacion.getTipo_vivienda()), Element.ALIGN_CENTER));

        content.addCell(Default.celda("\n            VII.V. ZONA:\n\n", Default.TITULO));
        content.addCell(Default.celda(Default.checkZona(informacion.getZona_vivienda()), Element.ALIGN_CENTER));

        content.addCell(Default.celda("\n            VII.VI. DISTRIBUCIÒN:\n\n", Default.TITULO));
        content.addCell(Default.celda(Default.checkDistribucion(
                informacion.getDistribucion()[0],
                informacion.getDistribucion()[1],
                informacion.getDistribucion()[2],
                informacion.getDistribucion()[3]), Element.ALIGN_CENTER));
        content.addCell(Default.borrarBordesTable(distribucion));

        content.addCell(Default.celda("\n            VII.VIII. MATERIAL DE LA VIVIENDA:\n\n", Default.TITULO));
        content.addCell(Default.celda(Default.checkMaterialPisos(
                informacion.getMaterial_piso()[0],
                informacion.getMaterial_piso()[1],
                informacion.getMaterial_piso()[2],
                informacion.getMaterial_piso()[3],
                informacion.getMaterial_piso_otro()), Element.ALIGN_CENTER));

        content.addCell(Default.celda(Default.checkMaterialMuro(
                informacion.getMaterial_muros()[0],
                informacion.getMaterial_muros()[1],
                informacion.getMaterial_muros()[2],
                informacion.getMaterial_muros()[3],
                informacion.getMaterial_muros_otro()), Element.ALIGN_CENTER));

        content.addCell(Default.celda(Default.checkMaterialTecho(
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

        content.addCell(Default.celda("\n            VII.VIII. SERVICIOS PÚBLICOS:\n\n", Default.TITULO));
        content.addCell(Default.celda(Default.checkServiciosPublicos(
                informacion.getServicios_publicos()[0],
                informacion.getServicios_publicos()[1],
                informacion.getServicios_publicos()[2],
                informacion.getServicios_publicos()[3],
                informacion.getServicios_publicos()[4],
                informacion.getServicios_publicos()[5]
        ), Element.ALIGN_CENTER));

        content.addCell(Default.celda("\n\n            VIII. ANTECEDENTES Y DESCRIPCIÓN DE LA PROBLEMÁTICA:\n\n", Default.TITULO));
        content.addCell(Default.celda(informacion.getDescripcion_problematica()));

        content.addCell(Default.celda("\n\n            IX. ENTREVISTA CON NIÑA, NIÑO O ADOLESCENTE:\n\n", Default.TITULO));
        content.addCell(Default.celda(informacion.getEntrevista_nino()));

        content.setWidthPercentage(100);
        paragraph.add(content);

        return paragraph;
    }

    private Paragraph paginaSeis() {
        Paragraph paragraph = new Paragraph();

        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("\n\n            X. DIAGNÓSTICO SOCIAL:\n\n", Default.TITULO));
        content.addCell(Default.celda(informacion.getDiagnostico_social()));

        content.addCell(Default.celda("\n\n            XI. PLAN DE ACCIÓN:\n\n", Default.TITULO));
        content.addCell(Default.celda(informacion.getPlan_de_accion()));

        content.addCell(Default.celda("\n\n            XII. OBSERVACIONES:\n\n", Default.TITULO));
        content.addCell(Default.celda(informacion.getObservaciones()));

        content.setWidthPercentage(100);
        paragraph.add(content);

        return paragraph;
    }

    private PdfPTable paginaUnoSeccionUno() throws DocumentException {
        PdfPTable table = new PdfPTable(2);

        Paragraph p = new Paragraph(new Chunk("I. DATOS GENERALES\n\n    I.I. NIÑA, NIÑO O ADOLESENTE", Default.TITULO));
        PdfPCell tituloDatosGenerales = new PdfPCell(p);
        tituloDatosGenerales.setVerticalAlignment(Element.ALIGN_BOTTOM);

        PdfPCell infoGeneral = new PdfPCell();
        PdfPTable tablaInfoGeneral = new PdfPTable(2);
        tablaInfoGeneral.setHorizontalAlignment(Element.ALIGN_RIGHT);
        tablaInfoGeneral.addCell(Default.celda("#: ", Element.ALIGN_RIGHT, Default.TITULO));
        tablaInfoGeneral.addCell(Default.celda(informacion.getFolio()));

        tablaInfoGeneral.addCell(Default.celda("N° de Expediente: ", Element.ALIGN_RIGHT, Default.TITULO));
        tablaInfoGeneral.addCell(Default.celda(informacion.getNo_expediente()));

        tablaInfoGeneral.addCell(Default.celda("Fecha: ", Element.ALIGN_RIGHT, Default.TITULO));
        tablaInfoGeneral.addCell(Default.celda(informacion.getFecha()));

        tablaInfoGeneral.addCell(Default.celda("Hora: ", Element.ALIGN_RIGHT, Default.TITULO));
        tablaInfoGeneral.addCell(Default.celda(informacion.getHora()));

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

    private PdfPTable informacionNino() throws DocumentException {
        PdfPTable table = new PdfPTable(1);

        PdfPTable linea_uno = new PdfPTable(4);
        PdfPTable linea_dos = new PdfPTable(4);
        PdfPTable linea_tres = new PdfPTable(6);
        PdfPTable linea_cuatro = new PdfPTable(4);
        PdfPTable linea_cinco = new PdfPTable(4);
        PdfPTable linea_seis = new PdfPTable(4);

        // LINEA UNO
        linea_uno.addCell(Default.celda("Nombre:", Default.TITULO));
        linea_uno.addCell(Default.celda(informacion.getNombre(), Default.SUBRAYADO));

        linea_uno.addCell(Default.celda("Edad:", Default.TITULO));
        linea_uno.addCell(Default.celda(informacion.getEdad(), Default.SUBRAYADO));

        // LINEA DOS
        linea_dos.addCell(Default.celda("Fecha de Nacimiento:", Default.TITULO));
        linea_dos.addCell(Default.celda(informacion.getFecha_nacimiento(), Default.SUBRAYADO));

        linea_dos.addCell(Default.celda("Lugar de Nacimiento:", Default.TITULO));
        linea_dos.addCell(Default.celda(informacion.getLugar_nacimiento(), Default.SUBRAYADO));

        // LINEA TRES
        linea_tres.addCell(Default.celda("Nacionalidad:", Default.TITULO));
        linea_tres.addCell(Default.celda(informacion.getNacionalidad(), Default.SUBRAYADO));

        linea_tres.addCell(Default.celda("Género:", Default.TITULO));
        linea_tres.addCell(Default.celda(informacion.getSexo(), Default.SUBRAYADO));

        linea_tres.addCell(Default.celda("Idioma:", Default.TITULO));
        linea_tres.addCell(Default.celda(informacion.getIdioma(), Default.SUBRAYADO));

        // LINEA CUATRO
        linea_cuatro.addCell(Default.celda("Grupo Étnico:", Default.TITULO));
        linea_cuatro.addCell(Default.celda(informacion.getEtnia(), Default.SUBRAYADO));

        linea_cuatro.addCell(Default.celda("Religión:", Default.TITULO));
        linea_cuatro.addCell(Default.celda(informacion.getReligion(), Default.SUBRAYADO));

        // LINEA CINCO
        linea_cinco.addCell(Default.celda("Discapacidad:", Default.TITULO));
        linea_cinco.addCell(Default.celda(Default.checkSiNo(informacion.isDiscapacidad()), Default.NORMAL));

        linea_cinco.addCell(Default.celda("¿Cuál?", Default.TITULO));
        linea_cinco.addCell(Default.celda(informacion.getTipo_discapacidad(), Default.NORMAL));

        // LINEA SEIS
        linea_seis.addCell(Default.celda("Escolaridad:", Default.TITULO));
        linea_seis.addCell(Default.celda(informacion.getEscolaridad(), Default.SUBRAYADO));

        linea_seis.addCell(Default.celda("Domicilio:", Default.TITULO));
        linea_seis.addCell(Default.celda(informacion.getDomicilio()));

        linea_uno.setTotalWidth(new float[]     {15, 65, 10, 10});
        linea_dos.setTotalWidth(new float[]     {28, 15, 27, 30});
        linea_tres.setTotalWidth(new float[]    {20, 20, 15, 15, 15, 15});
        linea_cuatro.setTotalWidth(new float[]  {25, 25, 25, 25});
        linea_cinco.setTotalWidth(new float[]   {20, 15, 10, 55});
        linea_seis.setTotalWidth(new float[]    {16, 29, 15, 40});

        table.setWidthPercentage(90);

        table.addCell(Default.borrarBordesTable(linea_uno));
        table.addCell(Default.celda(" "));
        table.addCell(Default.borrarBordesTable(linea_dos));
        table.addCell(Default.celda(" "));
        table.addCell(Default.borrarBordesTable(linea_tres));
        table.addCell(Default.celda(" "));
        table.addCell(Default.borrarBordesTable(linea_cuatro));
        table.addCell(Default.celda(" "));
        table.addCell(Default.borrarBordesTable(linea_cinco));
        table.addCell(Default.celda(" "));
        table.addCell(Default.borrarBordesTable(linea_seis));

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
        titulo.addCell(Default.celda("    I.II. MADRE, PADRE O TUTOR:", Default.TITULO));

        // LINEA UNO
        linea_uno.addCell(Default.celda("Nombre:", Default.TITULO));
        linea_uno.addCell(Default.celda(informacion.getNombre_tutor(), Default.SUBRAYADO));

        linea_uno.addCell(Default.celda("Edad:", Default.TITULO));
        linea_uno.addCell(Default.celda(informacion.getEdad_tutor(), Default.SUBRAYADO));

        // LINEA DOS
        linea_dos.addCell(Default.celda("Parentesco:", Default.TITULO));
        linea_dos.addCell(Default.celda(informacion.getParentesco(), Default.SUBRAYADO));

        linea_dos.addCell(Default.celda("Estado Civil:", Default.TITULO));
        linea_dos.addCell(Default.celda(informacion.getEstado_civil(), Default.SUBRAYADO));

        linea_dos.addCell(Default.celda("Teléfono:", Default.TITULO));
        linea_dos.addCell(Default.celda(informacion.getTelefono(), Default.SUBRAYADO));

        // LINEA TRES
        linea_tres.addCell(Default.celda("Idioma:", Default.TITULO));
        linea_tres.addCell(Default.celda(informacion.getIdioma_tutor(), Default.SUBRAYADO));

        linea_tres.addCell(Default.celda("Grupo Étnico:", Default.TITULO));
        linea_tres.addCell(Default.celda(informacion.getEtnia_tutor(), Default.SUBRAYADO));

        linea_tres.addCell(Default.celda("Religión:", Default.TITULO));
        linea_tres.addCell(Default.celda(informacion.getReligion_tutor(), Default.SUBRAYADO));

        // LINEA CUATRO
        linea_cuatro.addCell(Default.celda("Discapacidad:", Default.TITULO));
        linea_cuatro.addCell(Default.celda(Default.checkSiNo(informacion.isDiscapacidad_tutor()), Default.NORMAL));

        linea_cuatro.addCell(Default.celda("¿Cuál?", Default.TITULO));
        linea_cuatro.addCell(Default.celda(informacion.getTipo_discapacidad_tutor(), Default.NORMAL));

        // LINEA CINCO
        linea_cinco.addCell(Default.celda("Escolaridad:", Default.TITULO));
        linea_cinco.addCell(Default.celda(informacion.getEscolaridad_tutor(), Default.SUBRAYADO));

        linea_cinco.addCell(Default.celda("Domicilio:", Default.TITULO));
        linea_cinco.addCell(Default.celda(informacion.getDomicilio_tutor()));

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

        table.addCell(Default.borrarBordesTable(titulo));
        table.addCell(Default.celda(" "));
        table.addCell(Default.borrarBordesTable(linea_uno));
        table.addCell(Default.celda(" "));
        table.addCell(Default.borrarBordesTable(linea_dos));
        table.addCell(Default.celda(" "));
        table.addCell(Default.borrarBordesTable(linea_tres));
        table.addCell(Default.celda(" "));
        table.addCell(Default.borrarBordesTable(linea_cuatro));
        table.addCell(Default.celda(" "));
        table.addCell(Default.borrarBordesTable(linea_cinco));
        table.addCell(Default.celda(" "));
        table.addCell(Default.borrarBordesTable(linea_seis));

        return table;
    }
}

class Default {

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
