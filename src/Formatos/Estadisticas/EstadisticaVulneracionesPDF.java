package Formatos.Estadisticas;

import Design.Default;
import Formatos.AnexoUnoPDF;
import Informacion.EstadisticaTrabajoSocialData;
import Informacion.EstadisticaVulneracionesData;
import Informacion.TrabajadorData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static Design.Default.*;
import static Design.Default.NORMAL_CHICA;

public class EstadisticaVulneracionesPDF {

    public EstadisticaVulneracionesPDF (String nombre_reporte, String url_reporte, EstadisticaTrabajoSocialData data, String periodo, TrabajadorData d) throws IOException, DocumentException {
        Default.HeaderTable header = new Default.HeaderTable(getHeader(), periodo, true);

        Document document = new Document(PageSize.A4.rotate(), 30, 30, header.getTableHeight(), 30);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        String[] prueba =  new String[] {"1","2","3","4"};

        pdfWriter.setPageEvent(header);
        document.open();
        document.add(getTitle("VULNERACIONES"));
        document.add(getTablaVulneraciones(data.getVulneraciones()));
        document.add(Default.generarTabla(new String[] {"VALORACIÓN", "OC", "FISICO", "PSIC EM", "EB SEX", "G Y C", "AM FAB", "RIES", "REINT", "OTRO"}, data.getVulneraciones_tabla_uno()));
        document.add(getFirma(d));
        document.close();

        pdfWriter.setPageEvent(new Default.FooterTableCount());
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
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

    public PdfPTable getTitle(String titulo) {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda(5));
        content.addCell(Default.celda(titulo.toUpperCase(), Default.TITULO, Element.ALIGN_CENTER));
        content.addCell(Default.celda(5));

        return content;
    }

    private PdfPTable getFirma(TrabajadorData t) {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.firmaTrabajador(t.getNombre(), ""));

        return content;
    }

    private PdfPTable getTablaVulneraciones(ArrayList<EstadisticaVulneracionesData> datos) throws DocumentException {
        PdfPTable content = new PdfPTable(1);


        content.addCell(Default.celdaTriple(
                Default.rellenoColor(Default.HEXA_ROSA),
                Default.rellenoColor("EXPEDIENTES", Default.HEXA_ROSA, Element.ALIGN_CENTER),
                Default.rellenoColor("REPORTES", Default.HEXA_ROSA, Element.ALIGN_CENTER),
                new float[] {40,30,30}
        ));
        content.addCell(Default.celdaTripleBackground(
                Default.rellenoColor("CLASIFICACIÓN DE VULNERACIÓN DE DERECHOS", Default.HEXA_AZUL, Element.ALIGN_CENTER),
                Default.celdaCuadruple(
                        Default.rellenoColor("MUJER", Default.HEXA_AZUL, Element.ALIGN_CENTER),
                        Default.rellenoColor("HOMBRE", Default.HEXA_AZUL, Element.ALIGN_CENTER),
                        Default.rellenoColor("DESCONOCIDO", Default.HEXA_AZUL, Element.ALIGN_CENTER),
                        Default.rellenoColor("TOTAL", Default.HEXA_AZUL, Element.ALIGN_CENTER),
                        new float[] {22,22,34,22}
                ),
                Default.celdaCuadruple(
                        Default.rellenoColor("MUJER", Default.HEXA_AZUL, Element.ALIGN_CENTER),
                        Default.rellenoColor("HOMBRE", Default.HEXA_AZUL, Element.ALIGN_CENTER),
                        Default.rellenoColor("DESCONOCIDO", Default.HEXA_AZUL, Element.ALIGN_CENTER),
                        Default.rellenoColor("TOTAL", Default.HEXA_AZUL, Element.ALIGN_CENTER),
                        new float[] {22,22,34,22}
                ),
                new float[] {40,30,30}, Default.HEXA_AZUL

        ));

        PdfPTable table = new PdfPTable(3);
        PdfPTable expedientes = new PdfPTable(4);
        PdfPTable reportes = new PdfPTable(4);
        expedientes.setWidthPercentage(100);
        reportes.setWidthPercentage(100);
        for (EstadisticaVulneracionesData t : datos) {
            table.addCell(rellenoColor(t.getVulneracion(), Default.HEXA_AZUL, Element.ALIGN_LEFT));
            expedientes.addCell(celdaBorderButtomAzul(t.getExpediente_mujer(), NORMAL_CHICA, Element.ALIGN_CENTER));
            expedientes.addCell(celdaBorderButtomAzul(t.getExpediente_hombre(), NORMAL_CHICA, Element.ALIGN_CENTER));
            expedientes.addCell(celdaBorderButtomAzul(t.getExpediente_desconocido(), NORMAL_CHICA, Element.ALIGN_CENTER));
            expedientes.addCell(celdaBorderButtomAzul(t.getExpediente_total(), NORMAL_CHICA, Element.ALIGN_CENTER));

            reportes.addCell(celdaBorderButtomAzul(t.getReporte_mujer(), NORMAL_CHICA, Element.ALIGN_CENTER));
            reportes.addCell(celdaBorderButtomAzul(t.getReporte_hombre(), NORMAL_CHICA, Element.ALIGN_CENTER));
            reportes.addCell(celdaBorderButtomAzul(t.getReporte_desconocido(), NORMAL_CHICA, Element.ALIGN_CENTER));
            reportes.addCell(celdaBorderButtomAzul(t.getReporte_total(), NORMAL_CHICA, Element.ALIGN_CENTER));

            table.addCell(Default.celda(expedientes));
            table.addCell(Default.celda(reportes));
            expedientes.deleteBodyRows();
            reportes.deleteBodyRows();
        }

        table.setWidthPercentage(100);
        table.setTotalWidth(new float[] {40,30,30});
        content.addCell(Default.celda(table));

        content.setWidthPercentage(100);
        return content;
    }
}
