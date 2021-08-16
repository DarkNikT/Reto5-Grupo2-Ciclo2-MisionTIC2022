/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.reto5.controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import co.edu.utp.misiontic2022.c2.reto5.model.dao.ProyectoCiudadDao;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.ProyectoCiudad;
import co.edu.utp.misiontic2022.c2.reto5.model.dao.LiderCiudadDao;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.LiderCiudad;
import co.edu.utp.misiontic2022.c2.reto5.model.dao.SumaProveedorDao;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.SumaProveedor;

//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientosReto5 {

    //declarar modelo requerimiento 1
    private ProyectoCiudadDao proyectoCiudadDao;
    private LiderCiudadDao liderCiudadDao ;
    private SumaProveedorDao sumaProveedorDao;

    public ControladorRequerimientosReto5(){
        this.proyectoCiudadDao = new ProyectoCiudadDao();
        this.liderCiudadDao = new LiderCiudadDao();
        this.sumaProveedorDao = new SumaProveedorDao();
    }

    public ArrayList<ProyectoCiudad> consultarProyectoCiudad() throws SQLException {
        return this.proyectoCiudadDao.rankingProyectosCiudad();
    }

    public ArrayList<LiderCiudad> consultarLiderCiudad() throws SQLException {
        return this.liderCiudadDao.rankingLiderCiudad();
    }

    public ArrayList<SumaProveedor> consultarSumaProveedor() throws SQLException {
        return this.sumaProveedorDao.rankingSumaProveedor();
    }
}

