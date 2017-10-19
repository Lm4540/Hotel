/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import uml.tipos_de_habitaciones;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admòn
 */
public class DAOtipos_de_habitaciones implements Operaciones{
    
tipos_de_habitaciones tipo=new tipos_de_habitaciones();
    List<tipos_de_habitaciones> datos = new ArrayList<>();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String sql="";
    Database db = new Database();

    public DAOtipos_de_habitaciones() {       
        try {Class.forName(db.getDriver());} catch (ClassNotFoundException e) {}
    }
       
  ///MOSTRAR DATOS
    @Override
    public List<tipos_de_habitaciones> consultar() {
        sql="SELECT * FROM `tipos_de_habitaciones` ORDER BY `id_tipo` ASC";
        try {
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new tipos_de_habitaciones(rs.getInt(1), rs.getString(2),rs.getDouble(3), rs.getString(4), rs.getInt(4)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
    //INSERTAR DATOS
 @Override
    public boolean insertar(Object obj) {
        tipo = (tipos_de_habitaciones) obj;
        sql = "INSERT INTO `tipos_de_habitaciones` (`nombre`, `precio`, `caracteristicas`, `cantidad`) VALUES (?, ?, ?, ?)";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setString(1, tipo.getNombre());
            pst.setString(3, tipo.getCaracteristicas());
            pst.setDouble(2, tipo.getPrecio());
            pst.setInt(4, tipo.getCantidad());
            
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false;}
    }
    
    //MODIFICAR
 @Override
    public boolean modificar(Object obj) {
        tipo = (tipos_de_habitaciones) obj;
        sql = "UPDATE `tipos_de_habitaciones` SET `nombre` = ?, `precio` = ?, `caracteristicas` = ?, `cantidad` = ? WHERE `tipos_de_habitaciones`.`id_tipo` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setString(1, tipo.getNombre());
            pst.setString(3, tipo.getCaracteristicas());
            pst.setDouble(2, tipo.getPrecio());
            pst.setInt(4, tipo.getCantidad());
            pst.setInt(5, tipo.getCantidad());
            

            int filas = pst.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {return false;}
    }
    
    //ELIMINAR
 @Override
    public boolean eliminar(Object obj) {
        tipo= (tipos_de_habitaciones) obj;
        sql = "DELETE FROM `tipos_de_habitaciones` WHERE `tipos_de_habitaciones`.`id_tipo` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setInt(1, tipo.getId_tipo());
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false; }
    }

    
    //FILTRAR
    @Override
    public List<tipos_de_habitaciones> filtrar(String campo, String valor) {
        sql="select * from tipos_de_habitaciones where "+campo+" like '%"+valor+"%'";
        try {
            
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new tipos_de_habitaciones(rs.getInt(1), rs.getString(2),rs.getDouble(3), rs.getString(4), rs.getInt(4)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
   
}

