/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import uml.categorias_plato;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admòn
 */
public class DAOcategorias_plato implements Operaciones{
    
    categorias_plato cat=new categorias_plato();
    List<categorias_plato> datos = new ArrayList<>();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String sql="";
    Database db = new Database();

    public DAOcategorias_plato() {       
        try {Class.forName(db.getDriver());} catch (ClassNotFoundException e) {}
    }
       
  ///MOSTRAR DATOS
    @Override
    public List<categorias_plato> consultar() {
        sql="SELECT * FROM `categorias_plato`";
        try {
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new categorias_plato(rs.getInt(1), rs.getString(2)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
    //INSERTAR DATOS
 @Override
    public boolean insertar(Object obj) {
        cat = (categorias_plato) obj;
        sql = "INSERT INTO `categorias_plato` (`nombre`) VALUES (?)";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setString(1, cat.getNombre());
            
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false;}
    }
    
    //MODIFICAR
 @Override
    public boolean modificar(Object obj) {
        cat = (categorias_plato) obj;
        sql = "UPDATE `categorias_plato` SET `nombre` = ? WHERE `categorias_plato`.`id_categoria` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setString(1, cat.getNombre());
            pst.setInt(2, cat.getId_categoria());
            int filas = pst.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {return false;}
    }
    
    //ELIMINAR
 @Override
    public boolean eliminar(Object obj) {
        cat= (categorias_plato) obj;
        sql = "DELETE FROM `categorias_plato` WHERE `categorias_plato`.`id_categoria` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setInt(1, cat.getId_categoria());
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false; }
    }

    
    //FILTRAR
    @Override
    public List<categorias_plato> filtrar(String campo, String valor) {
        sql="select * from categorias_plato where "+campo+" like '%"+valor+"%'";
        try {
            
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new categorias_plato(rs.getInt(1), rs.getString(2)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
   
}

