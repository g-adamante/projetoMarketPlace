 package opet.marketplace.dao.jdbc;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import opet.marketplace.dao.IReplyDAO;
import opet.marketplace.jdbc.Connector;
import opet.marketplace.util.ExceptionUtil;
import opet.marketplace.vo.Reply;

 public class ReplyJdbcDAO
   implements IReplyDAO
 {
/*  18 */   private Connection sConnection = new Connector().connect();



   @Override
public Reply create(Reply pReply)
   {
/*  24 */     Reply tReply = null;
     try
     {
/*  27 */       PreparedStatement tPS = null;
/*  28 */       tPS = this.sConnection.prepareStatement(
/*  29 */         "INSERT INTO REPLIES(REPLY_ID, REPLY_CONTENT, REPLY_DATE, REPLY_TOPIC, REPLY_BY) VALUES(REPLIES_SEQ.NEXTVAL,?,?,?,?)");



/*  33 */       tPS.setString(1, pReply.getReplyContent());
/*  34 */       tPS.setDate(2, new java.sql.Date(pReply.getReplyDate().getTime()));
/*  35 */       tPS.setInt(3, pReply.getReplyTopic());
/*  36 */       tPS.setInt(4, pReply.getReplyBy());





/*  42 */       int tQtdeReg = tPS.executeUpdate();


/*  45 */       if (tQtdeReg == 1)
       {
/*  47 */         tReply = pReply;






/*  54 */         Statement currvalStatement = null;
/*  55 */         ResultSet currvalResultSet = null;
/*  56 */         String sql_currval = "SELECT REPLIES_SEQ.CURRVAL FROM dual";

/*  58 */         currvalStatement = this.sConnection.createStatement();
/*  59 */         currvalResultSet = currvalStatement.executeQuery(sql_currval);



/*  63 */         if (currvalResultSet.next()) {
/*  64 */           tReply.setReplyId(

/*  66 */             currvalResultSet.getInt(1));
         }
       }






/*  75 */       tPS.close();
     } catch (SQLException tExcept) {
/*  77 */       ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de inser��o de resposta");
     }

/*  80 */     return tReply;
   }



   @Override
public Reply recovery(int pInt)
   {
/*  87 */     Reply tReply = null;


     try
     {
/*  92 */       PreparedStatement tPS = null;
/*  93 */       tPS = this.sConnection.prepareStatement("SELECT * FROM REPLIES WHERE REPLY_ID = ?");


/*  96 */       tPS.setInt(1, pInt);


/*  99 */       ResultSet tResultSet = tPS.executeQuery();


/* 102 */       if (tResultSet.next())
       {
/* 104 */         tReply = loadReply(tResultSet);
       }


/* 108 */       tResultSet.close();
/* 109 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 112 */       ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o do reply");
     }


/* 116 */     return tReply;
   }


   @Override
public Reply update(Reply pReply)
   {
/* 122 */     Reply tReply = null;

     try
     {
/* 126 */       PreparedStatement tPS = null;
/* 127 */       tPS = this.sConnection.prepareStatement(
/* 128 */         "UPDATE REPLIES SET REPLY_CONTENT = ? WHERE REPLY_ID = ?");


/* 131 */       tPS.setString(1, pReply.getReplyContent());
/* 132 */       tPS.setInt(2, pReply.getReplyId());



/* 136 */       int tQtdeReg = tPS.executeUpdate();


/* 139 */       if (tQtdeReg == 1)
       {
/* 141 */         tReply = pReply;
       }



/* 146 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 149 */       ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do replyo");
     }

/* 152 */     return tReply;
   }

   @Override
public boolean delete(int pInt)
   {
     try
     {
/* 159 */       PreparedStatement tPS = null;
/* 160 */       tPS = this.sConnection.prepareStatement("DELETE FROM REPLIES WHERE REPLY_ID  = ?");


/* 163 */       tPS.setInt(1, pInt);



/* 167 */       int tQtdeReg = tPS.executeUpdate();


/* 170 */       tPS.close();


/* 173 */       return tQtdeReg == 1;
     } catch (SQLException tExcept) {
/* 175 */       ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de dele��o do reply");
     }
/* 177 */     return false;
   }


   @Override
public List<Reply> search()
   {
/* 183 */     List<Reply> tList = new ArrayList();

     try
     {
/* 187 */       PreparedStatement tPS = null;
/* 188 */       tPS = this.sConnection.prepareStatement("SELECT * FROM REPLIES ORDER BY UPPER(REPLY_ID)");



/* 192 */       ResultSet tRS = tPS.executeQuery();



/* 196 */       while (tRS.next())
       {


/* 200 */         Reply tReply = loadReply(tRS);


/* 203 */         tList.add(tReply);
       }


/* 207 */       tRS.close();
/* 208 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 211 */       ExceptionUtil.mostrarErro(tExcept,
/* 212 */         "Erro no m�todo de recuperacao de lsita de reply");
     }

/* 215 */     return tList;
   }


   @Override
public List<Reply> searchByContent(String pString)
   {
/* 221 */     String tSearchReply = "%" + pString + "%";


/* 224 */     List<Reply> tList = new ArrayList();

     try
     {
/* 228 */       PreparedStatement tPS = null;
/* 229 */       tPS = this.sConnection.prepareStatement(

/* 231 */         "SELECT * FROM REPLIES WHERE UPPER(REPLY_CONTENT) LIKE UPPER(?) ORDER BY UPPER(REPLY_ID)");



/* 235 */       tPS.setString(1, tSearchReply);



/* 239 */       ResultSet tRS = tPS.executeQuery();



/* 243 */       while (tRS.next())
       {


/* 247 */         Reply tReply = loadReply(tRS);


/* 250 */         tList.add(tReply);
       }


/* 254 */       tRS.close();
/* 255 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 258 */       ExceptionUtil.mostrarErro(tExcept,
/* 259 */         "Erro no m�todo de pesquisa por mensagem na de lista de replys");
     }

/* 262 */     return tList;
   }



   @Override
public List<Reply> searchByUser(int pInt)
   {
/* 269 */     List<Reply> tList = new ArrayList();

     try
     {
/* 273 */       PreparedStatement tPS = null;
/* 274 */       tPS = this.sConnection.prepareStatement(

/* 276 */         "SELECT * FROM REPLIES WHERE REPLY_BY = ?");



/* 280 */       tPS.setInt(1, pInt);



/* 284 */       ResultSet tRS = tPS.executeQuery();



/* 288 */       while (tRS.next())
       {


/* 292 */         Reply tReply = loadReply(tRS);


/* 295 */         tList.add(tReply);
       }


/* 299 */       tRS.close();
/* 300 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 303 */       ExceptionUtil.mostrarErro(tExcept,
/* 304 */         "Erro no m�todo de pesquisa por usuario (autor) na lista de reply");
     }

/* 307 */     return tList;
   }


   @Override
public List<Reply> searchByTopic(int pInt)
   {
/* 313 */     List<Reply> tList = new ArrayList();

     try
     {
/* 317 */       PreparedStatement tPS = null;
/* 318 */       tPS = this.sConnection.prepareStatement(

/* 320 */         "SELECT * FROM REPLIES WHERE REPLY_TOPIC = ?");



/* 324 */       tPS.setInt(1, pInt);



/* 328 */       ResultSet tRS = tPS.executeQuery();



/* 332 */       while (tRS.next())
       {


/* 336 */         Reply tReply = loadReply(tRS);


/* 339 */         tList.add(tReply);
       }


/* 343 */       tRS.close();
/* 344 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 347 */       ExceptionUtil.mostrarErro(tExcept,
/* 348 */         "Erro no m�todo de pesquisa por topico na lista de reply");
     }

/* 351 */     return tList;
   }







   private Reply loadReply(ResultSet tResultSet)
     throws SQLException
   {
/* 363 */     int replyId = tResultSet.getInt("REPLY_ID");
/* 364 */     String replyContent = tResultSet.getString("REPLY_CONTENT");
/* 365 */     java.sql.Date replyDate = tResultSet.getDate("REPLY_DATE");
/* 366 */     int replyTopic = tResultSet.getInt("REPLY_TOPIC");
/* 367 */     int replyBy = tResultSet.getInt("REPLY_BY");

/* 369 */     Reply tReply = new Reply(replyId, replyContent, replyDate, replyTopic, replyBy);

/* 371 */     return tReply;
   }
 }
