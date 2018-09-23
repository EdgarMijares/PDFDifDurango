package Formatos;

import Design.Default;
import Informacion.LiberacionDeCustodiaData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LiberacionCustodiaPDF {

    LiberacionDeCustodiaData data = new LiberacionDeCustodiaData();

    public LiberacionCustodiaPDF(String nombre_reporte, String url_reporte, int centro_asistencia, LiberacionDeCustodiaData data) throws DocumentException, IOException {
        this.data = data;

        Default.HeaderTable header = new Default.HeaderTable(getHeader(centro_asistencia), data.getNo_registro());

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

        content.addCell(Default.celda());
        content.addCell(Default.celda("\n\nACTA DE LIBERACÓN DE CUSTODIA\n\n\n", Default.TITULO, Element.ALIGN_CENTER));
        String hora = data.getHora();
        String dia = data.getDia();
        String mes = data.getMes();
        String ano = data.getAno();
        String direccion = data.getDireccion();
        String coordinador = data.getCoordinador();
        String victima = data.getVictima();
        String responsable = data.getResponsable();
        String parentesco = data.getParentesco();
        String domicilio = data.getDomicilio();
        String telefono = data.getTelefono();
        String ine = data.getIne();
        content.addCell(Default.celda(
                "EN LA CIUDAD DE DURANGO. DURANGO. SIENDO LAS " + hora + " HORAS DEL DIA " + dia + " DEL MES " + mes + " DEL AÑO" +
                ano + ", SE REUNIERON EN LAS OFICINAS QUE OCUPA CASA DE CRECEMOS DIF ESTATAL DURANGO, UBICADO EN " + direccion + " LA " +
                coordinador + " COORDINADORA DE CASA CRECEMOS DIF ESTATAL DURANGO, CON EL OBJETO DE HACER ENTREGA POR PARTE DE LA " +
                "PROCURADURÍA DE PROTECCIÓN DE NIÑAS, NIÑOS Y ADOLESCENTES AL MENOR " + victima + "\n\n" +
                "QUIEN ENTREGA AL SEÑOR(A) " + responsable + "\n\n" +
                "PARENTESCO: " + parentesco + "\n\n" +
                "DOMICILIO: " + domicilio + "\n\n" +
                "TELÉFONO: " + telefono + "\n\n" +
                "NUMERO DE CREDENCIAL ELECTORAL: " + ine + "\n\n" +
                ano, Element.ALIGN_JUSTIFIED));
        content.addCell(Default.celda());
        content.addCell(Default.celda("LA ENTREGA DEL MENOR SE REALIZA EN BUEN ESTADO DE SALUD FÍSICA " +
                "Y MENTAL, QUIEN ESTUVO EN CUSTODIA PROVISIONAL EN ESTA INSTITUCIÓN, UNA VEZ RESUELTA SU SITUACIÓN LEGAL Y/O FAMILIAR.\n\n" +
                "SE LEVANTA LA PRESENTE ACTA FIRMANDO AL CALCE LAS PERSONAS QUE EN ELLA INTERVINIERON.\n\n" +
                "DURANGO, DURANGO, A "+ dia + " DE "+ mes + " DEL AÑO ", Element.ALIGN_JUSTIFIED));
        content.addCell(Default.celda());
        content.addCell(Default.celda("ENTREGA: " + coordinador));
        content.addCell(Default.celda("RECIBE: " + responsable));

        return content;
    }

    private PdfPTable getHeader(int centro) throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(1);

        String ruta_img = "";
        switch (centro) {
            case 0: ruta_img = LiberacionCustodiaPDF.class.getClassLoader().getResource("images/CASA_HOGAR.png").toString(); break;
            case 1: ruta_img = LiberacionCustodiaPDF.class.getClassLoader().getResource("images/MI_CASA.png").toString(); break;
            case 2: ruta_img = LiberacionCustodiaPDF.class.getClassLoader().getResource("images/REFUGIO_ESPERANZA.png").toString(); break;
        }

        content.addCell(Default.celda());
        content.addCell(Default.celda(Default.createImageWidth(ruta_img, 250), Element.ALIGN_CENTER));

        content.setTotalWidth(100);
        return content;
    }

    private PdfPTable getFooter() throws IOException, DocumentException {
        PdfPTable content = new PdfPTable(1);
        content.setTotalWidth(550);

        PdfPTable redes = new PdfPTable(3);

        redes.addCell(Default.celda("WWW.DURANGO.GOB.MX", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.COURIER, 12, com.itextpdf.text.Font.NORMAL), Element.ALIGN_RIGHT));
        redes.addCell(Default.celda(Default.createImageWidth(LiberacionCustodiaPDF.class.getClassLoader().getResource("images/facebook.png").toString(), 15), "| DIF Municipal Durango"));
        redes.addCell(Default.celda(Default.createImageWidth(LiberacionCustodiaPDF.class.getClassLoader().getResource("images/twitter.png").toString(), 15), "| @DIF_Durango"));

        redes.setWidthPercentage(100);

        content.addCell(Default.rellenoColor("\n" + data.getDireccion_casa().getDireccion_uno() + "\n\n"+ data.getDireccion_casa().getGetDireccion_dos() +"\n ", 0x009FBF));
        content.addCell(Default.celda(redes, Element.ALIGN_RIGHT));

        return content;
    }
}