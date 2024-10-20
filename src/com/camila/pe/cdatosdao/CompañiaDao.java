
package com.camila.pe.cdatosdao;

//IMPORTACIONES
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.camila.pe.cmodelo.Compañia;
import com.camila.pe.db.Conexion;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CompañiaDao {
      private String mensaje;
    
    public String agregarCompañia(Connection conn, Compañia compañia ){
    PreparedStatement ps = null;
    String sql = "INSERT INTO Compañia (nro_compañia,Nombre)"
            + "VALUES (?,?)";
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1,compañia.getNro_compañia());
        ps.setString(2, compañia.getNombre());
        ps.execute();
        ps.close();
        mensaje = "Se agrego la Compañia correctamente ";
    }catch (Exception e){
        mensaje = "Alto! error al agregar Compañia  "+ e.getMessage();
        System.out.println(e.getMessage());
    }
    return mensaje;  
        
    }
    
//    SEGUNDO METODO ELIMINAR 
    public String eliminarCompañia (Connection conn , Compañia compañia){
        PreparedStatement ps = null;
        String sql = "DELETE FROM Compañia WHERE nro_compañia = ?";
        try{
        ps = conn.prepareStatement(sql);
        ps.setString(1, compañia.getNro_compañia());
        ps.execute();
        ps.close();
        mensaje = "El tipo de documento fue eliminado correctamente";
        }catch (Exception e){
    mensaje = "Alto error al eliminar tipo documento " + e.getMessage();
        System.out.println(e.getMessage());
    }return mensaje;
  }
    
    //TERCER METODO MODIFICAR
     public String modificarCompañia(Connection conn, Compañia compañia) {
    PreparedStatement ps = null;
    String sql = "UPDATE Compañia SET Nombre=? WHERE nro_compañia=?";
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, compañia.getNombre());
        ps.setString(2, compañia.getNro_compañia());
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
    public void listarCompañia(Connection conn, JTable table){
        DefaultTableModel model;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String[] columnas = {"Nro_compañia","Nombre"};
        model = new DefaultTableModel(null,columnas);
        
        String sql = "SELECT * FROM Compañia";
        String[] datosTP = new String[3];
        
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Compañia cp = new Compañia();
                cp.setNro_compañia(resultSet.getString("nro_compañia"));
                cp.setNombre(resultSet.getString("Nombre"));
          
                
                datosTP[0] = cp.getNro_compañia()+"";
                datosTP[1] = cp.getNombre()+"";
             
               

                model.addRow(datosTP);
            }
            table.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            System.out.println(e.getMessage());
        }
     }
        public ArrayList<Compañia> listarCompañiaCombo(Connection conn){
        ArrayList<Compañia> listarCompañia = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        
        String sql = "SELECT nro_compañia FROM Compañia";
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Compañia td = new Compañia();
                td.setNro_compañia(resultSet.getString("nro_compañia"));
         
                listarCompañia.add(td);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            System.out.println(e.getMessage());
        }
        return listarCompañia;
    }
}
