package co.edu.utp.misiontic2022.c2.reto5.controller;


import co.edu.utp.misiontic2022.c2.reto5.model.vo.LiderCiudad;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.ProyectoCiudad;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.SumaProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.utp.misiontic2022.c2.reto5.view.VistaReto5;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * Clase para realizar las acciones de cada botón de la vista, y relizar las diferentes
 * peticiones a la base de datos.
 * @param vista Vista de la aplicación VistaReto5
 */
public class ControladorVista implements ActionListener{
    private ControladorRequerimientosReto5 controladorRequerimientos;
    private VistaReto5 vista;
    public ControladorVista(VistaReto5 vista){
        // Se inicializa el controlador
        controladorRequerimientos = new ControladorRequerimientosReto5();
        this.vista = vista;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Se recibe el String del comando que lanza cada botón
        String actionCommand = e.getActionCommand();
        // Se revisa que botón fué presionado
        switch (actionCommand){
            // Mostrar el requerimiento 1
            case "REQ1":
                mostrarRequerimiento1();
                break;
            // Mostrar el requerimiento 2
            case "REQ2":
                mostrarRequerimiento2();
                break;
            // Mostrar el requerimiento 3
            case "REQ3":
                mostrarRequerimiento3();
                break;
            // Volver al menu inicial
            case "BACK":
                vista.mostrarMenu();
            default:
        }
    }
    // Método para mostrar los resultados del requerimiento 1.
    public void mostrarRequerimiento1(){
        // Se oculta el panel con los botones y se muestra el panel con la tabla.
        vista.mostrarTablaResultados();
        // Se coloca un titulo con el nombre de la tabla de este requerimiento.
        vista.setTituloTabla("Proyecto Ciudad");
        // Se captura su exite un error con la comunicación con la base de datos.
        try{
            // Se consultan los datos
            ArrayList<ProyectoCiudad> data = controladorRequerimientos.consultarProyectoCiudad();
            //Se crea un array vacio para los campos recibidos y un campo de indice
            Object[][] datosTabla = new Object[data.size()][4];
            // Titulos de los campos de la tabla de requerimiento 1
            String[] titulosTabla = new String[]{"#","Constructora", "Fecha inicio", "Clasificación"};
            // Se llena el array de datos con el ArrayList recibido
            for(int idx = 0; idx < data.size(); idx ++){
                datosTabla[idx][0] = idx;
                datosTabla[idx][1] = data.get(idx).getConstructora();
                datosTabla[idx][2] = data.get(idx).getFechaInicio();
                datosTabla[idx][3] = data.get(idx).getClasificacion();
            }
            
            vista.setDatosTabla(datosTabla, titulosTabla);
        }catch(SQLException exceptionSQL){
            vista.mostrarError(exceptionSQL);
        }
    }
    // Método para mostrar los resultados del requerimiento 2.
    public void mostrarRequerimiento2(){
        // Se oculta el panel con los botones y se muestra el panel con la tabla.
        vista.mostrarTablaResultados();
        // Se coloca un titulo con el nombre de la tabla de este requerimiento.
        vista.setTituloTabla("Suma Proveedor");
        // Se captura su exite un error con la comunicación con la base de datos.
        try{
            // Se consultan los datos
            ArrayList<SumaProveedor> data = controladorRequerimientos.consultarSumaProveedor();
            //Se crea un array vacio para el campo recibido y un campo de indice
            Object[][] datosTabla = new Object[data.size()][2];
            // Titulos de los campos de la tabla de requerimiento 2
            String[] titulosTabla = new String[]{"#","Suma Proveedor"};
            // Se llena el array de datos con el ArrayList recibido
            for(int idx = 0; idx < data.size(); idx ++){
                datosTabla[idx][0] = idx;
                datosTabla[idx][1] = data.get(idx).getSumaProveedor();
            }
            vista.setDatosTabla(datosTabla, titulosTabla);
        }catch(SQLException exceptionSQL){
            vista.mostrarError(exceptionSQL);
        }
    }
    
    // Método para mostrar los resultados del requerimiento 2.
    public void mostrarRequerimiento3(){
        // Se oculta el panel con los botones y se muestra el panel con la tabla.
        vista.mostrarTablaResultados();
        // Se coloca un titulo con el nombre de la tabla de este requerimiento.
        vista.setTituloTabla("Líder Ciudad");
        // Se captura su exite un error con la comunicación con la base de datos.
        try{
            // Se consultan los datos y se pasan al método creado para
            // visualizar este requerimiento en la tabla.
            ArrayList<LiderCiudad> data = controladorRequerimientos.consultarLiderCiudad();
            //Se crea un array vacio para el campo recibido y un campo de indice
            Object[][] datosTabla = new Object[data.size()][2];
            // Titulos de los campos de la tabla de requerimiento 2
            String[] titulosTabla = new String[]{"#","Líder Ciudad"};
            // Se llena el array de datos con el ArrayList recibido
            for(int idx = 0; idx < data.size(); idx ++){
                datosTabla[idx][0] = idx;
                datosTabla[idx][1] = data.get(idx).getLiderCiudad();
            }
            // Se muestra en la tabla los datos
            vista.setDatosTabla(datosTabla, titulosTabla);
        }catch(SQLException exceptionSQL){
            vista.mostrarError(exceptionSQL);
        }
    }
}