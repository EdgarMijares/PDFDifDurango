package Formatos;

import Design.Default;
import Informacion.AnexoUnoData;
import Informacion.EstadisticasData;
import Informacion.TablaEstadisticasData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EstadisticasPDF {
    public EstadisticasPDF (String nombre_reporte, String url_reporte, AnexoUnoData data) throws IOException, DocumentException {
        Default.HeaderTable header = new Default.HeaderTable(getHeader(), "Estadisticas perdiodo: 10/01/2001 - 11/01/2001");

        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), 30);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        document.open();
        document.add(getContet());
        document.close();
        pdfWriter.setPageEvent(new Default.FooterTableCount());
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
    }

    private PdfPTable getHeader() throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(2);

        content.addCell(Default.celda());
        content.addCell(Default.celda());

        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/DIF_ESTATAL.png").toString(), 60, Element.ALIGN_LEFT)));
        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/evnnya_lateral.png").toString(), 60, Element.ALIGN_RIGHT)));

        content.setWidthPercentage(95);
        return content;
    }

    private static PdfPTable getContet() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        TablaEstadisticasData t1 = new TablaEstadisticasData();
        t1.setTitulo("DATO 1");
        t1.setDato("30");
        TablaEstadisticasData t2 = new TablaEstadisticasData();
        t2.setTitulo("DATO 2");
        t2.setDato("60");

        TablaEstadisticasData t3 = new TablaEstadisticasData();
        t3.setTitulo("DATO 3");
        t3.setDato("20");
        TablaEstadisticasData t4 = new TablaEstadisticasData();
        t4.setTitulo("DATO 4");
        t4.setDato("40");

        ArrayList<TablaEstadisticasData> estadisticasData1 = new ArrayList<>();
        estadisticasData1.add(t1);
        estadisticasData1.add(t2);

        ArrayList<TablaEstadisticasData> estadisticasData2 = new ArrayList<>();
        estadisticasData2.add(t3);
        estadisticasData2.add(t4);

        EstadisticasData e1 = new EstadisticasData("TABLA 1", estadisticasData1);
        EstadisticasData e2 = new EstadisticasData("TABLA 2", estadisticasData2);

        ArrayList<EstadisticasData> estadisticasData = new ArrayList<>();
        estadisticasData.add(e1);
        estadisticasData.add(e2);

        content.addCell(Default.createTableEstaditicas(estadisticasData));

        return content;
    }

}
