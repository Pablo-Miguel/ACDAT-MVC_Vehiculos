/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vahiculos.acdat.DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vahiculos.acdat.Servicio.Vehiculo;

/**
 *
 * @author Nitro
 */
public class ConexionDB {
    static Connection conn = null;
    static ResultSet rs = null;
    static PreparedStatement stmt = null;
    static String bd = "vehiculos";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/" + bd;
    
    private static void enlace() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            System.out.println("Conexión exitosa");
        } catch (SQLException ex) {
            System.out.println("Excepicon en la conexión");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encuentra la clase");
        } catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public static void insertarVehiculo(Vehiculo vehiculo) throws SQLException, SQLIntegrityConstraintViolationException {
        
        enlace();
        
        try {
            
            String sql = "INSERT INTO vehiculo (Marca, Modelo, Matricula) VALUES (?, ?, ?);";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, vehiculo.getMarca());
            stmt.setString(2, vehiculo.getModelo());
            stmt.setString(3, vehiculo.getMatricula());
            System.out.println(stmt.toString());
            stmt.execute();
            
        } catch (SQLIntegrityConstraintViolationException ex){
            System.out.println("Error SQL: " + ex.toString());
            throw new SQLIntegrityConstraintViolationException();
        } 
        catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
            throw new SQLException();
        }
        
        cerrarSesion();
        
    }
    
    public static List<Vehiculo> getVehiculos() {
        
        enlace();
        List<Vehiculo> listaVehiculos = null;
        
        
        try {
            
            String sql = "SELECT * FROM vehiculo";
            stmt = conn.prepareStatement(sql);
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();
            
            /*
                ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM TABLE2");
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                String name = rsmd.getColumnName(1);
            */
            
            listaVehiculos = new ArrayList<Vehiculo>();
            while (rs.next()) {
                listaVehiculos.add(new Vehiculo(rs.getString("Marca"), rs.getString("Modelo"), rs.getString("Matricula")));
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        cerrarSesion();
        
        return listaVehiculos;

    }
    
    public static Vehiculo getVehiculo(String matricula) {
        
        Vehiculo vehiculo = null;
        enlace();
        
        try {
            
            String sql = "SELECT * FROM vehiculo WHERE matricula = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, matricula);
            System.out.println(stmt.toString());
            rs = stmt.executeQuery();
            
            if(rs.next()){
                vehiculo = new Vehiculo(rs.getString("Marca"), rs.getString("Modelo"), rs.getString("Matricula"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        cerrarSesion();
        
        return vehiculo;
    }
    
    public static Vehiculo updateVehiculo(String matriculaAntigua, String matriculaNueva, String marca, String modelo) {
        enlace();
        
        try {
            
            String sql = "UPDATE vehiculo SET Marca = ?, Modelo = ?, Matricula = ? WHERE Matricula = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, marca);
            stmt.setString(2, modelo);
            stmt.setString(3, matriculaNueva);
            stmt.setString(4, matriculaAntigua);
            System.out.println(stmt.toString());
            stmt.executeUpdate();
            
            return new Vehiculo(marca, modelo, matriculaNueva);
            
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        cerrarSesion();
        
        return null;
    }

    public static Integer deleteVehiculo(String matricula) {
        
        enlace();
        
        try {
            
            String sql = "DELETE FROM vehiculo WHERE matricula = ?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, matricula);
            System.out.println(stmt.toString());
            stmt.execute();
            
            return 0;
            
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        cerrarSesion();
        
        return -1;
    }
    
    private static void cerrarSesion() {
        try {
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("Conexión cerrada \n");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
