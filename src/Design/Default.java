package Design;

import Informacion.InformeClinicoData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import javax.crypto.spec.DESedeKeySpec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class Default {

    public static Font TITULO = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    public static Font NORMAL = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
    public static Font SUBRAYADO = new Font(Font.FontFamily.HELVETICA, 12, Font.UNDERLINE);

    public static Font NORMAL_CHICA = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);

    private static String[] MES_TEXTO = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public static class HeaderTable extends PdfPageEventHelper {
        protected PdfPTable table;
        protected float tableHeight;

        public HeaderTable(PdfPTable table, String no_registro) throws IOException, BadElementException {
            this.table = new PdfPTable(1);
            this.table.addCell(Default.celda(table));
            this.table.addCell(Default.rellenoColor(no_registro, 0x009FBF));
            this.table.setTotalWidth(532);
            this.table.setLockedWidth(true);
            this.tableHeight = this.table.getTotalHeight();
        }

        public float getTableHeight() {
            return tableHeight;
        }

        public void onEndPage(PdfWriter writer, Document document) {
            table.writeSelectedRows(0, -1,
                    document.left(),
                    document.top() + ((document.topMargin() + tableHeight) / 2),
                    writer.getDirectContent());
        }
    }

    public static class FooterTable extends PdfPageEventHelper {
        protected PdfPTable footer;
        public FooterTable(PdfPTable footer) {
            this.footer = footer;
        }
        public void onEndPage(PdfWriter writer, Document document) {
            footer.writeSelectedRows(0, -1, 25, this.footer.getTotalHeight() + 15, writer.getDirectContent());
        }
    }

    public static PdfPCell firmaTrabajador(String trabajador, String cargo, String cedula) {
        PdfPTable content = new PdfPTable(1);
        content.addCell(Default.celda());
        content.addCell(Default.celda());
        content.addCell(Default.celda("_______________________________________",Element.ALIGN_CENTER));
        content.addCell(Default.celda(trabajador, Element.ALIGN_CENTER));
        content.addCell(Default.celda(cargo, Element.ALIGN_CENTER));
        content.addCell(Default.celda("Ced. Prof: " + cedula, Element.ALIGN_CENTER));

        return Default.celda(content);
    }

    public static PdfPCell firmaTrabajador(String trabajador, String cargo) {
        PdfPTable content = new PdfPTable(1);
        content.addCell(Default.celda());
        content.addCell(Default.celda());
        content.addCell(Default.celda("_______________________________________",Element.ALIGN_CENTER));
        content.addCell(Default.celda(trabajador, Element.ALIGN_CENTER));
        content.addCell(Default.celda(cargo, Element.ALIGN_CENTER));

        return Default.celda(content);
    }

    public static Image createImageWidth(String ruta, int largo) throws IOException, BadElementException {
        Image image = Image.getInstance(ruta);
        if(largo > 300) {largo = 300;}
        float height = (image.getHeight() / image.getWidth()) * largo;
        image.scaleAbsoluteWidth(largo);
        image.scaleAbsoluteHeight(height);
        image.setAlignment(Element.ALIGN_CENTER);
        return image;
    }

    public static Image createImageHeight(String ruta, int alto) throws IOException, BadElementException {
        Image image = Image.getInstance(ruta);
        if(alto > 300) {alto = 300;}
        float width = (image.getWidth() / image.getHeight()) * alto;
        image.scaleAbsoluteWidth(width);
        image.scaleAbsoluteHeight(alto);
        return image;
    }

    public static PdfPCell rellenoColor(String texto, int color) {
        PdfPCell cell = Default.celda(texto, NORMAL, Element.ALIGN_RIGHT, new int[] {255,255,255}, 9);
//        cell.setFixedHeight(15);
        cell.setBorder(0);
        cell.setBackgroundColor(new BaseColor(color));
        return cell;
    }

    public static PdfPCell celda() {
        PdfPCell cell = new PdfPCell();
        cell.addElement(new Paragraph(" "));
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(String texto, Font fuente, int posicion, int[] colores, int font_size) {
        fuente.setColor(colores[0], colores[1], colores[2]);
        fuente.setSize(font_size);
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(texto, fuente)));
        cell.setHorizontalAlignment(posicion);
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(String texto, Font fuente, int posicion) {
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(texto, fuente)));
        cell.setHorizontalAlignment(posicion);
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(String texto, Font fuente) {
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(texto, fuente)));
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(String texto, int posicion) {
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(texto)));
        cell.setHorizontalAlignment(posicion);
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(String texto) {
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(texto)));
        cell.setFixedHeight(20);
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(Element element, String text) throws DocumentException {
        PdfPCell cell = new PdfPCell();
        cell.addElement(textIcon(element, text));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(PdfPCell element) {
        PdfPCell cell = element;
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(Element element) {
        PdfPCell cell = new PdfPCell();
        cell.addElement(element);
        cell.setBorder(0);
        return cell;
    }

    public static PdfPCell celda(Element element, int posicion) {
        PdfPCell cell = new PdfPCell();
        cell.addElement(element);
        cell.setHorizontalAlignment(posicion);
        cell.setBorder(0);
        return cell;
    }

    private static PdfPTable textIcon(Element element, String text) throws DocumentException {
        PdfPTable content = new PdfPTable(2);
        content.addCell(Default.celda(element));
        content.addCell(Default.celda(text, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL)));
        content.setHorizontalAlignment(Element.ALIGN_RIGHT);
        content.setTotalWidth(new float[] {10, 90});
        return content;
    }

    public static String fechaTexto() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + " de " +  MES_TEXTO[Calendar.getInstance().get(Calendar.MONTH)] + " del " + Calendar.getInstance().get(Calendar.YEAR);
    }
}
