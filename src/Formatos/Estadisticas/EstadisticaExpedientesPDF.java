package Formatos.Estadisticas;

import Design.Default;
import Formatos.AnexoUnoPDF;
import Informacion.EstadisticaExpendientesData;
import Informacion.EstadisticaTrabajoSocialData;
import Informacion.TrabajadorData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EstadisticaExpedientesPDF {

    public EstadisticaExpedientesPDF (String nombre_reporte, String url_reporte, EstadisticaTrabajoSocialData data, String periodo, TrabajadorData d) throws IOException, DocumentException {
        Default.HeaderTable header = new Default.HeaderTable(getHeader(), periodo, true);

        Document document = new Document(PageSize.A4.rotate(), 30, 30, header.getTableHeight(), 30);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        document.open();
        document.add(getTitle());
        document.add(getTabla(data));
        document.add(getFirma(d));
        document.close();

        pdfWriter.setPageEvent(new Default.FooterTableCount());
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
    }

    private PdfPTable getTabla(EstadisticaTrabajoSocialData data) throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda(generarTablaExpedientes(
                new String[] {"ASESOR JURÍDICO", "COMPROBADOS", "NO COMPROBADOS", "FALSOS",
                        "NO FAVORABLE", "FAVORABLE", "ANTES ACTUALIZADOS", "ACTUALIZADOS", "SIN RESULTADO", "TOTAL ASIGNADOS"},
                    data.getExpendientesData()
                )));
        content.setWidthPercentage(100);

        return content;
    }

    private PdfPTable getHeader() throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(2);

        content.addCell(Default.celda());
        content.addCell(Default.celda());

        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("images/DIF_ESTATAL.png").toString(), 60, Element.ALIGN_LEFT)));
        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("images/evnnya_lateral.png").toString(), 60, Element.ALIGN_RIGHT)));

        content.setWidthPercentage(100);
        return content;
    }

    public PdfPTable getTitle() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("EXPEDIENTES ASIGNADOS", Default.TITULO, Element.ALIGN_CENTER));

        return content;
    }

    private PdfPTable getFirma(TrabajadorData t) {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.firmaTrabajador(t.getNombre(), ""));

        return content;
    }

    public static PdfPTable generarTablaExpedientes(String[] titulo, ArrayList<EstadisticaExpendientesData> datos) throws DocumentException {
        PdfPTable table = new PdfPTable(titulo.length);
        for (String t : titulo) {
            table.addCell(Default.rellenoColor(t, Default.HEXA_AZUL, Default.TITULO_CHICA_BLANCO, Element.ALIGN_LEFT));
        }
        for (EstadisticaExpendientesData t : datos){
            table.addCell(Default.celdaBorderButtomAzul(t.getComprobados(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(Default.celdaBorderButtomAzul(t.getNo_comprobados(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(Default.celdaBorderButtomAzul(t.getFalsos(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(Default.celdaBorderButtomAzul(t.getNo_favorable(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(Default.celdaBorderButtomAzul(t.getFavorable(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(Default.celdaBorderButtomAzul(t.getAntes_actualizados(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(Default.celdaBorderButtomAzul(t.getActualizados(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(Default.celdaBorderButtomAzul(t.getSin_resultado(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(Default.celdaBorderButtomAzul(t.getTotal_asignados(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
        }
        table.setTotalWidth(new float[] {20,10,10,6,9,9,10,10,8,8});
        table.setWidthPercentage(100);
        PdfPTable content = new PdfPTable(1);
        content.addCell(Default.celda());
        content.addCell(Default.celda(table));
        content.setWidthPercentage(100);
        return content;
    }
}
