package opet.marketplace.dao;

import java.util.List;
import opet.marketplace.vo.User;

public abstract interface IUserDAO
{
  public abstract User create(User paramUser);
  
  public abstract User recovery(int paramInt);
  
  public abstract User update(User paramUser);
  
  public abstract boolean delete(int paramInt);
  
  public abstract List<User> search();
  
  public abstract List<User> searchByNome(String paramString);
  
  public abstract List<User> searchByEmail(String paramString);
}
