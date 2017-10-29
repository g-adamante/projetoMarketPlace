 package opet.marketplace.model;

 import java.util.List;

import opet.marketplace.dao.jdbc.UserJdbcDAO;
import opet.marketplace.vo.User;

 public class UserModel
 {
   private UserJdbcDAO oUserJdbcDAO;

   public UserModel()
   {
/* 13 */     this.oUserJdbcDAO = new UserJdbcDAO();
   }

   public boolean create(User pUser)
   {
/* 18 */     User sucessUser = this.oUserJdbcDAO.create(pUser);

/* 20 */     if (sucessUser == null) {
/* 21 */       return false;
     }

/* 24 */     return true;
   }



   public User recovery(int pInt)
   {
/* 31 */     return this.oUserJdbcDAO.recovery(pInt);
   }


   public boolean update(User pUser)
   {
/* 37 */     User sucessUser = this.oUserJdbcDAO.update(pUser);

/* 39 */     if (sucessUser == null) {
/* 40 */       return false;
     }


/* 44 */     return true;
   }




   public boolean delete(int pInt)
   {
/* 52 */     return this.oUserJdbcDAO.delete(pInt);
   }

   public List<User> search()
   {
/* 57 */     return this.oUserJdbcDAO.search();
   }


   public List<User> searchByName(String pString)
   {
/* 63 */     return this.oUserJdbcDAO.searchByName(pString);
   }

   public User searchByEmail(String pString) {
/* 67 */     return this.oUserJdbcDAO.searchByEmail(pString);
   }

   public boolean validateLogin(String pUserEmail, String pUserPass) {
/* 71 */     return this.oUserJdbcDAO.validateLogin(pUserEmail, pUserPass);
   }
 }
