 package opet.marketplace.jdbc;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class Connector
 {
/* 11 */   String dbUrl = "jdbc:oracle:thin:@localhost:1521:system";
/* 12 */   String dbUser = "system";
/* 13 */   String dbPassword = "system";
   PreparedStatement preparedStatement;
   ResultSet resultSet;
   Connection connection;
//
//   /* 11 */   String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
//   /* 12 */   String dbUser = "aluno";
//   /* 13 */   String dbPassword = "aluno";
//      PreparedStatement preparedStatement;
//      ResultSet resultSet;
//      Connection connection;



   public Connector()
   {
     try {
/* 21 */       Class.forName("oracle.jdbc.driver.OracleDriver");
     }
     catch (ClassNotFoundException e) {
/* 24 */       e.printStackTrace();
     }
   }

   public Connection connect()
   {
     try
     {
/* 32 */       System.out.println("VAI ABRIR A CONEXAO");
/* 33 */       this.connection = java.sql.DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPassword);
/* 34 */       System.out.println("CONEXAO ABERTA CORRETAMENTE");
     }
     catch (SQLException e)
     {
/* 38 */       e.printStackTrace();
/* 39 */       return null;
     }
/* 41 */     return this.connection;
   }

   public void disconnect()
     throws SQLException
   {
/* 47 */     System.out.println("VAI FECHAR A CONEXAO");
/* 48 */     if (this.preparedStatement != null) {
/* 49 */       this.preparedStatement.close();
     }
/* 51 */     if ((this.connection != null) && (!this.connection.isClosed()))
     {
/* 53 */       this.connection.close();
/* 54 */       System.out.println("CONEXAO FECHADA CORRETAMENTE");
     }
     else
     {
/* 58 */       System.out.println("CONEXAO NAO ESTAVA FECHADA");
     }
   }
 }

