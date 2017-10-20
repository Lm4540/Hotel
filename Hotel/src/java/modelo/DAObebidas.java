/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.*;
import uml.bebidas;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admòn
 */
public class DAObebidas implements Operaciones{
    
bebidas bebida=new bebidas();
    List<bebidas> datos = new ArrayList<>();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String sql="";
    Database db = new Database();

    public DAObebidas() {       
        try {Class.forName(db.getDriver());} catch (ClassNotFoundException e) {}
    }
       
  ///MOSTRAR DATOS
    @Override
    public List<bebidas> consultar() {
        sql="SELECT * FROM `bebidas`";
        try {
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new bebidas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
    //INSERTAR DATOS
 @Override
    public boolean insertar(Object obj) {
        bebida = (bebidas) obj;
        sql = "INSERT INTO `bebidas` (`imagen`, `titulo`, `descripcion`) VALUES (?,?,?)";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setString(1, bebida.getImagen());
            pst.setString(2, bebida.getTitulo());
            pst.setString(3, bebida.getDescipcion());
            
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false;}
    }
    
    //MODIFICAR
 @Override
    public boolean modificar(Object obj) {
        bebida = (bebidas) obj;
        sql = "UPDATE `bebidas` SET `imagen` = ?, `titulo` = ?, `descripcion` = ? WHERE `bebidas`.`id_bebida` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            
            pst.setString(1, bebida.getImagen());
            pst.setString(3, bebida.getDescipcion());
            pst.setString(2, bebida.getTitulo());
            pst.setInt(4, bebida.getId_bebida());
            

            int filas = pst.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {return false;}
    }
    
    //ELIMINAR
 @Override
    public boolean eliminar(Object obj) {
        bebida= (bebidas) obj;
        sql = "DELETE FROM `bebidas` WHERE `bebidas`.`id_bebida` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setInt(1, bebida.getId_bebida());
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false; }
    }

    
    //FILTRAR
    @Override
    public List<bebidas> filtrar(String campo, String valor) {
        sql="select * from bebidas where "+campo+" like '%"+valor+"%'";
        try {
            
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new bebidas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
   
}

