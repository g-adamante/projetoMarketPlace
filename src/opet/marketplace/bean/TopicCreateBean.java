package opet.marketplace.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import opet.marketplace.controller.TopicController;
import opet.marketplace.vo.Categories;
import opet.marketplace.vo.Topic;

@ManagedBean(name = "topicCreateBean")
@SessionScoped
public class TopicCreateBean implements Serializable
{

    /**
     *
     */
    private static final long serialVersionUID = 7206397106663250389L;
    @ManagedProperty("#{loginBean}")
    private LoginBean         loginBean;
    private TopicController   oTopicController;
    private int               topicId;
    private String            topicSubject;
    private int               topicCategory;
    private String            topicMessage;
    private int               topicBy;
    private Date              date;

    public TopicCreateBean()
    {
        System.out.println("topicCreateBean construtor");

        this.oTopicController = new TopicController();
        this.date = new Date();
    }

    public String createTopic()
    {

        if (getTopicCategory() == 1)
        {
            Categories category = Categories.FINANCEIRO;

            Topic topic = new Topic(1, getTopicSubject(), getTopicMessage(), getDate(), category,
                            loginBean.getActiveUser().getUserId());

            this.oTopicController.create(topic);
            setTopicMessage(null);
            setTopicSubject(null);
        }
        else
        {
            Categories category = Categories.JURIDICO;

            Topic topic = new Topic(1, getTopicSubject(), getTopicMessage(), getDate(), category,
                            loginBean.getActiveUser().getUserId());

            this.oTopicController.create(topic);
            setTopicMessage(null);
            setTopicSubject(null);
        }

        return "/marketplace/mainMenu";
    }

    public int getTopicId()
    {
        return topicId;
    }

    public void setTopicId(int topicId)
    {
        this.topicId = topicId;
    }

    public String getTopicSubject()
    {
        return topicSubject;
    }

    public void setTopicSubject(String topicSubject)
    {
        this.topicSubject = topicSubject;
    }

    public int getTopicCategory()
    {
        return topicCategory;
    }

    public void setTopicCategory(int topicCategory)
    {
        this.topicCategory = topicCategory;
    }

    public String getTopicMessage()
    {
        return topicMessage;
    }

    public void setTopicMessage(String topicMessage)
    {
        this.topicMessage = topicMessage;
    }

    public int getTopicBy()
    {
        return topicBy;
    }

    public void setTopicBy(int topicBy)
    {
        this.topicBy = topicBy;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public LoginBean getLoginBean()
    {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean)
    {
        this.loginBean = loginBean;
    }
}
