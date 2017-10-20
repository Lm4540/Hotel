/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import uml.platos;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admòn
 */
public class DAOplatos implements Operaciones{
    
platos plato=new platos();
    List<platos> datos = new ArrayList<>();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String sql="";
    Database db = new Database();

    public DAOplatos() {       
        try {Class.forName(db.getDriver());} catch (ClassNotFoundException e) {}
    }
       
  ///MOSTRAR DATOS
    @Override
    public List<platos> consultar() {
        sql="SELECT * FROM `platos`";
        try {
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new platos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
    //INSERTAR DATOS
 @Override
    public boolean insertar(Object obj) {
        plato = (platos) obj;
        sql = "INSERT INTO `platos` (`imagen`, `titulo`, `descripcion`, `categoria`) VALUES (?, ?, ?, ?)";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setString(1, plato.getImagen());
            pst.setString(2, plato.getTitulo());
            pst.setString(3, plato.getDescripcion());
            pst.setInt(4, plato.getCategoria());
            
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false;}
    }
    
    //MODIFICAR
 @Override
    public boolean modificar(Object obj) {
        plato = (platos) obj;
        sql = "UPDATE `platos` SET `imagen` = ?, `titulo` = ?, `descripcion` = ?, `categoria` = ? WHERE `platos`.`id_plato` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setString(1, plato.getImagen());
            pst.setString(3, plato.getTitulo());
            pst.setString(2, plato.getDescripcion());
            pst.setInt(4, plato.getCategoria());
            pst.setInt(5, plato.getId_plato());
            

            int filas = pst.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {return false;}
    }
    
    //ELIMINAR
 @Override
    public boolean eliminar(Object obj) {
        plato= (platos) obj;
        sql = "DELETE FROM `platos` WHERE `platos`.`id_plato` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setInt(1, plato.getId_plato());
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false; }
    }

    
    //FILTRAR
    @Override
    public List<platos> filtrar(String campo, String valor) {
        sql="select * from platos where "+campo+" like '%"+valor+"%'";
        try {
            
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new platos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
   
}


