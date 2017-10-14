package opet.marketplace.dao;

import java.util.List;

import opet.marketplace.vo.Categories;
import opet.marketplace.vo.Topic;

public abstract interface ITopicDAO {
	  public abstract Topic create(Topic pTopic);
	  
	  public abstract Topic recovery(int pInt);
	  
	  public abstract Topic update(Topic pTopic);
	  
	  public abstract boolean delete(int pInt);
	  
	  public abstract List<Topic> search();
	  
	  public abstract List<Topic> searchBySubject(String pString);
	  
	  public abstract List<Topic> searchByUser(int pInt);
	  
	  public abstract List<Topic> searchByCategory(Categories pCategory);
	}
