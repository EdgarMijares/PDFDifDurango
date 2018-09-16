package Formatos;

import Design.Default;
import Informacion.InformacionNinoData;
import Informacion.TrabajoSocialData;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.sun.org.apache.bcel.internal.classfile.ConstantNameAndType;

import java.awt.*;
import java.io.*;

public class TrabajoSocialPDF {
    TrabajoSocialData data;

    public TrabajoSocialPDF (String nombre_reporte, String url_reporte, TrabajoSocialData data) throws IOException, DocumentException {
        this.data = data;
        Default.HeaderTable header = new Default.HeaderTable(getHeader());

        Document document = new Document(PageSize.A4, 30, 30, header.getTableHeight(), 30);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));

        pdfWriter.setPageEvent(header);
        document.open();
        document.add(getDatosExpendientes());
        document.add(getDatosGenerales());
        document.add(getValoracion());
        document.add(getTecnicasUtilizadas());
        document.add(getEstrucutraFamiliar());
        document.add(getDinamicaFamiliar());
        document.close();

        pdfWriter.setPageEvent(new Default.FooterTableCount());
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
    }

    private PdfPTable getHeader() throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(2);

        content.addCell(Default.celda());
        content.addCell(Default.celda());
        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/DIF_ESTATAL.png").toString(), 50, Element.ALIGN_LEFT)));
        content.addCell(Default.celda(Default.createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/GOBIERNO_ESTADO.png").toString(), 50, Element.ALIGN_RIGHT)));

        content.setWidthPercentage(80);
        return content;
    }

    private PdfPTable getDatosExpendientes() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("\nANEXO II", Default.TITULO, Element.ALIGN_CENTER));
        content.addCell(Default.celda("Formato en materia de Trabajo Social", Default.TITULO, Element.ALIGN_CENTER));

        PdfPTable content_double = new PdfPTable(2);
        PdfPTable datos = new PdfPTable(2);

        datos.addCell(Default.celda("#", Default.TITULO, Element.ALIGN_RIGHT));
        datos.addCell(Default.celda(data.getFolio(), Element.ALIGN_LEFT));
        datos.addCell(Default.celda("N° De Expediente:", Default.TITULO, Element.ALIGN_RIGHT));
        datos.addCell(Default.celda(data.getNo_expediente(), Element.ALIGN_LEFT));
        datos.addCell(Default.celda("Fecha:", Default.TITULO, Element.ALIGN_RIGHT));
        datos.addCell(Default.celda(data.getFecha(), Element.ALIGN_LEFT));
        datos.addCell(Default.celda("Hora:", Default.TITULO, Element.ALIGN_RIGHT));
        datos.addCell(Default.celda(data.getHora(), Element.ALIGN_LEFT));

        datos.setTotalWidth(new float[]{45, 60});
        content_double.setTotalWidth(new float[]{50, 50});

        content.setWidthPercentage(100);
        content_double.setWidthPercentage(100);
        datos.setWidthPercentage(100);

        content_double.addCell(Default.celda());
        content_double.addCell(Default.celda(datos));
        content.addCell(Default.celda(content_double));

        return content;
    }

    private PdfPTable getDatosGenerales() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda("I. DATOS GENERALES\n    I.I NIÑA, NIÑO O ADOLESENTE", Default.TITULO));
//        content.addCell(Default.celda());
        for (InformacionNinoData info: data.getInformacionNinoData()){
            content.addCell(Default.celdaTriple(
                    Default.celdaDoble("NOMBRE:", info.getNombre(), new float[] {21,79}),
                    Default.celdaDoble("EDAD:", info.getEdad(), new float[] {40,60}),
                    Default.celdaDoble("GÉNERO:", info.getSexo(), new float[] {40,60}),
                    new float[] {50, 20 , 30}
            ));
            content.addCell(Default.celdaDoble(
                    Default.celdaDoble("FECHA DE NACIMIENTO:", info.getFecha_nacimiento().toUpperCase(), new float[] {65, 35}),
                    Default.celdaDoble("LUGAR DE NACIMIENTO:", info.getLugar_nacimiento().toUpperCase(), new float[] {43, 57}),
                    new float[] {40, 60}
            ));
            content.addCell(Default.celdaTriple(
                    Default.celdaDoble("NACIONALIDAD:", info.getNacionalidad(), new float[] {50,50}),
                    Default.celdaDoble("IDIOMA:", info.getIdioma(), new float[] {35,65}),
                    Default.celdaDoble("GRUPO ÉTNICO:", info.getEtnia(), new float[] {50,50}),
                    new float[] {33, 25, 42}
            ));
            PdfPTable discapaciad = new PdfPTable(4);
            discapaciad.addCell(Default.celda("DISCAPACIDAD:", Default.TITULO_CHICA, Element.ALIGN_LEFT));
            discapaciad.addCell(Default.checkTrueFalse(info.isDiscapacidad(), 80));

            discapaciad.addCell(Default.celda("¿CUÁL?", Default.TITULO_CHICA, Element.ALIGN_LEFT));
            discapaciad.addCell(Default.celda(info.getTipo_discapacidad(), Default.NORMAL_CHICA, Element.ALIGN_JUSTIFIED));
            discapaciad.setTotalWidth(new float[] {18,32,10,40});
            discapaciad.setWidthPercentage(100);
            content.addCell(Default.celdaDoble(
                    Default.celdaDoble("RELIGIÓN:", info.getReligion(), new float[] {25,75}),
                    Default.celdaDoble("ESCOLARIDAD:", info.getEscolaridad(), new float[] {33,67}),
                    new float[] {50,50}
            ));
            content.addCell(Default.celda(discapaciad));
            content.addCell(Default.celdaDoble("DOMICILIO:", info.getDomicilio(), new float[] {13, 87}));
        }
        content.addCell(Default.celda());
        content.addCell(Default.celda("    I.II MADRE, PADRE O TUTOR", Default.TITULO));

        content.addCell(Default.celdaTriple(
                Default.celdaDoble("NOMBRE:", data.getNombre_tutor(), new float[] {21,79}),
                Default.celdaDoble("EDAD:", data.getEdad_tutor(), new float[] {50,50}),
                Default.celdaDoble("PARENTESCO:", data.getParentesco(), new float[] {45,55}),
                new float[] {50, 15 , 35}
        ));

        content.addCell(Default.celdaTriple(
                Default.celdaDoble("ESTADO CIVIL:", data.getEstado_civil(), new float[] {50,50}),
                Default.celdaDoble("TÉLEFONO:", data.getTelefono(), new float[] {35,65}),
                Default.celdaDoble("IDIOMA:", data.getIdioma_tutor(), new float[] {35,65}),
                new float[] {35, 35, 30}
        ));

        content.addCell(Default.celdaTriple(
                Default.celdaDoble("GRUPO ÉTNICO:", data.getEtnia_tutor(), new float[] {50,50}),
                Default.celdaDoble("RELIGÓN:", data.getReligion_tutor(), new float[] {35,65}),
                Default.celdaDoble("ESCOLARIDAD:", data.getEscolaridad_tutor(), new float[] {45,55}),
                new float[] {35, 30, 35}
        ));

        PdfPTable discapaciad = new PdfPTable(4);
        discapaciad.addCell(Default.celda("DISCAPACIDAD:", Default.TITULO_CHICA, Element.ALIGN_LEFT));
        discapaciad.addCell(Default.checkTrueFalse(data.isDiscapacidad_tutor(), 80));

        discapaciad.addCell(Default.celda("¿CUÁL?", Default.TITULO_CHICA, Element.ALIGN_LEFT));
        discapaciad.addCell(Default.celda(data.getTipo_discapacidad_tutor(), Default.NORMAL_CHICA, Element.ALIGN_JUSTIFIED));
        discapaciad.setTotalWidth(new float[] {18,32,10,40});
        discapaciad.setWidthPercentage(100);
        content.addCell(Default.celda(discapaciad));
        content.addCell(Default.celdaDoble("DOMICILIO:", data.getDomicilio_tutor(), new float[] {13, 87}));

        content.setWidthPercentage(90);

        return content;
    }

    private PdfPTable getValoracion() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("II. VALORACIÓN", Default.TITULO));
        content.addCell(Default.celdaTriple(
                Default.opcion("INICIAL", true, new float[] {20, 80}),
                Default.opcion("SUBSECUENTE", true, new float[] {20, 80}),
                Default.opcion("SEGUIMIENTO DE CASO", true, new float[] {20, 80})
        ));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getTecnicasUtilizadas() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("III. TÉCNICAS UTILIZADAS", Default.TITULO));
        content.addCell(Default.celdaDoble(
                Default.opcion("ENTREVISTA", data.getTecnicas()[0], new float[] {10, 90}),
                Default.opcion("OBSERVACIÓN", data.getTecnicas()[1], new float[] {10, 90})
        ));
        content.addCell(Default.celdaDoble(
                Default.opcion("VISITA DOMICILIARIA", data.getTecnicas()[2], new float[] {10, 90}),
                Default.opcion("MIXTA", data.getTecnicas()[3], new float[] {10, 90})
        ));
        content.addCell(Default.celdaDoble(
                Default.opcion("COLATERAL", data.getColateral(), new float[] {20, 80}),
                Default.opcion("DIRECTA", data.getDirecta(), new float[] {20, 80})
        ));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getEstrucutraFamiliar() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("        IV. ESTRUCTURA FAMILIAR", Default.TITULO));
        content.addCell(Default.celda());
        content.addCell(Default.createTableFamilaDetallada(new String[] {"NOMBRE", "PARENTESCO", "EDAD", "SEXO", "ESTADO CIVIL", "ESCOLARIDAD", "OCUPACIÓN"}, data.getFamilia()));

        content.setWidthPercentage(100);
        return content;
    }

    private PdfPTable getDinamicaFamiliar() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("V. DINÁMICA FAMILIAR", Default.TITULO));
        content.addCell(Default.celda(data.getDinamica_familiar(), Element.ALIGN_JUSTIFIED));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getFamiliograma() throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda(Default.createImageWidth(data.getFamiliograma(), 300)));
        content.setWidthPercentage(90);

        return content;
    }

    private PdfPTable getSituacionEconomica() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(Default.celda());
        content.addCell(Default.celda("VII. SITUACIÓN ECONOMICA", Default.TITULO));
//        content.------a

        return content;
    }
}
