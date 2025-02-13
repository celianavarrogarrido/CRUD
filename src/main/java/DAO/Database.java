package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    // Establece la base de datos
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/asignaturas"; 
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    static {
        try {
            // Cargar el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("No se pudo cargar el driver de MySQL");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}