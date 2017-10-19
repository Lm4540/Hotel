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
            while(rs.next()){datos.add(new habitaciones(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
    //INSERTAR DATOS
 @Override
    public boolean insertar(Object obj) {
        ha = (habitaciones) obj;
        sql = "INSERT INTO `usuarios` (`email`, `tipo`, `contraseña`) VALUES (?, ?, ?)";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setString(1, ha.getEmail());
            pst.setString(2, ha.getTipo());
            pst.setString(3, ha.getContraseña());
            
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false;}
    }
    
    //MODIFICAR
 @Override
    public boolean modificar(Object obj) {
        ha = (habitaciones) obj;
        sql = "UPDATE `usuarios` SET `email` = ?, `tipo` = ?, `contraseña` = ? WHERE `usuarios`.`email` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setString(1, ha.getEmail());
            pst.setString(3, ha.getContraseña());
            pst.setString(2, ha.getTipo());
            pst.setString(4, ha.getEmail());
            

            int filas = pst.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {return false;}
    }
    
    //ELIMINAR
 @Override
    public boolean eliminar(Object obj) {
        ha= (habitaciones) obj;
        sql = "DELETE FROM `usuarios` WHERE `usuarios`.`email` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setString(1, ha.getEmail());
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false; }
    }

    
    //FILTRAR
    @Override
    public List<habitaciones> filtrar(String campo, String valor) {
        sql="select * from usuarios where "+campo+" like '%"+valor+"%'";
        try {
            
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new habitaciones(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
   
}


