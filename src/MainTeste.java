
import java.util.Date;

import opet.marketplace.dao.jdbc.TopicJdbcDAO;
import opet.marketplace.vo.Lawyer;
import opet.marketplace.vo.User;

public class MainTeste
{
    public static void main(String[] args)
    {
        TopicJdbcDAO topicJdbcDAO = new TopicJdbcDAO();

        Date date = new Date();

        User pUser = new Lawyer(1, "JA", "JA", "JA", date);

        System.out.println(topicJdbcDAO.addTopicLawyer(1, 1));

      //  System.out.println(userJdbcDAO.validateLogin("JA@JA.COM", "JA"));
    }
}
