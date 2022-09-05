package lexicon.jdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
public static final String URL="jdbc:mysql://localhost:3306/shopping_practice?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Berlin";
public static final String USER="root";
public static final String PASSWORD="root";

public static Connection myConnection(){
    Connection connection= null;
    try{
        connection= DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (SQLException e){
             e.printStackTrace();
}
    return connection;
}
}
