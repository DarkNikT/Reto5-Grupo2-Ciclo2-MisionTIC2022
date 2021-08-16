package co.edu.utp.misiontic2022.c2.reto5.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import co.edu.utp.misiontic2022.c2.reto5.controller.ControladorRequerimientosReto5;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.LiderCiudad;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.ProyectoCiudad;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.SumaProveedor;

/**
 *
 * Date: 15/08/2021
 */
public class VistaReto5 extends javax.swing.JFrame {
    // Declarando controlador para gestion de peticiones SQL
    private ControladorRequerimientosReto5 controladorQuery;
    // Declarando modelo de datos de la tabla.
    private DefaultTableModel defaultTableModel;

    /**
     * Creates new form VistaReto5
     */    
    public VistaReto5() {
        initComponents();   //Inicializa componentes, método creado por Netbeans
        this.setTitle("Reto 5  Ciclo 2   MisionTIC2022");   //Se coloca un titulo al JFrame
        
        // Se inicializa el controlador para realizar la comunicación con la base de datos
        controladorQuery = new ControladorRequerimientosReto5();
        
        // Se agrega un ActionListener para el botón del requerimiento 1:
        bntRequerimiento1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Se oculta el panel con los botones y se muestra el panel con la tabla.
                panelResultados.setVisible(true);panelMenuInicial.setVisible(false);
                // Se coloca un titulo con el nombre de la tabla de este requerimiento.
                labelTablaResultado.setText("Proyecto Ciudad");
                // Se captura su exite un error con la comunicación con la base de datos.
                try{
                    // Se consultan los datos y se pasan al método creado para
                    // visualizar este requerimiento en la tabla.
                    setResultadosProyectosEnTabla(controladorQuery.consultarProyectoCiudad());
                }catch(SQLException exceptionSQL){
                    JOptionPane.showMessageDialog(panelContenido, exceptionSQL);
                }
            }
        });
        // Se agrega un ActionListener para el botón del requerimiento 2
        btnRequerimiento2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Se oculta el panel con los botones y se muestra el panel con la tabla.
                panelResultados.setVisible(true);panelMenuInicial.setVisible(false);
                // Se coloca un titulo con el nombre de la tabla de este requerimiento.
                labelTablaResultado.setText("Suma Proveedor");
                // Se captura su exite un error con la comunicación con la base de datos.
                try{
                    // Se consultan los datos y se pasan al método creado para
                    // visualizar este requerimiento en la tabla.                    
                    setResultadosSumarEnTabla(controladorQuery.consultarSumaProveedor());
                }catch(SQLException exceptionSQL){
                    JOptionPane.showMessageDialog(panelContenido, exceptionSQL);
                }
            }
        });
        // Se agrega un ActionListener para el botón del requerimiento 3
        btnRequerimiento3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Se oculta el panel con los botones y se muestra el panel con la tabla.
                panelResultados.setVisible(true);panelMenuInicial.setVisible(false);
                // Se coloca un titulo con el nombre de la tabla de este requerimiento.
                labelTablaResultado.setText("Lider Ciudad");
                // Se captura su exite un error con la comunicación con la base de datos.
                try{
                    // Se consultan los datos y se pasan al método creado para
                    // visualizar este requerimiento en la tabla.
                    setResultadosLiderEnTabla(controladorQuery.consultarLiderCiudad());
                }catch(SQLException exceptionSQL){
                    JOptionPane.showMessageDialog(panelContenido, exceptionSQL);
                }
            }
        });
        
        // Se agrega un ActionListener para el botón de regresar al menú:
        btnRegresarToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Se oculta el panel con la tsbla y se muestra el panel con los botones.
                panelMenuInicial.setVisible(true);panelResultados.setVisible(false);
            }
        });
               
        panelResultados.setVisible(false);
    }
    
    /**
     * Función para colocar los datos recibidos del controlador para el requerimiento 1
     * en la tabla de resultados.
     * @param data ArrayList<ProyectoCiudad>
     */    
    private void setResultadosProyectosEnTabla(ArrayList<ProyectoCiudad> data){
        //Se crea un array vacio para los tres campos recibidos y un campo de indice
        Object[][] datosTabla = new Object[data.size()][4]; 
        // Titulos de los campos de la tabla de requerimiento 1
        String[] titulosTabla = new String[]{"#","Nombre Constructora", "Fecha", "Clasificacion"};
        // Se llena el array de datos con el ArrayList recibido
        for(int idx = 0; idx < data.size(); idx ++){
            datosTabla[idx][0] = idx;
            datosTabla[idx][1] = data.get(idx).getConstructora();
            datosTabla[idx][2] = data.get(idx).getFechaInicio();
            datosTabla[idx][3] = data.get(idx).getClasificacion();
        }
        // Se crea un DefaultTableModel con los datos y titulos de los campos creados anteriormente.
        defaultTableModel = new DefaultTableModel(datosTabla,titulosTabla)
        {
            //Se modifica el render de las celdas para que no se puedan editar
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        // Se agrega el modelo de la tabla a la tabla del formulario.
        tablaResutados.setModel(defaultTableModel);
        // se define que la columna del indice tenga un tamaño menor
        tablaResutados.getColumnModel().getColumn(0).setPreferredWidth(20);
        tablaResutados.getColumnModel().getColumn(0).setMaxWidth(20);
    }
    /**
     * Función para colocar los datos recibidos del controlador para el requerimiento 2
     * en la tabla de resultados.
     * @param data ArrayList<SumaProveedor>
     */    
    private void setResultadosSumarEnTabla(ArrayList<SumaProveedor> data){
        //Se crea un array vacio para el campo recibido y un campo de indice
        Object[][] datosTabla = new Object[data.size()][2];
        // Titulos de los campos de la tabla de requerimiento 2
        String[] titulosTabla = new String[]{"#","Suma Cantidad"};
        // Se llena el array de datos con el ArrayList recibido
        for(int idx = 0; idx < data.size(); idx ++){
            datosTabla[idx][0] = idx;
            datosTabla[idx][1] = data.get(idx).getSumaProveedor();
        }
        // Se crea un DefaultTableModel con los datos y titulos de los campos creados anteriormente.
        defaultTableModel = new DefaultTableModel(datosTabla,titulosTabla)
        {
            //Se modifica el render de las celdas para que no se puedan editar
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };       
        // Se agrega el modelo de la tabla a la tabla del formulario.
        tablaResutados.setModel(defaultTableModel);
        // se define que la columna del indice tenga un tamaño menor
        tablaResutados.getColumnModel().getColumn(0).setPreferredWidth(20);
        tablaResutados.getColumnModel().getColumn(0).setMaxWidth(20);
    }
    /**
     * Función para colocar los datos recibidos del controlador para el requerimiento 3
     * en la tabla de resultados.
     * @param data ArrayList<LiderCiudad>
     */ 
    private void setResultadosLiderEnTabla(ArrayList<LiderCiudad> data){
        //Se crea un array vacio para el campo recibido y un campo de indice
        Object[][] datosTabla = new Object[data.size()][2];
        // Titulos de los campos de la tabla de requerimiento 3
        String[] titulosTabla = new String[]{"#","Líder Ciudad"};
        // Se llena el array de datos con el ArrayList recibido
        for(int idx = 0; idx < data.size(); idx ++){
            datosTabla[idx][0] = idx;
            datosTabla[idx][1] = data.get(idx).getLiderCiudad();
        }
        // Se crea un DefaultTableModel con los datos y titulos de los campos creados anteriormente.
        defaultTableModel = new DefaultTableModel(datosTabla,titulosTabla)
        {
            //Se modifica el render de las celdas para que no se puedan editar
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };       
        // Se agrega el modelo de la tabla a la tabla del formulario.
        tablaResutados.setModel(defaultTableModel);
        // se define que la columna del indice tenga un tamaño menor
        tablaResutados.getColumnModel().getColumn(0).setPreferredWidth(20);
        tablaResutados.getColumnModel().getColumn(0).setMaxWidth(20);
    }
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel_inicio = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        panelLogoUTP = new ImageComponent(ImgApp.LOGO_UTP.toString());
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        javax.swing.JPanel panelLogoMisiontic = new ImageComponent(ImgApp.LOGO_MISIONTIC.toString());
        panelContenido = new javax.swing.JPanel();
        panelMenuInicial = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bntRequerimiento1 = new ButtonImageComponent("Requerimiento 1",TextoBotones.REQUERIMIENTO1.getTexto(), ImgApp.IMG_REQ_1.toString());
        btnRequerimiento2 = new ButtonImageComponent("Requerimiento 2",TextoBotones.REQUERIMIENTO2.getTexto(), ImgApp.IMG_REQ_2.toString());
        btnRequerimiento3 = new co.edu.utp.misiontic2022.c2.reto5.view.ButtonImageComponent("Requerimiento 3",TextoBotones.REQUERIMIENTO3.getTexto(), ImgApp.IMG_REQ_3.toString());
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelResultados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResutados = new javax.swing.JTable();
        btnRegresarToMenu = new javax.swing.JButton();
        labelTablaResultado = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        setMinimumSize(new java.awt.Dimension(700, 650));
        setName("vistaPrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 650));
        getContentPane().setLayout(new java.awt.BorderLayout(5, 10));

        panel_inicio.setBackground(ColorAPP.FONDO.getColor());
        panel_inicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel_inicio.setLayout(new javax.swing.BoxLayout(panel_inicio, javax.swing.BoxLayout.PAGE_AXIS));

        panelTitulo.setBackground(ColorAPP.FONDO.getColor());
        panelTitulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelTitulo.setMaximumSize(new java.awt.Dimension(7000, 110));
        panelTitulo.setMinimumSize(new java.awt.Dimension(360, 90));
        panelTitulo.setName(""); // NOI18N
        panelTitulo.setPreferredSize(new java.awt.Dimension(600, 70));
        panelTitulo.setLayout(new javax.swing.BoxLayout(panelTitulo, javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setBackground(ColorAPP.FONDO.getColor());
        jPanel4.setPreferredSize(new java.awt.Dimension(150, 120));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        panelLogoUTP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelLogoUTP.setToolTipText("");
        panelLogoUTP.setMaximumSize(new java.awt.Dimension(180, 80));
        panelLogoUTP.setMinimumSize(new java.awt.Dimension(150, 70));
        panelLogoUTP.setOpaque(false);
        panelLogoUTP.setPreferredSize(new java.awt.Dimension(150, 80));

        javax.swing.GroupLayout panelLogoUTPLayout = new javax.swing.GroupLayout(panelLogoUTP);
        panelLogoUTP.setLayout(panelLogoUTPLayout);
        panelLogoUTPLayout.setHorizontalGroup(
            panelLogoUTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        panelLogoUTPLayout.setVerticalGroup(
            panelLogoUTPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel4.add(panelLogoUTP, gridBagConstraints);

        panelTitulo.add(jPanel4);

        jPanel1.setBackground(ColorAPP.FONDO.getColor());
        jPanel1.setMinimumSize(new java.awt.Dimension(158, 120));
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setBackground(ColorAPP.TITULO.getColor());
        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RETO 5 ");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setMaximumSize(new java.awt.Dimension(48, 15));
        jLabel1.setMinimumSize(new java.awt.Dimension(48, 15));
        jPanel1.add(jLabel1);

        jLabel2.setBackground(ColorAPP.TITULO.getColor());
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CICLO 2: PROGRAMACIÓN JAVA");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel2);

        panelTitulo.add(jPanel1);

        jPanel5.setBackground(ColorAPP.FONDO.getColor());
        jPanel5.setLayout(new java.awt.GridBagLayout());

        panelLogoMisiontic.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelLogoMisiontic.setMaximumSize(new java.awt.Dimension(180, 80));
        panelLogoMisiontic.setMinimumSize(new java.awt.Dimension(150, 70));
        panelLogoMisiontic.setName(""); // NOI18N
        panelLogoMisiontic.setPreferredSize(new java.awt.Dimension(150, 80));

        javax.swing.GroupLayout panelLogoMisionticLayout = new javax.swing.GroupLayout(panelLogoMisiontic);
        panelLogoMisiontic.setLayout(panelLogoMisionticLayout);
        panelLogoMisionticLayout.setHorizontalGroup(
            panelLogoMisionticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        panelLogoMisionticLayout.setVerticalGroup(
            panelLogoMisionticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );

        jPanel5.add(panelLogoMisiontic, new java.awt.GridBagConstraints());

        panelTitulo.add(jPanel5);

        panel_inicio.add(panelTitulo);

        panelContenido.setBackground(ColorAPP.FONDO.getColor());
        panelContenido.setMaximumSize(new java.awt.Dimension(5000, 5000));
        panelContenido.setOpaque(false);
        panelContenido.setPreferredSize(new java.awt.Dimension(595, 300));
        panelContenido.setLayout(new javax.swing.OverlayLayout(panelContenido));

        panelMenuInicial.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(ColorAPP.FONDO.getColor());
        jPanel2.setMaximumSize(new java.awt.Dimension(595, 400));
        jPanel2.setMinimumSize(new java.awt.Dimension(590, 300));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 300));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        bntRequerimiento1.setForeground(Color.WHITE);
        bntRequerimiento1.setText("Requerimiento 1");
        bntRequerimiento1.setPreferredSize(new java.awt.Dimension(80, 60));
        bntRequerimiento1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(bntRequerimiento1);

        btnRequerimiento2.setForeground(Color.WHITE);
        btnRequerimiento2.setText("Requerimiento 2");
        btnRequerimiento2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(btnRequerimiento2);

        btnRequerimiento3.setBackground(new java.awt.Color(204, 204, 204));
        btnRequerimiento3.setForeground(Color.WHITE);
        btnRequerimiento3.setText("Requerimiento 3");
        btnRequerimiento3.setToolTipText("");
        btnRequerimiento3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRequerimiento3.setSelected(true);
        btnRequerimiento3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(btnRequerimiento3);

        panelMenuInicial.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(ColorAPP.FONDO.getColor());
        jPanel9.setForeground(Color.WHITE);
        jPanel9.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jPanel9.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel9.setMinimumSize(new java.awt.Dimension(0, 50));
        jPanel9.setOpaque(true);
        jPanel9.setPreferredSize(new java.awt.Dimension(605, 50));

        jLabel4.setBackground(ColorAPP.FONDO.getColor());
        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(ColorAPP.TITULO.getColor());
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Seleccione una opción");
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelMenuInicial.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        panelContenido.add(panelMenuInicial);

        panelResultados.setBackground(ColorAPP.FONDO.getColor());
        panelResultados.setMaximumSize(new java.awt.Dimension(595, 32767));
        panelResultados.setMinimumSize(new java.awt.Dimension(590, 23));

        tablaResutados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaResutados);

        btnRegresarToMenu.setBackground(ColorAPP.FONDO.getColor());
        btnRegresarToMenu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresarToMenu.setForeground(Color.WHITE);
        btnRegresarToMenu.setText("Regresar");
        btnRegresarToMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRegresarToMenu.setBorderPainted(false);

        labelTablaResultado.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelTablaResultado.setForeground(Color.WHITE);
        labelTablaResultado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTablaResultado.setText("Resultados");

        javax.swing.GroupLayout panelResultadosLayout = new javax.swing.GroupLayout(panelResultados);
        panelResultados.setLayout(panelResultadosLayout);
        panelResultadosLayout.setHorizontalGroup(
            panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelResultadosLayout.createSequentialGroup()
                        .addComponent(btnRegresarToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelTablaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelResultadosLayout.setVerticalGroup(
            panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegresarToMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(labelTablaResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelContenido.add(panelResultados);

        panel_inicio.add(panelContenido);

        panel.setBackground(ColorAPP.FONDO.getColor());
        panel.setMaximumSize(new java.awt.Dimension(32767, 50));
        panel.setPreferredSize(new java.awt.Dimension(605, 50));

        jLabel5.setBackground(ColorAPP.FONDO.getColor());
        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setForeground(ColorAPP.TITULO.getColor());
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("<html>Realizado por: Fabian David Guevara Pinilla <br> 2021</html>");
        jLabel5.setOpaque(true);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap())
        );

        panel_inicio.add(panel);

        getContentPane().add(panel_inicio, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntRequerimiento1;
    private javax.swing.JButton btnRegresarToMenu;
    private javax.swing.JButton btnRequerimiento2;
    private javax.swing.JButton btnRequerimiento3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTablaResultado;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelLogoUTP;
    private javax.swing.JPanel panelMenuInicial;
    private javax.swing.JPanel panelResultados;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JPanel panel_inicio;
    private javax.swing.JTable tablaResutados;
    // End of variables declaration//GEN-END:variables
}
