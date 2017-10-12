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
    this.userId = pId;
    this.userName = pName;
    this.userPass = pPass;
    this.userEmail = pEmail;
    this.userCreationTime = pCreationTime;
  }
  
  public int getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(int userId)
  {
    this.userId = userId;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserPass()
  {
    return this.userPass;
  }
  
  public void setUserPass(String userPass)
  {
    this.userPass = userPass;
  }
  
  public String getUserEmail()
  {
    return this.userEmail;
  }
  
  public void setUserEmail(String userEmail)
  {
    this.userEmail = userEmail;
  }
  
  public Date getUserCreationTime()
  {
    return this.userCreationTime;
  }
  
  public void setUserCreationTime(Date userCreationTime)
  {
    this.userCreationTime = userCreationTime;
  }
}
