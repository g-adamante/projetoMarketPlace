package opet.marketplace.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import opet.marketplace.controller.TopicController;
import opet.marketplace.vo.Topic;

@ManagedBean(name = "topicListBean")
@SessionScoped
public class TopicListBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3105772281518129604L;
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	private TopicController oTopicController;
	private List<Topic> topicList;

	public TopicListBean() {
		System.out.println("topicCreateBean construtor");

		oTopicController = new TopicController();
		setTopicList(new ArrayList<Topic>());
	}	

	public void searchTopics() {
			setTopicList(oTopicController.search());
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}
}
