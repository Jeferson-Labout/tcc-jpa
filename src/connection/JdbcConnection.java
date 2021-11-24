/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jefson
 */
public class JdbcConnection {

   
//    private static final String DRIVER = "org.postgresql.Driver";
//    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/rota";
//    private static final String USER = "postgres";
//    private static final String PASS = "190215";
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://45.34.12.245:5432/pgrota";
    private static final String USER = "pgadmin";
    private static final String PASS = "HS3*Zg+cc7!XHdFY";

    public static Connection connection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return connection;
    }

     
    

}
