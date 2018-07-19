package Design;

import Informacion.InformeClinicoData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import sun.awt.im.InputMethodAdapter;
import sun.misc.CEFormatException;

import javax.crypto.spec.DESedeKeySpec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ConcurrentNavigableMap;

public class Default {

    public static Font TITULO = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    public static Font NORMAL = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
    public static Font SUBRAYADO = new Font(Font.FontFamily.HELVETICA, 12, Font.UNDERLINE);

    public static Font TITULO_CHICA = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD);
    public static Font NORMAL_CHICA = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);


    public static int HEXA_ROSA = 0xFF2075;
    public static BaseColor COLOR_ROSA = new BaseColor(0xFF2075);

    public static Font TITULO_CHICA_ROSA = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, COLOR_ROSA);
    public static Font TITULO_CHICA_BLANCO = new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, new BaseColor(0xFFFFFF));

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

        public HeaderTable(PdfPTable table) throws IOException, BadElementException {
            this.table = new PdfPTable(1);
            this.table.addCell(Default.celda(table));
            this.table.addCell(Default.celda());
            this.table.addCell(Default.rellenoColor(3, 0x009FBF));
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

    public static class FooterTableCount extends PdfPageEventHelper {
        protected PdfPTable footer;
        public FooterTableCount() {
            this.footer = new PdfPTable(1);
        }
        public void onEndPage(PdfWriter writer, Document document) {
//            footer.addCell(Default.celda(/));
            footer.addCell(String.valueOf(writer.getPageNumber()));
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

    public static PdfPCell firmaTrabajadorChica(String trabajador, String cargo) {
        PdfPTable content = new PdfPTable(1);
        content.addCell(Default.celda());
        content.addCell(Default.celda());
        content.addCell(Default.celda("_______________________________________", TITULO_CHICA, Element.ALIGN_CENTER));
        content.addCell(Default.celda(trabajador, TITULO_CHICA, Element.ALIGN_CENTER));
        content.addCell(Default.celda(cargo, TITULO_CHICA, Element.ALIGN_CENTER));

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

    public static Image createImageWidth(String ruta, int largo, int posicion) throws IOException, BadElementException {
        Image image = Image.getInstance(ruta);
        if(largo > 300) {largo = 300;}
        float height = (image.getHeight() / image.getWidth()) * largo;
        image.scaleAbsoluteWidth(largo);
        image.scaleAbsoluteHeight(height);
        image.setAlignment(posicion);
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

    public static Image createImageHeight(String ruta, int alto, int posicion) throws IOException, BadElementException {
        Image image = Image.getInstance(ruta);
        if(alto > 300) {alto = 300;}
        float width = (image.getWidth() / image.getHeight()) * alto;
        image.scaleAbsoluteWidth(width);
        image.scaleAbsoluteHeight(alto);
        image.setAlignment(posicion);
        return image;
    }

    public static PdfPCell rellenoColor(String texto, int color) {
        PdfPCell cell = Default.celda(texto, NORMAL, Element.ALIGN_RIGHT, new int[] {255,255,255}, 9);
        cell.setFixedHeight(15);
        cell.setBorder(0);
        cell.setBackgroundColor(new BaseColor(color));
        return cell;
    }

    public static PdfPCell rellenoColor(int altura, int color) {
        PdfPCell cell = Default.celda(" ", NORMAL, Element.ALIGN_RIGHT, new int[] {255,255,255}, 9);
        cell.setFixedHeight(altura);
        cell.setBorder(0);
        cell.setBackgroundColor(new BaseColor(color));
        return cell;
    }

    public static PdfPCell rellenoColor(String texto, int fondo,Font fuente, int posicion) {
        PdfPCell cell = Default.celda(texto, fuente, posicion);
        cell.setFixedHeight(15);
        cell.setBorder(0);
        cell.setBackgroundColor(new BaseColor(fondo));
        return cell;
    }

    public static PdfPCell checkTrue() {
        Font fuente = TITULO_CHICA_BLANCO;
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk("X", fuente)));
        cell.setFixedHeight(15);
        cell.setBorderColor(COLOR_ROSA);
        cell.setBackgroundColor(COLOR_ROSA);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return cell;
    }
    public static PdfPCell checkFalse() {
        Font fuente = TITULO_CHICA_BLANCO;
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(" ", fuente)));
        cell.setFixedHeight(15);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBorderColor(COLOR_ROSA);
        return cell;
    }

    public static PdfPCell checkTrueFalse(boolean quest,int porcentaje) {
        PdfPTable content = new PdfPTable(4);
        content.addCell(Default.celda("SI", NORMAL_CHICA, Element.ALIGN_LEFT));
        content.addCell((quest? checkTrue(): checkFalse()));
        content.addCell(Default.celda("NO", NORMAL_CHICA, Element.ALIGN_CENTER));
        content.addCell((quest? checkFalse(): checkTrue()));
        content.setWidthPercentage(porcentaje);
        return Default.celda(content);
    }

    public static PdfPCell celdaDobleChica(String titulo, String texto, float[] porcentaje) throws DocumentException {
        PdfPTable content = new PdfPTable(2);
        content.addCell(Default.celdaBorderButtom(titulo, Default.TITULO_CHICA));
        content.addCell(Default.celdaBorderButtom(texto, Default.NORMAL_CHICA));
        content.setTotalWidth(porcentaje);
        content.setWidthPercentage(100);
        return Default.celda(content);
    }

    public static PdfPCell celdaDoble(String titulo, String texto, float[] porcentaje) throws DocumentException {
        PdfPTable content = new PdfPTable(2);
        content.addCell(Default.celdaBorderButtom(titulo, Default.TITULO_CHICA));
        content.addCell(Default.celdaBorderButtom(texto, Default.NORMAL_CHICA));
        content.setTotalWidth(porcentaje);
        content.setWidthPercentage(100);
        return Default.celda(content);
    }

    public static PdfPCell celdaDoble(PdfPCell derecha, PdfPCell izquierda) throws DocumentException {
        PdfPTable content = new PdfPTable(2);
        content.addCell(derecha);
        content.addCell(izquierda);
        content.setTotalWidth(new float[] {50, 50});
        content.setWidthPercentage(100);
        return Default.celda(content);
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

    public static PdfPCell celdaBorderButtom(String texto, Font fuente) {
        PdfPCell cell = new PdfPCell(new Paragraph(new Chunk(texto, fuente)));
        cell.setBorder(0);
//        cell.setBorderColorBottom();
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

    public static PdfPCell createTable(String[] titulo, ArrayList<Object> datos) {
        PdfPTable table = new PdfPTable(titulo.length);
        for (String t : titulo) {
            table.addCell(Default.rellenoColor(t, HEXA_ROSA, TITULO_CHICA_BLANCO, Element.ALIGN_CENTER));
        }
        table.setWidthPercentage(100);
        return Default.celda(table);
    }
}
