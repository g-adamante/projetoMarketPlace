package opet.markeplace.model;

import java.util.List;

import opet.marketplace.dao.jdbc.UserJdbcDAO;
import opet.marketplace.vo.User;


public class UserModel {

	private UserJdbcDAO UserJdbcDAO;
	
	  public boolean create(User pUser){
		  
		  User SucessUser = UserJdbcDAO.create(pUser);
		  
		  if(SucessUser == null){
			  return false;
		  }
		  else{
			  return true;
		  }
		  
	  };
	  
	  public User recovery(int pInt){
		  
		  return UserJdbcDAO.recovery(pInt);
		  
	  };
	  
	  public boolean update(User pUser){
		  User SucessUser = UserJdbcDAO.update(pUser);
		  
		  if(SucessUser == null){
			return false;  
		  }
		  else{

			  return true;
			  
		  }
		  
	  };
	  
	  public boolean delete(int pInt){
		  return UserJdbcDAO.delete(pInt);
	  }
	  
	  public List<User> search(){
		  return UserJdbcDAO.search();
	  }

	  
	  public List<User> searchByName(String pString){
		  return UserJdbcDAO.searchByName(pString);
	  }
	  
	  public List<User> searchByEmail(String pString){
		  return UserJdbcDAO.searchByEmail(pString);
	  }
	
	  
	  
}
