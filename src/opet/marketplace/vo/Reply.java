 package opet.marketplace.vo;

 import java.util.Date;

 public class Reply
 {
   private int replyId;
   private String replyContent;
   private Date replyDate;
   private int replyTopic;
   private int replyBy;

   public Reply(int replyId, String replyContent, Date replyDate, int replyTopic, int replyBy)
   {
/* 15 */     this.replyId = replyId;
/* 16 */     this.replyContent = replyContent;
/* 17 */     this.replyDate = replyDate;
/* 18 */     this.replyTopic = replyTopic;
/* 19 */     this.replyBy = replyBy;
   }

   public int getReplyId() {
/* 23 */     return this.replyId;
   }

   public void setReplyId(int replyId) {
/* 27 */     this.replyId = replyId;
   }

   public String getReplyContent() {
/* 31 */     return this.replyContent;
   }

   public void setReplyContent(String replyContent) {
/* 35 */     this.replyContent = replyContent;
   }

   public Date getReplyDate() {
/* 39 */     return this.replyDate;
   }

   public void setReplyDate(Date replyDate) {
/* 43 */     this.replyDate = replyDate;
   }

   public int getReplyTopic() {
/* 47 */     return this.replyTopic;
   }

   public void setReplyTopic(int replyTopic) {
/* 51 */     this.replyTopic = replyTopic;
   }

   public int getReplyBy() {
/* 55 */     return this.replyBy;
   }

   public void setReplyBy(int replyBy) {
/* 59 */     this.replyBy = replyBy;
   }
 }
