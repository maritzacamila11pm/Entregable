

package com.camila.pe.cdatosdao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.camila.pe.cmodelo.Billete;
import com.camila.pe.db.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BilleteDao {
       private String mensaje;
    
    public String agregarBillete(Connection conn, Billete billete ){
    PreparedStatement ps = null;  
    String sql = "INSERT INTO Billete (nro_billete, fecha, hora,Destino,Origen,Itinerario, DNI,nro_compañia) " + "VALUES (?,?,?,?,?,?,?,?)";
    try {
    ps= conn.prepareStatement(sql);
    ps.setString(1,billete.getNro_billete());
    ps.setString(2, billete.getFecha());
    ps.setString(3, billete.getHora());
    ps.setString (4 , billete.getDestino() );
    ps.setString (5 , billete.getOrigen());   
    ps.setString (6 , billete.getItinerario());
    ps.setString (7 , billete.getDNI());    
    ps.setString (8 , billete.getNro_compañia());
    ps.execute();
    ps.close();
    mensaje = "Billete fue creado correctamente ";
    } catch (Exception e ){
    mensaje = "Alto ! , error al crear Billete  . " + e.getMessage();
      System.out.println(e.getMessage());

    }
return  mensaje;
        
    }
    
//    SEGUNDO METODO ELIMINAR 
    public String eliminarBillete(Connection conn , Billete billete){
        PreparedStatement ps = null;
        String sql = "DELETE FROM Billete WHERE nro_billete = ?";
        try{
        ps = conn.prepareStatement(sql);
        ps.setString(1, billete.getNro_billete());
        ps.execute();
        ps.close();
        mensaje = "El Billete fue eliminado correctamente";
        }catch (Exception e){
    mensaje = "Alto error al eliminar Billete " + e.getMessage();
        System.out.println(e.getMessage());
    }return mensaje;
  }
    
    //TERCER METODO MODIFICAR
  public String modificarBillete(Connection conn, Billete billete) {
    PreparedStatement ps = null;
    String sql = "UPDATE Billete SET fecha=?, hora=?, destino=?, origen=?, itinerario=?, DNI=?, nro_compañia=? WHERE nro_billete=?";
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, billete.getFecha());
        ps.setString(2, billete.getHora());
        ps.setString(3, billete.getDestino());
        ps.setString(4, billete.getOrigen());
        ps.setString(5, billete.getItinerario());
        ps.setString(6, billete.getDNI());
        ps.setString(7, billete.getNro_compañia());
        ps.setString(8, billete.getNro_billete());

        int affectedRows = ps.executeUpdate();
        if (affectedRows > 0) {
            return "Billete actualizado correctamente";
        } else {
            return "No se encontró el billete con el número proporcionado";
        }
    } catch (Exception e) {
        return "Error al actualizar billete: " + e.getMessage();
    } finally {
        try {
            if (ps != null) ps.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
        }
    }
}
    
    //Cuarto Metodo - Listar Tipo Documento.
    public void listarBillete(Connection conn, JTable table){
        DefaultTableModel model;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String[] columnas = {"nro_billete ","fecha","hora","Destino","Origen","Itinerario","DNI","nro_compañia"};
        model = new DefaultTableModel(null,columnas);
        
        String sql = "SELECT * FROM Billete";
        String[] datosTP = new String[4];
        
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Billete td = new Billete();
                td.setNro_billete(resultSet.getString("nro_billete"));
                td.setHora(resultSet.getString("fecha"));
                td.setFecha(resultSet.getString("hora"));
                td.setDestino(resultSet.getString("Destino"));
                td.setOrigen(resultSet.getString("Origen"));
                td.setItinerario(resultSet.getString("Itinerario"));
                td.setDNI(resultSet.getString("DNI"));
                td.setNro_compañia(resultSet.getString("nro_compañia"));

                datosTP[0] = td.getNro_billete()+"";
                datosTP[1] = td.getHora()+"";
                datosTP[2] = td.getFecha()+""; 
                datosTP[3] = td.getDestino()+"";
                datosTP[4] = td.getOrigen()+"";
                datosTP[5] = td.getItinerario()+"";
                datosTP[6] = td.getDNI()+"";
                datosTP[7] = td.getNro_compañia()+"";
                model.addRow(datosTP);
            }
            table.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            System.out.println(e.getMessage());
        }
     }
}
