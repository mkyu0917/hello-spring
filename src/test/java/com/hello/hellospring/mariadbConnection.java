package com.hello.hellospring;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mariadbConnection {

    @Test
    public void Connection() throws ClassNotFoundException, SQLException {

        String url="jdbc:mysql://localhost:3306/corona?serverTimezone=UTC";
        String id="데이터베이스아이디";
        String pw="데이터베이스비밀번호";
        Connection conn= null;

      try {
          Class.forName("org.mariadb.jdbc.Driver");
          conn = DriverManager.getConnection(url, id, pw);
          System.out.println("연결성공");
      }catch(SQLException e){

          System.out.println("SQL연결오류");

      }catch(ClassNotFoundException cfe){

          System.out.println(cfe.getMessage());
      }

    }

}
