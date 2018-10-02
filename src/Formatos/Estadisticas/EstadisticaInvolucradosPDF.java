package Formatos.Estadisticas;

import Design.Default;
import Formatos.AnexoUnoPDF;
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

import static Design.Default.*;

public class EstadisticaInvolucradosPDF {

    public EstadisticaInvolucradosPDF (String nombre_reporte, String url_reporte, EstadisticaTrabajoSocialData data, String periodo, TrabajadorData d) throws IOException, DocumentException {
        Default.HeaderTable header = new Default.HeaderTable(getHeader(), periodo);

        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), 30);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        document.open();
        document.add(getTitle());
        document.add(getTablaUno(data.getDatos_involucrados_hombre(), data.getDatos_involucrados_mujer(), data.getDatos_involucrados_desconocido()));
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

    public PdfPTable getTitle() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("REPORTE DE INVOLUCRADOS", Default.TITULO, Element.ALIGN_CENTER));

        return content;
    }

    private PdfPTable getTablaUno(String[] HOMBRES, String[] MUJER, String[] DESCONOCIDO) throws DocumentException {
        String[] titulo = new String[] {"", "AGRESOR", "VICTIMA"};
        ArrayList<String[]> datos = new ArrayList<>();
        datos.add(HOMBRES);
        datos.add(MUJER);
        datos.add(DESCONOCIDO);
        PdfPTable table = new PdfPTable(titulo.length);

        for (String t : titulo) {
            table.addCell(rellenoColor(t, HEXA_AZUL, TITULO_CHICA_BLANCO, Element.ALIGN_CENTER));
        }
        for (Object[] t : datos){
            for (Object aT : t) {
                table.addCell(celdaBorderButtomAzul(aT.toString(), NORMAL_CHICA, Element.ALIGN_CENTER));
            }
        }
        table.setWidthPercentage(100);
        PdfPTable content = new PdfPTable(1);
        content.addCell(Default.celda());
        content.addCell(celda(table));
        content.addCell(Default.celda());
        content.setWidthPercentage(100);
        return content;
    }

    private PdfPTable getFirma(TrabajadorData t) {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.firmaTrabajador(t.getNombre(), ""));

        return content;
    }
}