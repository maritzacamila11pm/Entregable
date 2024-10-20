
package com.camila.pe.cnegocio;

//IMPORTACIONES

import com.camila.pe.cdatosdao.ClienteDao;
import com.camila.pe.cmodelo.Cliente;
import com.camila.pe.db.Conexion;
import  java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
public class ClienteBO {
    
     private String mensaje ;
    ClienteDao tdd = new ClienteDao();
    
//    AGREGAR
    public String agregarCliente(Cliente cliente)throws SQLException {
    Connection c = Conexion.getConnection();
    try{
       mensaje = tdd.agregarCliente(c, cliente);
       c.commit();
    }catch (Exception e ){
       c.rollback();
    }finally {
       c.close();
    }
    return mensaje;
    }
    
//    ELIMINAR
    public String eliminarCliente(Cliente cliente) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.eliminarCliente(c, cliente);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
//    MODIFICAR
    public String modificarCliente(Cliente cliente) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.modificarCliente(c, cliente);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
//    LISTAR
    public void listarCliente(JTable table){
        Connection c = Conexion.getConnection();
        tdd.listarCliente(c, table);
        try {
            c.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
    
    //
     public ArrayList<Cliente> listarClienteCombo(){
        ArrayList<Cliente> listarClienteCombo = new ArrayList<>();
        Connection c = Conexion.getConnection();
        listarClienteCombo = tdd.listarClienteCombo(c);
        try {
            c.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
        return listarClienteCombo;
    }
}
