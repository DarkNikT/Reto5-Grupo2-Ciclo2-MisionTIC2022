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
import co.edu.utp.misiontic2022.c2.reto5.model.vo.SumaProveedor;

public class SumaProveedorDao {

    public ArrayList<SumaProveedor> rankingSumaProveedor() throws SQLException {
        //Se declara un objeto de coneccion "null"
        Connection connection = JDBCUtilities.getConnection();
        ArrayList<SumaProveedor> sumarProveedorList = new ArrayList<>();
        try {
            String sql = "SELECT SUM(c.Cantidad) AS 'Suma' FROM Compra c WHERE c.Proveedor  == 'Homecenter'";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                SumaProveedor sumaProveedor = new SumaProveedor();
                sumaProveedor.setSumaProveedor(resultSet.getString("Suma"));
                sumarProveedorList.add(sumaProveedor);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error DAO requerimiento 3" + e);
        }finally{
            // Cerrar la conexión si hubo un problema del Query
            if( connection != null){
                connection.close();
            }
        }
        return sumarProveedorList;
    }  
}