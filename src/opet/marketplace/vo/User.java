 package opet.marketplace.vo;

 import java.util.Date;

 public class User
 {
   private int userId;
   private String userName;
   private String userPass;
   private String userEmail;
   private Date userCreationTime;

   public User(int pId, String pName, String pPass, String pEmail, Date pCreationTime)
   {
/* 15 */     this.userId = pId;
/* 16 */     this.userName = pName;
/* 17 */     this.userPass = pPass;
/* 18 */     this.userEmail = pEmail;
/* 19 */     this.userCreationTime = pCreationTime;
   }

   public int getUserId()
   {
/* 24 */     return this.userId;
   }

   public void setUserId(int userId)
   {
/* 29 */     this.userId = userId;
   }

   public String getUserName()
   {
/* 34 */     return this.userName;
   }

   public void setUserName(String userName)
   {
/* 39 */     this.userName = userName;
   }

   public String getUserPass()
   {
/* 44 */     return this.userPass;
   }

   public void setUserPass(String userPass)
   {
/* 49 */     this.userPass = userPass;
   }

   public String getUserEmail()
   {
/* 54 */     return this.userEmail;
   }

   public void setUserEmail(String userEmail)
   {
/* 59 */     this.userEmail = userEmail;
   }

   public Date getUserCreationTime()
   {
/* 64 */     return this.userCreationTime;
   }

   public void setUserCreationTime(Date userCreationTime)
   {
/* 69 */     this.userCreationTime = userCreationTime;
   }
 }
