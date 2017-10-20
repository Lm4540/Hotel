/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import uml.usuarios;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admòn
 */
public class DAOreservaciones implements Operaciones{
    
usuarios us=new usuarios();
    List<usuarios> datos = new ArrayList<>();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String sql="";
    Database db = new Database();

    public DAOreservaciones() {       
        try {Class.forName(db.getDriver());} catch (ClassNotFoundException e) {}
    }
       
  ///MOSTRAR DATOS
    @Override
    public List<usuarios> consultar() {
        sql="SELECT * FROM `users` ORDER BY `tipo`";
        try {
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new usuarios(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
    //INSERTAR DATOS
 @Override
    public boolean insertar(Object obj) {
        us = (usuarios) obj;
        sql = "INSERT INTO `reservaciones` (`numero_habitacion`, `id_huesped`, `entrada`, `salida`, `estado`, `fecha_reservacion`, `comentarios`) VALUES ('1', '1', '2017-10-12 12:17:21', '2017-10-12 12:17:21', 'pendiente', CURRENT_TIMESTAMP, 'comentario')";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setString(1, us.getEmail());
            pst.setString(2, us.getTipo());
            pst.setString(3, us.getContraseña());
            
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false;}
    }
    
    //MODIFICAR
 @Override
    public boolean modificar(Object obj) {
        us = (usuarios) obj;
        sql = "UPDATE `usuarios` SET `email` = ?, `tipo` = ?, `contraseña` = ? WHERE `usuarios`.`email` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setString(1, us.getEmail());
            pst.setString(3, us.getContraseña());
            pst.setString(2, us.getTipo());
            pst.setString(4, us.getEmail());
            

            int filas = pst.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {return false;}
    }
    
    //ELIMINAR
 @Override
    public boolean eliminar(Object obj) {
        us= (usuarios) obj;
        sql = "DELETE FROM `usuarios` WHERE `usuarios`.`email` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setString(1, us.getEmail());
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false; }
    }

    
    //FILTRAR
    @Override
    public List<usuarios> filtrar(String campo, String valor) {
        sql="select * from usuarios where "+campo+" like '%"+valor+"%'";
        try {
            
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new usuarios(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
   
}


