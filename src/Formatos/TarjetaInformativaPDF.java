package Formatos;

import Design.Default;
import Informacion.TarjetaInformativaData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TarjetaInformativaPDF {

    TarjetaInformativaData data;

    public TarjetaInformativaPDF(String nombre_reporte, String url_reporte, int centro_asistencia, TarjetaInformativaData data) throws DocumentException, IOException {
        this.data = data;

        Default.HeaderTable header = new Default.HeaderTable(getHeader(centro_asistencia), " ");

        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), getFooter().getTotalHeight() + 10);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        pdfWriter.setPageEvent(new Default.FooterTable(getFooter()));
        document.open();
        document.add(textoCarta());
        document.close();
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
    }

    private PdfPTable textoCarta() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("\nTARJETA INFORMATIVA\n", Default.TITULO,Element.ALIGN_CENTER));
        content.addCell(Default.celda());
        content.addCell(Default.celda(data.getTrabajador_receptor().getNombre(), Default.TITULO ));
        content.addCell(Default.celda(data.getTrabajador_receptor().getCargo(), Default.TITULO ));
        content.addCell(Default.celda("PRESENTE", Default.TITULO ));
        content.addCell(Default.celda());
        content.addCell(Default.celda(data.getTexto(), Element.ALIGN_JUSTIFIED));

        content.addCell(Default.celda());
        content.addCell(Default.celda());

        PdfPTable firma = new PdfPTable(1);

        firma.addCell(Default.celda("ATENTAMENTE", Default.TITULO, Element.ALIGN_CENTER));
        firma.addCell(Default.celda("Durango, Dgo., a " + Default.fechaTexto(), Element.ALIGN_CENTER));
        firma.addCell(Default.firmaTrabajador(data.getTrabajador_remitente().getNombre(), data.getTrabajador_remitente().getCargo()));

        content.addCell(Default.celda(firma));
        return content;
    }

    private PdfPTable getHeader(int centro) throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(1);

        String ruta_img = "";
        switch (centro) {
            case 0: ruta_img = TarjetaInformativaPDF.class.getClassLoader().getResource("images/CASA_HOGAR.png").toString(); break;
            case 1: ruta_img = TarjetaInformativaPDF.class.getClassLoader().getResource("images/MI_CASA.png").toString(); break;
            case 2: ruta_img = TarjetaInformativaPDF.class.getClassLoader().getResource("images/REFUGIO_ESPERANZA.png").toString(); break;
        }
        content.addCell(Default.celda());
        content.addCell(Default.celda(Default.createImageWidth(ruta_img, 250)));

        return content;
    }

    private PdfPTable getFooter() throws IOException, DocumentException {
        PdfPTable content = new PdfPTable(1);
        content.setTotalWidth(550);
        PdfPCell pdfPCell = Default.celda(
                "\n" + data.getDireccion().getDireccion_uno() + "\n" + data.getDireccion().getGetDireccion_dos() + " \n ", Default.NORMAL_CHICA, Element.ALIGN_RIGHT, new int[] {255,255,255}, 10);
        pdfPCell.setBackgroundColor(new BaseColor(0x009FBF));

        PdfPTable redes = new PdfPTable(3);

        redes.addCell(Default.celda("WWW.DURANGO.GOB.MX", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.COURIER, 12, com.itextpdf.text.Font.NORMAL), Element.ALIGN_RIGHT));
        redes.addCell(Default.celda(Default.createImageWidth(TarjetaInformativaPDF.class.getClassLoader().getResource("images/facebook.png").toString(), 15), "| DIF Municipal Durango"));
        redes.addCell(Default.celda(Default.createImageWidth(TarjetaInformativaPDF.class.getClassLoader().getResource("images/twitter.png").toString(), 15), "| @DIF_Durango"));

        redes.setWidthPercentage(100);

        content.addCell(Default.celda(pdfPCell));
        content.addCell(Default.celda(redes, Element.ALIGN_RIGHT));

        return content;
    }
}
