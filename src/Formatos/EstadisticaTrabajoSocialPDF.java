package Formatos;

import Design.Default;
import Informacion.TrabajoSocialData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static Design.Default.*;

public class EstadisticaTrabajoSocialPDF {

    public EstadisticaTrabajoSocialPDF (String nombre_reporte, String url_reporte, TrabajoSocialData data) throws IOException, DocumentException {
//        this.data = data;
        Default.HeaderTable header = new Default.HeaderTable(getHeader(), true);

        Document document = new Document(PageSize.A4.rotate(), 30, 30, header.getTableHeight(), 30);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        document.open();
        document.add(getTablaUno());
        document.add(getTablaDos());
        document.add(getTablaTres());
        document.close();

        pdfWriter.setPageEvent(new Default.FooterTableCount());
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
    }

    private PdfPTable getHeader() throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(2);

        content.addCell(Default.celda());
        content.addCell(Default.celda());

        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/DIF_ESTATAL.png").toString(), 60, Element.ALIGN_LEFT)));
        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/evnnya_lateral.png").toString(), 60, Element.ALIGN_RIGHT)));

        content.setWidthPercentage(100);
        return content;
    }

    private PdfPTable getTablaUno() throws DocumentException {
        String[] titulo = new String[] {"SOLICITANTES", "DIRECTAS", "COLATERALES", "TOTAL", "1ERA VEZ", "SUB", "SEGUIM"};
        String[] pammna = new String[] {"PAMNNA", "9", "8","7","6","5","4"};
        String[] del_mpales = new String[] {"DEL. MPALES", "9", "8","7","6","5","4"};
        ArrayList<String[]> datos = new ArrayList<>();
        datos.add(pammna);
        datos.add(del_mpales);
        PdfPTable table = new PdfPTable(titulo.length);

        for (String t : titulo) {
            table.addCell(rellenoColor(t, HEXA_AZUL, TITULO_CHICA_BLANCO, Element.ALIGN_CENTER));
        }
        for (String[] t : datos){
            table.addCell(celdaBorderButtomAzul(t[0], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[1], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[2], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[3], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[4], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[5], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[6], NORMAL_CHICA, Element.ALIGN_CENTER));
        }
        table.setWidthPercentage(100);
        PdfPTable content = new PdfPTable(1);
        content.addCell(Default.celda());
        content.addCell(celda(table));
        content.addCell(Default.celda());
        content.setWidthPercentage(100);
        return content;
    }

    private PdfPTable getTablaDos() throws DocumentException {
        String[] titulo = new String[] {"VALORACIÓN", "COMPROBADO", "NO COMPROBADO", "FALSO", "FAVORABLE", "NO FAVORABLE", "NO SE LOCALIZA", "ASEGURAMIENTO", "CITATORIO", "OTROS"};
        String[] PRIMERAVEZ = new String[] {"1ERA VEZ", "9", "8","7","6","5","4", "9", "9", "2"};
        String[] SUBSECUENTE = new String[] {"SUBSECUENTE", "9", "8","7","6","5","4", "9", "9", "2"};
        String[] SEGUIMIENTO = new String[] {"SEGUIMIENTO", "9", "8","7","6","5","4", "9", "9", "2"};
        ArrayList<String[]> datos = new ArrayList<>();
        datos.add(PRIMERAVEZ);
        datos.add(SUBSECUENTE);
        datos.add(SEGUIMIENTO);
        PdfPTable table = new PdfPTable(titulo.length);

        for (String t : titulo) {
            table.addCell(rellenoColorDoble(t, HEXA_AZUL, TITULO_CHICA_BLANCO, Element.ALIGN_CENTER));
        }
        for (String[] t : datos){
            table.addCell(celdaBorderButtomAzul(t[0], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[1], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[2], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[3], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[4], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[5], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[6], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[7], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[8], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[9], NORMAL_CHICA, Element.ALIGN_CENTER));
        }
        table.setTotalWidth(new float[] {10,10,10,8,10,10,10,12,10,10});
        table.setWidthPercentage(100);
        PdfPTable content = new PdfPTable(1);
        content.addCell(celda(table));
        content.addCell(Default.celda());
        content.setWidthPercentage(100);
        return content;
    }

    private PdfPTable getTablaTres() throws DocumentException {
        String[] titulo = new String[] {"VALORACIÓN", "OC", "FISICO", "PSIC EM", "EB SEX", "G Y C", "AM FAB", "RIES", "REINT", "OTRO"};
        String[] PRIMERAVEZ = new String[] {"1ERA VEZ", "9", "8","7","6","5","4", "9", "9", "2"};
        String[] SUBSECUENTE = new String[] {"SUBSECUENTE", "9", "8","7","6","5","4", "9", "9", "2"};
        String[] SEGUIMIENTO = new String[] {"SEGUIMIENTO", "9", "8","7","6","5","4", "9", "9", "2"};
        ArrayList<String[]> datos = new ArrayList<>();
        datos.add(PRIMERAVEZ);
        datos.add(SUBSECUENTE);
        datos.add(SEGUIMIENTO);
        PdfPTable table = new PdfPTable(titulo.length);

        for (String t : titulo) {
            table.addCell(rellenoColorDoble(t, HEXA_AZUL, TITULO_CHICA_BLANCO, Element.ALIGN_CENTER));
        }
        for (String[] t : datos){
            table.addCell(celdaBorderButtomAzul(t[0], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[1], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[2], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[3], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[4], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[5], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[6], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[7], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[8], NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(celdaBorderButtomAzul(t[9], NORMAL_CHICA, Element.ALIGN_CENTER));
        }
        table.setWidthPercentage(100);
        PdfPTable content = new PdfPTable(1);
        content.addCell(celda(table));
        content.addCell(Default.celda());
        content.setWidthPercentage(100);
        return content;
    }
}
