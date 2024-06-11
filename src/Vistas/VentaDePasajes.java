/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;

import Entidades.*;
import accesoADatos.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Deb APBT
 */
public class VentaDePasajes extends javax.swing.JInternalFrame {
    
    private List<Pasajero> listaP;
    private List<Ruta> listaR;
    private List<Colectivo> listaC;
    
    private RutaData rutaData;
    private PasajeroData pasajeroData = new PasajeroData();
    private PasajeData pasajeData;
    private Pasaje pasajeActual = null;
    
    private Pasajero pasajeroActual = null;
    
    private DefaultTableModel modelo;
    private DefaultComboBoxModel jcomboRuta;
    

    /**
     * Creates new form VentaDePasajes
     */
    public VentaDePasajes() {
        
        initComponents();
        
        pasajeroData = new PasajeroData();
        listaP = pasajeroData.listarPasajero();
        
        rutaData= new RutaData();
        listaR =rutaData.listarRuta();
        cargarRutas(); 
        cargarColectivos();
        
        modelo = new DefaultTableModel();
    }

    public void llenarRutas(){
     List<Ruta> listaRuta = rutaData.listarRuta();
     jcomboRuta = new DefaultComboBoxModel(listaRuta.toArray()); 
     comboRuta.setModel(jcomboRuta);
    }
    
    
    public void cargarRutas(){

    for(Ruta item : listaR) {
        
            comboRuta.addItem(item);
        }     
    }
    
    
    
    private void cargarColectivos(){
    
        for(Colectivo item : listaC) {
        
            comboColectivo.addItem(item);
        }
    }
     
    
    private void borrarFilasTabla(){
    
        int indice = modelo.getRowCount() - 1;
        for(int i = indice; i >= 0; i--){
        
            modelo.removeRow(i);
        }
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
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfDocumento = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jdFecha = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        comboRuta = new javax.swing.JComboBox<>();
        comboHorario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        comboColectivo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfApellido = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtfTelefono = new javax.swing.JTextField();
        jtfCorreo = new javax.swing.JTextField();
        comboAsiento = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setVisible(true);

        jLabel1.setFont(new java.awt.Font("Calibri", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Venta de pasajes");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton1.setText("Salir");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ruta:");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 2, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Registrar Venta de Pasaje");
        jLabel9.setToolTipText("");
        jLabel9.setAlignmentY(0.0F);
        jLabel9.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), null));
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Horario:");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtfDocumento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jbGuardar.setText("Guardar");
        jbGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setText("Anular Venta de Pasaje Emitido");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("Si lo desea, seleccione un pasaje de la tabla y anulelo: ");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton4.setBackground(new java.awt.Color(0, 204, 0));
        jButton4.setText("Emitir Factura de Pasaje");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("(Aca podria cargar los datos del pasaje emitido)");
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        jScrollPane2.setViewportView(jTextArea1);

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 2, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Busqueda de Pasajeros");
        jLabel12.setToolTipText("");
        jLabel12.setAlignmentY(0.0F);
        jLabel12.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(), null));
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Fecha:");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Busqueda por DNI de Pasajero: ");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jbBuscar.setText("Buscar");
        jbBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Apellido:");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtfPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nombre:");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtfNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        comboColectivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Colectivo:");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Asiento: ");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Precio: ");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtfApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel14.setText("Telefono:");

        jLabel15.setText("Correo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(144, 144, 144)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboRuta, 0, 91, Short.MAX_VALUE)
                    .addComponent(comboAsiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboHorario, 0, 162, Short.MAX_VALUE)
                    .addComponent(jtfPrecio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboColectivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
<<<<<<< Updated upstream
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
=======
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> Stashed changes
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< Updated upstream
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(jtfTelefono))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNombre)
                    .addComponent(jtfCorreo))
                .addGap(73, 73, 73))
=======
                .addComponent(jtfApellido)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
>>>>>>> Stashed changes
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfApellido)
                    .addComponent(jLabel8)
                    .addComponent(jtfNombre))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscar)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jtfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboRuta)
                                    .addComponent(comboHorario)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboColectivo)
                                    .addComponent(jtfPrecio)
                                    .addComponent(comboAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(211, 211, 211))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // TODO add your handling code here:
        try {
            String dni = jtfDocumento.getText();
            String apellido = jtfApellido.getText();
            String nombre = jtfNombre.getText();
            String telefono = jtfTelefono.getText();
            String correo = jtfCorreo.getText();
              
            Pasajero pasajero = new Pasajero(nombre, apellido, dni, correo, telefono, true); //falta telefono, correo y estado. como hacemos? 1.creamos un nuevo constructor o 2.le pasamos todos los datos en la vista
            
            Colectivo colectivo = (Colectivo)comboColectivo.getSelectedItem();
            Ruta ruta = (Ruta)comboRuta.getSelectedItem();
            int asiento = (int)comboAsiento.getSelectedItem();
            
            Double precio = Double.parseDouble(jtfPrecio.getText());
            
            if(nombre.isEmpty() || apellido.isEmpty()){
                JOptionPane.showMessageDialog(this, "No puede haber campos vacios");
                return;
            }
    
        java.util.Date fecha = jdFecha.getDate();
        LocalDate fechaViaje = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();   
            
        java.util.Date hora = jdFecha.getDate(); // esto esta mal.
        LocalTime horaViaje = hora.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        
        
        if(pasajeActual == null) {
            pasajeActual = new Pasaje(pasajero, colectivo, ruta, fechaViaje, horaViaje, asiento, precio);
            pasajeData.guardarPasaje(pasajeActual);
        } else {
            pasajeActual.setPasajero(pasajero);
            pasajeActual.setColectivo(colectivo);
            pasajeActual.setRuta(ruta);
            pasajeActual.setFechaViaje(fechaViaje);
            pasajeActual.setHoraViaje(horaViaje);
            pasajeActual.setAsiento(asiento);
            pasajeActual.setPrecio(precio);

            //pasajeData.modificarPasaje(pasajeroActual);
            // NO tenemos el metodo de modificar pasaje. 1) creamos un metodo q tenga esto o 2) no lo modificamos y le enviamos un showMessage que cargue los datos correctamente.
        }
        
        } catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar el pasaje");
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    
    
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        try {
<<<<<<< Updated upstream
            
             String dni = jtfDocumento.getText();
             //ahora creamos el objeto "aludata" arriba de esta clase
             pasajeroActual = pasajeroData.buscarPasajeroPorDni(dni);
             
             if(pasajeroActual != null){
                 
                 jtfApellido.setText(pasajeroActual.getApellido());
                 jtfNombre.setText(pasajeroActual.getNombre());
                 jtfTelefono.setText(pasajeroActual.getTelefono());
                 jtfCorreo.setText(pasajeroActual.getCorreo());
             }            
        } catch(NumberFormatException msj){
        
=======

            String dni = jtfDocumento.getText();
            //ahora creamos el objeto "aludata" arriba de esta clase
            pasajeroActual = pasajeroData.buscarPasajeroPorDni(dni);

            if (pasajeroActual != null) {

                jtfApellido.setText(pasajeroActual.getApellido());
                jtfNombre.setText(pasajeroActual.getNombre());
            }

        } catch (NumberFormatException msj) {

>>>>>>> Stashed changes
            JOptionPane.showMessageDialog(this, "Debe ingresar un DNI válido");

    }//GEN-LAST:event_jbBuscarActionPerformed

        
        
        
        

        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Integer> comboAsiento;
    private javax.swing.JComboBox<Colectivo> comboColectivo;
    private javax.swing.JComboBox<Horario> comboHorario;
    private javax.swing.JComboBox<Ruta> comboRuta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbGuardar;
    private com.toedter.calendar.JDateChooser jdFecha;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfCorreo;
    private javax.swing.JTextField jtfDocumento;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPrecio;
    private javax.swing.JTextField jtfTelefono;
    // End of variables declaration//GEN-END:variables
}
