/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import uml.habitaciones;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admòn
 */
public class DAOhabitaciones implements Operaciones{
    
habitaciones ha=new habitaciones();
    List<habitaciones> datos = new ArrayList<>();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String sql="";
    Database db = new Database();

    public DAOhabitaciones() {       
        try {Class.forName(db.getDriver());} catch (ClassNotFoundException e) {}
    }
       
  ///MOSTRAR DATOS
    @Override
    public List<habitaciones> consultar() {
        sql="SELECT * FROM `habitaciones`";
        try {
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new habitaciones(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
    //INSERTAR DATOS
 @Override
    public boolean insertar(Object obj) {
        ha = (habitaciones) obj;
        sql = "INSERT INTO `habitaciones` (`numero`, `piso`, `disponible`, `tipo`) VALUES (?, ?, ?, ?)";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setInt(1, ha.getNumero());
            pst.setInt(2, ha.getPiso());
            pst.setString(3, ha.getDisponible());
            pst.setInt(4, ha.getTipo());
            
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false;}
    }
    
    //MODIFICAR
 @Override
    public boolean modificar(Object obj) {
        ha = (habitaciones) obj;
        sql = "UPDATE `habitaciones` SET `piso` = ?, `disponible` = ?, `tipo` = ? WHERE `habitaciones`.`numero` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setInt(1, ha.getPiso());
            pst.setString(2, ha.getDisponible());
            pst.setInt(3, ha.getTipo());
            pst.setInt(4, ha.getNumero());
            

            int filas = pst.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {return false;}
    }
    
    //ELIMINAR
 @Override
    public boolean eliminar(Object obj) {
        ha= (habitaciones) obj;
        sql = "DELETE FROM `habitaciones` WHERE `habitaciones`.`numero` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setInt(1, ha.getNumero());
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false; }
    }

    
    //FILTRAR
    @Override
    public List<habitaciones> filtrar(String campo, String valor) {
        sql="select * from habitaciones where "+campo+" like '%"+valor+"%'";
        try {
            
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new habitaciones(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
   
}


