package Informacion;

import org.omg.CORBA.TRANSACTION_MODE;

public class TarjetaInformativaData {
    TrabajadorData trabajador_remitente = new TrabajadorData();
    TrabajadorData trabajador_receptor = new TrabajadorData();
    DireccionCasaData direccion = new DireccionCasaData();

    String texto = "";

    public TarjetaInformativaData() {
    }

    public TarjetaInformativaData(TrabajadorData trabajador_remitente, TrabajadorData trabajador_receptor, DireccionCasaData direccion, String texto) {
        this.trabajador_remitente = trabajador_remitente;
        this.trabajador_receptor = trabajador_receptor;
        this.direccion = direccion;
        this.texto = texto;
    }

    public TrabajadorData getTrabajador_remitente() {
        return trabajador_remitente;
    }

    public void setTrabajador_remitente(TrabajadorData trabajador_remitente) {
        this.trabajador_remitente = trabajador_remitente;
    }

    public TrabajadorData getTrabajador_receptor() {
        return trabajador_receptor;
    }

    public void setTrabajador_receptor(TrabajadorData trabajador_receptor) {
        this.trabajador_receptor = trabajador_receptor;
    }

    public DireccionCasaData getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionCasaData direccion) {
        this.direccion = direccion;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
