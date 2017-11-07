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
public class TopicListBean implements Serializable
{

    /**
     *
     */
    private static final long serialVersionUID = 3105772281518129604L;
    @ManagedProperty("#{loginBean}")
    private LoginBean         loginBean;
    private TopicController   oTopicController;
    private List<Topic>       publicTopicList;
    private List<Topic>       privateTopicList;
    private List<Topic>       clientTopicList;
    private Topic             activeTopic;

    public TopicListBean()
    {
        System.out.println("topicCreateBean construtor");

        oTopicController = new TopicController();
        setPublicTopicList(new ArrayList<Topic>());
        setPrivateTopicList(new ArrayList<Topic>());
        setActiveTopic(null);
    }

    public void searchTopics()
    {
        // setPublicTopicList(oTopicController.search());
    }

    public void searchUserTopics()
    {
        List<Topic> iterativeTopics = oTopicController.search();
        List<Topic> userTopics = new ArrayList<Topic>();

        for (Topic tTopic : iterativeTopics)
        {
            if (tTopic.getTopicLawyer() == loginBean.getActiveUser().getUserId())
            {
                userTopics.add(tTopic);
            }

        }

        setPrivateTopicList(userTopics);

    }

    public void searchClientTopics()
    {
        List<Topic> iterativeTopics = oTopicController.search();
        List<Topic> userTopics = new ArrayList<Topic>();

        for (Topic tTopic : iterativeTopics)
        {
            if (tTopic.getTopicBy() == loginBean.getActiveUser().getUserId())
            {
                userTopics.add(tTopic);
            }

        }

        setClientTopicList(userTopics);

    }

    public void searchNotAttributedTopics()
    {
        List<Topic> iterativeTopics = oTopicController.search();
        List<Topic> notAttributedTopics = new ArrayList<Topic>();

        for (Topic tTopic : iterativeTopics)
        {
            if (tTopic.getTopicLawyer() == 0)
            {
                notAttributedTopics.add(tTopic);
            }

        }

        setPublicTopicList(notAttributedTopics);
        System.out.println("Passou pelo método");
    }

    public String replyTopic(Topic pTopic)
    {
        setActiveTopic(pTopic);
        return "/marketplace/topicReplies";
    }

    public LoginBean getLoginBean()
    {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean)
    {
        this.loginBean = loginBean;
    }

    public void addTopicLawyer(int topicId)
    {
        if (oTopicController.addTopicLawyer(loginBean.getActiveUser().getUserId(), topicId))
        {
            searchNotAttributedTopics();
        }
        else
        {

            searchNotAttributedTopics();
        }
    }

    public List<Topic> getPublicTopicList()
    {
        return publicTopicList;
    }

    public void setPublicTopicList(List<Topic> pPublicTopicList)
    {
        publicTopicList = pPublicTopicList;
    }

    public List<Topic> getPrivateTopicList()
    {
        return privateTopicList;
    }

    public void setPrivateTopicList(List<Topic> pPrivateTopicList)
    {
        privateTopicList = pPrivateTopicList;
    }

    public Topic getActiveTopic()
    {
        return activeTopic;
    }

    public void setActiveTopic(Topic activeTopic)
    {
        this.activeTopic = activeTopic;
    }

    public List<Topic> getClientTopicList()
    {
        return clientTopicList;
    }

    public void setClientTopicList(List<Topic> pClientTopicList)
    {
        clientTopicList = pClientTopicList;
    }


}
