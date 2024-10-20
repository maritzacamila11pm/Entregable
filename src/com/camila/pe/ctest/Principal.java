
package com.camila.pe.ctest;
import com.camila.pe.cmodelo.Billete;
import com.camila.pe.cmodelo.Cliente;
import com.camila.pe.cmodelo.Compañia;
import com.camila.pe.cnegocio.BilleteBO;
import com.camila.pe.cnegocio.ClienteBO;
import com.camila.pe.cnegocio.CompañiaBO;
import java.sql.SQLException;
import java.text.ParseException;

public class Principal {
    ClienteBO tdbo = new  ClienteBO();
    Cliente td = new Cliente();
    CompañiaBO cpbo = new CompañiaBO();
    Compañia cp = new Compañia();
    BilleteBO btbo = new BilleteBO();
    Billete b = new Billete();
    
    public  void insertar() throws SQLException, ParseException{
        td.setDNI("73646183");
        td.setNombre("Maria");
        td.setTelefono("910380665");
        td.setDireccion("Puno");

        tdbo.agregarCliente(td);
    }
    
    public  void eliminar() throws SQLException, ParseException{
        td.setDNI("73646183");
        tdbo.eliminarCliente(td);
    }
    
    public  void modificar() throws SQLException, ParseException{
        td.setDNI("73646183");
        td.setNombre("Camila");
        td.setTelefono("910380665");
       td.setDireccion("Arequipa");
        
        tdbo.modificarCliente(td);
    }
    
    public void insertarCompañia () throws SQLException, ParseException{
    
    cp.setNro_compañia("1");
    cp.setNombre("INTERBANK");
    cpbo.agregarCompañia(cp);
    }
    
    public void eliminarCompañia () throws SQLException, ParseException{ 
    cp.setNro_compañia("1");
    cpbo.eliminarCompañia(cp);

    }
   
    public void modificarCompañia () throws SQLException, ParseException{ 
    cp.setNro_compañia("12");
    cp.setNombre("banco ");
    cpbo.modificarCompañia(cp);
    }
     
//BILLETE
    
     public void insertarBillete () throws SQLException, ParseException{
    b.setNro_billete("12");
    b.setFecha("12-11-2009");
    b.setHora("12:00 PM");
    b.setDestino("Puno");
    b.setOrigen("Lima");
    b.setItinerario("A");
    b.setDNI("73646183");
    b.setNro_compañia("12");

    btbo.agregarBillete(b);
    }
    
    public void eliminarBillete () throws SQLException, ParseException{ 
    b.setNro_billete("12");
    btbo.eliminarBillete(b);

    }
    
    public void modificaBillete () throws SQLException, ParseException{ 
    b.setNro_billete("12");
    b.setFecha("12-11-2000 ");
    b.setHora("8:00 PM");
    b.setDestino("Lima");
    b.setOrigen("Chucuito");
    b.setItinerario("121");
    b.setDNI("73646183");
    b.setNro_compañia("12");
    btbo.modificarBillete(b);
    }
    public static void main(String[] args) throws SQLException, ParseException {
        Principal P = new  Principal();
//       P.insertar();
//       P.eliminar();
//       P.modificar();
//       P.insertarCompañia();
//       P.eliminarCompañia();
//       P.modificarCompañia();
//       P.insertarBillete();
//       P.eliminarBillete();
//       P.modificaBillete();



    }
}
