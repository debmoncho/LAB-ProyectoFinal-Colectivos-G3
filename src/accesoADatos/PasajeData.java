
package accesoADatos;

import Entidades.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PasajeData {
    
    private Connection con = null;
    
    //declarar clases datas
    private PasajeroData pd = new PasajeroData();
//    private RutaData rd = new RutaData();

    public PasajeData() {
        con = Conexion.getConexion();
    }
    
     public void guardarPasaje(Pasaje pasaje){
        
        String sql = "INSERT INTO pasajes (idPasajero, idColectivo, idRuta, fechaViaje, horaViaje, asiento, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
        try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            
            ps.setInt(1, pasaje.getPasajero().getIdPasajero());
            ps.setInt(2, pasaje.getColectivo().getIdColectivo());
            ps.setInt(3, pasaje.getRuta().getIdRuta());
            ps.setDate(4, Date.valueOf(pasaje.getFechaViaje()));
            ps.setTime(5, Time.valueOf(pasaje.getHoraViaje()));
            ps.setInt(6, pasaje.getAsiento());
            ps.setDouble(7, pasaje.getPrecio());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                
                pasaje.setIdPasaje(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pasaje vendido exitosamente!");

            }
            
            ps.close();
        
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al vender el pasaje");
            
        }
        
    }
     
         public void borrarPasaje(int idPasajero, int idRuta){
        
        String sql = "DELETE FROM pasajes WHERE idPasajero = ? AND idRuta = ?";
        
        try {
        
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idPasajero);
            ps.setInt(2, idRuta);
            
            int exito = ps.executeUpdate();
            
            if(exito > 0){
                JOptionPane.showMessageDialog(null, "Pasaje borrado exitosamente!");
            }
            
            ps.close();
        
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al borrar el pasaje");
        
        }
        
    }
         
         public void actualizarFechaViaje(int idPasajero, int idRuta, LocalDate fechaViaje){
    
        String sql = "UPDATE pasajes SET fechaViaje = ? WHERE idPasajero = ? AND idRuta = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
        
            ps.setDate(1, Date.valueOf(fechaViaje));
            ps.setInt(2, idPasajero);
            ps.setInt(3, idRuta);
            
            int exito = ps.executeUpdate();
            
            if(exito > 0){
                JOptionPane.showMessageDialog(null, "Fecha de viaje actualizada exitosamente!");
            }
            
            ps.close();
        
        
        } catch (SQLException ex) {
            
            
            JOptionPane.showMessageDialog(null, "Error al actualizar la fecha de viaje");
            
        }

    }
         
         public void actualizarHoraViaje(int idPasajero, int idRuta, LocalTime horaViaje){
    
        String sql = "UPDATE pasajes SET horaViaje = ? WHERE idPasajero = ? AND idRuta = ?";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
        
            ps.setTime(1, Time.valueOf(horaViaje));
            ps.setInt(2, idPasajero);
            ps.setInt(3, idRuta);
            
            int exito = ps.executeUpdate();
            
            if(exito > 0){
                JOptionPane.showMessageDialog(null, "Hora de viaje actualizada exitosamente!");
            }
            
            ps.close();
        
        
        } catch (SQLException ex) {
            
            
            JOptionPane.showMessageDialog(null, "Error al actualizar la hora de viaje");
            
        }

    }
         
             
        public List<Pasaje> obtenerPasajes() {

        ArrayList<Pasaje> vendidos = new ArrayList<>();

        String sql = "SELECT * FROM pasajes";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Pasaje pasaje = new Pasaje();

                pasaje.setIdPasaje(rs.getInt("idPasaje"));

                Pasajero pedro = pd.buscarPasajero(rs.getInt("idPasajero"));

//                Ruta cordoba = rd.buscarRuta(rs.getInt("idRuta"));

                pasaje.setPasajero(pedro);
//                pasaje.setRuta(cordoba);
//                falta colectivo - idcolectivo, hace falta??
                
                pasaje.setFechaViaje(rs.getDate("fechaViaje").toLocalDate());
                pasaje.setHoraViaje(rs.getTime("horaViaje").toLocalTime());
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getDouble("precio"));

                vendidos.add(pasaje);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido obtener la lista de pasajes vendidos");
        }
        
        return vendidos;
    }
    
    public List<Pasaje> obtenerPasajeVendidoPorPasajero(int idPasajero) {

        ArrayList<Pasaje> vendidos = new ArrayList<>();

        String sql = "SELECT * FROM pasajes WHERE idPasajero = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idPasajero);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Pasaje pasaje = new Pasaje();

                pasaje.setIdPasaje(rs.getInt("idPasaje"));

                Pasajero pedro = pd.buscarPasajero(rs.getInt("idPasajero"));

//                Ruta cordoba = rd.buscarRuta(rs.getInt("idRuta"));

                pasaje.setPasajero(pedro);
//                pasaje.setRuta(cordoba);
//                falta colectivo - idcolectivo, hace falta??
                
                pasaje.setFechaViaje(rs.getDate("fechaViaje").toLocalDate());
                pasaje.setHoraViaje(rs.getTime("horaViaje").toLocalTime());
                pasaje.setAsiento(rs.getInt("asiento"));
                pasaje.setPrecio(rs.getDouble("precio"));

                vendidos.add(pasaje);
            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se ha podido realizar la venta del pasaje");
        }

        return vendidos;

    }
}