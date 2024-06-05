/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoADatos;

import Entidades.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SrPanda
 */
public class RutaData {
    private Connection con = null;
    public RutaData(){
    
        con = Conexion.getConexion();
        
    }
    
    public void guardarRuta(Ruta ruta){
    
        String sql = "INSERT INTO Rutas (origen,destino,duracionEstimada,estado)"
                + "VALUES (?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, ruta.getOrigen());
            ps.setString(2, ruta.getDestino());
            ps.setTime(3, Time.valueOf(ruta.getDuracionEstimada()));
            ps.setBoolean(4, ruta.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
            
                ruta.setIdRuta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ruta Guardada Correctamente");
                   
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ruta Incorrecta");
        }
        
    }
}
