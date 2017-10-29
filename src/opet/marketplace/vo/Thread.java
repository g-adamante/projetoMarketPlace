 package opet.marketplace.vo;

 import java.util.Date;

 public class Thread
 {
   private int threadId;
   private String threadSubject;
   private Date threadDate;
   private Categories threadCategory;
   private int topicBy;

   public Thread(int threadId, String threadSubject, Date threadDate, Categories threadCategory, int topicBy)
   {
/* 15 */     this.threadId = threadId;
/* 16 */     this.threadSubject = threadSubject;
/* 17 */     this.threadDate = threadDate;
/* 18 */     this.threadCategory = threadCategory;
/* 19 */     this.topicBy = topicBy;
   }

   public int getThreadId()
   {
/* 24 */     return this.threadId;
   }

   public void setThreadId(int threadId)
   {
/* 29 */     this.threadId = threadId;
   }

   public String getThreadSubject()
   {
/* 34 */     return this.threadSubject;
   }

   public void setThreadSubject(String threadSubject)
   {
/* 39 */     this.threadSubject = threadSubject;
   }

   public Date getThreadDate()
   {
/* 44 */     return this.threadDate;
   }

   public void setThreadDate(Date threadDate)
   {
/* 49 */     this.threadDate = threadDate;
   }

   public Categories getThreadCategory()
   {
/* 54 */     return this.threadCategory;
   }

   public void setThreadCategory(Categories threadCategory)
   {
/* 59 */     this.threadCategory = threadCategory;
   }

   public int getTopicBy()
   {
/* 64 */     return this.topicBy;
   }

   public void setTopicBy(int topicBy)
   {
/* 69 */     this.topicBy = topicBy;
   }
 }
