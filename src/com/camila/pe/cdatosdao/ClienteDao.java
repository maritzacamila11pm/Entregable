
package com.camila.pe.cdatosdao;

//importaciones

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.camila.pe.cmodelo.Cliente;
import com.camila.pe.db.Conexion;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDao {
    private String mensaje;
    
    public String agregarCliente(Connection conn, Cliente cliente ){
    PreparedStatement ps = null;
    String sql = "INSERT INTO Cliente (DNI,nombre,telefono,direccion)"
            + "VALUES (?,?,?,?)";
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1,cliente.getDNI());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getTelefono());
        ps.setString(4, cliente.getDireccion());
        ps.execute();
        ps.close();
        mensaje = "Se agrego al Cliente correctamente ";
    }catch (Exception e){
        mensaje = "Alto! error al agregar Cliente "+ e.getMessage();
        System.out.println(e.getMessage());
    }
    return mensaje;  
        
    }
    
//    SEGUNDO METODO ELIMINAR 
    public String eliminarCliente (Connection conn , Cliente cliente){
        PreparedStatement ps = null;
        String sql = "DELETE FROM Cliente WHERE DNI = ?";
        try{
        ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getDNI());
        ps.execute();
        ps.close();
        mensaje = "El tipo de documento fue eliminado correctamente";
        }catch (Exception e){
    mensaje = "Alto error al eliminar tipo documento " + e.getMessage();
        System.out.println(e.getMessage());
    }return mensaje;
  }
    
    //TERCER METODO MODIFICAR
     public String modificarCliente(Connection conn, Cliente cliente) {
    PreparedStatement ps = null;
    String sql = "UPDATE Cliente SET nombre=?, telefono=?, direccion=? WHERE DNI=?";
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getTelefono());
        ps.setString(3, cliente.getDireccion());
        ps.setString(4, cliente.getDNI());

        int affectedRows = ps.executeUpdate();
        if (affectedRows > 0) {
            mensaje = "Cliente actualizado correctamente";
        } else {
            mensaje = "No se encontró el cliente con el DNI proporcionado";
        }
    } catch (Exception e) {
        mensaje = "Alto! error al actualizar Cliente. " + e.getMessage();
        System.out.println(e.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
        }
    }
    return mensaje;
}

    
    //Cuarto Metodo - Listar Tipo Documento.
    public void listarCliente(Connection conn, JTable table){
        DefaultTableModel model;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String[] columnas = {"DNI","nombre","telefono","direccion"};
        model = new DefaultTableModel(null,columnas);
        
        String sql = "SELECT * FROM Cliente";
        String[] datosTP = new String[4];
        
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Cliente td = new Cliente();
                td.setDNI(resultSet.getString("DNI"));
                td.setNombre(resultSet.getString("Nombre"));
                td.setTelefono(resultSet.getString("Telefono"));
                td.setDireccion(resultSet.getString("Direccion"));
            
                
                datosTP[0] = td.getDNI()+"";
                datosTP[1] = td.getNombre()+"";
                datosTP[2] = td.getTelefono()+"";
                datosTP[3] = td.getDireccion()+"";
               

                model.addRow(datosTP);
            }
            table.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            System.out.println(e.getMessage());
        }
     }
        public ArrayList<Cliente> listarClienteCombo(Connection conn){
        ArrayList<Cliente> listarCliente = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        
        String sql = "SELECT DNI FROM Cliente";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Cliente td = new Cliente();
                td.setDNI(resultSet.getString("DNI"));
         
                listarCliente.add(td);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            System.out.println(e.getMessage());
        }
        return listarCliente;
    }
}
