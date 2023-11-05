/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @autor jesus francisco dugarte vargas aka zedeon 
 */
package Vista;
import Controlador.Controlador;
import Modelo.Alquila;
import Modelo.Cinta;
import Modelo.Cliente;
import Modelo.Pelicula;
import Modelo.Tienda;

import java.awt.Color;
import java.awt.Font;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Patricia Burgos
 */
public class Ventana1 extends javax.swing.JFrame {
    private ArrayList<Tienda>vector_tiendas;
    private Controlador controlador;
    private String id_copia;
    private String dni_copia;
    private String id_cinta_copia;
    private String code_pelicula_copia;
    private boolean leido = false;
    private ArrayList<Cliente>vector_clientes;
    private ArrayList<Cinta>vector_cintas; 
    private ArrayList<Pelicula>vector_peliculas;
    
    /**
     * Creates new form Ventana1
     */
    public Ventana1(ArrayList<Tienda> tiendas, Controlador controlador, ArrayList<Cliente> clientes, ArrayList<Cinta>cintas,ArrayList<Pelicula>peliculas) throws IOException, FileNotFoundException, ClassNotFoundException, NotSerializableException, SAXException {
    initComponents();
    this.controlador = controlador;
    this.vector_tiendas = tiendas;
    this.vector_clientes = clientes;
    this.vector_cintas= cintas;
    this.vector_peliculas = peliculas;
    
    
    verificarDatosTiendas();
    verificarDatosClientes(); 
    verificarDatosCintas();
    
    jButton_guardar_tienda.setVisible(false);
    jButton_guardar_cliente.setVisible(false);
    jButton_guardar_cinta.setVisible(false);
    jButton_guardar_pelicula.setVisible(false);
    agregarCltButtom.setVisible(false);
    
}

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel_tienda = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_tienda = new javax.swing.JTable();
        jButton_aniadir_tienda = new javax.swing.JButton();
        jButton_modificar_tienda = new javax.swing.JButton();
        jButton_borrar_tienda = new javax.swing.JButton();
        jLabel_id_tienda = new javax.swing.JLabel();
        jLabel_nombre_tienda = new javax.swing.JLabel();
        jLabel_direccion_tienda = new javax.swing.JLabel();
        jTextField_id_tienda = new javax.swing.JTextField();
        jTextField__nombre_tienda = new javax.swing.JTextField();
        jTextField_direccion_tienda = new javax.swing.JTextField();
        jButton_guardar_tienda = new javax.swing.JButton();
        jButton_cancelar_tienda = new javax.swing.JButton();
        Leerbuttom = new javax.swing.JButton();
        choice2 = new java.awt.Choice();
        label1 = new java.awt.Label();
        agregarCltButtom = new java.awt.Button();
        jPanel_Cliente = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Cliente = new javax.swing.JTable();
        jLabel_Dni = new javax.swing.JLabel();
        jLabel_nombre_cliente = new javax.swing.JLabel();
        jLabel_telf_cliente = new javax.swing.JLabel();
        jTextField_dni = new javax.swing.JTextField();
        jTextField_nombre_cliente = new javax.swing.JTextField();
        jTextField_telf_cliente = new javax.swing.JTextField();
        jButton_guardar_cliente = new javax.swing.JButton();
        jButton_cancelar_cliente = new javax.swing.JButton();
        jButton_aniadir_cliente = new javax.swing.JButton();
        jButton_modificar_cliente = new javax.swing.JButton();
        jButton_borrar_cliente = new javax.swing.JButton();
        choice1 = new java.awt.Choice();
        button1 = new java.awt.Button();
        jPanel_libro = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_cinta = new javax.swing.JTable();
        jLabel_cod_cinta = new javax.swing.JLabel();
        jLabel_Formato_cinta = new javax.swing.JLabel();
        jTextField_cod_cinta = new javax.swing.JTextField();
        jTextField_formato_cinta = new javax.swing.JTextField();
        jButton_guardar_cinta = new javax.swing.JButton();
        jButton_cancelar_cinta = new javax.swing.JButton();
        jButton_borrar_cinta = new javax.swing.JButton();
        jButton_modificar_cinta = new javax.swing.JButton();
        jButton_aniadir_cinta = new javax.swing.JButton();
        choice3 = new java.awt.Choice();
        button2 = new java.awt.Button();
        label2 = new java.awt.Label();
        jPanel_persona = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_Pelicula = new javax.swing.JTable();
        jLabel_cod_pelicula = new javax.swing.JLabel();
        jLabel_Titulo_pelicula = new javax.swing.JLabel();
        jLabel_Fecha_pelicula = new javax.swing.JLabel();
        jTextField_fecha_pelicula = new javax.swing.JTextField();
        jTextField_cod_pelicula = new javax.swing.JTextField();
        jTextField_titulo_pelicula = new javax.swing.JTextField();
        jButton_guardar_pelicula = new javax.swing.JButton();
        jButton_cancelar_pelicula = new javax.swing.JButton();
        jButton_borrar_pelicula = new javax.swing.JButton();
        jButton_modificar_pelicula = new javax.swing.JButton();
        jButton_aniadir_pelicula = new javax.swing.JButton();
        jLabel_Genero_pelicula = new javax.swing.JLabel();
        jTextField_genero_pelicula = new javax.swing.JTextField();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_tienda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombe", "Direccion"
            }
        ));
        jScrollPane1.setViewportView(jTable_tienda);

        jButton_aniadir_tienda.setText("Añadir");
        jButton_aniadir_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_tiendaActionPerformed(evt);
            }
        });

        jButton_modificar_tienda.setText("Modificar");
        jButton_modificar_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_tiendaActionPerformed(evt);
            }
        });

        jButton_borrar_tienda.setText("Borrar");
        jButton_borrar_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_tiendaActionPerformed(evt);
            }
        });

        jLabel_id_tienda.setText("ID:");

        jLabel_nombre_tienda.setText("Nombre:");

        jLabel_direccion_tienda.setText("Dirección:");

        jTextField_id_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_id_tiendaActionPerformed(evt);
            }
        });

        jTextField__nombre_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField__nombre_tiendaActionPerformed(evt);
            }
        });

        jTextField_direccion_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_direccion_tiendaActionPerformed(evt);
            }
        });

        jButton_guardar_tienda.setText("Guardar");
        jButton_guardar_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_tiendaActionPerformed(evt);
            }
        });

        jButton_cancelar_tienda.setText("Cancelar");
        jButton_cancelar_tienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_tiendaActionPerformed(evt);
            }
        });

        Leerbuttom.setText("Importar Datos ");
        Leerbuttom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeerbuttomActionPerformed(evt);
            }
        });

        choice2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choice2MouseClicked(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label1.setText("Seleccione un Cliente para agregarlo ");

        agregarCltButtom.setLabel("Agregar ");
        agregarCltButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCltButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_tiendaLayout = new javax.swing.GroupLayout(jPanel_tienda);
        jPanel_tienda.setLayout(jPanel_tiendaLayout);
        jPanel_tiendaLayout.setHorizontalGroup(
            jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tiendaLayout.createSequentialGroup()
                .addGroup(jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_tiendaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Leerbuttom)
                            .addGroup(jPanel_tiendaLayout.createSequentialGroup()
                                .addGroup(jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_id_tienda)
                                    .addComponent(jLabel_nombre_tienda)
                                    .addComponent(jLabel_direccion_tienda))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(choice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_id_tienda, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(jTextField__nombre_tienda)
                                    .addComponent(jTextField_direccion_tienda))
                                .addGroup(jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_tiendaLayout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton_guardar_tienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton_cancelar_tienda, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                                    .addGroup(jPanel_tiendaLayout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(agregarCltButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel_tiendaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_modificar_tienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_aniadir_tienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_tienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel_tiendaLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel_tiendaLayout.setVerticalGroup(
            jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_tiendaLayout.createSequentialGroup()
                .addGroup(jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_tiendaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_aniadir_tienda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_tienda))
                    .addGroup(jPanel_tiendaLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_id_tienda)
                    .addComponent(jTextField_id_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nombre_tienda)
                    .addComponent(jTextField__nombre_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_guardar_tienda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_direccion_tienda)
                    .addComponent(jTextField_direccion_tienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancelar_tienda))
                .addGap(42, 42, 42)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel_tiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(choice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarCltButtom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(Leerbuttom)
                .addGap(63, 63, 63))
        );

        jTabbedPane.addTab("Tienda", jPanel_tienda);

        jTable_Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Telefono", "DNI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable_Cliente);

        jLabel_Dni.setText("DNI:");

        jLabel_nombre_cliente.setText("Nombre:");

        jLabel_telf_cliente.setText("Telf");

        jButton_guardar_cliente.setText("Guardar");
        jButton_guardar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_clienteActionPerformed(evt);
            }
        });

        jButton_cancelar_cliente.setText("Cancelar");
        jButton_cancelar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_clienteActionPerformed(evt);
            }
        });

        jButton_aniadir_cliente.setText("Añadir");
        jButton_aniadir_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_clienteActionPerformed(evt);
            }
        });

        jButton_modificar_cliente.setText("Modificar");
        jButton_modificar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_clienteActionPerformed(evt);
            }
        });

        jButton_borrar_cliente.setText("Borrar");
        jButton_borrar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_clienteActionPerformed(evt);
            }
        });

        choice1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choice1MouseClicked(evt);
            }
        });

        button1.setLabel("button1");

        javax.swing.GroupLayout jPanel_ClienteLayout = new javax.swing.GroupLayout(jPanel_Cliente);
        jPanel_Cliente.setLayout(jPanel_ClienteLayout);
        jPanel_ClienteLayout.setHorizontalGroup(
            jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ClienteLayout.createSequentialGroup()
                .addGroup(jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_modificar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_aniadir_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel_ClienteLayout.createSequentialGroup()
                        .addGroup(jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_ClienteLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Dni)
                                    .addComponent(jLabel_nombre_cliente)
                                    .addComponent(jLabel_telf_cliente))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_dni, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(jTextField_nombre_cliente)
                                    .addComponent(jTextField_telf_cliente)))
                            .addGroup(jPanel_ClienteLayout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton_guardar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_cancelar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel_ClienteLayout.setVerticalGroup(
            jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ClienteLayout.createSequentialGroup()
                .addGroup(jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ClienteLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_aniadir_cliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_cliente))
                    .addGroup(jPanel_ClienteLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_ClienteLayout.createSequentialGroup()
                        .addGroup(jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Dni)
                            .addComponent(jTextField_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_nombre_cliente)
                            .addComponent(jTextField_nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_guardar_cliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_telf_cliente)
                            .addComponent(jTextField_telf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_cancelar_cliente))
                        .addGap(104, 104, 104)
                        .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Cliente", jPanel_Cliente);

        jTable_cinta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod_cinta", "Formato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable_cinta);
        if (jTable_cinta.getColumnModel().getColumnCount() > 0) {
            jTable_cinta.getColumnModel().getColumn(0).setResizable(false);
            jTable_cinta.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel_cod_cinta.setText("Cod_cinta");

        jLabel_Formato_cinta.setText("Formato");

        jButton_guardar_cinta.setText("Guardar");
        jButton_guardar_cinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_cintaActionPerformed(evt);
            }
        });

        jButton_cancelar_cinta.setText("Cancelar");
        jButton_cancelar_cinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_cintaActionPerformed(evt);
            }
        });

        jButton_borrar_cinta.setText("Borrar");
        jButton_borrar_cinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_cintaActionPerformed(evt);
            }
        });

        jButton_modificar_cinta.setText("Modificar");
        jButton_modificar_cinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_cintaActionPerformed(evt);
            }
        });

        jButton_aniadir_cinta.setText("Añadir");
        jButton_aniadir_cinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_cintaActionPerformed(evt);
            }
        });

        choice3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choice3MouseClicked(evt);
            }
        });

        button2.setLabel("Almacenar");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label2.setText("Escoja una Peli que almacenar ");

        javax.swing.GroupLayout jPanel_libroLayout = new javax.swing.GroupLayout(jPanel_libro);
        jPanel_libro.setLayout(jPanel_libroLayout);
        jPanel_libroLayout.setHorizontalGroup(
            jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_libroLayout.createSequentialGroup()
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_modificar_cinta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_aniadir_cinta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_borrar_cinta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_libroLayout.createSequentialGroup()
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_cod_cinta)
                                    .addComponent(jLabel_Formato_cinta))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField_cod_cinta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .addComponent(jTextField_formato_cinta, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_libroLayout.createSequentialGroup()
                                .addComponent(choice3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton_guardar_cinta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_cancelar_cinta, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel_libroLayout.setVerticalGroup(
            jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_libroLayout.createSequentialGroup()
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_aniadir_cinta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_cinta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_cinta))
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_cod_cinta)
                            .addComponent(jTextField_cod_cinta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Formato_cinta)
                            .addComponent(jTextField_formato_cinta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_libroLayout.createSequentialGroup()
                        .addComponent(jButton_guardar_cinta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_cancelar_cinta)
                        .addGap(1, 1, 1)))
                .addGap(89, 89, 89)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Cinta", jPanel_libro);

        jTable_Pelicula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod_pelicula", "Titulo", "Fecha", "Genero"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable_Pelicula);
        if (jTable_Pelicula.getColumnModel().getColumnCount() > 0) {
            jTable_Pelicula.getColumnModel().getColumn(0).setResizable(false);
            jTable_Pelicula.getColumnModel().getColumn(1).setResizable(false);
            jTable_Pelicula.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel_cod_pelicula.setText("Cod_peli");

        jLabel_Titulo_pelicula.setText("Titulo:");

        jLabel_Fecha_pelicula.setText("Fecha");

        jButton_guardar_pelicula.setText("Guardar");
        jButton_guardar_pelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_peliculaActionPerformed(evt);
            }
        });

        jButton_cancelar_pelicula.setText("Cancelar");
        jButton_cancelar_pelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelar_peliculaActionPerformed(evt);
            }
        });

        jButton_borrar_pelicula.setText("Borrar");
        jButton_borrar_pelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrar_peliculaActionPerformed(evt);
            }
        });

        jButton_modificar_pelicula.setText("Modificar");
        jButton_modificar_pelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_modificar_peliculaActionPerformed(evt);
            }
        });

        jButton_aniadir_pelicula.setText("Añadir");
        jButton_aniadir_pelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aniadir_peliculaActionPerformed(evt);
            }
        });

        jLabel_Genero_pelicula.setText("Genero");

        javax.swing.GroupLayout jPanel_personaLayout = new javax.swing.GroupLayout(jPanel_persona);
        jPanel_persona.setLayout(jPanel_personaLayout);
        jPanel_personaLayout.setHorizontalGroup(
            jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_personaLayout.createSequentialGroup()
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_cod_pelicula)
                            .addComponent(jLabel_Titulo_pelicula)
                            .addComponent(jLabel_Fecha_pelicula)
                            .addComponent(jLabel_Genero_pelicula))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_cod_pelicula, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(jTextField_titulo_pelicula)
                            .addComponent(jTextField_fecha_pelicula)
                            .addComponent(jTextField_genero_pelicula, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_guardar_pelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_cancelar_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_modificar_pelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_aniadir_pelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_borrar_pelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel_personaLayout.setVerticalGroup(
            jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_personaLayout.createSequentialGroup()
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton_aniadir_pelicula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_modificar_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_borrar_pelicula))
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_cod_pelicula)
                            .addComponent(jTextField_cod_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Titulo_pelicula)
                            .addComponent(jTextField_titulo_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Fecha_pelicula)
                            .addComponent(jTextField_fecha_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_personaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Genero_pelicula)
                            .addComponent(jTextField_genero_pelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_personaLayout.createSequentialGroup()
                        .addComponent(jButton_guardar_pelicula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_cancelar_pelicula)))
                .addContainerGap(243, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Pelicula", jPanel_persona);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );

        jTabbedPane.getAccessibleContext().setAccessibleName("Ciudad");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verificarDatosTiendas() {
        System.out.println("el array de tiendas contiene "+  this.vector_tiendas.size());
    }
    private void verificarDatosClientes() {
        System.out.println("el array de clienes contiene "+  this.vector_clientes.size());
        
    }
    private void verificarDatosCintas(){
        System.out.println("el array de clienes contiene "+  this.vector_cintas.size());
    }
    private void jButton_guardar_tiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_tiendaActionPerformed
       
        int filaSeleccionada = jTable_tienda.getSelectedRow();

        if (filaSeleccionada != -1) {
         
            // Obtener datos de los campos de texto
            String id = jTextField_id_tienda.getText();
            String nombre = jTextField__nombre_tienda.getText();
            String direccion = jTextField_direccion_tienda.getText();

            // Crear una nueva tienda con los datos
            Tienda tiendaModificada = new Tienda(id, nombre, direccion,null);

            // Llamar al método de modificación en el controlador
            controlador.modificarTiendaXML(tiendaModificada,this.id_copia);
            
        } else {
            // Mostrar mensaje de error si no se selecciona una fila
            JOptionPane.showMessageDialog(this, "Selecciona una fila para guardar los cambios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        jButton_guardar_tienda.setVisible(false);
    }//GEN-LAST:event_jButton_guardar_tiendaActionPerformed
 
    public void CargarDatosTiendas(DefaultTableModel model) {
    model.setRowCount(0);
    // Obtener los datos de tiendas desde el controlador (reemplaza 'controlador' con tu instancia real del controlador)
    ArrayList<Tienda> tiendas = (ArrayList<Tienda>) controlador.obtenerTodasLasTiendas();

    for (Tienda tienda : tiendas) {
        model.addRow(new Object[]{tienda.getId_tienda(), tienda.getNombre() ,tienda.getDireccion()});
    }

    jTable_tienda.setDefaultEditor(Object.class, null);
} 
 public void CargarDatosClientes(DefaultTableModel model) {
    model.setRowCount(0);
    // Obtener los datos de tiendas desde el controlador (reemplaza 'controlador' con tu instancia real del controlador)
    ArrayList<Cliente> clientes = (ArrayList<Cliente>) controlador.obtenerTodosLosClientes();

    for (Cliente cliente : clientes) {
        model.addRow(new Object[]{ cliente.getNombre(),cliente.getTlf(),cliente.getDni()});
    }

    jTable_Cliente.setDefaultEditor(Object.class, null);
}
public void CargarDatosPeliculas(DefaultTableModel model){
    model.setRowCount(0);
    ArrayList<Pelicula> peliculas = (ArrayList<Pelicula>) controlador.obtenerTodasLasPeliculas();
    for(Pelicula pelicula : peliculas){
        model.addRow (new Object []{pelicula.getCod_pelicula(),pelicula.getTitulo(),pelicula.getFecha_estreno(),pelicula.getGenero()});
    }
     jTable_Pelicula.setDefaultEditor(Object.class, null);
}
public void CargarDatosCinta(DefaultTableModel model){
    model.setRowCount(0);
    ArrayList<Cinta> cintas = (ArrayList<Cinta>) controlador.obtenerTodasLasCintas();
    for (Cinta cinta : cintas ){
        model.addRow(new Object[]{cinta.getCod_cint(),cinta.getFormato()});
    }
    jTable_cinta.setDefaultEditor(Object.class, null);
}
    
    private void LeerbuttomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeerbuttomActionPerformed
        if (!leido) {
            CargarDatosTiendas((DefaultTableModel) jTable_tienda.getModel());
            CargarDatosClientes((DefaultTableModel)jTable_Cliente.getModel());
            CargarDatosCinta((DefaultTableModel)jTable_cinta.getModel());
            CargarDatosPeliculas((DefaultTableModel)jTable_Pelicula.getModel());
            
            
            leido = true; // Marcar que los datos se han leído
            //Leerbuttom.setEnabled(false);// Deshabilitar el botón "Leer"
        } else {
            JOptionPane.showMessageDialog(this, "Los datos ya se han importado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_LeerbuttomActionPerformed

    private void jTextField_id_tiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_id_tiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_id_tiendaActionPerformed

    private void jTextField__nombre_tiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField__nombre_tiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField__nombre_tiendaActionPerformed

    private void jTextField_direccion_tiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_direccion_tiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_direccion_tiendaActionPerformed

    private void jButton_aniadir_tiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_tiendaActionPerformed
        if(!camposTiendaEstanVacios()){
            String id = jTextField_id_tienda.getText();
            String nombre = jTextField__nombre_tienda.getText();
            String direccion = jTextField_direccion_tienda.getText();
            Tienda nuevaTienda = new Tienda(id, nombre, direccion,null);
            this.controlador.agregarTienda(id, nombre, direccion,null);


            this.controlador.aniadirXML(nuevaTienda, "C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Tiendas.xml");

            CargarDatosTiendas((DefaultTableModel)jTable_tienda.getModel());   
            resetearCamposTienda();
        }else{
             JOptionPane.showMessageDialog(this, "No se puede añadir una tienda con campos vacios ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_aniadir_tiendaActionPerformed
    private boolean camposTiendaEstanVacios() {
        return jTextField_id_tienda.getText().isEmpty() &&
               jTextField__nombre_tienda.getText().isEmpty() &&
               jTextField_direccion_tienda.getText().isEmpty();
    }
    private void resetearCamposTienda() {
        jTextField_id_tienda.setText(""); 
        jTextField__nombre_tienda.setText(""); 
        jTextField_direccion_tienda.setText("");  
    }
    private void jButton_modificar_tiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_tiendaActionPerformed
       
        int filaSeleccionada = jTable_tienda.getSelectedRow();

        if (filaSeleccionada != -1) {
             jButton_guardar_tienda.setVisible(true);
            // Obtener el valor de la primera celda en la fila seleccionada
            Object valorCelda = jTable_tienda.getValueAt(filaSeleccionada, 0); // 0 representa la primera columna
     
            if (valorCelda != null) {
                this.id_copia = valorCelda.toString();
            } else {
                this.id_copia = ""; // Asignar cadena vacía si la celda está vacía
            }
        } else {
            this.id_copia = ""; // Asignar cadena vacía si no se ha seleccionado ninguna fila
        }
        if (filaSeleccionada != -1) {
            String id =  jTextField_id_tienda.getText();
        
            
            String nombre = jTextField__nombre_tienda.getText();
            String direccion = jTextField_direccion_tienda.getText();
            Tienda tiendaModificada = new Tienda(id, nombre, direccion,null);

        

            // Actualizar la tabla de la vista con los datos actualizados
            DefaultTableModel modelo = (DefaultTableModel) jTable_tienda.getModel();
            if (!id.isEmpty()) {
                modelo.setValueAt(id, filaSeleccionada, 0);
            }
            if (!nombre.isEmpty()) {
                modelo.setValueAt(nombre, filaSeleccionada, 1);
            }
            if (!direccion.isEmpty()) {
                modelo.setValueAt(direccion, filaSeleccionada, 2);
            }

            // Notificar a la tabla que los datos han cambiado
            modelo.fireTableDataChanged();
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_modificar_tiendaActionPerformed

    private void jButton_borrar_tiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_tiendaActionPerformed
        int filaSeleccionada = jTable_tienda.getSelectedRow();

        if (filaSeleccionada != -1) {
   
            String idTienda = jTable_tienda.getValueAt(filaSeleccionada, 0).toString();

            // Llamar al método para eliminar la tienda
            controlador.eliminarTienda(idTienda);

            // Actualizar la tabla u otras partes de la interfaz si es necesario
            DefaultTableModel model = (DefaultTableModel) jTable_tienda.getModel();
            model.removeRow(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton_borrar_tiendaActionPerformed

    private void jButton_cancelar_tiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_tiendaActionPerformed
        jTextField_id_tienda.setText("");
        jTextField__nombre_tienda.setText("");
        jTextField_direccion_tienda.setText("");
        jTable_tienda.clearSelection();
        
    }//GEN-LAST:event_jButton_cancelar_tiendaActionPerformed
    private void limpiarCamposCliente() {
        jTextField_nombre_cliente.setText(""); 
        jTextField_telf_cliente.setText("");
        jTextField_dni.setText(""); 
    }
    private boolean camposClienteEstanVacios() {
        return jTextField_dni.getText().isEmpty() &&
               jTextField_nombre_cliente.getText().isEmpty() &&
               jTextField_telf_cliente.getText().isEmpty();
    }
    private boolean camposCintasEstanVacios(){
        return jTextField_cod_cinta.getText().isEmpty() &&jTextField_formato_cinta.getText().isEmpty();
   }
    private void jButton_aniadir_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_clienteActionPerformed
        if(!camposClienteEstanVacios()){
            String nombre = jTextField_nombre_cliente.getText();
            String telefono = jTextField_telf_cliente.getText();
            String dni = jTextField_dni.getText();
            ArrayList <Alquila> alquileres_del_cliente_nuevo = new ArrayList<>();
            Cliente nuevo_clt = new Cliente(dni, nombre, telefono, alquileres_del_cliente_nuevo,null);
            this.controlador.agregarCliente(dni, nombre, telefono, alquileres_del_cliente_nuevo,null);
            this.controlador.agregarClienteXML("C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Clientes.xml", nuevo_clt);
            CargarDatosClientes((DefaultTableModel)jTable_Cliente.getModel());
            limpiarCamposCliente();
        }else{
            JOptionPane.showMessageDialog(this, "No se puede añadir un Cliente con campos vacios ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_aniadir_clienteActionPerformed

    private void jButton_modificar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_clienteActionPerformed
        if (jTable_Cliente.getSelectedRowCount() > 0) {
            int filaSeleccionada = jTable_Cliente.getSelectedRow();
            jButton_guardar_cliente.setVisible(true);

            // Obtener el valor de la primera celda en la fila seleccionada (DNI)
            Object valorCelda = jTable_Cliente.getValueAt(filaSeleccionada, 0);
            Object dni_backup = jTable_Cliente.getValueAt(filaSeleccionada, 2);
            this.dni_copia = dni_backup.toString();

            if (valorCelda != null) {
                // Obtener los valores de los campos de texto para el cliente modificado
                String dni = jTextField_dni.getText();
                String nombre = jTextField_nombre_cliente.getText();
                String telf = jTextField_telf_cliente.getText();

                // Comprobar si los campos no están vacíos y son diferentes
                boolean dniNoVacio = !dni.isEmpty();
                boolean nombreNoVacio = !nombre.isEmpty();
                boolean telfNoVacio = !telf.isEmpty();

                // Actualizar la tabla de la vista con los datos modificados
                DefaultTableModel modelo = (DefaultTableModel) jTable_Cliente.getModel();

                if (dniNoVacio) {
                    modelo.setValueAt(dni, filaSeleccionada, 2);
                }
                if (nombreNoVacio) {
                    modelo.setValueAt(nombre, filaSeleccionada, 0);
                }
                if (telfNoVacio) {
                    modelo.setValueAt(telf, filaSeleccionada, 1);
                }

                // Notificar a la tabla que los datos han cambiado
                modelo.fireTableDataChanged();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_modificar_clienteActionPerformed

    private void jButton_guardar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_clienteActionPerformed
        int filaSeleccionada = jTable_Cliente.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el valor de la primera celda en la fila seleccionada (DNI)
            Object valorCelda = jTable_Cliente.getValueAt(filaSeleccionada, 2);
            Object ValorNombre = jTable_Cliente.getValueAt(filaSeleccionada,0);
            Object ValorTelf = jTable_Cliente.getValueAt(filaSeleccionada,1);
            if (valorCelda != null) {
                String dniOriginal = valorCelda.toString();
                String nombreOriginal = ValorNombre.toString();
                String telfOriginal = ValorTelf.toString();
                
                // Obtener los valores de los campos de texto para el cliente modificado
                String dni = jTextField_dni.getText();
                String nombre = jTextField_nombre_cliente.getText();
                String telf = jTextField_telf_cliente.getText();

                // Comprobar si los campos no están vacíos y son diferentes
                boolean dniNoVacio = !dni.isEmpty();
                boolean nombreNoVacio = !nombre.isEmpty();
                boolean telfNoVacio = !telf.isEmpty();

                // Crear un objeto Cliente con los datos modificados
                Cliente clienteModificado = new Cliente(dniOriginal, nombreOriginal, telfOriginal, null,null);

                // Modificar solo los campos no vacíos
                if (dniNoVacio) {
                    clienteModificado.setDni(dni);
                }
                if (nombreNoVacio) {
                    clienteModificado.setNombre(nombre);
                }
                if (telfNoVacio) {
                    clienteModificado.setTlf(telf);
                }

                // Llamar al método para modificar el cliente en el archivo XML solo si se han realizado cambios
                if (dniNoVacio || nombreNoVacio || telfNoVacio) {
                    controlador.modificarClienteXML("C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Clientes.xml", this.dni_copia, clienteModificado);

                    // Actualizar la tabla de la vista con los datos modificados
                    DefaultTableModel modelo = (DefaultTableModel) jTable_Cliente.getModel();
                    modelo.setValueAt(dniNoVacio ? dni : valorCelda, filaSeleccionada, 2);
                    modelo.setValueAt(nombreNoVacio ? nombre : jTable_Cliente.getValueAt(filaSeleccionada, 0), filaSeleccionada, 0);
                    modelo.setValueAt(telfNoVacio ? telf : jTable_Cliente.getValueAt(filaSeleccionada, 1), filaSeleccionada, 1);

                    // Notificar a la tabla que los datos han cambiado
                    modelo.fireTableDataChanged();
                } else {
                    JOptionPane.showMessageDialog(this, "No se han realizado cambios.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para guardar los cambios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        jButton_guardar_cliente.setVisible(false);
        limpiarCamposCliente();
    }//GEN-LAST:event_jButton_guardar_clienteActionPerformed

    private void jButton_borrar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_clienteActionPerformed
        int filaSeleccionada = jTable_Cliente.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el valor de la primera celda en la fila seleccionada (DNI)
            Object valorCelda = jTable_Cliente.getValueAt(filaSeleccionada, 2);

            if (valorCelda != null) {
                String dniCliente = valorCelda.toString();

                // Llamar al método para eliminar el cliente del archivo XML
                controlador.eliminarCliente(dniCliente);
                 // Limpiar la tabla antes de agregar el nuevo cliente
                      
                        

                // Eliminar la fila seleccionada de la tabla
               DefaultTableModel modelo = (DefaultTableModel) jTable_Cliente.getModel();
                modelo.removeRow(filaSeleccionada);
                modelo.fireTableDataChanged();

                // Notificar a la tabla que los datos han cambiado

                limpiarCamposCliente();
                
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_jButton_borrar_clienteActionPerformed
    private void resetearCamposCinta(){
        jTextField_cod_cinta.setText("");
        jTextField_formato_cinta.setText("");
    }
    private void jButton_aniadir_cintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_cintaActionPerformed
        if(!camposCintasEstanVacios()){
            String codcinta = jTextField_cod_cinta.getText();
            String formato = jTextField_formato_cinta.getText();
            Cinta nuevaCinta = new Cinta (codcinta, formato, null);
            this.controlador.agregarCinta(codcinta,formato,null);
            this.controlador.agregarCintaAXML(nuevaCinta);
            CargarDatosCinta((DefaultTableModel)jTable_cinta.getModel());
            resetearCamposCinta();
        }else{
             JOptionPane.showMessageDialog(this, "No se puede añadir una cinta con campos vacios ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_aniadir_cintaActionPerformed

    private void jButton_modificar_cintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_cintaActionPerformed
        int filaSeleccionada = jTable_cinta.getSelectedRow();   
        if (jTable_cinta.getSelectedRowCount() > 0) {

            jButton_guardar_cinta.setVisible(true);

            // Obtener el valor de la primera celda en la fila seleccionada (DNI)
            Object id_cinta = jTable_cinta.getValueAt(filaSeleccionada, 0);

            this.id_cinta_copia = id_cinta.toString();

            if (id_cinta != null) {
                // Obtener los valores de los campos de texto para la modificada
                String cod_cinta = jTextField_cod_cinta.getText();
                String formato_cinta = jTextField_formato_cinta.getText();
       

                // Comprobar si los campos no están vacíos y son diferentes
                boolean idNoVacio = !cod_cinta.isEmpty();
                boolean formatoNoVacio = !formato_cinta.isEmpty();


                // Actualizar la tabla de la vista con los datos modificados
                DefaultTableModel modelo = (DefaultTableModel) jTable_cinta.getModel();

                if (idNoVacio) {
                    modelo.setValueAt(cod_cinta, filaSeleccionada, 0);
                }
                if (formatoNoVacio) {
                    modelo.setValueAt(formato_cinta, filaSeleccionada, 1);
                }
                if(!idNoVacio && !formatoNoVacio){
                     JOptionPane.showMessageDialog(this, "No se ha recibido ningun cambio todas las cadenas estan vacias ", "Error", JOptionPane.ERROR_MESSAGE);
                }
               
                // Notificar a la tabla que los datos han cambiado
                modelo.fireTableDataChanged();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_jButton_modificar_cintaActionPerformed
    private void LimpiarCamposCintas(){
        jTextField_cod_cinta.setText("");
        jTextField_formato_cinta.setText("");
    }
    private void jButton_guardar_cintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_cintaActionPerformed
         int filaSeleccionada = jTable_cinta.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el valor de la primera celda en la fila seleccionada (DNI)
            Object id_cinta = jTable_cinta.getValueAt(filaSeleccionada, 0);
 
            if (id_cinta != null) {
        
                
                // Obtener los valores de los campos de texto para el cliente modificado
                String cod_cinta = jTextField_cod_cinta.getText();
                String Formato_cinta = jTextField_formato_cinta.getText();


                // Comprobar si los campos no están vacíos y son diferentes
                boolean codNoVacio = !cod_cinta.isEmpty();
                boolean formatoNoVacio =  !Formato_cinta.isEmpty();


                // Llamar al método para modificar el cliente en el archivo XML solo si se han realizado cambios
                if (codNoVacio || formatoNoVacio ) {

                    controlador.modificarCintaEnXML(cod_cinta, Formato_cinta, null,this.id_cinta_copia);
                
                } else {
                    JOptionPane.showMessageDialog(this, "No se han realizado cambios.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para guardar los cambios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        jButton_guardar_cinta.setVisible(false);
        LimpiarCamposCintas();
        
    }//GEN-LAST:event_jButton_guardar_cintaActionPerformed
        private boolean camposPeliculasEstanVacios(){
            return jTextField_cod_pelicula.getText().isEmpty()&&
                    jTextField_titulo_pelicula.getText().isEmpty()&&
                    jTextField_formato_cinta.getText().isEmpty()&&
                    jTextField_fecha_pelicula.getText().isEmpty()&&
                    jTextField_genero_pelicula.getText().isEmpty();
        }
    private void resetearCamposPeli(){
        
        jTextField_cod_pelicula.setText("");
        jTextField_titulo_pelicula.setText("");
        jTextField_fecha_pelicula.setText("");
        jTextField_genero_pelicula.setText("");
    }
    private void jButton_aniadir_peliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aniadir_peliculaActionPerformed
          if(!camposPeliculasEstanVacios()){
            String cod_pelicula = jTextField_cod_pelicula.getText();
            String titulo = jTextField_titulo_pelicula.getText();
            String formato = jTextField_formato_cinta.getText();
            String fecha = jTextField_fecha_pelicula.getText();
            String genero =jTextField_genero_pelicula.getText();
            Pelicula nuevaPeli = new Pelicula(cod_pelicula, titulo, genero, fecha, null);
       
            this.controlador.agregarPelicula(cod_pelicula, titulo, genero, fecha, null);
            this.controlador.agregarPeliculaAXML(nuevaPeli);
            


             CargarDatosPeliculas((DefaultTableModel)jTable_Pelicula.getModel());
            resetearCamposPeli();
        }else{
             JOptionPane.showMessageDialog(this, "No se puede añadir una tienda con campos vacios ", "Error", JOptionPane.ERROR_MESSAGE);
        } // TODO add your handling code here:
    }//GEN-LAST:event_jButton_aniadir_peliculaActionPerformed

    private void jButton_modificar_peliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_modificar_peliculaActionPerformed
           
        int filaSeleccionada = jTable_Pelicula.getSelectedRow();

        if (filaSeleccionada != -1) {
             jButton_guardar_pelicula.setVisible(true);
            // Obtener el valor de la primera celda en la fila seleccionada
            Object valorCelda = jTable_Pelicula.getValueAt(filaSeleccionada, 0); // 0 representa la primera columna
     
            if (valorCelda != null) {
                this.code_pelicula_copia = valorCelda.toString();
            }
        }
        if (filaSeleccionada != -1) {
            String id =  jTextField_cod_pelicula.getText();
        
            
            String titulo = jTextField_titulo_pelicula.getText();
            String genero = jTextField_genero_pelicula.getText();
            String fecha = jTextField_fecha_pelicula.getText();
            Pelicula peliculaMod = new Pelicula (code_pelicula_copia, id, fecha, fecha, null);

        

            // Actualizar la tabla de la vista con los datos actualizados
            DefaultTableModel modelo = (DefaultTableModel) jTable_Pelicula.getModel();
            if (!id.isEmpty()) {
                modelo.setValueAt(id, filaSeleccionada, 0);
            }
            if (!titulo.isEmpty()) {
                modelo.setValueAt(titulo, filaSeleccionada, 1);
            }
            if(!fecha.isEmpty()){
                modelo.setValueAt(fecha, filaSeleccionada, 2);
            }
            if (!genero.isEmpty()) {
                modelo.setValueAt(genero, filaSeleccionada, 3);
            }

            // Notificar a la tabla que los datos han cambiado
            modelo.fireTableDataChanged();
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_modificar_peliculaActionPerformed

    private void jButton_guardar_peliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_peliculaActionPerformed
        int filaSeleccionada = jTable_Pelicula.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el valor de la primera celda en la fila seleccionada (DNI)
            Object id_cinta = jTable_Pelicula.getValueAt(filaSeleccionada, 0);
 
            if (id_cinta != null) {
        
                
                // Obtener los valores de los campos de texto para el cliente modificado
                String cod_peli = jTextField_cod_pelicula.getText();
                String titulo_peli = jTextField_titulo_pelicula.getText();
                String genero = jTextField_genero_pelicula.getText();
                String fech_peli = jTextField_fecha_pelicula.getText();
                


                // Comprobar si los campos no están vacíos y son diferentes
                boolean codNoVacio = !cod_peli.isEmpty();
                boolean tituloNovacio =  !titulo_peli.isEmpty();
                boolean generNoVacio = !genero.isEmpty();
                boolean fechaNoVacia = !fech_peli.isEmpty();


                // Llamar al método para modificar el cliente en el archivo XML solo si se han realizado cambios
                if (codNoVacio || tituloNovacio || generNoVacio || fechaNoVacia) {

                    controlador.modificarPeliculaEnXML(cod_peli, titulo_peli, genero, fech_peli, this.code_pelicula_copia);
                
                } else {
                    JOptionPane.showMessageDialog(this, "No se han realizado cambios.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para guardar los cambios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        jButton_guardar_cinta.setVisible(false);
        resetearCamposPeli();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_guardar_peliculaActionPerformed

    private void jButton_borrar_peliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_peliculaActionPerformed
        int filaSeleccionada = jTable_Pelicula.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener el valor de la primera celda en la fila seleccionada (DNI)
            Object valorCelda = jTable_Pelicula.getValueAt(filaSeleccionada, 0);

            if (valorCelda != null) {
                String cod_peli = valorCelda.toString();

                // Llamar al método para eliminar el cliente del archivo XML
                controlador.borrarPeliculaDelXML(cod_peli);
                 // Limpiar la tabla antes de agregar el nuevo cliente
                      
                        

                // Eliminar la fila seleccionada de la tabla
                DefaultTableModel modelo = (DefaultTableModel) jTable_Pelicula.getModel();
                modelo.removeRow(filaSeleccionada);
                modelo.fireTableDataChanged();

                // Notificar a la tabla que los datos han cambiado

                resetearCamposPeli();
                
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_borrar_peliculaActionPerformed

    private void jButton_cancelar_peliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_peliculaActionPerformed
       resetearCamposPeli();
    }//GEN-LAST:event_jButton_cancelar_peliculaActionPerformed

    private void jButton_cancelar_cintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_cintaActionPerformed
        LimpiarCamposCintas();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_cancelar_cintaActionPerformed

    private void jButton_cancelar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelar_clienteActionPerformed
        limpiarCamposCliente();      
    }//GEN-LAST:event_jButton_cancelar_clienteActionPerformed

    private void choice2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choice2MouseClicked
        agregarCltButtom.setVisible(true);
        int filaSeleccionada = jTable_tienda.getSelectedRow();

        if (filaSeleccionada == -1) {
            // Mostrar un mensaje de error si no se ha seleccionado ninguna fila
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una tienda de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String idTiendaSeleccionada = (String) jTable_tienda.getValueAt(filaSeleccionada, 0);

        ArrayList<Cliente> clientes = (ArrayList<Cliente>) controlador.obtenerTodosLosClientes();

        choice2.removeAll();

        for (Cliente cliente : clientes) {
            if (!cliente.perteneceATienda(idTiendaSeleccionada)) {
                choice2.add(cliente.getNombre());
            }
        }
    }//GEN-LAST:event_choice2MouseClicked
    private Cliente buscarClientePorNombre(String nombreCliente) {
        // Aquí busco un cliente por su nombre y retorno el objeto Cliente correspondiente si lo encuentro.
   
        for (Cliente cliente : vector_clientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente
    }
    private void actualizarListaClientes() {
        
        int filaSeleccionada = jTable_tienda.getSelectedRow();

        if (filaSeleccionada == -1) {
            // Mostrar un mensaje de error al usuario
            JOptionPane.showMessageDialog(this, "Debes seleccionar una tienda primero.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si no se ha seleccionado una tienda
        }

        // Obtener el ID de la tienda seleccionada en jTable_tienda
        String idTiendaSeleccionada = (String) jTable_tienda.getValueAt(filaSeleccionada, 0);

        // Obtener la lista de clientes del sistema
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) controlador.obtenerTodosLosClientes();

        // Limpiar el componente 'choice2' antes de agregar nuevos elementos
        choice2.removeAll();

        // Agregar cada cliente al componente 'choice2' si no pertenece a la tienda seleccionada
        for (Cliente cliente : clientes) {
            if (!cliente.perteneceATienda(idTiendaSeleccionada)) {
                choice2.add(cliente.getNombre());
            }
        }
    }
    private void agregarCltButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCltButtomActionPerformed
          // Obtengo el nombre del cliente seleccionado en el Choice
    String nombreClienteSeleccionado = choice2.getSelectedItem();

    // Busco el objeto Cliente correspondiente al nombre seleccionado
    Cliente clienteSeleccionado = buscarClientePorNombre(nombreClienteSeleccionado);

    if (clienteSeleccionado != null) {
        // Obtener el ID de la tienda seleccionada en la JTable
        int filaSeleccionada = jTable_tienda.getSelectedRow();

        if (filaSeleccionada != -1) {
            String idTiendaSeleccionada = (String) jTable_tienda.getValueAt(filaSeleccionada, 0);

            // Buscar la tienda en el vector de tiendas
            Tienda tiendaSeleccionada = null;
            for (Tienda tienda : this.vector_tiendas) {
                if (tienda.getId_tienda().equals(idTiendaSeleccionada)) {
                    tiendaSeleccionada = tienda;
                    break; // Salir del bucle una vez encontrada la coincidencia
                }
            }

            if (tiendaSeleccionada != null) {
                // Llamar al método para agregar el cliente a la tienda
                controlador.agregarClienteAtiendaXML(clienteSeleccionado);

                // Llamar al método para agregar la tienda al cliente
                controlador.agregarTiendaAClienteXML("C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Clientes.xml", clienteSeleccionado, tiendaSeleccionada);

               
            } else {
                System.err.println("No se encontró la tienda con el ID seleccionado.");
            }
        } else {
            System.err.println("No se ha seleccionado una tienda.");
        }
    } else {
        System.err.println("Cliente no encontrado.");
    }
     actualizarListaClientes();
    agregarCltButtom.setVisible(false);
        
    }//GEN-LAST:event_agregarCltButtomActionPerformed
    public Cliente buscarClientePorDNI(String dni) {
        for (Cliente cliente : vector_clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente; // Se encontró al cliente por su DNI
            }
        }
        return null; // No se encontró al cliente con ese DNI
    }
    private void choice1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choice1MouseClicked
       int filaSeleccionada = jTable_Cliente.getSelectedRow();

    if (filaSeleccionada == -1) {
        return;
    }

    String dniClienteSeleccionado = (String) jTable_Cliente.getValueAt(filaSeleccionada, 2);

    // Obtengo el objeto Cliente correspondiente al DNI seleccionado
    Cliente clienteSeleccionado = buscarClientePorDNI(dniClienteSeleccionado);

    if (clienteSeleccionado != null) {
        // Obtengo los alquileres del cliente
        ArrayList<Alquila> alquileres = clienteSeleccionado.getAlquileres_del_cliente();
         System.out.println(alquileres.size()+ "el cliente tiene estos alquileres ");
        // Limpio el componente 'choice1' antes de agregar nuevos elementos
        choice1.removeAll();

        // Agrego las películas disponibles (que no están en alquileres)
        for (Cinta cinta : vector_cintas) {
            boolean enAlquiler = false;
            for (Alquila alquiler : alquileres) {
                if (alquiler.getId_cinta().equals(cinta.getCod_cint())) {
                    System.out.println(alquiler.getId_cinta()+"cod cinta de alquiler " + cinta.getCod_cint() + " cod cinta a secas ");
                    enAlquiler = true;
                    break;
                }
            }

            if (!enAlquiler) {
                // Busco la película correspondiente al código de cinta
                for (Pelicula pelicula : this.vector_peliculas) {
                    if (pelicula.getCinta_donde_se_almacena().getCod_cint().equals(cinta.getCod_cint())) {
                        choice1.add(pelicula.getTitulo()); // Agrego el título de la película
                        break;
                    }
                }
            }
        }
    }
    }//GEN-LAST:event_choice1MouseClicked

    private void choice3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choice3MouseClicked
            // Limpia el componente 'choice3' antes de agregar nuevos elementos
      choice3.removeAll();

      // Recorre la lista de películas
      for (Pelicula pelicula : this.vector_peliculas) {
          // Verifica si la película no tiene una cinta asignada
          System.out.println(pelicula.getCinta_donde_se_almacena().getCod_cint()+ "codcint");
          if (pelicula.getCinta_donde_se_almacena().getCod_cint()== "N/A") {
              // Agrega el título de la película al 'choice3'
              choice3.add(pelicula.getTitulo());
              
          }
      }
    }//GEN-LAST:event_choice3MouseClicked
private Pelicula buscarPeliculaPorTitulo(String titulo) {
    // Recorre las películas
    for (Pelicula pelicula : this.vector_peliculas) {
        if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
            return pelicula;
        }
    }
    return null; // Si no se encuentra la película, retorna null
}

    private Cinta buscarCintaPorFila(int filaSeleccionada) {
    if (filaSeleccionada >= 0 && filaSeleccionada < jTable_cinta.getRowCount()) {
        // el valor de la columna que contiene el código de la cinta
        String codCinta = (String) jTable_cinta.getValueAt(filaSeleccionada, 0);
        
        // Luego, busca la cinta 
        for (Cinta cinta : this.vector_cintas) {
            if (cinta.getCod_cint().equals(codCinta)) {
                return cinta;
            }
        }
    }
    return null; // Si no se encuentra la cinta, retorna null
}
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

    String tituloPeliculaSeleccionada = choice3.getSelectedItem();
    
    // Busca la película correspondiente al título seleccionado
    Pelicula peliculaSeleccionada = buscarPeliculaPorTitulo(tituloPeliculaSeleccionada);

    // Si la película seleccionada es nula, no se encontró la película
    if (peliculaSeleccionada == null) {
        System.err.println("Pelicula no encontrada.");
        return;
    }

    // Obtiene la fila seleccionada en el jTableCinta
    int filaCintaSeleccionada = jTable_cinta.getSelectedRow();

    // Si no hay cinta seleccionada, muestra un mensaje de error y retorna
    if (filaCintaSeleccionada == -1) {
        System.err.println("Por favor, seleccione una cinta.");
        return;
    }

    // Obtiene la cinta correspondiente a la fila seleccionada
    Cinta cintaSeleccionada = buscarCintaPorFila(filaCintaSeleccionada);

   
    if (cintaSeleccionada.getPelicula_almacenada() == null && peliculaSeleccionada.getCinta_donde_se_almacena().getCod_cint() == "N/A") {
        // Asigna la película a la cinta
        cintaSeleccionada.setPelicula_almacenada(peliculaSeleccionada);
        
        // Asigna la cinta a la película
        peliculaSeleccionada.setCinta_donde_se_almacena(cintaSeleccionada);
        
        // Actualiza las etiquetas o componentes necesarios en tu interfaz gráfica
        controlador.agregarPeliculaACintaXML(cintaSeleccionada,peliculaSeleccionada, "C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Cintas.xml");
        controlador.actualizarPeliculaConCintaXML(peliculaSeleccionada, "C:\\Users\\Zedeon\\Documents\\2DAM\\AD\\TIENDA_PELIS\\src\\main\\Peliculas.xml");
        // por ejemplo, el jTableCinta y la etiqueta de la película
       
    } else {
        System.out.println(  peliculaSeleccionada.getCinta_donde_se_almacena().getCod_cint() + "estaes la cinta  donde se almacena la peli =  " + peliculaSeleccionada.getTitulo());
     
        System.err.println("La cinta ya tiene una película o la película ya está asignada a una cinta.");
    }
    }//GEN-LAST:event_button2ActionPerformed

    private void jButton_borrar_cintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrar_cintaActionPerformed
        
    }//GEN-LAST:event_jButton_borrar_cintaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Leerbuttom;
    private java.awt.Button agregarCltButtom;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Choice choice1;
    private java.awt.Choice choice2;
    private java.awt.Choice choice3;
    private javax.swing.JButton jButton_aniadir_cinta;
    private javax.swing.JButton jButton_aniadir_cliente;
    public javax.swing.JButton jButton_aniadir_pelicula;
    private javax.swing.JButton jButton_aniadir_tienda;
    private javax.swing.JButton jButton_borrar_cinta;
    private javax.swing.JButton jButton_borrar_cliente;
    public javax.swing.JButton jButton_borrar_pelicula;
    private javax.swing.JButton jButton_borrar_tienda;
    public javax.swing.JButton jButton_cancelar_cinta;
    private javax.swing.JButton jButton_cancelar_cliente;
    private javax.swing.JButton jButton_cancelar_pelicula;
    private javax.swing.JButton jButton_cancelar_tienda;
    public javax.swing.JButton jButton_guardar_cinta;
    private javax.swing.JButton jButton_guardar_cliente;
    private javax.swing.JButton jButton_guardar_pelicula;
    private javax.swing.JButton jButton_guardar_tienda;
    private javax.swing.JButton jButton_modificar_cinta;
    private javax.swing.JButton jButton_modificar_cliente;
    public javax.swing.JButton jButton_modificar_pelicula;
    private javax.swing.JButton jButton_modificar_tienda;
    private javax.swing.JLabel jLabel_Dni;
    private javax.swing.JLabel jLabel_Fecha_pelicula;
    private javax.swing.JLabel jLabel_Formato_cinta;
    private javax.swing.JLabel jLabel_Genero_pelicula;
    private javax.swing.JLabel jLabel_Titulo_pelicula;
    private javax.swing.JLabel jLabel_cod_cinta;
    private javax.swing.JLabel jLabel_cod_pelicula;
    private javax.swing.JLabel jLabel_direccion_tienda;
    private javax.swing.JLabel jLabel_id_tienda;
    private javax.swing.JLabel jLabel_nombre_cliente;
    private javax.swing.JLabel jLabel_nombre_tienda;
    private javax.swing.JLabel jLabel_telf_cliente;
    private javax.swing.JPanel jPanel_Cliente;
    private javax.swing.JPanel jPanel_libro;
    private javax.swing.JPanel jPanel_persona;
    private javax.swing.JPanel jPanel_tienda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable_Cliente;
    public javax.swing.JTable jTable_Pelicula;
    private javax.swing.JTable jTable_cinta;
    private javax.swing.JTable jTable_tienda;
    public javax.swing.JTextField jTextField__nombre_tienda;
    private javax.swing.JTextField jTextField_cod_cinta;
    private javax.swing.JTextField jTextField_cod_pelicula;
    public javax.swing.JTextField jTextField_direccion_tienda;
    public javax.swing.JTextField jTextField_dni;
    private javax.swing.JTextField jTextField_fecha_pelicula;
    private javax.swing.JTextField jTextField_formato_cinta;
    private javax.swing.JTextField jTextField_genero_pelicula;
    public javax.swing.JTextField jTextField_id_tienda;
    public javax.swing.JTextField jTextField_nombre_cliente;
    public javax.swing.JTextField jTextField_telf_cliente;
    private javax.swing.JTextField jTextField_titulo_pelicula;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton jbutton_aniadir_tienda;
    public Controlador control ;
}
