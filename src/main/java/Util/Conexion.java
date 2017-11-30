/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Labing
 */
public class Conexion {
 private static Conexion conexion=null;
 //Gestiona la conexion con la base de Datos
 private Connection connection=null;
 
// jdbc:postgresql://Host/Database?user=User&password=Password&ssl=
//true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
//DriverManager.getConnection(dbUrl);
 
 private Conexion() throws SQLException{
     
     try{
         //1.Cargar el driver
         Class.forName("com.mysql.jdbc.Driver"); 
         
     }catch(ClassNotFoundException e){
         
         
     }
     try{
         //2.Obtener la conexion                                               //nombre base de datos
        this.connection= DriverManager.getConnection("jdbc:postgresql://ec2-54-221-246-84.compute-1.amazonaws.com/d6etcdv0odfp3g?user=jktbvhczwvwlew&password=8ce55b778d60fb2d2206637e8e357c27784c4ff2579c47d3d78cced6b30848e0&ssl=\n" +
"true&sslfactory=org.postgresql.ssl.NonValidatingFactory");         
     }catch(SQLException e){
         
         
     }
  
 }
 
 public static Conexion getConexion() throws SQLException{
     if (conexion==null) {
         conexion= new Conexion();
         
     }
     return conexion;
 }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
 
}
