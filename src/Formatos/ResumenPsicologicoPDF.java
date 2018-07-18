package Formatos;

import Design.Default;
import Informacion.ResumenPsicologicoData;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResumenPsicologicoPDF {
    ResumenPsicologicoData data;

    public ResumenPsicologicoPDF(String nombre_reporte, String url_reporte, int centro_asistencia, ResumenPsicologicoData data) throws DocumentException, IOException {
        this.data = data;
        Default.HeaderTable header = new Default.HeaderTable(getHeader(centro_asistencia), data.getNo_registro());

        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), getFooter().getTotalHeight() + 10);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        pdfWriter.setPageEvent(new Default.FooterTable(getFooter()));
        document.open();
        document.add(getInfoNino());
        document.close();
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
    }

    private PdfPTable getHeader(int centro) throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(1);

        String ruta_img = "";
        switch (centro) {
            case 0: ruta_img = ResumenPsicologicoPDF.class.getClassLoader().getResource("Image/CASA_HOGAR.png").toString(); break;
            case 1: ruta_img = ResumenPsicologicoPDF.class.getClassLoader().getResource("Image/MI_CASA.png").toString(); break;
            case 2: ruta_img = ResumenPsicologicoPDF.class.getClassLoader().getResource("Image/REFUGIO_ESPERANZA.png").toString(); break;
        }
        content.addCell(Default.celda());
        content.addCell(Default.celda(Default.createImageWidth(ruta_img, 250)));

        return content;
    }

    private PdfPTable getFooter() throws IOException, DocumentException {
        PdfPTable content = new PdfPTable(1);
        content.setTotalWidth(550);
        PdfPCell pdfPCell = Default.celda(
                "\n" + data.getDireccion().getDireccion_uno()+"\n" + data.getDireccion().getGetDireccion_dos() + " \n ", Default.NORMAL_CHICA, Element.ALIGN_RIGHT, new int[] {255,255,255}, 10);
        pdfPCell.setBackgroundColor(new BaseColor(0x009FBF));

        PdfPTable redes = new PdfPTable(3);

        redes.addCell(Default.celda("WWW.DURANGO.GOB.MX", new Font(Font.FontFamily.COURIER, 12, Font.NORMAL), Element.ALIGN_RIGHT));
        redes.addCell(Default.celda(Default.createImageWidth(ResumenPsicologicoPDF.class.getClassLoader().getResource("Image/facebook.png").toString(), 15), "| DIF Municipal Durango"));
        redes.addCell(Default.celda(Default.createImageWidth(ResumenPsicologicoPDF.class.getClassLoader().getResource("Image/twitter.png").toString(), 15), "| @DIF_Durango"));

        redes.setWidthPercentage(100);

        content.addCell(Default.celda(pdfPCell));
        content.addCell(Default.celda(redes, Element.ALIGN_RIGHT));

        return content;
    }

    private PdfPTable getInfoNino() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("\nDEPARTAMENTO DE PSICOLOGIA\n\nRESUMEN PSICOLOGICO\n\n", Default.TITULO, Element.ALIGN_CENTER));

        content.addCell(Default.celda("Nombre: " + data.getNombre_victima(), Default.TITULO, Element.ALIGN_LEFT));
        content.addCell(Default.celda("Sexo: " + data.getSexo(), Default.TITULO, Element.ALIGN_LEFT));
        content.addCell(Default.celda("Edad: " + data.getEdad(), Default.TITULO, Element.ALIGN_LEFT));
        content.addCell(Default.celda("Fecha de ingreso: " + data.getFecha_ingreso(), Default.TITULO, Element.ALIGN_LEFT));
        content.addCell(Default.celda("Motivo de ingreso:" + data.getMotivo_ingreso() + "\n\n", Default.TITULO, Element.ALIGN_LEFT));
        content.addCell(Default.celda(data.getDescripcion(), Element.ALIGN_JUSTIFIED));

        content.addCell(Default.firmaTrabajador(data.getTrabajador().getNombre(), data.getTrabajador().getCargo(), data.getTrabajador().getCedula()));

        return content;
    }
}
