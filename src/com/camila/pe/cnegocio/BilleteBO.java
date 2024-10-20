package com.camila.pe.cnegocio;

import com.camila.pe.cdatosdao.BilleteDao;
import com.camila.pe.cmodelo.Billete;
import com.camila.pe.db.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

public class BilleteBO {
    private String mensaje;
    private BilleteDao billeteDao = new BilleteDao();

    // AGREGAR
    public String agregarBillete(Billete billete) {
        try (Connection c = Conexion.getConnection()) {
            mensaje = billeteDao.agregarBillete(c, billete);
            c.commit();
        } catch (SQLException e) {
            mensaje = "Error al agregar billete: " + e.getMessage();
            System.err.println(mensaje);
        }
        return mensaje;
    }

    // ELIMINAR
    public String eliminarBillete(Billete billete) {
        try (Connection c = Conexion.getConnection()) {
            mensaje = billeteDao.eliminarBillete(c, billete);
            c.commit();
        } catch (SQLException e) {
            mensaje = "Error al eliminar billete: " + e.getMessage();
            System.err.println(mensaje);
        }
        return mensaje;
    }

    // MODIFICAR
    public String modificarBillete(Billete billete) {
        try (Connection c = Conexion.getConnection()) {
            mensaje = billeteDao.modificarBillete(c, billete);
            c.commit();
        } catch (SQLException e) {
            mensaje = "Error al modificar billete: " + e.getMessage();
            System.err.println(mensaje);
        }
        return mensaje;
    }

    // LISTAR
    public void listarBilletes(JTable table) {
        try (Connection c = Conexion.getConnection()) {
            billeteDao.listarBillete(c, table);
        } catch (SQLException e) {
            System.err.println("Error al listar billetes: " + e.getMessage());
        }
    }
}
