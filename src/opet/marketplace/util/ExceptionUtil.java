 package opet.marketplace.util;
 import java.sql.DriverManager;
import java.sql.SQLException;


 public class ExceptionUtil
 {
   public static void mostrarErro(Exception pExcept, String pMsg)
   {
/* 26 */     System.out.println();
/* 27 */     System.out.println(pMsg);
/* 28 */     System.out.println("Exce��o....: " + pExcept.getClass().getName());
/* 29 */     System.out.println("Mensagem...: " + pExcept.getMessage());


/* 32 */     if ((pExcept instanceof SQLException))
     {
/* 34 */       SQLException tExcept = (SQLException)pExcept;
/* 35 */       System.out.println("SQLState...:" + tExcept.getSQLState());
/* 36 */       System.out.println("Error Code.:" + tExcept.getErrorCode());
/* 37 */       DriverManager.println("SQLState...:" + tExcept.getSQLState());
/* 38 */       DriverManager.println("Error Code.:" + tExcept.getErrorCode());
     }


/* 42 */     Throwable tCausa = pExcept.getCause();
/* 43 */     while (tCausa != null)
     {
/* 45 */       System.out.println("Causa.....: " + tCausa.getMessage());
/* 46 */       tCausa = tCausa.getCause();
     }


/* 50 */     System.out.println("Pilha de execu��o");
/* 51 */     pExcept.printStackTrace(System.out);
   }
 }

