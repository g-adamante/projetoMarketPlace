package opet.marketplace.vo;

import java.util.Date;

public class Client
  extends User
{
  public Client(int pId, String pName, String pPass, String pEmail, Date pCreationTime)
  {
    super(pId, pName, pPass, pEmail, pCreationTime);
  }
}
