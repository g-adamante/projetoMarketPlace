 package opet.marketplace.vo;

 import java.util.Date;

 public class Topic {
   private int topicId;
   private String topicSubject;
   private Date topicDate;
   private Categories topicCategory;
   private String topicMessage;
   private int topicBy;

   public Topic(int topicId, String topicSubject, String topicMessage, Date topicDate, Categories topicCategory, int topicBy) {
/* 14 */     this.topicId = topicId;
/* 15 */     this.topicSubject = topicSubject;
/* 16 */     this.topicDate = topicDate;
/* 17 */     this.topicCategory = topicCategory;
/* 18 */     this.topicBy = topicBy;
/* 19 */     this.topicMessage = topicMessage;
   }

   public int getTopicId() {
/* 23 */     return this.topicId;
   }

   public void setTopicId(int topicId) {
/* 27 */     this.topicId = topicId;
   }

   public String getTopicSubject() {
/* 31 */     return this.topicSubject;
   }

   public void setTopicSubject(String topicSubject) {
/* 35 */     this.topicSubject = topicSubject;
   }

   public Date getTopicDate() {
/* 39 */     return this.topicDate;
   }

   public void setTopicDate(Date topicDate) {
/* 43 */     this.topicDate = topicDate;
   }

   public Categories getTopicCategory() {
/* 47 */     return this.topicCategory;
   }

   public void setTopicCategory(Categories topicCategory) {
/* 51 */     this.topicCategory = topicCategory;
   }

   public int getTopicBy() {
/* 55 */     return this.topicBy;
   }

   public void setTopicBy(int topicBy) {
/* 59 */     this.topicBy = topicBy;
   }

   public String getTopicMessage() {
/* 63 */     return this.topicMessage;
   }

   public void setTopicMessage(String topicMessage) {
/* 67 */     this.topicMessage = topicMessage;
   }
 }