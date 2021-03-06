package co.edu.utp.misiontic2022.c2.reto5.view;

import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import co.edu.utp.misiontic2022.c2.reto5.controller.ControladorVista;

/**
 *
 * Date: 15/08/2021
 */
public class VistaReto5 extends javax.swing.JFrame {
    // Declarando controlador para gestion de peticiones SQL
    private ControladorVista controladorVista;
    /**
     * Creates new form VistaReto5
     */    
    public VistaReto5() {
        initComponents();   //Inicializa componentes, método creado por Netbeans
        this.setTitle("Reto 5 Grupo 2 Ciclo 2   MisionTIC2022");   //Se coloca un titulo al JFrame
        
        btnRequerimiento1.setActionCommand("REQ1");
        btnRequerimiento2.setActionCommand("REQ2");
        btnRequerimiento3.setActionCommand("REQ3");
        btnRegresarToMenu.setActionCommand("BACK");
        
        // Se inicializa el controlador para realizar la comunicación con la base de datos
        controladorVista = new ControladorVista(this);
        
        // Se agrega un ActionListener para el botón del requerimiento 1:
        btnRequerimiento1.addActionListener(controladorVista);
        // Se agrega un ActionListener para el botón del requerimiento 2
        btnRequerimiento2.addActionListener(controladorVista);
        // Se agrega un ActionListener para el botón del requerimiento 3
        btnRequerimiento3.addActionListener(controladorVista);
        // Se agrega un ActionListener para el botón de regresar al menú:
        btnRegresarToMenu.addActionListener(controladorVista);
               
        mostrarMenu();
    }
    // Método para empezar a mostrar la ventana en la pantalla.
    public void iniciar(){
        setVisible(true);
    }
    /**
     * Función para que la tabla muestre datos definidos en la tabla.
     * @param datosTabla Object[][] con los datos de la tabla.
     * @param titulosTabla String[] con los titulos de la tabla.
     * Deben tener el mismo tamaño de columnas.
     */
    public void setDatosTabla(Object[][] datosTabla, String[] titulosTabla){
        // Se crea un DefaultTableModel con los datos y titulos de los campos creados anteriormente.
        DefaultTableModel defaultTableModel = new DefaultTableModel(datosTabla,titulosTabla)
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
     * Función para hacer visible el panel de botones y ocultar el panel con la tabla.
     */
    public void mostrarMenu(){
        panelMenuInicial.setVisible(true);panelResultados.setVisible(false);
    }
    
    /**
     * Función para hacer visible el panel con la tabla y ocultar el panel con los botones.
     */
    public void mostrarTablaResultados(){
        panelMenuInicial.setVisible(false);panelResultados.setVisible(true);
    }
    
    /**
     * Función para colocarle el texto al label de titulo de la tabla.
     */
    public void setTituloTabla(String text){
        labelTablaResultado.setText(text);
    }
    
    /**
     * Función para abrir un dialogo en la ventana indicando un error con las consultas a la base de datos.
     */
    public void mostrarError(SQLException exceptionSQL){
        JOptionPane.showMessageDialog(panelContenido, exceptionSQL, "Error SQL", JOptionPane.ERROR_MESSAGE);
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
        btnRequerimiento1 = new ButtonImageComponent("Requerimiento 1",TextoBotones.REQUERIMIENTO1.getTexto(), ImgApp.IMG_REQ_1.toString());
        btnRequerimiento2 = new ButtonImageComponent("Requerimiento 2",TextoBotones.REQUERIMIENTO2.getTexto(), ImgApp.IMG_REQ_2.toString());
        btnRequerimiento3 = new co.edu.utp.misiontic2022.c2.reto5.view.ButtonImageComponent("Requerimiento 3",TextoBotones.REQUERIMIENTO3.getTexto(), ImgApp.IMG_REQ_3.toString());
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelResultados = new javax.swing.JPanel();
        encabezado = new javax.swing.JPanel();
        btnRegresarToMenu = new javax.swing.JButton();
        labelTablaResultado = new javax.swing.JLabel();
        tabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResutados = new javax.swing.JTable();
        panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(ColorAPP.FONDO.getColor());
        setMinimumSize(new java.awt.Dimension(700, 650));
        setName("vistaPrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 650));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panel_inicio.setBackground(ColorAPP.FONDO.getColor());
        panel_inicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panel_inicio.setMinimumSize(new java.awt.Dimension(630, 550));
        panel_inicio.setPreferredSize(new java.awt.Dimension(650, 600));
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

        panelMenuInicial.setMaximumSize(new java.awt.Dimension(5000, 2147483647));
        panelMenuInicial.setName(""); // NOI18N
        panelMenuInicial.setPreferredSize(new java.awt.Dimension(595, 350));
        panelMenuInicial.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(ColorAPP.FONDO.getColor());
        jPanel2.setMaximumSize(new java.awt.Dimension(595, 400));
        jPanel2.setMinimumSize(new java.awt.Dimension(590, 300));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 300));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnRequerimiento1.setForeground(Color.WHITE);
        btnRequerimiento1.setText("Requerimiento 1");
        btnRequerimiento1.setPreferredSize(new java.awt.Dimension(80, 60));
        btnRequerimiento1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(btnRequerimiento1);

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
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelMenuInicial.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        panelContenido.add(panelMenuInicial);

        panelResultados.setBackground(ColorAPP.FONDO.getColor());
        panelResultados.setMaximumSize(new java.awt.Dimension(5905, 32767));
        panelResultados.setMinimumSize(new java.awt.Dimension(590, 23));
        panelResultados.setName(""); // NOI18N
        panelResultados.setLayout(new javax.swing.BoxLayout(panelResultados, javax.swing.BoxLayout.PAGE_AXIS));

        encabezado.setMaximumSize(new java.awt.Dimension(32767, 40));
        encabezado.setOpaque(false);
        encabezado.setPreferredSize(new java.awt.Dimension(1752, 40));
        encabezado.setLayout(new javax.swing.BoxLayout(encabezado, javax.swing.BoxLayout.LINE_AXIS));

        btnRegresarToMenu.setBackground(ColorAPP.FONDO.getColor());
        btnRegresarToMenu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresarToMenu.setForeground(Color.WHITE);
        btnRegresarToMenu.setText("Regresar");
        btnRegresarToMenu.setBorderPainted(false);
        encabezado.add(btnRegresarToMenu);

        labelTablaResultado.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelTablaResultado.setForeground(Color.WHITE);
        labelTablaResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTablaResultado.setText("Resultados");
        labelTablaResultado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelTablaResultado.setMaximumSize(new java.awt.Dimension(2000, 22));
        labelTablaResultado.setMinimumSize(new java.awt.Dimension(308, 22));
        labelTablaResultado.setPreferredSize(new java.awt.Dimension(508, 22));
        labelTablaResultado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        encabezado.add(labelTablaResultado);

        panelResultados.add(encabezado);

        tabla.setOpaque(false);

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

        javax.swing.GroupLayout tablaLayout = new javax.swing.GroupLayout(tabla);
        tabla.setLayout(tablaLayout);
        tablaLayout.setHorizontalGroup(
            tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
            .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tablaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        tablaLayout.setVerticalGroup(
            tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
            .addGroup(tablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(tablaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelResultados.add(tabla);

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
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap())
        );

        panel_inicio.add(panel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(panel_inicio, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresarToMenu;
    private javax.swing.JButton btnRequerimiento1;
    private javax.swing.JButton btnRequerimiento2;
    private javax.swing.JButton btnRequerimiento3;
    private javax.swing.JPanel encabezado;
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
    private javax.swing.JPanel tabla;
    private javax.swing.JTable tablaResutados;
    // End of variables declaration//GEN-END:variables
}
