 package opet.marketplace.model;

 import java.util.List;

import opet.marketplace.dao.jdbc.ReplyJdbcDAO;
import opet.marketplace.vo.Reply;

 public class ReplyModel
 {
   private ReplyJdbcDAO oReplyJdbcDAO;

   public ReplyModel()
   {
/* 13 */     this.oReplyJdbcDAO = new ReplyJdbcDAO();
   }

   public boolean create(Reply pReply)
   {
/* 18 */     Reply sucessReply = this.oReplyJdbcDAO.create(pReply);

/* 20 */     if (sucessReply == null) {
/* 21 */       return false;
     }
/* 23 */     return true;
   }




   public Reply recovery(int pInt)
   {
/* 31 */     return this.oReplyJdbcDAO.recovery(pInt);
   }


   public boolean update(Reply pReply)
   {
/* 37 */     Reply sucessReply = this.oReplyJdbcDAO.update(pReply);

/* 39 */     if (sucessReply == null) {
/* 40 */       return false;
     }
/* 42 */     return true;
   }



   public boolean delete(int pInt)
   {
/* 49 */     return this.oReplyJdbcDAO.delete(pInt);
   }

   public List<Reply> search() {
/* 53 */     return this.oReplyJdbcDAO.search();
   }

   public List<Reply> searchByTopic(int pInt)
   {
/* 58 */     return this.oReplyJdbcDAO.searchByTopic(pInt);
   }

   public List<Reply> searchByUser(int pInt) {
/* 62 */     return this.oReplyJdbcDAO.searchByUser(pInt);
   }
 }