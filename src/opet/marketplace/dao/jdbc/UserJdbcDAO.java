 package opet.marketplace.dao.jdbc;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import opet.marketplace.dao.IUserDAO;
import opet.marketplace.jdbc.Connector;
import opet.marketplace.util.ExceptionUtil;
import opet.marketplace.vo.Client;
import opet.marketplace.vo.Lawyer;
import opet.marketplace.vo.User;

 public class UserJdbcDAO
   implements IUserDAO
 {
/*  20 */   private Connection sConnection = new Connector().connect();


   @Override
public User create(User pUser)
   {
/*  25 */     User tUser = null;
     try
     {
/*  28 */       PreparedStatement tPS = null;
/*  29 */       tPS = this.sConnection.prepareStatement(
/*  30 */         "INSERT INTO USERS(USER_ID, USER_NAME, USER_PASS, USER_EMAIL, USER_CREATION_DATE, USER_TYPE) VALUES(USER_SEQ.NEXTVAL,?,?,?,?,?)");



/*  34 */       tPS.setString(1, pUser.getUserName());
/*  35 */       tPS.setString(2, pUser.getUserPass());
/*  36 */       tPS.setString(3, pUser.getUserEmail());
/*  37 */       tPS.setDate(4, new java.sql.Date(pUser.getUserCreationTime().getTime()));
/*  38 */       if ((pUser instanceof Lawyer)) {
/*  39 */         tPS.setInt(5, 1);
       } else {
/*  41 */         tPS.setInt(5, 2);
       }






/*  49 */       int tQtdeReg = tPS.executeUpdate();


/*  52 */       if (tQtdeReg == 1)
       {
/*  54 */         tUser = pUser;






/*  61 */         Statement currvalStatement = null;
/*  62 */         ResultSet currvalResultSet = null;
/*  63 */         String sql_currval = "SELECT USER_SEQ.CURRVAL FROM dual";

/*  65 */         currvalStatement = this.sConnection.createStatement();
/*  66 */         currvalResultSet = currvalStatement.executeQuery(sql_currval);



/*  70 */         if (currvalResultSet.next()) {
/*  71 */           tUser.setUserId(

/*  73 */             currvalResultSet.getInt(1));
         }
       }






/*  82 */       tPS.close();
     } catch (SQLException tExcept) {
/*  84 */       ExceptionUtil.mostrarErro(tExcept,
/*  85 */         "Erro no m�todo da pesquisa por e-mail dos contatos");
     }

/*  88 */     return tUser;
   }



   @Override
public User recovery(int pUserId)
   {
/*  95 */     User tUser = null;

     try
     {
/*  99 */       PreparedStatement tPS = null;
/* 100 */       tPS = this.sConnection.prepareStatement("SELECT * FROM USERS WHERE USER_ID = ?");


/* 103 */       tPS.setInt(1, pUserId);


/* 106 */       ResultSet tResultSet = tPS.executeQuery();


/* 109 */       if (tResultSet.next())
       {
/* 111 */         tUser = loadUser(tResultSet);
       }


/* 115 */       tResultSet.close();
/* 116 */       tPS.close();
     } catch (SQLException tExcept) {
/* 118 */       ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o do usu�rio");
     }


/* 122 */     return tUser;
   }


   @Override
public User update(User pUser)
   {
/* 128 */     User tUser = null;

     try
     {
/* 132 */       PreparedStatement tPS = null;
/* 133 */       tPS = this.sConnection.prepareStatement("UPDATE USERS SET USER_NAME = ?, USER_PASS = ?, USER_EMAIL = ?,USER_TYPE = ? WHERE USER_ID  = ?");



/* 137 */       tPS.setString(1, pUser.getUserName());
/* 138 */       tPS.setString(2, pUser.getUserPass());
/* 139 */       tPS.setString(3, pUser.getUserEmail());


/* 142 */       if ((pUser instanceof Lawyer))
       {
/* 144 */         tPS.setInt(4, 1);
       }
       else
       {
/* 148 */         tPS.setInt(4, 2);
       }

/* 151 */       tPS.setInt(5, pUser.getUserId());



/* 155 */       int tQtdeReg = tPS.executeUpdate();


/* 158 */       if (tQtdeReg == 1)
       {
/* 160 */         tUser = pUser;
       }



/* 165 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 168 */       ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do usu�rio");
     }
/* 170 */     return tUser;
   }


   @Override
public boolean delete(int pUserID)
   {
     try
     {
/* 178 */       PreparedStatement tPS = null;
/* 179 */       tPS = this.sConnection.prepareStatement("DELETE FROM USERS WHERE USER_ID  = ?");


/* 182 */       tPS.setInt(1, pUserID);



/* 186 */       int tQtdeReg = tPS.executeUpdate();


/* 189 */       tPS.close();


/* 192 */       return tQtdeReg == 1;
     } catch (SQLException tExcept) {
/* 194 */       ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de dele��o do contato");
     }


/* 198 */     return false;
   }


   @Override
public List<User> search()
   {
/* 204 */     List<User> tList = new ArrayList();

     try
     {
/* 208 */       PreparedStatement tPS = null;
/* 209 */       tPS = this.sConnection.prepareStatement("SELECT * FROM USERS ORDER BY UPPER(USER_ID)");



/* 213 */       ResultSet tRS = tPS.executeQuery();



/* 217 */       while (tRS.next())
       {


/* 221 */         User tUser = loadUser(tRS);


/* 224 */         tList.add(tUser);
       }


/* 228 */       tRS.close();
/* 229 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 232 */       ExceptionUtil.mostrarErro(tExcept,
/* 233 */         "Erro no m�todo de recuperacao de lsita de contato");
     }

/* 236 */     return tList;
   }



   @Override
public List<User> searchByName(String pName)
   {
/* 243 */     String tNameSearch = "%" + pName + "%";


/* 246 */     List<User> tList = new ArrayList();

     try
     {
/* 250 */       PreparedStatement tPS = null;
/* 251 */       tPS = this.sConnection.prepareStatement(

/* 253 */         "SELECT * FROM USERS WHERE UPPER(USER_NAME) LIKE UPPER(?) ORDER BY UPPER(USER_NAME)");



/* 257 */       tPS.setString(1, tNameSearch);



/* 261 */       ResultSet tRS = tPS.executeQuery();



/* 265 */       while (tRS.next())
       {


/* 269 */         User tUser = loadUser(tRS);


/* 272 */         tList.add(tUser);
       }


/* 276 */       tRS.close();
/* 277 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 280 */       ExceptionUtil.mostrarErro(tExcept,
/* 281 */         "Erro no m�todo de pesquisa por nome na de lista de contato");
     }

/* 284 */     return tList;
   }



   @Override
public User searchByEmail(String pEmail)
   {
/* 291 */     String tEmailSearch = "%" + pEmail + "%";
/* 292 */     User tUser = null;

     try
     {
/* 296 */       PreparedStatement tPS = null;
/* 297 */       tPS = this.sConnection.prepareStatement(

/* 299 */         "SELECT * FROM USERS WHERE UPPER(USER_EMAIL) LIKE UPPER(?) ORDER BY UPPER(USER_EMAIL)");



/* 303 */       tPS.setString(1, tEmailSearch);



/* 307 */       ResultSet tRS = tPS.executeQuery();



/* 311 */       while (tRS.next())
       {


/* 315 */         tUser = loadUser(tRS);
       }




/* 321 */       tRS.close();
/* 322 */       tPS.close();
     }
     catch (SQLException tExcept) {
/* 325 */       ExceptionUtil.mostrarErro(tExcept,
/* 326 */         "Erro no método de pesquisa por email na de lista de contato");
     }

/* 329 */     return tUser;
   }


   public User searchById(int pId)
      {
     User tUser = null;

        try
        {
       PreparedStatement tPS = null;
      tPS = this.sConnection.prepareStatement(

         "SELECT * FROM USERS WHERE USER_ID = ?");



   /* 303 */       tPS.setInt(1, pId);



   /* 307 */       ResultSet tRS = tPS.executeQuery();



   /* 311 */       while (tRS.next())
          {


   /* 315 */         tUser = loadUser(tRS);
          }




   /* 321 */       tRS.close();
   /* 322 */       tPS.close();
        }
        catch (SQLException tExcept) {
   /* 325 */       ExceptionUtil.mostrarErro(tExcept,
   /* 326 */         "Erro no método de pesquisa por ID na de lista de usuário");
        }

   /* 329 */     return tUser;
      }


   public boolean validateLogin(String pUserEmail, String pUserPass)
   {
     try {
/* 335 */       PreparedStatement tPS = null;
/* 336 */       tPS = this.sConnection.prepareStatement(

/* 338 */         "SELECT * FROM USERS WHERE USER_EMAIL = ? AND USER_PASS = ?");



/* 342 */       tPS.setString(1, pUserEmail);
/* 343 */       tPS.setString(2, pUserPass);




/* 348 */       ResultSet tRS = tPS.executeQuery();

/* 350 */       if (tRS.next())
       {
/* 352 */         return true;
       }
     }
     catch (SQLException tExcept) {
/* 356 */       ExceptionUtil.mostrarErro(tExcept,
/* 357 */         "Erro no login"); }
/* 358 */     return false;
   }










   private User loadUser(ResultSet tResultSet)
     throws SQLException
   {
/* 373 */     int userId = tResultSet.getInt("USER_ID");
/* 374 */     String userName = tResultSet.getString("USER_NAME");
/* 375 */     String userPass = tResultSet.getString("USER_PASS");
/* 376 */     String userEmail = tResultSet.getString("USER_EMAIL");
/* 377 */     java.sql.Date userDate = tResultSet.getDate("USER_CREATION_DATE");
/* 378 */     int userType = tResultSet.getInt("USER_TYPE");

/* 380 */     if (userType == 1) {
/* 381 */       User tUser = new Lawyer(userId, userName, userPass, userEmail, userDate);
/* 382 */       return tUser;
     }
/* 384 */     User tUser = new Client(userId, userName, userPass, userEmail, userDate);
/* 385 */     return tUser;
   }
 }
