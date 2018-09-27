package Formatos;

import Informacion.InformacionNinoData;
import Informacion.PersonaData;
import Informacion.RecepcionReporteData;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static Design.Default.*;

public class RecepcionReportePDF {

    RecepcionReporteData data;

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

    public RecepcionReportePDF (String nombre_reporte, String url_reporte, RecepcionReporteData data) throws IOException, DocumentException {
        this.data = data;

        Document document = new Document(PageSize.A4, 30, 30, 30, (getFooter().getTotalHeight() + 25));
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(url_reporte + nombre_reporte + ".pdf"));
        pdfWriter.setPageEvent(new FooterTable(getFooter()));
        document.open();
        document.add(getHeader());
        document.add(getDatosRecepcion());
        document.add(getDatosDenunciante());
        document.add(getVictimas());
        document.add(getDatosCustodio());
        document.add(getDatosAgresores());
        document.add(getClasificacion());
        document.add(getResena());
        document.add(getObservaciones());
        document.close();
        pdfWriter.setPageEvent(new FooterTableCount());
        Desktop.getDesktop().open(new File(url_reporte + nombre_reporte + ".pdf"));
    }

    private PdfPTable getHeader() throws IOException, BadElementException {
        PdfPTable content = new PdfPTable(1);

        PdfPTable image = new PdfPTable(2);
        image.addCell(celda(createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("images/DIF_ESTATAL.png").toString(), 60, Element.ALIGN_LEFT)));
        image.addCell(celda(createImageHeight(AnexoUnoPDF.class.getClassLoader().getResource("images/GOBIERNO_ESTADO.png").toString(), 60, Element.ALIGN_RIGHT)));
        content.addCell(celda(image));
//        content.addCell(celda(5));
//        content.addCell(rellenoColor(1, HEXA_AZUL));
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

    private PdfPTable getFooter() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(celda());
        content.addCell(rellenoColor("EXPEDIENTE: " + data.getNo_expediente(), HEXA_ROSA));
        content.setTotalWidth(550);

        content.setWidthPercentage(100);
        return content;
    }

    private PdfPTable getDatosRecepcion () throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(celda("DATOS DE RECEPCIÓN DE REPORTE.", TITULO));
        content.addCell(celdaDoble(
                celda(" ", NORMAL_CHICA),
                celdaDoble(
                        celda("No. EXPEDIENTE:", TITULO_CHICA, Element.ALIGN_RIGHT),
                        celda(data.getNo_expediente(), NORMAL_CHICA, Element.ALIGN_RIGHT)
                ),
                new float[] {53,48}));

        content.addCell(celdaDoble(
                celda(" ", NORMAL_CHICA),
                celdaDoble(
                        celda("No. FOLIO:", TITULO_CHICA, Element.ALIGN_RIGHT),
                        celda(data.getFolio(), NORMAL_CHICA, Element.ALIGN_RIGHT),
                        new float[] {70,30}
                ),
                new float[] {85,25}));

        content.addCell(celdaDoble(
                celda(" ", NORMAL_CHICA),
                celdaDoble(
                        celda("FECHA:", TITULO_CHICA, Element.ALIGN_RIGHT),
                        celda(data.getFecha() + " - " + data.getHora(), NORMAL_CHICA, Element.ALIGN_RIGHT)
                ),
                new float[] {53,48}));

        content.addCell(
                celdaDoble(
                        celdaDobleChica("RECIBIÓ:", data.getRecibio(), new float[] {20, 80}),
                        celdaDobleChica("No. OFICIO:", data.getNo_oficio(), new float[] {31, 69})
                ));
        content.addCell(
                celdaDoble(
                        celdaDobleChica("FECHA OFICIO:", data.getFehca_oficio(), new float[] {31, 69}),
                        celdaDobleChica("QUIÉN ENVÍA:", data.getQuien_envia(), new float[] {31, 69})
        ));

        PdfPTable anonimo = new PdfPTable(3);
        anonimo.addCell(opcion("Anonimo", data.getAnonimato()[0]));
        anonimo.addCell(opcion("Público", data.getAnonimato()[1]));
        anonimo.addCell(opcion("Privado", data.getAnonimato()[2]));
        anonimo.setWidthPercentage(100);
        content.addCell(celdaDobleChica("ANONIMATO:", celda(anonimo), new float[] {21, 79}));

        PdfPTable medio = new PdfPTable(4);
        medio.addCell(opcion("Directa",       data.getMedio_reporte()[0], new float[]{25,85}));
        medio.addCell(opcion("Vía telefonica",data.getMedio_reporte()[1], new float[]{15,85}));
        medio.addCell(opcion("Escrita",       data.getMedio_reporte()[2], new float[]{25,85}));
        medio.addCell(opcion("Personal",      data.getMedio_reporte()[3], new float[]{25,85}));
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
                        celdaDobleChica("NOMBRE:", data.getDenunciante().getNombre(), new float[] {25, 75}),
                        celdaDoble(
                                    opcion("PERSONA FÍSICA", data.isEstado_denunciante()),
                                    opcion("PERSONA MORAL", !data.isEstado_denunciante())
                                ),
                        new float[] {45, 65}));

        // PREGUNTAR RELACION O PARENTESCO
        content.addCell(
                celdaTriple(
                        celdaDobleChica("EDAD:", data.getDenunciante().getEdad(), new float[] {50, 50}),
                        celdaDobleChica(celda("SEXO:", TITULO_CHICA, Element.ALIGN_RIGHT), data.getDenunciante().getSexo(), new float[] {40, 60}),
                        celdaDobleChica("ESCOLARIDAD:",data.getDenunciante().getEscolaridad(), new float[] {26, 74}),
                        new float[] {15,25,60}
                )
        );
//        content.addCell(celdaDobleChica("DOMICILIO:", "CALLE " + " #" + " C.P.", new float[] {12, 83}));
        content.addCell(celdaDoble(
                celdaDobleChica("RELACIÓN CON LA VÍCTIMA: ", data.getDenunciante().getRelacion_victima(), new float[] {75,25}),
                celdaDobleChica("DOMICILIO:", data.getDenunciante().getDireccion(), new float[] {20, 80}),
                new float[] {40,60}
        ));
        content.addCell(celdaDoble(
                celdaDobleChica("TELÉFONO FIJO:", data.getDenunciante().getTelefono(), new float[] {35,65}),
                celdaDobleChica("TELÉFONO MÓVIL:", data.getDenunciante().getCelular(), new float[] {38,62})
        ));
        content.addCell(celdaDoble(
                celdaDobleChica("MUNICIPIO:", data.getDenunciante().getMunicipio(), new float[] {22,68}),
                celdaDobleChica("CORREO:", data.getDenunciante().getCorreo(), new float[] {19,71})
        ));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getVictimas() throws DocumentException {
        PdfPTable content = new PdfPTable(1);
        content.addCell(rellenoColor());
        content.addCell(celda("DATOS DE LA" + ((data.getVictima().size() > 0)? "S":"") + " VICTIMA" + ((data.getVictima().size() > 0)? "S":""), TITULO));
        for (InformacionNinoData victima : data.getVictima()) {
            content.addCell(celdaTriple(
                    celdaDobleChica("NOMBRE:",victima.getNombre_completo(), new float[] {10,40}),
                    celdaDobleChica("EDAD:", victima.getEdad(), new float[] {50,50}),
                    celdaDobleChica("SEXO:", victima.getSexo(), new float[] {50,50}),
                    new float[] {60,20,20}
            ));
            content.addCell(celdaDobleChica("ESCOLARIDAD:", victima.getEscolaridad(), new float[] {16,84}));
            content.addCell(
                    celdaDoble(
                            celdaDobleChica("RELACIÓN CON EL AGRESOR:", victima.getRelacion_agresor(), new float[] {60,40}),
                            celdaDobleChica("CORREO:", victima.getCorreo(), new float[] {20,80})
                    )
            );
            content.addCell(celdaDoble(
                    celdaDobleChica("TELÉFONO FIJO:", victima.getTelefono(), new float[] {35,65}),
                    celdaDobleChica("TELÉFONO MÓVIL:", victima.getCelular(), new float[] {38,62})
            ));
        }
        content.addCell(celdaDobleChica("DIRECCIÓN:", (data.getVictima().size() > 0)? data.getVictima().get(0).getDomicilio(): "", new float[] {13,87}));
        content.addCell(celdaDobleChica("REFERENCIA:",(data.getVictima().size() > 0)? data.getVictima().get(0).getReferencia(): "", new float[] {15,85}));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getDatosCustodio() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(rellenoColor());
        content.addCell(celda("DATOS GENERALES DE QUIEN EJERCE LA CUSTODIA, TUTELA, Y CUIDADOS DEL NNyA", TITULO));
        content.addCell(celdaTriple(
                celdaDobleChica("NOMBRE:",data.getCustodio().getNombre(), new float[] {10,40}),
                celdaDobleChica("EDAD:", data.getCustodio().getEdad(), new float[] {50,50}),
                celdaDobleChica("SEXO:", data.getCustodio().getSexo(), new float[] {50,50}),
                new float[] {60,20,20}
        ));
        content.addCell(celdaDobleChica("ESCOLARIDAD:", data.getCustodio().getEscolaridad(), new float[] {16,84}));
        content.addCell(
                celdaDoble(
                        celdaDobleChica("RELACIÓN CON LA VÍCTIMA:", data.getCustodio().getRelacion_victima(), new float[] {60,40}),
                        celdaDobleChica("CORREO:", data.getCustodio().getCorreo(), new float[] {20,80})
                )
        );
        content.addCell(celdaDoble(
                celdaDobleChica("TELÉFONO FIJO:", data.getCustodio().getTelefono(), new float[] {35,65}),
                celdaDobleChica("TELÉFONO MÓVIL:", data.getCustodio().getCelular(), new float[] {38,62})
        ));
        content.addCell(celdaDobleChica("DIRECCIÓN:", data.getCustodio().getDireccion(), new float[] {13,87}));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getDatosAgresores() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(rellenoColor());
        content.addCell(celda((data.getAgresor().size() > 1)? "DATOS DE LOS AGRESORES": "DATOS DEL AGRESOR", TITULO));
        for (PersonaData agresor : data.getAgresor()) {
            content.addCell(celdaTriple(
                    celdaDobleChica("NOMBRE:",agresor.getNombre(), new float[] {10,40}),
                    celdaDobleChica("EDAD:", agresor.getEdad(), new float[] {50,50}),
                    celdaDobleChica("SEXO:", agresor.getSexo(), new float[] {50,50}),
                    new float[] {60,20,20}
            ));
            content.addCell(celdaDobleChica("ESCOLARIDAD:", agresor.getEscolaridad(), new float[] {16,84}));
            content.addCell(
                    celdaDoble(
                            celdaDobleChica("OCUPACIÓN:", agresor.getOcupacion(), new float[] {30,70}),
                            celdaDobleChica("LUGAR DE TRABAJO:", agresor.getTrabajo(), new float[] {45,55})
                    )
            );
            content.addCell(
                    celdaDoble(
                            celdaDobleChica("RELACIÓN CON LA VÍCTIMA:", agresor.getRelacion_victima(), new float[] {60,40}),
                            celdaDobleChica("ESTADO CIVIL:", agresor.getEstado_civil(), new float[] {35,65})
                    )
            );
            content.addCell(celdaTriple(
                    celdaDobleChica("CORREO:", agresor.getCorreo(), new float[] {35,65}),
                    celdaDobleChica("TELÉFONO FIJO:", agresor.getTelefono(), new float[] {55,45}),
                    celdaDobleChica("TELÉFONO MÓVIL:", agresor.getCelular(), new float[] {55,45}),
                    new float[] {33,33,34}
            ));
            content.addCell(celdaDobleChica("DIRECCIÓN:", agresor.getDireccion(), new float[] {13,87}));
        }

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getClasificacion() throws DocumentException {
        PdfPTable content = new PdfPTable(1);

        content.addCell(rellenoColor());
        content.addCell(celda("CLASIFICACIÓN DE VULNERACIÓN DE DERECHOS", TITULO));
        for (int i = 0; i < LISTA_DE_DERECHOS.length; i++) {
            if (data.getDerechos()[i]){
                content.addCell(opcion(LISTA_DE_DERECHOS[i], true, new float[] {3, 97}));
            }
        }
        content.addCell(data.getDerechos_otro());
        content.addCell(celda());

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getResena() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(rellenoColor());
        content.addCell(celda("RESEÑA DE LA SITUACIÓN DE VULNERACIÓN O RESTRICCIÓN", TITULO));
        content.addCell(celda(data.getResena(), NORMAL_CHICA,Element.ALIGN_JUSTIFIED));

        content.setWidthPercentage(90);
        return content;
    }

    private PdfPTable getObservaciones() {
        PdfPTable content = new PdfPTable(1);

        content.addCell(rellenoColor());
        content.addCell(celda("OBSERVACIONES", TITULO));
        content.addCell(celda(data.getObservaciones(), NORMAL_CHICA,Element.ALIGN_JUSTIFIED));

        content.addCell(firmaTrabajadorChica(data.getFirma(), ""));
        content.setWidthPercentage(90);
        return content;
    }
}
