/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tgid_teste;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WIN10
 */
public class ConnectionDB {
    
    public static Connection con = null;
    public static Statement stmt = null;
    public static ResultSet rs = null;
    
    public void Connection() {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root","root","Antonio220198");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM tgid_schema.clientes;");
            
            while(rs.next()) {
                Object[] obj = new Object[] {rs.getInt("id"), rs.getString("nome"), rs.getString("empresa_cnpj"), rs.getDouble("saldo"), rs.getString("cpf"), rs.getString("usuario"), rs.getString("senha")};
                System.out.println(obj[0] + " " +obj[1] + " " + obj[2] + " " + obj[3] + " " + obj[4] + " " + obj[5] + " " + obj[6]);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            CloseConnection();
        }
        //CloseConnection();
    }
    
    public void CloseConnection() {
        try {
            rs.close();
            stmt.close();
            con.close();
        } catch(Exception ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Object> data(String Identification, String type) {
        ArrayList<Object> result = new ArrayList<Object>();
        if(type.equals("client")){
            String CNPJ = "";
            try {              
                rs = stmt.executeQuery("SELECT * FROM tgid_schema.clientes WHERE cpf='"+Identification+"';");
                while(rs.next()) {
                    CNPJ = rs.getString("empresa_cnpj");
                    result.add(rs.getString("nome"));
                     result.add(rs.getString("cpf"));
                    result.add(rs.getDouble("saldo"));
                }
                rs = stmt.executeQuery("SELECT * FROM tgid_schema.empresas WHERE cnpj='"+CNPJ+"';");
                while(rs.next()) {
                    result.add(rs.getString("nome"));
                    result.add(rs.getDouble("taxa"));
                    result.add(CNPJ);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(type.equals("company")) {
            try {
                rs = stmt.executeQuery("SELECT * FROM tgid_schema.empresas WHERE cnpj='"+Identification+"';");
                while(rs.next()) {
                    result.add(rs.getString("nome"));
                    result.add(rs.getString("saldo"));
                    result.add(rs.getDouble("taxa"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public boolean Deposit(double val, double tax, String cpf, String cnpj) {
        double companyAmount = 0.0;
        try {
            stmt.executeUpdate("UPDATE tgid_schema.clientes SET saldo = '"+val+"' WHERE cpf = '"+cpf+"';");
            rs = stmt.executeQuery("SELECT saldo FROM tgid_schema.empresas WHERE cnpj = '"+cnpj+"'");
            while(rs.next()) {
                companyAmount = rs.getDouble("saldo");
            }
            companyAmount = companyAmount + val + tax;
            stmt.executeUpdate("UPDATE tgid_schema.empresas SET saldo = '"+companyAmount+"' WHERE cnpj = '"+cnpj+"';");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean Withdraw(double val, double tax, String cpf, String cnpj) {
        double companyAmount = 0.0;
        try {
            stmt.executeUpdate("UPDATE tgid_schema.clientes SET saldo = '"+val+"' WHERE cpf = '"+cpf+"';");
            rs = stmt.executeQuery("SELECT saldo FROM tgid_schema.empresas WHERE cnpj = '"+cnpj+"'");
            while(rs.next()) {
                companyAmount = rs.getDouble("saldo");
            }
            companyAmount = companyAmount - val + tax;
            stmt.executeUpdate("UPDATE tgid_schema.empresas SET saldo = '"+companyAmount+"' WHERE cnpj = '"+cnpj+"';");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean ChangeTax(Double tax, String cnpj) {
        try {
            stmt.executeUpdate("UPDATE tgid_schema.empresas SET taxa = '"+tax+"' WHERE cnpj = '"+cnpj+"';");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public String Login(String a1, String a2, String a3) {
        if(a3.equals("client")) {
            try {
                rs = stmt.executeQuery("SELECT * FROM tgid_schema.clientes;");
                while(rs.next()) {
                    if(a1.equals(rs.getString("cpf")) && a2.equals(rs.getString("senha"))) {
                        return rs.getString("cpf");
                    }
                }
            }
            catch(SQLException ex){
                System.out.println(ex);
            }
        }
        else {
            if(a3.equals("company")) {
                try {
                rs = stmt.executeQuery("SELECT * FROM tgid_schema.empresas;");
                while(rs.next()) {
                    if(a1.equals(rs.getString("cnpj")) && a2.equals(rs.getString("senha"))) {
                        return rs.getString("cnpj");
                    }
                }
                }
                catch(SQLException ex){
                    System.out.println(ex);
                }
            }
        }
        return "None";
    }
    
}
