package opet.marketplace.model;

import java.util.List;

import opet.marketplace.dao.jdbc.TopicJdbcDAO;
import opet.marketplace.vo.Topic;


public class TopicModel
{
  private TopicJdbcDAO oTopicJdbcDAO;

  public TopicModel()
  {
/* 14 */     this.oTopicJdbcDAO = new TopicJdbcDAO();
  }


  public boolean create(Topic pTopic)
  {
/* 20 */     Topic sucessTopic = this.oTopicJdbcDAO.create(pTopic);

/* 22 */     if (sucessTopic == null) {
/* 23 */       return false;
    }
/* 25 */     return true;
  }



  public Topic recovery(int pInt)
  {
/* 32 */     return this.oTopicJdbcDAO.recovery(pInt);
  }


  public boolean update(Topic pTopic)
  {
/* 38 */     Topic sucessTopic = this.oTopicJdbcDAO.update(pTopic);

/* 40 */     if (sucessTopic == null) {
/* 41 */       return false;
    }
/* 43 */     return true;
  }


  public boolean delete(int pInt)
  {
/* 49 */     return this.oTopicJdbcDAO.delete(pInt);
  }

  public List<Topic> search() {
/* 53 */     return this.oTopicJdbcDAO.search();
  }

  public List<Topic> searchBySubject(String pString) {
/* 57 */     return this.oTopicJdbcDAO.searchBySubject(pString);
  }

  public List<Topic> searchByUser(int pInt) {
/* 61 */     return this.oTopicJdbcDAO.searchByUser(pInt);
  }


public boolean addTopicLawyer(int userId, int topicId) {
    return this.oTopicJdbcDAO.addTopicLawyer(userId, topicId);
}

}

