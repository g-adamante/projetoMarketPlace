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
    this.threadId = threadId;
    this.threadSubject = threadSubject;
    this.threadDate = threadDate;
    this.threadCategory = threadCategory;
    this.topicBy = topicBy;
  }
  
  public int getThreadId()
  {
    return this.threadId;
  }
  
  public void setThreadId(int threadId)
  {
    this.threadId = threadId;
  }
  
  public String getThreadSubject()
  {
    return this.threadSubject;
  }
  
  public void setThreadSubject(String threadSubject)
  {
    this.threadSubject = threadSubject;
  }
  
  public Date getThreadDate()
  {
    return this.threadDate;
  }
  
  public void setThreadDate(Date threadDate)
  {
    this.threadDate = threadDate;
  }
  
  public Categories getThreadCategory()
  {
    return this.threadCategory;
  }
  
  public void setThreadCategory(Categories threadCategory)
  {
    this.threadCategory = threadCategory;
  }
  
  public int getTopicBy()
  {
    return this.topicBy;
  }
  
  public void setTopicBy(int topicBy)
  {
    this.topicBy = topicBy;
  }
}
