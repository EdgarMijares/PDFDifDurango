package Formatos;

import Design.Default;
import Informacion.EstadisticasData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EstadisticasPDF {
    EstadisticasData data;
    public EstadisticasPDF (String nombre_reporte, String url_reporte, EstadisticasData data) throws IOException, DocumentException {
        this.data = data;
        Default.HeaderTable header = new Default.HeaderTable(getHeader(), "Estadisticas perdiodo:" + this.data.getPeriodo());

        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), 30);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        document.open();
        document.add(getContet());
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
        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/evnnya_lateral.png").toString(), 60, Element.ALIGN_RIGHT)));

        content.setWidthPercentage(95);
        return content;
    }

    private PdfPTable getContet() throws NullPointerException {
        PdfPTable content = new PdfPTable(1);
        System.out.println(data.getDatos().size());
        System.out.println(data.getDatos().get(0).getTitulo());
        System.out.println(data.getDatos().get(1).getTitulo());
        content.addCell(Default.celda());
        content.addCell(Default.createTableEstaditicas(data.getDatos()));

        return content;
    }

    private PdfPTable getFirma() {
        PdfPTable content = new PdfPTable(1);
        content.addCell(Default.firmaTrabajador(data.getTrabajador(), ""));
        return content;
    }
}
