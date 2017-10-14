package opet.marketplace.vo;

import java.util.Date;

public class Reply {
	
	private int replyId;
	private String replyContent;
	private Date replyDate;
	private int replyTopic;
	private int replyBy;
	
	public Reply(int replyId, String replyContent, Date replyDate, int replyTopic, int replyBy) {
		super();
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.replyTopic = replyTopic;
		this.replyBy = replyBy;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public int getReplyTopic() {
		return replyTopic;
	}

	public void setReplyTopic(int replyTopic) {
		this.replyTopic = replyTopic;
	}

	public int getReplyBy() {
		return replyBy;
	}

	public void setReplyBy(int replyBy) {
		this.replyBy = replyBy;
	}
	
	
	
	
}
