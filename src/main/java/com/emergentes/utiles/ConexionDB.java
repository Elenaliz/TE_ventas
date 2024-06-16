package com.emergentes.utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    static String driver = "com.mysql.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_ventas";
    static public String usuario = "root";
    static public String password = "";
    protected Connection conn = null;

    public ConexionDB() {
        try {
            Class.forName(driver);
            System.out.println("Driver cargado correctamente");
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion OK " + conn);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en driver: " + ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Error al conectar: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        System.out.println("Cerrando la BD " + conn);
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConexionDB conexionDB = new ConexionDB();
        conexionDB.desconectar();
    }
}
