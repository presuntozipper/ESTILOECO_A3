package com.projetoa3.alpha0001;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {
   private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/ecoestilos";
   private static final String USER = "root";
   private static final String PASS = "2807";
   static Connection connect;

   public static Connection getConnection() throws SQLException {
      try {
          if (connect == null) {
              connect = DriverManager.getConnection(DB_URL, USER, PASS);
          }
          return connect;
      }catch (SQLException e) {
          return null;
      }
   }
    public ConnectDb() throws SQLException {
    }
}


