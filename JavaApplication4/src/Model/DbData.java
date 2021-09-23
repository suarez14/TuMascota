/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 57301
 */
public class DbData {
    
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String user = "root";
    private final String password = "";
    private final String ulr = "jdbc:mysql://localhost:3306/tumascotacorregida";

 
    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUlr() {
        return ulr;
    }
    
}
