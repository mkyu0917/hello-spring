package com.hello.hellospring;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mariadbConnection {

    @Test
    public void Connection() throws ClassNotFoundException, SQLException {

        String url="jdbc:mysql://localhost:3306/corona?serverTimezone=UTC";
        String id="mkyu0917";
        String pw="mkyu0917";
        Connection conn= null;

      try {
          Class.forName("org.mariadb.jdbc.Driver");
          conn = DriverManager.getConnection(url, id, pw);
      }catch(SQLException e){

          System.out.println("SQL연결오류");

      }catch(ClassNotFoundException cfe){

          System.out.println(cfe.getMessage());
      }

    }

}
