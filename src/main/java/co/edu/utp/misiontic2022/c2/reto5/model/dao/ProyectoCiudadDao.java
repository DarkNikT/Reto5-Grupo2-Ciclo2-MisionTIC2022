/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.misiontic2022.c2.reto5.model.dao;


//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import co.edu.utp.misiontic2022.c2.reto5.util.JDBCUtilities;

//Encapsulamiento de los datos
import co.edu.utp.misiontic2022.c2.reto5.model.vo.ProyectoCiudad;

public class ProyectoCiudadDao {

    public ArrayList<ProyectoCiudad> rankingProyectosCiudad() throws SQLException {
        //Se declara un objeto de coneccion "null"
        Connection connection =JDBCUtilities.getConnection();
        ArrayList<ProyectoCiudad> proyectoCiudadList = new ArrayList<>();    
        try {
            String sql = "SELECT proy.Constructora, proy.Fecha_Inicio, proy.Clasificacion "+
            "FROM Proyecto proy "+
            "WHERE proy.Ciudad == 'Pereira'";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                ProyectoCiudad proyectoCiudad = new ProyectoCiudad();
                proyectoCiudad.setConstructora(resultSet.getString("Constructora"));
                proyectoCiudad.setFechaInicio(resultSet.getString("Fecha_Inicio"));
                proyectoCiudad.setClasificacion(resultSet.getString("Clasificacion"));

                proyectoCiudadList.add(proyectoCiudad);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error consulta requerimiento 1" + e);
        }finally{
            // Cerrar la conexión si hubo un problema del Query
            if( connection != null){
                connection.close();
            }
        }
        return proyectoCiudadList;
    }  
}