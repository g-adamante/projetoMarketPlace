package opet.marketplace.vo;

import java.util.Date;

public class Lawyer
  extends User
{
  public Lawyer(int pId, String pName, String pPass, String pEmail, Date pCreationTime)
  {
    super(pId, pName, pPass, pEmail, pCreationTime);
  }
}
