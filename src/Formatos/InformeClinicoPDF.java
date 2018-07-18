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
import java.util.ArrayList;

public class InformeClinicoPDF {

    ArrayList<String> lista = new ArrayList<String>();
    InformeClinicoData data;
    String nombre_casa = "";

    public InformeClinicoPDF(String nombre_reporte, String url_reporte, int centro_asistencia, InformeClinicoData data) throws IOException, DocumentException {
        this.data = data;

        Default.HeaderTable header = new Default.HeaderTable(getHeader(centro_asistencia), data.getNo_registro());

        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), getFooter().getTotalHeight() + 10);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        pdfWriter.setPageEvent(new Default.FooterTable(getFooter()));
        document.open();
        document.add(getInfoVictima());
        document.close();
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
    }

    private PdfPTable getInfoVictima() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda(nombre_casa + "DIF ESTATAL\nDEPARTAMENTO DE PSICOLOGIA\nINFORME CLINICO", Default.TITULO, Element.ALIGN_CENTER));
        content.addCell(Default.celda("\n" + data.getFecha(), Default.TITULO, Element.ALIGN_RIGHT));
        content.addCell(Default.celda("\nFICHA DE IDENTIFICACIÓN DE VICTIMA\n ", Default.TITULO));

        PdfPTable informacion_victima = new PdfPTable(2);
        informacion_victima.addCell(Default.celda("NOMBRE: " + data.getNombre_victima()));
        informacion_victima.addCell(Default.celda("EDAD: " + data.getEdad()));
        informacion_victima.addCell(Default.celda("SEXO: " + data.getSexo()));
        informacion_victima.addCell(Default.celda("FECHA DE NACIMIENTO: " + data.getFecha_nacimiento()));
        informacion_victima.addCell(Default.celda());
        informacion_victima.setWidthPercentage(100);
        content.addCell(Default.celda(informacion_victima));

        content.addCell(Default.celda("FECHA DE INGRESO: " + data.getFecha_ingreso()));
        content.addCell(Default.celda("LUGAR DE NACIMIENTO: " + data.getLugar_nacimiento()));
        content.addCell(Default.celda("ESCOLARIDAD: " + data.getEscolaridad()));

        content.addCell(Default.celda("\nMOTIVO DE INFRESO\n ", Default.TITULO));
        content.addCell(Default.celda(data.getMotivo_ingreso(), Element.ALIGN_JUSTIFIED));

        content.addCell(Default.celda("\nPERFIL CLINICO\n ", Default.TITULO));
        content.addCell(Default.celda(crearLista(data.getPerfil_clinico())));

        content.addCell(Default.celda("\nANTECEDENTES\n ", Default.TITULO));
        content.addCell(Default.celda(data.getAntecendetes(), Element.ALIGN_JUSTIFIED));

        content.addCell(Default.celda("\nDESCRIPCION DEL USUAIRO\n ", Default.TITULO));
        content.addCell(Default.celda(data.getDescripcion_victima(), Element.ALIGN_JUSTIFIED));

        content.addCell(Default.celda("\nEXAMEN MENTAL\n ", Default.TITULO));
        content.addCell(Default.celda(data.getExamen_mental(), Element.ALIGN_JUSTIFIED));

        content.addCell(Default.celda("\nRESULTADOS DE EVALUACIÓN\n ", Default.TITULO));
        content.addCell(Default.celda(data.getResultado_evaluacion(), Element.ALIGN_JUSTIFIED));

        content.addCell(Default.celda("\nRECOMENDACIONES\n ", Default.TITULO));
        content.addCell(Default.celda(data.getDescripcion_recomencion(), Element.ALIGN_JUSTIFIED));

        content.addCell(Default.celda(crearLista(data.getPuntos_recomencion())));

        content.addCell(Default.firmaTrabajador(data.getTrabajador().getNombre(), data.getTrabajador().getCargo(), data.getTrabajador().getCedula()));
        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getHeader(int centro) throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(1);

        String ruta_img = "";
        switch (centro) {
            case 0: ruta_img = InformeClinicoPDF.class.getClassLoader().getResource("Image/CASA_HOGAR.png").toString(); nombre_casa = "CASA HOGAR "; break;
            case 1: ruta_img = InformeClinicoPDF.class.getClassLoader().getResource("Image/MI_CASA.png").toString(); nombre_casa = "MI CASA "; break;
            case 2: ruta_img = InformeClinicoPDF.class.getClassLoader().getResource("Image/REFUGIO_ESPERANZA.png").toString(); nombre_casa = "REFUCIO ESPERANZA "; break;
        }

        content.addCell(Default.celda());
        content.addCell(Default.celda(Default.createImageWidth(ruta_img, 250)));

        return content;
    }

    private PdfPTable getFooter() throws IOException, DocumentException {
        PdfPTable content = new PdfPTable(1);
        content.setTotalWidth(550);

        PdfPTable redes = new PdfPTable(3);

        redes.addCell(Default.celda("WWW.DURANGO.GOB.MX", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.COURIER, 12, com.itextpdf.text.Font.NORMAL), Element.ALIGN_RIGHT));
        redes.addCell(Default.celda(Default.createImageWidth(InformeClinicoPDF.class.getClassLoader().getResource("Image/facebook.png").toString(), 15), "| DIF Municipal Durango"));
        redes.addCell(Default.celda(Default.createImageWidth(InformeClinicoPDF.class.getClassLoader().getResource("Image/twitter.png").toString(), 15), "| @DIF_Durango"));

        redes.setWidthPercentage(100);

        content.addCell(Default.rellenoColor("\nAv del Hierro esquina con Av. Estaño s/n Fracc. Fidel Velasquez II\n\nDurango Dgo Tel: 814-69-31 y 814-25-23\n ", 0x009FBF));
        content.addCell(Default.celda(redes, Element.ALIGN_RIGHT));

        return content;
    }

    private PdfPTable crearLista(String[] lista) throws DocumentException {
        PdfPTable content = new PdfPTable(2);
        for (String objeto : lista) {
            content.addCell(Default.celda("-"));
            content.addCell(Default.celda(objeto));
        }
        content.setTotalWidth(new float[] {5, 95});
        content.setWidthPercentage(90);
        return content;
    }

}
