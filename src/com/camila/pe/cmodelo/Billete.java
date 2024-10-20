
package com.camila.pe.cmodelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Billete {
    private String nro_billete;
    private Date fecha;
    private String hora;
    private String Destino;
    private String Origen;
    private String Itinerario;
    private String DNI;
    private String nro_compañia;

    public String getNro_billete() {
        return nro_billete;
    }

    public void setNro_billete(String nro_billete) {
        this.nro_billete = nro_billete;
    }


    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public String getItinerario() {
        return Itinerario;
    }

    public void setItinerario(String Itinerario) {
        this.Itinerario = Itinerario;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNro_compañia() {
        return nro_compañia;
    }

    public void setNro_compañia(String nro_compañia) {
        this.nro_compañia = nro_compañia;
    }
     public String getFecha() {
        
        SimpleDateFormat dateformat  = new SimpleDateFormat("dd-MM-yyyy");
        return dateformat.format(fecha) ;
    }

    public void setFecha(String fecha)throws ParseException {
        
        SimpleDateFormat dateFormat  = new SimpleDateFormat("dd-MM-yyyy");
        this.fecha = dateFormat.parse(fecha);
    }
}
