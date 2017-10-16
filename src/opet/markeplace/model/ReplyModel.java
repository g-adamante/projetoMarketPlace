package opet.markeplace.model;

import java.util.List;

import opet.marketplace.dao.jdbc.ReplyJdbcDAO;
import opet.marketplace.vo.Reply;

public class ReplyModel {

	private ReplyJdbcDAO ReplyJdbcDAO;
	
	  public boolean create(Reply pReply){

			Reply SucessReply = ReplyJdbcDAO.create(pReply);

				if (SucessReply == null) {
					return false;
				} else {
					return true;
				}

		  
	  };
	  
	  public Reply recovery(int pInt){
		  
		  return ReplyJdbcDAO.recovery(pInt);
		  
	  };
	  
	  public boolean update(Reply pReply){

			Reply SucessReply = ReplyJdbcDAO.update(pReply);

				if (SucessReply == null) {
					return false;
				} else {
					return true;
				}

		  
	  };
	  
	  public boolean delete(int pInt){
		  return ReplyJdbcDAO.delete(pInt);
	  }
	  
	  public List<Reply> search(){
		  return ReplyJdbcDAO.search();
	  }

	  
	  public List<Reply> searchByTopic(int pInt){
		  return ReplyJdbcDAO.searchByTopic(pInt);
	  }
	  
	  public List<Reply> searchByUser(int pInt){
		  return ReplyJdbcDAO.searchByUser(pInt);
	  }
}
