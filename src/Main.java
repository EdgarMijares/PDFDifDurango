import Formatos.*;
import Formatos.Estadisticas.*;
import Informacion.*;
import com.itextpdf.text.DocumentException;
import org.omg.CORBA.TRANSACTION_MODE;
import sun.awt.geom.AreaOp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    public static void main(String[] a){
        // INRMACION TRABAJADOR
        TrabajadorData trabajador = new TrabajadorData("Psic. Karla Yadira Valenzuela Hernández", "Psicóloga de Casa Hogar", "8383815");
        DireccionCasaData direccion = new DireccionCasaData("Av del Hierro esquina con Av. Estaño s/n Fracc. Fidel Velasquez", "Durango Dgo Tel: 814-69-31 y 814-25-23");
        // RESUMEN PSICOLOGICO
        ResumenPsicologicoData resumenPsicologico = new ResumenPsicologicoData();
        resumenPsicologico.setNo_registro("DIF/PPNNA-040-019/2018");
        resumenPsicologico.setNombre_victima("Camila Bejarano Castrellón");
        resumenPsicologico.setSexo("Femenino");
        resumenPsicologico.setEdad("12 años");
        resumenPsicologico.setFecha_ingreso("04 de Abril de 2016");
        resumenPsicologico.setMotivo_ingreso("Omisión de cuidados");
        resumenPsicologico.setDescripcion(
                "Camila ingresa a casa hogar junto a sus hermanos Marcos Pablo y David. " +
                "Camila muestra rasgos de sensibilidad defensiva, inseguridad emocional, rigidez, " +
                "tensión y ansiedad.\n\n" +
                "A su ingreso se observa tímida, insegura, introvertida, retraída, pensativa, " +
                "poniendo resistencia a establecer contacto social ante su rigidez.\n\n" +
                "Camila es dependiente y con marcadas carencias de afecto de sus figuras " +
                "primarias por lo que es necesario darle a conocer que tiene los recursos " +
                "necesarios para obtener satisfacciones del medio ambiente, fortaleciendo valores " +
                "y elevando su autoestima.\n\n" +
                "Es una niña dedicada en su escuela, noble y aprensiva con sus hermanos " +
                "menores con los que se observa un vínculo fuerte.\n\n" +
                "Es consciente de su situación actual, reflexiva y abierta a la posibilidad de una " +
                "adopción siempre y cuando sea junto a sus hermanos.\n\n" +
                "La sesión es semanal, basada en la terapia cognitivo conductual y terapia breve.");

        resumenPsicologico.setTrabajador(trabajador);
        resumenPsicologico.setDireccion(direccion);

        // INFORME CLINICO
        InformeClinicoData informeClinicoData = new InformeClinicoData();
        informeClinicoData.setNo_registro("DIF/PPNNA-040-019/2018");
        informeClinicoData.setFecha("09/07/218");
        informeClinicoData.setNombre_victima("Luz Angélica Alanís Flores.");
        informeClinicoData.setEdad("13");
        informeClinicoData.setSexo("Femenino");
        informeClinicoData.setFecha_nacimiento("15 de juinio de 2004");
        informeClinicoData.setFecha_ingreso("09 de Diciembre del 2016");
        informeClinicoData.setLugar_nacimiento("Durango, Dgo.");
        informeClinicoData.setEscolaridad("6 año de primaria");
        informeClinicoData.setMotivo_ingreso("Angélica ingresa a Casa Hogar por omisión");

        informeClinicoData.setPerfil_clinico(new String[] {
                "Observación clinica",
                "Sesiones de terapia individual",
                "Entrevista con las cuidadoras",
                "Test del HTP",
                "Test de Persona Bajo la Lluvia"
        });

        informeClinicoData.setAntecendetes("A.ngéli ca es la menor de cuatro hermanas, su padre fallece sin recordar ya que refiere era muy " +
                "pequeña y su madre cuando ella tenía 7 años, desde ese momento quedaa cargo de sus tres " +
                "hermanas las cuales se la turnaban, por lo que un año atrás su hermana menor va y la deja a " +
                "cargo de un señor que le dijo a la niña era su padre biológico, del cual recibía maltrato fisico " +
                "y psicológico, por lo que opta por pedirle ayuda y refugiarse con su maestra de primaria la " +
                "cual la canaliza a grupo Esmeralda.");
        informeClinicoData.setDescripcion_victima("Mujer de 13 años, con apariencia física correspondiente a la edad cronológica, de tez moreno " +
                "clara, ojos grandes, color miel, estatura media y complexión media, cabello castaño claro al " +
                "hombro, viste acorde a su edad, en adecuadas condiciones de higiene y aliño personal.");
        informeClinicoData.setExamen_mental("No se detectaron dificultades visibles en la marcha, sus posturas corporales pueden " +
                "describirse como espontaneas. No presenta alteraciones en su pensamiento, con buen " +
                "reconocimiento e identificación de figuras, orientada en tiempo, espacio y persona.\n\n" +
                "Su actitud ante la entrevista fue de disposición, acatan.do las indicaciones.");
        informeClinicoData.setResultado_evaluacion("En base a la observación del usuario evaluado, entrevistas con cuidadoras y la interpretación " +
                "de las pruebas aplicadas arroja lo siguiente.\n\n" +
                "Se observan rasgos de depresión, inseguridad, sentimientos de inadecuación y ambivalencia " +
                "social, percibe el ambiente restrictivo con marcada tensión.\n\n" +
                "Manifiesta rasgos de personalidad apegado a lo concreto, fuerte tendencia instintiva y " +
                "agresividad. Temor a insertarse en el mundo de los adultos.\n\n" +
                "Dificultad en las introyecciones adecuadas, conflicto en el esquema corporal, fachada de " +
                "seguridad como compensación a sus sentimientos de inseguridad o inadaptación " +
                "mostrándose dominantemente autoritaria, deseo de sobresalir y de mejorar.\n\n" +
                "Utiliza como mecanismo de defensa el aislamiento.\n\n" +
                "En Casa Hogar su comportamiento en la villa es predominante ante sus compañeras, adopta " +
                "una postura de líder dado su edad, lo que le permite sentirse con autoridad, abusar de las más " +
                "pequeñas o insultar a compañeras nuevas que no son de su agrado.\n\n" +
                "Por las características propias de su edad ocasionalmente se muestra rebelde y retadora con " +
                "las figuras de autoridad, así como la tendencia a la manipulación para obtener ganancia " +
                "secundaria, derivado de esta conducta es por la razón que Angélica es ingresada a Casa " +
                "Hogar, ya a referencia de ella misma no obedecía las indicaciones y la mayor parte del tiempo " +
                "estaba fuera deElement la casa, llegando a altas horas de la noche, tanto con sus hermanas como con " +
                "su supuesto padre.\n\n" +
                "En las últimas semanas ha manifestado constantemente su necesidad por reintegrarse con su " +
                "familia, por lo que actualmente se encuentra abierta a la posibilidad de la opción que " +
                "representa la \"Sra. Chelo\". Aunado al aumento de angustia y ansiedad ha presentado la " +
                "conducta del cuting, que si bien se considera moderada es un signo de alarma a su estabilidad " +
                "emocional que había manifestado con anterioridad.\n\n" +
                "En su proceso es cooperadora, consiente de su situación actual se muestra reflexiva, dado " +
                "que no existe el interés ni la intención de las hermanas de hacerse cargo de ella , se " +
                "recomiendan las visitas de la Sra. Consuelo Villalobos para ir fortaleciendo el vínculo de " +
                "amistad establecido previamente.");
        informeClinicoData.setDescripcion_recomencion("De acuerdo a los datos arrojados durante la evaluación correspondiente, son las siguientes:");
        informeClinicoData.setPuntos_recomencion(new String[] {
                "Se recomienda seguir fortaleciendo la adquisición de hábitos, límites y reglas para buscar la plena integración con su medio ambiente",
                "Centrarse en su proyecto de vida que le permita obtener las herramientas para desarrollarse fuera de Casa Hogar en un futuro próximo",
                "Trabajar con la expresión y manejo adecuado de las emociones",
                "Continuar con un proceso de psicoterapia que le ayude a proporcionar una estructura, seguridad y confianza que necesita"
        });

        informeClinicoData.setTrabajador(trabajador);
        informeClinicoData.setDireccion(direccion);

        // LIBERACION DE CUSTODIA
        LiberacionDeCustodiaData liberacionDeCustodia = new LiberacionDeCustodiaData();
        liberacionDeCustodia.setHora(Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" + Calendar.getInstance().get(Calendar.MINUTE));
        liberacionDeCustodia.setDia(String.valueOf(Calendar.getInstance().get(Calendar.DATE)));
        liberacionDeCustodia.setMes(Calendar.getInstance().get(Calendar.MONTH));
        liberacionDeCustodia.setAno(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        liberacionDeCustodia.setDireccion("PRIB. BILBAO #111 FRACC. ARANTZAZU");
        liberacionDeCustodia.setCoordinador("M.T.G FLOR MARÍA BERMÚDEZ MEJÍA");
        liberacionDeCustodia.setVictima("MARÍA TERESA GRAClANO MARTINEZ");
        liberacionDeCustodia.setResponsable("C. ALEJANDRO GRACIANO ARREGLA");
        liberacionDeCustodia.setParentesco("PADRE");
        liberacionDeCustodia.setDomicilio("C. SIN NOMBRE SIN COL. BAJÍO DORADO C P. 34046");
        liberacionDeCustodia.setTelefono("618 268 51 25");
        liberacionDeCustodia.setIne("GRARAL75102010H901");

        liberacionDeCustodia.setTrabajador(trabajador);
        liberacionDeCustodia.setDireccion_casa(direccion);

        // TARJETA INFORMATIVA
        TarjetaInformativaData tarjetaInformativa = new TarjetaInformativaData();
        tarjetaInformativa.setTexto("Por este medio rindo informe de llamada telefónica hecha a solicitud de la" +
                "adolescente María Teresa Graciano Martínez, la cual fue autorizada por su" +
                "abogado el Lic. Octavio Campa Duarte, toda vez qué ésta se llevara a" +
                "cabo bajo supervisión y vigilancia de trabajo social.\n\n" +
                "La persona contactada responde al nombre de Luz Elena Holguín Sarabia" +
                "con número de teléfono celular 6181 686993, quien responde y acepta la" +
                "llamada, afirma ser la persona en cuestión y conocer a la adolescente." +
                "En un lapso de aproximadamente 5 minutos Teresa saluda a su pariente," +
                "preguntando como estaba y solicitándole la reciba de nuevo en su hogar" +
                "así como pidiendo disculpas por lo sucedido en el pasado, le pide que se" +
                "haga responsable de ella, como la persona estaba trabajando fue muy" +
                "breve y la adolescente se despidió agradeciendo la llamada, posterior o" +
                "esto cuelga. Realice nuevamente llamada para pedir información y" +
                "preguntar si podría recibir visita de trabajo social, esto bajo sugerencia del" +
                "abogado y trámite solicitado por Teresa.\n\n" +
                "Sin más por el momento quedo a sus órdenes, para cualquier duda o  " +
                "comentario al respecto. ");

        TrabajadorData receptor = new TrabajadorData();
        receptor.setNombre("M.P.G. FLOR MARIA BERMUDEZ MEJIA");
        receptor.setCargo("COORDINADOR");

        tarjetaInformativa.setTrabajador_remitente(trabajador);
        tarjetaInformativa.setTrabajador_receptor(receptor);
        tarjetaInformativa.setDireccion(direccion);

        // ANEXO UNO
        AnexoUnoData anexoUnoData = new AnexoUnoData();

        ArrayList<Familia> lista_familia = new ArrayList<>();
        // AQUÍ CREO QUE TIENEN UN ARRAY LIST SOLO LO PASAN COMO PARAMETRO DIRECTO A FAMILIA
        Familia familia = new Familia("Nanci Yutzelly", "Valles", "Cejas", "Hermanastra");
        Familia familia2 = new Familia("Nanci Yutzelly", "Valles", "Cejas", "Hermanastra");
        lista_familia.add(familia);
        lista_familia.add(familia2);
        anexoUnoData.setFamilia(lista_familia);

        // RECEPCION REPORTE
        RecepcionReporteData recepcionReporteData = new RecepcionReporteData();
        recepcionReporteData.setEstado_denunciante(false);

        //Estadisticas Data
        ArrayList<String> derecha = new ArrayList<>();
        ArrayList<String> izquierda = new ArrayList<>();

        ArrayList<String> derecha2 = new ArrayList<>();
        ArrayList<String> izquierda2 = new ArrayList<>();

        for (int i = 1; i <= 5; i++){
            izquierda.add("Dato " + i);
            derecha.add(String.valueOf(Math.random() * 10 + 1));
        }

        for (int i = 1; i <= 5; i++){
            izquierda2.add("Dato " + (i + 5));
            derecha2.add(String.valueOf(Math.random() * 10 + 1));
        }

        TablaEstadisticasData tablaEstadisticasData = new TablaEstadisticasData();
        tablaEstadisticasData.setTitulo("Tabla 1");
        tablaEstadisticasData.setColumna_derecha(derecha);
        tablaEstadisticasData.setColumna_izquierda(izquierda);

        TablaEstadisticasData tablaEstadisticasData2 = new TablaEstadisticasData();
        tablaEstadisticasData2.setTitulo("Tabla 2");
        tablaEstadisticasData2.setColumna_derecha(derecha2);
        tablaEstadisticasData2.setColumna_izquierda(izquierda2);

        ArrayList<TablaEstadisticasData> arrayTabalaEstadisticaData = new ArrayList<>();
        arrayTabalaEstadisticaData.add(tablaEstadisticasData);
        arrayTabalaEstadisticaData.add(tablaEstadisticasData2);

        EstadisticasData estadisticasData = new EstadisticasData("PERIODO", "TRABAJADOR", arrayTabalaEstadisticaData);

        // TRABAJO SOCIAL
        TrabajoSocialData data = new TrabajoSocialData();
        data.setFolio("12345");
        data.setNo_expediente("DIF/PPNNA-040-019/2018");
        data.setFecha(
                Calendar.getInstance().get(Calendar.DATE) + "/" +
                        (Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" +
                        Calendar.getInstance().get(Calendar.YEAR));
        data.setHora(
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" +
                        Calendar.getInstance().get(Calendar.MINUTE) + ":" +
                        Calendar.getInstance().get(Calendar.SECOND));

        // INFORMACION NINO
        ArrayList<InformacionNinoData> lista_nino = new ArrayList<>();
        InformacionNinoData nino = new InformacionNinoData();
        nino.setNombre("Edgar Cipriano Mijares Cejas");
        nino.setEdad("23");
        nino.setFecha_nacimiento("06/08/1994");
        nino.setLugar_nacimiento("Durango Durango MX");
        nino.setNacionalidad("Mexicana");
        nino.setSexo("Masculino");
        nino.setIdioma("Español");
        nino.setEtnia("");
        nino.setReligion("Catolico");
        nino.setDiscapacidad(false);
        nino.setTipo_discapacidad("");
        nino.setEscolaridad("Tecnico informatico");
        nino.setDomicilio("Fraccionamiento Arantzazu Privada Bilbao #111");
        lista_nino.add(nino);

        data.setInformacionNinoData(lista_nino);

        // INFORMACION TUTOR
        data.setNombre_tutor("Cipriano Mijares Chavarria");
        data.setEdad_tutor("42");
        data.setParentesco("Padre");
        data.setEstado_civil("Casado");
        data.setTelefono("+52 618 157 18 96");
        data.setIdioma_tutor("Español");
        data.setEtnia_tutor("");
        data.setReligion_tutor("Catolico");
        data.setDiscapacidad_tutor(false);
        data.setEscolaridad_tutor("");
        data.setDomicilio_tutor("Fraccionamiento Arantzazu Privada Bilbao #111");

        // INFORMACION
        data.setValoracion(0);
        data.setTecnicas(new boolean[]{true, true, false, false});

        // INFORMACION FAMILIA
        ArrayList<Familia> lista_familia2 = new ArrayList<>();
        // AQUÍ CREO QUE TIENEN UN ARRAY LIST SOLO LO PASAN COMO PARAMETRO DIRECTO A FAMILIA

        Familia familia3 = new Familia(
                "Nanci Yutzelly",
                "Valles",
                "Cejas",
                "Hermanastra",
                "28",
                "F",
                "Soltero",
                "Lic. Odontologo",
                "Odontologo");

        lista_familia2.add(familia3);
        data.setFamilia(lista_familia2);

        data.setDinamica_familiar("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took" +
                " a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries," +
                " but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the " +
                "1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop " +
                "publishing software like Aldus PageMaker including versions of Lorem Ipsum");

        data.setFamiliograma("http://www.gabrielcastro.com/wordpress/wp-content/uploads/2009/11/genograma_v05.jpg");

        // INFORMACION ECONOMICA
        data.setIngresos_padre(2500.00);
        data.setIngresos_madre(2500.00);
        data.setIngresos_hermano(2500.00);
        data.setIngresos_otros(2500.00);

        data.setEgresos_alimentacion(2500.00);
        data.setEgresos_educacion(2500.00);
        data.setEgresos_salud(2500.00);
        data.setEgresos_vestido(2500.00);
        data.setEgresos_servicios(2500.00);
        data.setEgresos_transporte(2500.00);
        data.setEgresos_renta(2500.00);

        // INFORMACION VIVIENDA
        data.setVivienda(2);
        data.setTipo_vivienda(0);
        data.setZona_vivienda(1);
        data.setDistribucion(new boolean[] {true, true, true, true});
        data.setHabitaciones(new String[] {"1", "1", "1"});
        data.setMaterial_piso(new boolean[] {false, true, false, false});
        data.setMaterial_piso_otro("Vitropiso");
        data.setMaterial_muros(new boolean[] {false, false, true, false});
        data.setMaterial_muros_otro("");
        data.setMaterial_techo(new boolean[] {true, true, false, true});
        data.setMaterial_techo_otro("");
        data.setServicios_publicos(new boolean[] {true, true, true, true, true, false});

        data.setDescripcion_problematica(
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a " +
                        "piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor " +
                        "at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum " );

        data.setEntrevista_nino(
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a " +
                        "piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor " +
                        "at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum " +
                        "passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum " +
                        "comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, " +
                        "written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of " +
                        "Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n");

        data.setDiagnostico_social(
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a " +
                        "piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor " +
                        "at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum " +
                        "passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum " +
                        "comes from sections 1.10.32 and 1.10.33 of ");

        data.setPlan_de_accion(
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a " +
                        "piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor " +
                        "at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum " +
                        "passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum " +
                        "comes from sections 1.10.32 and 1.10.33 of");

        data.setObservaciones(
                "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a ");

        data.setTrabajador_social("Edgar Cipriano Mijares Cejas");

        //ESTADISTICA TRABAJO SOCIAL
        EstadisticaTrabajoSocialData estadisticaTrabajoSocialData = new EstadisticaTrabajoSocialData();
        estadisticaTrabajoSocialData.setDatos_mpales(new String[] {"1", "2", "3", "4", "5","6"});
        estadisticaTrabajoSocialData.setDatos_pmnna(new String[] {"1", "2", "3", "4", "5", "6"});

        estadisticaTrabajoSocialData.setDatos_primera_t2(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        estadisticaTrabajoSocialData.setDatos_segunda_t2(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        estadisticaTrabajoSocialData.setDatos_tercera_t2(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"});

        estadisticaTrabajoSocialData.setDatos_primera_t3(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        estadisticaTrabajoSocialData.setDatos_segunda_t3(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        estadisticaTrabajoSocialData.setDatos_tercera_t3(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"});

        estadisticaTrabajoSocialData.setDatos_involucrados_hombre(new String[] {"1", "2"});
        estadisticaTrabajoSocialData.setDatos_involucrados_mujer(new String[] {"1", "2"});
        estadisticaTrabajoSocialData.setDatos_involucrados_desconocido(new String[] {"1", "2"});

        // VULNERACIONES
        EstadisticaVulneracionesData d1 = new EstadisticaVulneracionesData(
                "vulneracion 1",
                "1","2","3",
                "1","2","3");
        ArrayList<EstadisticaVulneracionesData> vulneraciones = new ArrayList<>();
        vulneraciones.add(d1);
        estadisticaTrabajoSocialData.setVulneraciones(vulneraciones);

        // EXPEDIENTES
        ArrayList<EstadisticaExpendientesData> expedientes = new ArrayList<>();
        EstadisticaExpendientesData epe1 = new EstadisticaExpendientesData(
                "Nombre asesor", "1", "1", "1", "1",
                "1", "2", "1", "1"
        );
        expedientes.add(epe1);
        estadisticaTrabajoSocialData.setExpendientesData(expedientes);

        // REPORTES MUNICIOPIO
        ArrayList<ReportesMunicipiosData> municipio = new ArrayList<>();
        ReportesMunicipiosData mun1 = new ReportesMunicipiosData(
                "Durango", "1", "1", "1"
        );
        municipio.add(mun1);
        estadisticaTrabajoSocialData.setMunicipiosData(municipio);

        try {
//            new ResumenPsicologicoPDF("RESUMEN_PSICOLOGICO","F:\\Downloads\\DIF\\", 0, resumenPsicologico);
//            new InformeClinicoPDF("INFORME_CLINICO","F:\\Downloads\\DIF\\", 0, informeClinicoData);
//            new LiberacionCustodiaPDF("LIBERACION_CUSTODIA","F:\\Downloads\\DIF\\", 0, liberacionDeCustodia);
//            new TarjetaInformativaPDF("TARJETA_INFORMATIVA","F:\\Downloads\\DIF\\", 0, tarjetaInformativa);
//            new AnexoUnoPDF("ANEXO_UNO", "F:\\Downloads\\DIF\\", anexoUnoData);
//            new RecepcionReportePDF("RECEPCION_REPORTE", "F:\\Downloads\\DIF\\", recepcionReporteData);
//            new EstadisticasPDF("RECEPCION_REPORTE", "F:\\Downloads\\DIF\\", estadisticasData);
//            new TrabajoSocialPDF("ANEXO_DOS", "F:\\Downloads\\DIF\\", data);
//            new EstadisticaTrabajoSocialPDF("ESTADISTICAS_TRABAJO_SOCIAL", "F:\\Downloads\\DIF\\",estadisticaTrabajoSocialData, "Periodo: 10/10/1994 - 11/10/1994", new TrabajadorData("Nombre"));
//            new InvolucradosPDF("INVOLUCRADOS_EXPEDIENTE", "F:\\Downloads\\DIF\\", new InvolucradosData());
//            new EstadisticaInvolucradosPDF("ESTADISTICAS_INVOLUCRADOS", "F:\\Downloads\\DIF\\", estadisticaTrabajoSocialData, "Periodo: 10/10/1994 - 11/10/1994", new TrabajadorData("Nombre"));
//            new EstadisticaAsistenciaSocialPDF("ESTADISTICAS_ASISTENCIA_SOCIAL", "F:\\Downloads\\DIF\\", estadisticaTrabajoSocialData, "Periodo: 10/10/1994 - 11/10/1994", new TrabajadorData("Nombre"));
//            new EstadisticaVulneracionesPDF("ESTADISTICAS_VULNERACIONES", "F:\\Downloads\\DIF\\", estadisticaTrabajoSocialData, "Periodo: 10/10/1994 - 11/10/1994", new TrabajadorData("Nombre"));
            new EstadisticaExpedientesPDF("ESTADISTICAS_EXPEDIETNES", "F:\\Downloads\\DIF\\", estadisticaTrabajoSocialData,
                    "Primer periodo: 10/10/1994 - 11/10/1994", "Segundo periodo: 10/10/1994 - 11/10/1994", new TrabajadorData("Nombre"));
//            new ReportesMunicipiosPDF("REPORTE_MUNICIPIO", "F:\\Downloads\\DIF\\", estadisticaTrabajoSocialData, "Periodo: 10/10/1994 - 11/10/1994", new TrabajadorData("Nombre"));
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
