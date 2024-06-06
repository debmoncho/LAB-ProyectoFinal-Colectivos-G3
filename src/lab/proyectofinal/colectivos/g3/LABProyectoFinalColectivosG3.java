package lab.proyectofinal.colectivos.g3;

import accesoADatos.*;
import java.sql.*;
import Entidades.*;
import java.time.LocalTime;

/**
 *
 * @author Deb APBT
 */
public class LABProyectoFinalColectivosG3 {

    public static void main(String[] args) {

        //PROYECTO INICIADO
        //LALALALALA
        Connection con = Conexion.getConexion(); // siempre descomentado

        // COLECTIVO DATA
        // Agregar-Guardar colectivo
//        ColectivoData bondi = new ColectivoData(); // si se prueba, dejar descomentado para todos los metodos
//        
//        Colectivo cole = new Colectivo(1, "875SPX", "Mercedes Benz", "XT1000", 45, true);
//       
//        bondi.guardarColectivo(cole);
//        Colectivo cole2 = new Colectivo(3, "951TBX", "LG", "Terreneitor", 60, true);
//
//        bondi.guardarColectivo(cole2);
        // Modificar colectivo
//        Colectivo cole = new Colectivo(2, "875SPX", "Airton Menta", "XT1000", 45, true);
//        
//        bondi.modificarColectivo(cole);
        //Eliminar colectivo
//        bondi.eliminarColectivo(1);
        //Buscar colectivo
//        Colectivo encontrado = bondi.buscarColectivo(2);
//
//        System.out.println("ID: " + encontrado.getIdColectivo());
//        System.out.println("Matricula: " + encontrado.getMatricula());
//        System.out.println("Marca: " + encontrado.getMarca());
//        System.out.println("Modelo: " + encontrado.getModelo());
//        System.out.println("Capacidad: " + encontrado.getCapacidad());
        // Listar colectivos
//        
//        for (Colectivo pasajero : bondi.listarColectivos()) {
        // manera ordenada de ver los datos de los elementos System
//            System.out.println("");
//            System.out.println(pasajero.getIdColectivo());
//            System.out.println(pasajero.getMatricula());
//            System.out.println(pasajero.getMarca());
//            System.out.println(pasajero.getModelo());
//            System.out.println(pasajero.getCapacidad());
//            System.out.println("");
        //ver los elementos con un to string System
//            System.out.println(pasajero);
//            System.out.println("");
//        }
// -------------------------------------------------------------------------------------------------
        // PASAJERO DATA
        //Guardar pasajero
//        PasajeroData persona = new PasajeroData();
        // guardar y editar pasajero
//        Pasajero per = new Pasajero(1, "Javier Alejandro", "Pepon", "51489753", "lala@gmail.com", "2665854796", true);
//        
//        persona.guardarPasajero(per);
//        Pasajero per2 = new Pasajero(2, "Luis", "Mercado", "12159741", "lilo@gmail.com", "4459874", true);
//        
//        persona.guardarPasajero(per2);
//        persona.modificarPasajero(per);
        // Eliminar-desactivar pasajero
//        persona.eliminarPasajero(3);
        //Buscar pasajero por id
//        Pasajero encontrado =  persona.buscarPasajero(1);
//        
//        System.out.println("DNI: "+ encontrado.getDni());
//        System.out.println("Apellido: "+ encontrado.getApellido());
//        System.out.println("Nombre: "+ encontrado.getNombre());
        // Buscar pasajero por DNI
//        Pasajero encontrado = persona.buscarPasajeroPorDni("51489753");
//
//        System.out.println("DNI: " + encontrado.getDni());
//        System.out.println("Apellido: " + encontrado.getApellido());
//        System.out.println("Nombre: " + encontrado.getNombre());
        // Listar pasajero
//        PasajeroData data = new PasajeroData();
//        
//        for (Pasajero pasajero : data.listarPasajero()) {
        // manera ordenada de ver los datos de los elementos System
//            System.out.println("");
//            System.out.println(pasajero.getDni());
//            System.out.println(pasajero.getApellido());
//            System.out.println(pasajero.getNombre());
//            System.out.println("");
        //ver los elementos con un to string System
//            System.out.println(pasajero);
//            System.out.println("");
//        }
//------------------------------------------------------------------------------------------------
//      Ruta ruta = new Ruta("Flores", "San Luis", LocalTime.of(0, 40),true);
// 
////
       RutaData rd = new RutaData();
       
       for(Ruta ru : rd.listarRuta()){
           System.out.println("");
           System.out.println(ru.getIdRuta());
           System.out.println(ru.getOrigen());
           System.out.println(ru.getDestino());
           System.out.println(ru.getDuracionEstimada());
           System.out.println("");
       }
       
       
       
//      rd.guardarRuta(ruta);
//      Ruta rutaEncontrada = rd.buscarRuta(3);
//        System.out.println("Id: "+rutaEncontrada.getIdRuta());
//        System.out.println("Origen: "+rutaEncontrada.getOrigen());
//        System.out.println("Destino: "+rutaEncontrada.getDestino());
//        System.out.println("Duracion: "+rutaEncontrada.getDuracionEstimada());
//        
//     rutaEncontrada.setDestino("Tacamandapio");
//     rd.actualiazRuta(rutaEncontrada);
      
//        rd.guardarRuta(ruta);

 //rd.actualiazRuta(ruta);
 // rd.eliminarRuta(4);
//-------------------------------------------------------------------------------------------------------------------------------------------------

//Horario horario=new Horario(1,ruta, LocalTime.now(), LocalTime.now(),true);
//
//Horario horario2=new Horario(2, ruta, LocalTime.MAX, LocalTime.MIN, true);

//Horario horario3=new Horario(3, ruta, LocalTime.of(22,30), LocalTime.of(23,50), true);

 HorarioData hd=new HorarioData();
 
// hd.guardarHorario(horario3);
 
//  hd.guardarHorario(horario2);
 
 // hd.modificarHorario(horario);
 
// hd.eliminarHorario(1);

//buscar horario por ruta

for(Horario elemento:hd.obtenerHorarioPorRuta(3)){
    System.out.println(" ");
    System.out.println(elemento.getIdHorario());
    System.out.println(elemento.getRuta());
    System.out.println(elemento.getHoraLlegada());
    System.out.println(elemento.getHoraSalida());
    System.out.println(elemento.isEstado());
}

   //mostrar todos los horarios
   
//   for (Horario elemento : hd.obtenerTodosLosHorarios()) {
//    System.out.println(" ");
//    System.out.println("ID Horario: " + elemento.getIdHorario());
//    System.out.println("Ruta: " + elemento.getRuta());
//    System.out.println("Hora de Salida: " + elemento.getHoraSalida());
//    System.out.println("Hora de Llegada: " + elemento.getHoraLlegada());
//    System.out.println("Estado: " + elemento.isEstado());
//}
   
//mostrar horarios por hora de salida

 for (Horario elemento : hd.obtenerHorarioPorHoraSalida(LocalTime.of(22, 30))) {
    System.out.println(" ");
    System.out.println("ID Horario: " + elemento.getIdHorario());
    System.out.println("Ruta: " + elemento.getRuta());
    System.out.println("Hora de Salida: " + elemento.getHoraSalida());
    System.out.println("Hora de Llegada: " + elemento.getHoraLlegada());
    System.out.println("Estado: " + elemento.isEstado());
}



    }
 
 
    

}
