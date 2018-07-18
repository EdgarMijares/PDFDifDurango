package Formatos;

import Design.Default;
import Informacion.InformeClinicoData;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AnexoUnoPDF {
    public AnexoUnoPDF(String nombre_reporte, String url_reporte) throws IOException, DocumentException {
        Default.HeaderTable header = new Default.HeaderTable(getHeader(), "DIF/PPNNA-040-019/2018");

        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), 30);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        document.open();
        document.add(getDatosExpendientes());
        document.add(getDatosGenerales());
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

        content.addCell(Default.celda());
        content.addCell(Default.celda("ANEXO I", Default.TITULO, Element.ALIGN_CENTER));
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

    private PdfPTable getDatosGenerales() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("1. DATOS GENERALES", Default.TITULO));
        content.addCell(Default.celda("1.1 INFORMACIÓN DEL PACIENTE", Default.TITULO));
        content.addCell(Default.celda());
        content.addCell(Default.celda("NOMBRE: ", new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL)));
        content.addCell(Default.celda("FECHA DE NACIMIENTO: ", new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL)));
        content.addCell(Default.celda("LUGAR DE NACIMIENTO: ", new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL)));
        content.addCell(Default.celda("NACIONALIDAD: ", new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL)));
        content.addCell(Default.celda("GÉNERO", new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL)));
        content.addCell(Default.celda("ESCOLARIDAD: ", new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL)));
        content.addCell(Default.celda("RELIGIÓN: ", new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL)));
        content.addCell(Default.celda("ESTADO CIVIL: ", new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL)));
        content.addCell(Default.celda());
        content.addCell(Default.celda());

        content.setWidthPercentage(80);

        return content;
    }
}
