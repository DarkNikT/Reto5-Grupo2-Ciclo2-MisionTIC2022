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
import co.edu.utp.misiontic2022.c2.reto5.model.vo.ProyectoCiudad;
import co.edu.utp.misiontic2022.c2.reto5.util.JDBCUtilities;

//Encapsulamiento de los datos
import co.edu.utp.misiontic2022.c2.reto5.model.vo.LiderCiudad;

public class LiderCiudadDao {
    /**
     * Solucion requerimiento
     * Obtener el nombre de la constructora, 
     * la fecha de inicio y la clasificación para la ciudad de “Pereira”.
     * @return
     * @throws SQLException
    */
    public ArrayList<LiderCiudad> rankingLiderCiudad() throws SQLException {
         //Se declara un objeto de coneccion
        Connection connection =JDBCUtilities.getConnection();
        ArrayList<LiderCiudad> liderCiudadList = new ArrayList<>();

         try {

             String sql = "SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS [Nombre Líder] " +
             "FROM Lider l " +
             "WHERE Ciudad_Residencia = 'Londres'";
 
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
 
             while(resultSet.next()){
                 LiderCiudad liderCiudad = new LiderCiudad();
                 liderCiudad.setLiderCiudad(resultSet.getString("Nombre Líder"));
                 liderCiudadList.add(liderCiudad);
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
         return liderCiudadList;
     }  

}