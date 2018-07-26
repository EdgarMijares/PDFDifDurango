package Formatos;

import Design.Default;
import Informacion.AnexoUnoData;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static Design.Default.*;

public class RecepcionReportePDF {

    private static String LISTA_DE_DERECHOS[] = {
            "Derecho a la vida, a la supervivencia y al desarrollo",
            "Derecho de prioridad\n",
            "Derecho a la identidad",
            "Derecho a vivir en familia",
            "Derecho a la igualdad sustantiva",
            "Derecho a no ser discriminado",
            "Derecho a vivr en condiciones de bienestar y a un sano desarrollo integral",
            "Derecho a una vida libre de violencia y a la integridad personal",
            "Derecho a la protección de la salud y a la seguridad social",
            "Derecho a la inclusión de niñas, niños y adolescentes con discapacidad",
            "Derecho a la educación",
            "Derecho al descanso y al esparcimiento",
            "Derecho a la libertad de convicciones éticas, pensamiento, conciencia, religión y cultura",
            "Derecho a la libertad de expresión de acceso a la información",
            "Derecho de participación",
            "Derecho de asociación y reunió",
            "Derecho a la intimidad",
            "Derecho a la seguridad jurídica y al debido proceso",
            "Derechos de niñas, niños y adolescentes migrantes",
            "Derecho de acceso a las tecnologías de la información y comunicación así como a los " +
                    "servicios de radiodifusión y telecuminicaciones, incluido el de banda ancha e internet, en términos" +
                    "de lo previsto en la Ley Federal de Telecomunicaciones y Radiodifusión. Para tales efectos, el estado " +
                    "establecerá condiciones de competecia efectiva en la presentación de dicho servicios"
    };

    public RecepcionReportePDF (String nombre_reporte, String url_reporte, AnexoUnoData data) throws IOException, DocumentException {
//        this.data = data;

        Document document = new Document(PageSize.A4, 30, 30, 30, (getFooter().getTotalHeight() + 25));
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));
        pdfWriter.setPageEvent(new FooterTable(getFooter()));
        document.open();
        document.add(getHeader());
        document.add(getDatosRecepcion());
        document.add(getDatosDenunciante());
        document.add(getVictimas(false));
        document.add(getDatosCustodio());
//        document.newPage();
        document.add(getDatosAgresores());
        document.add(getClasificacion());
        document.add(getResena());
        document.add(getObservaciones());
        document.close();
        pdfWriter.setPageEvent(new FooterTableCount());
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
    }

    private PdfPTable getFooter() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(celda());
        content.addCell(rellenoColor("EXPEDIENTE: DIF/PPNNA-040-071/2018", HEXA_ROSA));
        content.setTotalWidth(550);

        content.setWidthPercentage(100);
        return content;
    }
    private PdfPTable getHeader() throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(1);

        PdfPTable image = new PdfPTable(2);
        image.addCell(celda(createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/DIF_ESTATAL.png").toString(), 60, Element.ALIGN_LEFT)));
        image.addCell(celda(createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("Image/GOBIERNO_ESTADO.png").toString(), 60, Element.ALIGN_RIGHT)));
        content.addCell(celda(image));
        content.addCell(celda(5));
        content.addCell(rellenoColor(1, HEXA_AZUL));
        content.addCell(celda("Procuraduría de Protección de Niñas, Niños y Adolescentes", new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD), Element.ALIGN_JUSTIFIED_ALL));
        content.addCell(celda(5));
        content.addCell(celda("Reporte de restricción o vulneración de Derechos de Niñas, Niños y Adolescentes", TITULO, Element.ALIGN_JUSTIFIED_ALL));
        content.addCell(celda(5));
        content.addCell(celda(
                "Con fundamento en el artículo 123 de la Ley General de las Niñas, Niños y Adolescentes, se presenta la " +
                "siguiente denuncia sobre restricción o vulneración de derechos de Niñas, Niños y Adolescentes, ante esta " +
                "Procuraduría de Protección quien es competente para conocer del caso según lo establecido en los artículos " +
                "114, 115, 116, 118, 122 fracción 1 y 123, de la ley en referencia, así también los artículos 75, 76 fracción 1 y 77 " +
                "FRACCIÓN I, XLV, XLVII y XVLIII, 12, 14 fracc IV, V Y X, 17, 18, 19, 20, 22 de la Ley para la Procuraduría de " +
                "Protección de Niñas, Niños y Adolescentes del Estado de Durango.", NORMAL_CHICA, Element.ALIGN_JUSTIFIED));
        content.addCell(celda(5));
        content.addCell(rellenoColor(1, HEXA_AZUL));
        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getDatosRecepcion () throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(celda("DATOS DE RECEPCIÓN DE REPORTE.", TITULO));
        content.addCell(celdaDoble(
                celda(" ", NORMAL_CHICA),
                celdaDoble(
                        celda("No. EXPEDIENTE:", TITULO_CHICA, Element.ALIGN_RIGHT),
                        celda("DIF/PPNNA-040-071/2018", NORMAL_CHICA, Element.ALIGN_RIGHT)
                ),
                new float[] {53,48}));

        content.addCell(celdaDoble(
                celda(" ", NORMAL_CHICA),
                celdaDoble(
                        celda("No. FOLIO:", TITULO_CHICA, Element.ALIGN_RIGHT),
                        celda("99990", NORMAL_CHICA, Element.ALIGN_RIGHT),
                        new float[] {70,30}
                ),
                new float[] {85,25}));

        content.addCell(celdaDoble(
                celda(" ", NORMAL_CHICA),
                celdaDoble(
                        celda("FECHA:", TITULO_CHICA, Element.ALIGN_RIGHT),
                        celda("01/06/2018 - 11:52:00", NORMAL_CHICA, Element.ALIGN_RIGHT),
                        new float[] {25,65}
                ),
                new float[] {70,30}));

        content.addCell(
                celdaDoble(
                        celdaDobleChica("RECIBIÓ:", "LIC. ELVA SOFIA BLANCO LOPEZ", new float[] {20, 80}),
                        celdaDobleChica("No. OFICIO:", "123456789", new float[] {31, 69})
                ));
        content.addCell(
                celdaDoble(
                        celdaDobleChica("FECHA OFICIO:", "123456789", new float[] {31, 69}),
                        celdaDobleChica("QUIÉN ENVÍA:", " ", new float[] {31, 69})
        ));

        PdfPTable anonimo = new PdfPTable(3);
        anonimo.addCell(opcion("Anonimo", true));
        anonimo.addCell(opcion("Público", false));
        anonimo.addCell(opcion("Privado", false));
        anonimo.setWidthPercentage(100);
        content.addCell(celdaDobleChica("ANONIMATO:", celda(anonimo), new float[] {21, 79}));

        PdfPTable medio = new PdfPTable(4);
        medio.addCell(opcion("Directa",       true, new float[]{25,85}));
        medio.addCell(opcion("Vía telefonica",false, new float[]{15,85}));
        medio.addCell(opcion("Escrita",       false, new float[]{25,85}));
        medio.addCell(opcion("Personal",      false, new float[]{25,85}));
        medio.setTotalWidth(new float[] {20,30,20,20});
        medio.setWidthPercentage(100);
        content.addCell(celdaDobleChica("MEDIO DE REPORTE:", celda(medio), new float[] {21, 79}));

        content.setWidthPercentage(90);

        return content;
    }

    private PdfPTable getDatosDenunciante () throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(rellenoColor());
        content.addCell(celda("DATOS DEL DENUNCIANTE", TITULO));
        content.addCell(
                celdaDoble(
                        celdaDobleChica("NOMBRE:", "", new float[] {25, 75}),
                        celdaDoble(
                                    opcion("PERSONA FÍSICA", false),
                                    opcion("PERSONA MORAL", false)
                                ),
                        new float[] {45, 65}));

        // PREGUNTAR RELACION O PARENTESCO
        content.addCell(
                celdaTriple(
                        celdaDobleChica("EDAD:", "", new float[] {50, 50}),
                        celdaDobleChica(
                                celda("SEXO:", TITULO_CHICA, Element.ALIGN_RIGHT), "", new float[] {40, 60}),
                        celdaDobleChica(
                                celda("ESCOLARIDAD:", TITULO_CHICA),
                                celda("NINGUNA", NORMAL_CHICA),
                                new float[] {26, 74}),
                        new float[] {15,25,60}
                )
        );
//        content.addCell(celdaDobleChica("DOMICILIO:", "CALLE " + " #" + " C.P.", new float[] {12, 83}));
        content.addCell(celdaDoble(
                celdaDobleChica("RELACIÓN CON LA VÍCTIMA: ", "", new float[] {75,25}),
                celdaDobleChica("DOMICILIO:", "CALLE " + " #" + " C.P.", new float[] {20, 80}),
                new float[] {40,60}
        ));
        content.addCell(celdaDoble(
                celdaDobleChica("TELÉFONO FIJO:", "", new float[] {35,65}),
                celdaDobleChica("TELÉFONO MÓVIL:", "", new float[] {38,62})
        ));
        content.addCell(celdaDoble(
                celdaDobleChica("MUNICIPIO:", "", new float[] {22,68}),
                celdaDobleChica("CORREO:", "", new float[] {19,71})
        ));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getVictimas(boolean t) throws DocumentException {
        PdfPTable content = new PdfPTable(1);
        content.addCell(rellenoColor());
        content.addCell(celda("DATOS DE LA" + (t? "S":"") + " VICTIMA" + (t? "S":""), TITULO));
        content.addCell(celdaTriple(
                celdaDobleChica("NOMBRE:","", new float[] {10,40}),
                celdaDobleChica("EDAD:", "", new float[] {50,50}),
                celdaDobleChica("SEXO:", "", new float[] {50,50}),
                new float[] {60,20,20}
        ));
        content.addCell(celdaDobleChica("ESCOLARIDAD:", "", new float[] {16,84}));
        content.addCell(
                celdaDoble(
                        celdaDobleChica("RELACIÓN CON EL AGRESOR:", "", new float[] {60,40}),
                        celdaDobleChica("CORREO:", "", new float[] {20,80})
                )
        );
        content.addCell(celdaDoble(
                celdaDobleChica("TELÉFONO FIJO:", "", new float[] {35,65}),
                celdaDobleChica("TELÉFONO MÓVIL:", "", new float[] {38,62})
        ));
        content.addCell(celdaDobleChica("DIRECCIÓN:", "", new float[] {13,87}));
        content.addCell(celdaDobleChica("REFERENCIA:", "", new float[] {15,85}));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getDatosCustodio() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(rellenoColor());
        content.addCell(celda("DATOS GENERALES DE QUIEN EJERCE LA CUSTODIA, TUTELA, Y CUIDADOS DEL NNyA", TITULO));
        content.addCell(celdaTriple(
                celdaDobleChica("NOMBRE:","", new float[] {10,40}),
                celdaDobleChica("EDAD:", "", new float[] {50,50}),
                celdaDobleChica("SEXO:", "", new float[] {50,50}),
                new float[] {60,20,20}
        ));
        content.addCell(celdaDobleChica("ESCOLARIDAD:", "", new float[] {16,84}));
        content.addCell(
                celdaDoble(
                        celdaDobleChica("RELACIÓN CON LA VÍCTIMA:", "", new float[] {60,40}),
                        celdaDobleChica("CORREO:", "", new float[] {20,80})
                )
        );
        content.addCell(celdaDoble(
                celdaDobleChica("TELÉFONO FIJO:", "", new float[] {35,65}),
                celdaDobleChica("TELÉFONO MÓVIL:", "", new float[] {38,62})
        ));
        content.addCell(celdaDobleChica("DIRECCIÓN:", "", new float[] {13,87}));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getDatosAgresores() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(rellenoColor());
        content.addCell(celda("DATOS DEL AGRESOR", TITULO));
        content.addCell(celdaTriple(
                celdaDobleChica("NOMBRE:","", new float[] {10,40}),
                celdaDobleChica("EDAD:", "", new float[] {50,50}),
                celdaDobleChica("SEXO:", "", new float[] {50,50}),
                new float[] {60,20,20}
        ));
        content.addCell(celdaDobleChica("ESCOLARIDAD:", "", new float[] {16,84}));
        content.addCell(
                celdaDoble(
                        celdaDobleChica("OCUPACIÓN:", "", new float[] {30,70}),
                        celdaDobleChica("LUGAR DE TRABAJO:", "", new float[] {45,55})
                )
        );
        content.addCell(
                celdaDoble(
                        celdaDobleChica("ESTADO CIVIL:", "", new float[] {35,65}),
                        celdaDobleChica("RELACIÓN CON LA VÍCTIMA:", "", new float[] {60,40})
                )
        );
        content.addCell(celdaTriple(
                celdaDobleChica("CORREO:", "", new float[] {35,65}),
                celdaDobleChica("TELÉFONO FIJO:", "", new float[] {55,45}),
                celdaDobleChica("TELÉFONO MÓVIL:", "", new float[] {55,45}),
                new float[] {33,33,34}
        ));
        content.addCell(celdaDobleChica("DIRECCIÓN:", "", new float[] {13,87}));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getClasificacion() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(rellenoColor());
        content.addCell(celda("CLASIFICACIÓN DE VULNERACIÓN DE DERECHOS", TITULO));
        for (int i = 0; i < LISTA_DE_DERECHOS.length; i++) {
            content.addCell(opcion(LISTA_DE_DERECHOS[i], true, new float[] {3, 97}));
        }
        content.addCell("\n \n ");
        content.addCell(celda());

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getResena() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(rellenoColor());
        content.addCell(celda("RESEÑA DE LA SITUACIÓN DE VULNERACIÓN O RESTRICCIÓN", TITULO));
        content.addCell(celda("", NORMAL_CHICA,Element.ALIGN_JUSTIFIED));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getObservaciones() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(rellenoColor());
        content.addCell(celda("OBSERVACIONES", TITULO));
        content.addCell(celda("", NORMAL_CHICA,Element.ALIGN_JUSTIFIED));

        content.addCell(firmaTrabajadorChica("NOMBRE", ""));
        content.setWidthPercentage(90);
        return content;
    }
}
