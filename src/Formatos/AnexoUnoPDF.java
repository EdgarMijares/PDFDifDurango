package Formatos;

import Design.Default;
import Informacion.InformeClinicoData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AnexoUnoPDF {
    public AnexoUnoPDF(String nombre_reporte, String url_reporte) throws IOException, DocumentException {
        Default.HeaderTable header = new Default.HeaderTable(getHeader(), "123");

        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), 30);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        document.open();
        document.add(new Paragraph("s"));
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

//    private PdfPTable getFooter() throws IOException, DocumentException {
//        PdfPTable content = new PdfPTable(1);
//        content.setTotalWidth(550);
//
//        PdfPTable redes = new PdfPTable(3);
//
//        redes.addCell(Default.celda("WWW.DURANGO.GOB.MX", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.COURIER, 12, com.itextpdf.text.Font.NORMAL), Element.ALIGN_RIGHT));
//        redes.addCell(Default.celda(Default.createImageWidth(InformeClinicoPDF.class.getClassLoader().getResource("Image/facebook.png").toString(), 15), "| DIF Municipal Durango"));
//        redes.addCell(Default.celda(Default.createImageWidth(InformeClinicoPDF.class.getClassLoader().getResource("Image/twitter.png").toString(), 15), "| @DIF_Durango"));
//
//        redes.setWidthPercentage(100);
//
//        content.addCell(Default.rellenoColor("\nAv del Hierro esquina con Av. Estaño s/n Fracc. Fidel Velasquez II\n\nDurango Dgo Tel: 814-69-31 y 814-25-23\n ", 0x009FBF));
//        content.addCell(Default.celda(redes, Element.ALIGN_RIGHT));
//
//        return content;
//    }
}
