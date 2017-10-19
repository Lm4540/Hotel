/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Admòn
 */
public class Database {
    
private String driver;
 private String url;
 private String uss;
 private String pass;
 public Database() {
 this.driver = "com.mysql.jdbc.Driver";
 this.url = "jdbc:mysql://localhost:3306/world";
 this.uss = "root";
 this.pass = "";
 }
 public String getDriver() {
 return driver;
 }
 public String getUrl() {
 return url;
 }
 public String getUss() {
 return uss;
 }
 public String getPass() {
 return pass;
 }
}