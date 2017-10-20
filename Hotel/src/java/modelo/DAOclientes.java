/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import uml.clientes;


/**
 *
 * @author Admòn
 */
public class DAOclientes implements Operaciones{
    
clientes cliente=new clientes();
    List<clientes> datos = new ArrayList<>();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String sql="";
    Database db = new Database();

    public DAOclientes() {       
        try {Class.forName(db.getDriver());} catch (ClassNotFoundException e) {}
    }
       
  ///MOSTRAR DATOS
    @Override
    public List<clientes> consultar() {
        sql="SELECT * FROM `clientes` order by nombre";
        try {
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new clientes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
    //INSERTAR DATOS
 @Override
    public boolean insertar(Object obj) {
        cliente = (clientes) obj;
        if(cliente.getId_cliente()==0){
        
        }
        
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
                sql = "INSERT INTO `clientes` (`email`, `nombre`, `tipo_documento`, `numero_documento`) VALUES (?, ?, ?, ?)"; 
                pst=con.prepareStatement(sql);
                pst.setString(1, cliente.getEmail());
                pst.setString(2, cliente.getNombre());
                pst.setString(3, cliente.getTipo_documento());
                pst.setString(4, cliente.getNumero_documento());
               
            
            
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false;}
    }
    
    //MODIFICAR
 @Override
    public boolean modificar(Object obj) {
        cliente = (clientes) obj;
       
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            
                sql="UPDATE `clientes` SET `email` = ?, `nombre` = ?, `tipo_documento` = ?, `numero_documento` = ? WHERE `clientes`.`id_cliente` = ?"; 
                pst=con.prepareStatement(sql);
                pst.setString(1, cliente.getEmail());
                pst.setString(2, cliente.getNombre());
                pst.setString(3, cliente.getTipo_documento());
                pst.setString(4, cliente.getNumero_documento());
                pst.setInt(5, cliente.getId_cliente());
            int filas = pst.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {return false;}
    }
    
    //ELIMINAR
 @Override
    public boolean eliminar(Object obj) {
        cliente= (clientes) obj;
        sql = "DELETE FROM `clientes` WHERE `clientes`.`id_cliente` = ?";
        try {
            con=DriverManager.getConnection(db.getUrl(),db.getUss(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setInt(1, cliente.getId_cliente());
            int filas = pst.executeUpdate();
            return filas>0;
        } catch (SQLException e) {return false; }
    }

    
    //FILTRAR
    @Override
    public List<clientes> filtrar(String campo, String valor) {
        sql="select * from clientes where "+campo+" like '%"+valor+"%'";
        try {
            
            con=DriverManager.getConnection(db.getUrl(), db.getUss(), db.getPass());
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){datos.add(new clientes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));}
            con.close();
            rs.close();
        } catch (SQLException e) { }
        return datos;
    }
   
}

