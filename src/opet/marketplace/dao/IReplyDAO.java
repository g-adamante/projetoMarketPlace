package opet.marketplace.dao;

import java.util.List;

import opet.marketplace.vo.Reply;

public abstract interface IReplyDAO {
	
	  public abstract Reply create(Reply pReply);
	  
	  public abstract Reply recovery(int pInt);
	  
	  public abstract Reply update(Reply pReply);
	  
	  public abstract boolean delete(int pInt);
	  
	  public abstract List<Reply> search();
	  
	  public abstract List<Reply> searchByContent(String pString);
	  
	  public abstract List<Reply> searchByUser(int pInt);
	  
	  public abstract List<Reply> searchByTopic(int pInt);

}
