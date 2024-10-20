
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camila.pe.cnegocio;

import com.camila.pe.cdatosdao.CompañiaDao;
import com.camila.pe.cmodelo.Cliente;
import com.camila.pe.cmodelo.Compañia;
import com.camila.pe.db.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;


public class CompañiaBO {
       private String mensaje ;
    CompañiaDao tdd = new CompañiaDao();
    
//    AGREGAR
    public String agregarCompañia(Compañia compañia)throws SQLException {
    Connection c = Conexion.getConnection();
    try{
       mensaje = tdd.agregarCompañia(c, compañia);
       c.commit();
    }catch (Exception e ){
       c.rollback();
    }finally {
       c.close();
    }
    return mensaje;
    }
    
//    ELIMINAR
    public String eliminarCompañia(Compañia compañia) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.eliminarCompañia(c, compañia);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
//    MODIFICAR
    public String modificarCompañia(Compañia compañia) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.modificarCompañia(c,compañia );
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
//    LISTAR
    public void listarCompañia(JTable table){
        Connection c = Conexion.getConnection();
        tdd.listarCompañia(c, table);
        try {
            c.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
    
    
     public ArrayList<Compañia> listarCompañiaCombo(){
        ArrayList<Compañia> listarCompañiaCombo = new ArrayList<>();
        Connection c = Conexion.getConnection();
        listarCompañiaCombo = tdd.listarCompañiaCombo(c);
        try {
            c.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
        return listarCompañiaCombo;
}
}