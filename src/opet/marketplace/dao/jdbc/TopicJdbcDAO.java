 package opet.marketplace.dao.jdbc;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import opet.marketplace.dao.ITopicDAO;
import opet.marketplace.jdbc.Connector;
import opet.marketplace.util.ExceptionUtil;
import opet.marketplace.vo.Categories;
import opet.marketplace.vo.Topic;

 public class TopicJdbcDAO
   implements ITopicDAO
 {
/*  19 */   private Connection sConnection = new Connector().connect();


   @Override
public Topic create(Topic pTopic)
   {
/*  24 */     Topic tTopic = null;


/*  27 */     int categoryInt = pTopic.getTopicCategory().ordinal();
     try
     {
/*  30 */       PreparedStatement tPS = null;
/*  31 */       tPS = this.sConnection.prepareStatement(
/*  32 */         "INSERT INTO TOPICS(TOPIC_ID, TOPIC_SUBJECT, TOPIC_MESSAGE, TOPIC_DATE, TOPIC_CAT, TOPIC_BY) VALUES(TOPIC_SEQ.NEXTVAL,?,?,?,?,?)");



/*  36 */       tPS.setString(1, pTopic.getTopicSubject());
/*  37 */       tPS.setString(2, pTopic.getTopicMessage());
/*  38 */       tPS.setDate(3, new java.sql.Date(pTopic.getTopicDate().getTime()));
/*  39 */       tPS.setInt(4, categoryInt);
/*  40 */       tPS.setInt(5, pTopic.getTopicBy());





/*  46 */       int tQtdeReg = tPS.executeUpdate();


/*  49 */       if (tQtdeReg == 1)
       {
/*  51 */         tTopic = pTopic;






/*  58 */         Statement currvalStatement = null;
/*  59 */         ResultSet currvalResultSet = null;
/*  60 */         String sql_currval = "SELECT TOPIC_SEQ.CURRVAL FROM dual";

/*  62 */         currvalStatement = this.sConnection.createStatement();
/*  63 */         currvalResultSet = currvalStatement.executeQuery(sql_currval);



/*  67 */         if (currvalResultSet.next()) {
/*  68 */           tTopic.setTopicId(

/*  70 */             currvalResultSet.getInt(1));
         }
       }






/*  79 */       tPS.close();
     } catch (SQLException tExcept) {
/*  81 */       ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de inser��o de topico");
     }

/*  84 */     return tTopic;
   }



   @Override
public Topic recovery(int pInt)
   {
/*  91 */     Topic tTopic = null;


     try
     {
/*  96 */       PreparedStatement tPS = null;
/*  97 */       tPS = this.sConnection.prepareStatement("SELECT * FROM TOPICS WHERE TOPIC_ID = ?");


/* 100 */       tPS.setInt(1, pInt);


/* 103 */       ResultSet tResultSet = tPS.executeQuery();


/* 106 */       if (tResultSet.next())
       {
/* 108 */         tTopic = loadTopic(tResultSet);
       }


/* 112 */       tResultSet.close();
/* 113 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 116 */       ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o do topico");
     }


/* 120 */     return tTopic;
   }


   @Override
public Topic update(Topic pTopic)
   {
/* 126 */     Topic tTopic = null;


/* 129 */     int categoryInt = pTopic.getTopicCategory().ordinal();

     try
     {
/* 133 */       PreparedStatement tPS = null;
/* 134 */       tPS = this.sConnection.prepareStatement(
/* 135 */         "UPDATE TOPICS SET TOPIC_SUBJECT = ?, TOPIC_MESSAGE = ?, TOPIC_CAT = ? WHERE TOPIC_ID = ?");


/* 138 */       tPS.setString(1, pTopic.getTopicSubject());
/* 139 */       tPS.setString(2, pTopic.getTopicMessage());
/* 140 */       tPS.setInt(3, categoryInt);
/* 141 */       tPS.setInt(4, pTopic.getTopicId());



/* 145 */       int tQtdeReg = tPS.executeUpdate();


/* 148 */       if (tQtdeReg == 1)
       {
/* 150 */         tTopic = pTopic;
       }



/* 155 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 158 */       ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do topico");
     }

/* 161 */     return tTopic;
   }

   @Override
public boolean delete(int pInt)
   {
     try
     {
/* 168 */       PreparedStatement tPS = null;
/* 169 */       tPS = this.sConnection.prepareStatement("DELETE FROM TOPICS WHERE TOPIC_ID  = ?");


/* 172 */       tPS.setInt(1, pInt);



/* 176 */       int tQtdeReg = tPS.executeUpdate();


/* 179 */       tPS.close();


/* 182 */       return tQtdeReg == 1;
     } catch (SQLException tExcept) {
/* 184 */       ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de dele��o do topico");
     }
/* 186 */     return false;
   }


   @Override
public List<Topic> search()
   {
/* 192 */     List<Topic> tList = new ArrayList();

     try
     {
/* 196 */       PreparedStatement tPS = null;
/* 197 */       tPS = this.sConnection.prepareStatement("SELECT * FROM TOPICS ORDER BY UPPER(TOPIC_ID)");



/* 201 */       ResultSet tRS = tPS.executeQuery();



/* 205 */       while (tRS.next())
       {


/* 209 */         Topic tTopic = loadTopic(tRS);


/* 212 */         tList.add(tTopic);
       }


/* 216 */       tRS.close();
/* 217 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 220 */       ExceptionUtil.mostrarErro(tExcept,
/* 221 */         "Erro no m�todo de recuperacao de lsita de topicos");
     }

/* 224 */     return tList;
   }


   @Override
public List<Topic> searchBySubject(String pString)
   {
/* 230 */     String tSearchTopic = "%" + pString + "%";


/* 233 */     List<Topic> tList = new ArrayList();

     try
     {
/* 237 */       PreparedStatement tPS = null;
/* 238 */       tPS = this.sConnection.prepareStatement(

/* 240 */         "SELECT * FROM TOPICS WHERE UPPER(TOPIC_SUBJECT) LIKE UPPER(?) ORDER BY UPPER(TOPIC_ID)");



/* 244 */       tPS.setString(1, tSearchTopic);



/* 248 */       ResultSet tRS = tPS.executeQuery();



/* 252 */       while (tRS.next())
       {


/* 256 */         Topic tTopic = loadTopic(tRS);


/* 259 */         tList.add(tTopic);
       }


/* 263 */       tRS.close();
/* 264 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 267 */       ExceptionUtil.mostrarErro(tExcept,
/* 268 */         "Erro no m�todo de pesquisa por assunto na de lista de topicos");
     }

/* 271 */     return tList;
   }



   @Override
public List<Topic> searchByUser(int pInt)
   {
/* 278 */     List<Topic> tList = new ArrayList();

     try
     {
/* 282 */       PreparedStatement tPS = null;
/* 283 */       tPS = this.sConnection.prepareStatement(

/* 285 */         "SELECT * FROM TOPICS WHERE TOPIC_BY = ?");



/* 289 */       tPS.setInt(1, pInt);



/* 293 */       ResultSet tRS = tPS.executeQuery();



/* 297 */       while (tRS.next())
       {


/* 301 */         Topic tTopic = loadTopic(tRS);


/* 304 */         tList.add(tTopic);
       }


/* 308 */       tRS.close();
/* 309 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 312 */       ExceptionUtil.mostrarErro(tExcept,
/* 313 */         "Erro no m�todo de pesquisa por usuario (autor) na lista de topicos");
     }

/* 316 */     return tList;
   }



   @Override
public List<Topic> searchByCategory(Categories pCategory)
   {
/* 323 */     int categoryInt = pCategory.ordinal();


/* 326 */     List<Topic> tList = new ArrayList();

     try
     {
/* 330 */       PreparedStatement tPS = null;
/* 331 */       tPS = this.sConnection.prepareStatement(

/* 333 */         "SELECT * FROM TOPICS WHERE TOPIC_BY = ?");



/* 337 */       tPS.setInt(1, categoryInt);



/* 341 */       ResultSet tRS = tPS.executeQuery();



/* 345 */       while (tRS.next())
       {


/* 349 */         Topic tTopic = loadTopic(tRS);


/* 352 */         tList.add(tTopic);
       }


/* 356 */       tRS.close();
/* 357 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 360 */       ExceptionUtil.mostrarErro(tExcept,
/* 361 */         "Erro no m�todo de pesquisa por categoria na de lista topicos");
     }

/* 364 */     return tList;
   }









   private Topic loadTopic(ResultSet tResultSet)
     throws SQLException
   {
/* 378 */     int topicId = tResultSet.getInt("TOPIC_ID");
/* 379 */     String topicSubject = tResultSet.getString("TOPIC_SUBJECT");
/* 380 */     String topicMessage = tResultSet.getString("TOPIC_MESSAGE");
/* 381 */     java.sql.Date topicDate = tResultSet.getDate("TOPIC_DATE");
/* 382 */     int topicBy = tResultSet.getInt("TOPIC_BY");
/* 383 */     int topicCatInt = tResultSet.getInt("TOPIC_CAT");


     Categories[] arrayOfCategories;

/* 388 */     int j = (arrayOfCategories = Categories.values()).length; for (int i = 0; i < j; i++) { Categories cat = arrayOfCategories[i];
/* 389 */       if (cat.ordinal() == topicCatInt) {
/* 390 */         Categories topicCat = cat;
/* 391 */         Topic tTopic = new Topic(topicId, topicSubject, topicMessage, topicDate, topicCat, topicBy);
/* 392 */         return tTopic;
       }
     }


/* 397 */     return null;
   }
 }