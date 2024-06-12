/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.Colectivo;
import Entidades.Horario;
import Entidades.Pasaje;
import Entidades.Pasajero;
import Entidades.Ruta;
import accesoADatos.ColectivoData;
import accesoADatos.HorarioData;
import accesoADatos.PasajeData;
import accesoADatos.PasajeroData;
import accesoADatos.RutaData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tebby
 */
public class Ventas extends javax.swing.JInternalFrame {

    private HorarioData hd = new HorarioData();
    private RutaData rd = new RutaData();
    private PasajeroData pd = new PasajeroData();
    private ColectivoData cd = new ColectivoData();
    private PasajeData pasajeD = new PasajeData();
    private DefaultTableModel modelo;
    private DefaultComboBoxModel comboModelo;

    /**
     * Creates new form Ventas
     */
    public Ventas() {
        initComponents();
        modelo = new DefaultTableModel();
        comboModelo = new DefaultComboBoxModel();
        armarCabecera();
        llenarRutas();
        LlenarColectivos();

    }

    public void LlenarColectivos() {
        List<Colectivo> listaCole = cd.listarColectivos();
        comboModelo = new DefaultComboBoxModel(listaCole.toArray());
        jComboColectivo.setModel(comboModelo);
    }

    public void llenarRutas() {
        List<Ruta> listaRuta = rd.listarRuta();
        comboModelo = new DefaultComboBoxModel(listaRuta.toArray());
        jComboRuta.setModel(comboModelo);
    }

    public void llenarHorario() {
        Ruta ruta = (Ruta) jComboRuta.getSelectedItem();
        List<Horario> listaHora = hd.obtenerHorarioPorRuta(ruta.getIdRuta());
        List<String> infoHora = new ArrayList<>();

        for (Horario hora : listaHora) {
            String info = hora.getHoraSalida().toString();
            infoHora.add(info);
        }

        comboModelo = new DefaultComboBoxModel(infoHora.toArray());
        jComboHora.setModel(comboModelo);
    }

    public void traerAsientos() {
        Colectivo cole = (Colectivo) jComboColectivo.getSelectedItem();
        List<Pasaje> pasajes = pasajeD.obtenerPasajesCompradosPorColectivo(cole.getIdColectivo());
        List<Integer>pasajesComprados=new ArrayList<Integer>();
        boolean comprado=false;
        for(Pasaje p:pasajes){
            
            pasajesComprados.add(p.getAsiento());
           
        }       
        List<Integer> asientos = new ArrayList<Integer>();
        for (int i = 0; i < cole.getCapacidad(); i++) {
            comprado=false;
           for(Integer p:pasajesComprados){
               if(i+1 == p){
                   comprado=true;
                   break;
               }
           }
           if(!comprado){
               asientos.add(i + 1);
           }
        }
        comboModelo = new DefaultComboBoxModel(asientos.toArray());
        jComboAsiento.setModel(comboModelo);
    }

    private void llenarTabla(ArrayList<Pasajero> pasajeros) {
        for (Pasajero aux : pasajeros) {
            Pasajero pasajero = aux;
            if (pasajero.isEstado()) {
                modelo.addRow(new Object[]{pasajero.getIdPasajero(), pasajero.getNombre(), pasajero.getApellido(), pasajero.getDni(), pasajero.getTelefono()});
            }
        }
        jTabla.setModel(modelo);
    }

    public void llenarTablaPorSeleccion() {
        modelo.setRowCount(0);
        ArrayList<Pasajero> listaPasajero = pd.buscarPasajerosCl(jDni.getText());
        llenarTabla(listaPasajero);
    }

    private void armarCabecera() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Id");
        filaCabecera.add("Nombre");
        filaCabecera.add("Apellido");
        filaCabecera.add("Dni ");
        filaCabecera.add("Telefono");
        //filaCabecera.add("estado");
        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jTabla.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jDni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboRuta = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboHora = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboColectivo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboAsiento = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jdFecha = new com.toedter.calendar.JDateChooser();
        jGuardar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Venta de Pasajes");

        jLabel2.setText("Clientes");

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTabla);

        jLabel3.setText("Ingrese DNI:");

        jDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDniKeyReleased(evt);
            }
        });

        jLabel4.setText("Ruta:");

        jComboRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboRutaActionPerformed(evt);
            }
        });

        jLabel5.setText("Horario:");

        jComboHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboHoraActionPerformed(evt);
            }
        });

        jLabel6.setText("Colectivo:");

        jComboColectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboColectivoActionPerformed(evt);
            }
        });

        jLabel7.setText("Asiento");

        jComboAsiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboAsientoActionPerformed(evt);
            }
        });

        jLabel8.setText("fecha");

        jGuardar.setText("Guardar");
        jGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(232, 232, 232)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(266, 266, 266)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(126, 126, 126)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jDni, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(32, 32, 32)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jComboRuta, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboAsiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jGuardar)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jdFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboColectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addComponent(jGuardar)
                .addGap(0, 91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDniKeyReleased
        // TODO add your handling code here:
        llenarTablaPorSeleccion();

    }//GEN-LAST:event_jDniKeyReleased

    private void jComboHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboHoraActionPerformed

    private void jComboRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboRutaActionPerformed
        // TODO add your handling code here:
        llenarHorario();
    }//GEN-LAST:event_jComboRutaActionPerformed

    private void jComboColectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboColectivoActionPerformed
        // TODO add your handling code here:
        traerAsientos();
    }//GEN-LAST:event_jComboColectivoActionPerformed

    private void jComboAsientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAsientoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboAsientoActionPerformed

    private void jGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarActionPerformed
        // TODO add your handling code here:
       DefaultTableModel model2 = (DefaultTableModel) jTabla.getModel();
        int id = (int) model2.getValueAt(jTabla.getSelectedRow(), 0);
        Pasajero pasajero = pd.buscarPasajero(id);
        java.util.Date fecha = jdFecha.getDate();
        LocalDate lc = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Ruta ruta = (Ruta) jComboRuta.getSelectedItem();
//        LocalTime horario = (LocalTime) jComboHora.getSelectedItem();
        String selected = (String) jComboHora.getSelectedItem();
        LocalTime horaViaje = LocalTime.parse(selected);
        Colectivo colectivo = (Colectivo) jComboColectivo.getSelectedItem();
        int asiento = (int) jComboAsiento.getSelectedItem();
        Pasaje pasaje=new Pasaje(0, pasajero, colectivo, ruta, lc, horaViaje, asiento, 2);
//        JOptionPane.showMessageDialog(null, info);
            pasajeD.guardarPasaje(pasaje);
    }//GEN-LAST:event_jGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboAsiento;
    private javax.swing.JComboBox<String> jComboColectivo;
    private javax.swing.JComboBox<String> jComboHora;
    private javax.swing.JComboBox<String> jComboRuta;
    private javax.swing.JTextField jDni;
    private javax.swing.JButton jGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    private com.toedter.calendar.JDateChooser jdFecha;
    // End of variables declaration//GEN-END:variables
}