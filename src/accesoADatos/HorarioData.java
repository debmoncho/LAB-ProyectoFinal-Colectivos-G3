/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoADatos;

import Entidades.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JOptionPane;

/**
 *
 * @author tebby
 */
public class HorarioData {
    
    private Connection con = null;

    public HorarioData() {

        con = Conexion.getConexion();
    }
    
    public void guardarHorario(Horario horario){
        
        String sql="INSERT INTO horarios(idRuta, horaSalida, horaLlegada, estado) VALUES (? , ? , ?, ?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS );
            
            ps.setInt(1, horario.getRuta().getIdRuta());
            ps.setTime(2, Time.valueOf(horario.getHoraSalida()));
            ps.setTime(3, Time.valueOf(horario.getHoraLlegada()));
            ps.setBoolean(4, horario.isEstado());           
            ps.executeUpdate();
            
             ResultSet rs = ps.getGeneratedKeys();
             
             if(rs.next()){
                 horario.setIdHorario(rs.getInt(1));
                 JOptionPane.showMessageDialog(null, "Horario Guardado");
             }
            ps.close();
                             
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al insertar el horario");
       
        }
        
    }
    
    public void modificarHorario(Horario horario){
        
        String sql="UPDATE horarios SET  horaSalida = ? ,horaLlegada= ? ,estado =? WHERE idHorario= ? ";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setTime(1, Time.valueOf(horario.getHoraSalida()));
            ps.setTime(2, Time.valueOf(horario.getHoraLlegada()));
            ps.setBoolean(3, horario.isEstado());
            ps.setInt(4, horario.getIdHorario());
            
            int exit=ps.executeUpdate();
            
            if(exit== 1){
                 JOptionPane.showMessageDialog(null, "Horario modificado!");
            }
                                             
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error al modificar un horario");
        }          
    }  
    
    
    
    
}
