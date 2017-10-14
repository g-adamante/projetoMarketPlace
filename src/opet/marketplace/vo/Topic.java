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
		this.topicId = topicId;
		this.topicSubject = topicSubject;
		this.topicDate = topicDate;
		this.topicCategory = topicCategory;
		this.topicBy = topicBy;
		this.topicMessage = topicMessage;
	}

	public int getTopicId() {
		return this.topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicSubject() {
		return this.topicSubject;
	}

	public void setTopicSubject(String topicSubject) {
		this.topicSubject = topicSubject;
	}

	public Date getTopicDate() {
		return this.topicDate;
	}

	public void setTopicDate(Date topicDate) {
		this.topicDate = topicDate;
	}

	public Categories getTopicCategory() {
		return this.topicCategory;
	}

	public void setTopicCategory(Categories topicCategory) {
		this.topicCategory = topicCategory;
	}

	public int getTopicBy() {
		return this.topicBy;
	}

	public void setTopicBy(int topicBy) {
		this.topicBy = topicBy;
	}

	public String getTopicMessage() {
		return topicMessage;
	}

	public void setTopicMessage(String topicMessage) {
		this.topicMessage = topicMessage;
	}

}
