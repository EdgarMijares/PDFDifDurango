package Formatos.Estadisticas;

import Design.Default;
import Formatos.AnexoUnoPDF;
import Informacion.EstadisticaExpendientesData;
import Informacion.EstadisticaTrabajoSocialData;
import Informacion.ReportesMunicipiosData;
import Informacion.TrabajadorData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReportesMunicipiosPDF {

    public ReportesMunicipiosPDF (String nombre_reporte, String url_reporte, EstadisticaTrabajoSocialData data, String periodo, TrabajadorData d) throws IOException, DocumentException {
        Default.HeaderTable header = new Default.HeaderTable(getHeader(), periodo);

        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), 30);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        String[] prueba =  new String[] {"1","2","3","4"};

        pdfWriter.setPageEvent(header);
        document.open();
        document.add(getTitle("REPORTES"));
//        document.add(getTablaVulneraciones(data.getVulneraciones()));
        document.add(generarTablaReportes(new String[] {"MUNICIPIO", "NUEVOS REPORTES", "REPORTES SUBSECUENTES", "EXPEDIENTES CREADOS"}, data.getMunicipiosData()));
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

    private PdfPTable getTitle(String titulo) {
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

    public static PdfPTable generarTablaReportes(String[] titulo, ArrayList<ReportesMunicipiosData> datos) throws DocumentException {
        PdfPTable table = new PdfPTable(titulo.length);
        for (String t : titulo) {
            table.addCell(Default.rellenoColor(t, Default.HEXA_AZUL, Default.TITULO_CHICA_BLANCO, Element.ALIGN_CENTER));
        }
        for (ReportesMunicipiosData t : datos){
            table.addCell(Default.celdaBorderButtomAzul(t.getMunicipio(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(Default.celdaBorderButtomAzul(t.getNuevos_reportes(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(Default.celdaBorderButtomAzul(t.getReportes_subsecunetes(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
            table.addCell(Default.celdaBorderButtomAzul(t.getExpedientes_creados(), Default.NORMAL_CHICA, Element.ALIGN_CENTER));
        }
        table.setWidthPercentage(100);
        PdfPTable content = new PdfPTable(1);
        content.addCell(Default.celda(table));
        content.setWidthPercentage(100);
        return content;
    }
}
