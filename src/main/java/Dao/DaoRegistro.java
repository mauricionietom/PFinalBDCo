/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.registro;
import Util.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mnieto
 */
public class DaoRegistro {
    
    private Connection conexion;

    public DaoRegistro() throws SQLException {
        Conexion db = Conexion.getConexion();
        this.conexion = db.getConnection();
    }
    
    public registro objetoRegistro(int idExp) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        String query;
        registro esq = null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Statement stmt = (Statement) conexion.createStatement();
        query = "select colmenahija.idColmenaH, colmena.idcolmena, familia.ubicacion, cajon.idFabrica,sum (registro.kilos) as SumaKilos from colmenahija,colmena,\n" +
"familia,cajon,registro,trabajador where familia.idFamilia = colmenahija.idFamilia and registro.idColmenaH = colmenahija.idColmenaH and \n" +
"Registro.idTrabajador = trabajador.idTrabajador \n" +
"and colmena.idColmena = colmenahija.IdColmena and trabajador.idTrabajador != 123456 GROUP BY cajon.idFabrica, colmenahija.idColmenaH, colmena.idcolmena, familia.ubicacion\n" +
"having sum(registro.kilos)>2 order by sum(registro.kilos) asc limit 10";
        
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();

        System.out.println(query);

        

        while (rs.next()) {
            esq = new registro();

            esq.setIdColmena(rs.getInt("idColmena"));
            esq.setIdColmenaH(rs.getInt("idColmenaH"));
            esq.setIdFabrica(rs.getInt("idFabrica"));
            esq.setUbicacion(rs.getString("ubicaion"));
            esq.setSumaKilos(rs.getInt("sumakilos"));
            
        }

        return esq;
    }
    
    public ArrayList<registro> getRegistro() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        ArrayList<registro> historial = new ArrayList<registro>();
        Statement stmt = (Statement) conexion.createStatement();
        String query = "select colmenahija.idColmenaH, colmena.idcolmena, familia.ubicacion, cajon.idFabrica,sum (registro.kilos) as SumaKilos from colmenahija,colmena,\n" +
"familia,cajon,registro,trabajador where familia.idFamilia = colmenahija.idFamilia and registro.idColmenaH = colmenahija.idColmenaH and \n" +
"Registro.idTrabajador = trabajador.idTrabajador \n" +
"and colmena.idColmena = colmenahija.IdColmena and trabajador.idTrabajador != 123456 GROUP BY cajon.idFabrica, colmenahija.idColmenaH, colmena.idcolmena, familia.ubicacion\n" +
"having sum(registro.kilos)>2 order by sum(registro.kilos) asc limit 10";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();

        registro esq = new registro();
        

        while (rs.next()) {
            esq = new registro();

            esq.setIdColmena(rs.getInt("idColmena"));
            esq.setIdColmenaH(rs.getInt("idColmenaH"));
            esq.setIdFabrica(rs.getInt("idFabrica"));
            esq.setUbicacion(rs.getString("ubicacion"));
            esq.setSumaKilos(rs.getInt("sumakilos"));

            historial.add(esq);

        }
        return historial;
    }
    
}
