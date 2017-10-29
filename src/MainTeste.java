
import java.util.Date;

import opet.marketplace.dao.jdbc.UserJdbcDAO;
import opet.marketplace.vo.Lawyer;
import opet.marketplace.vo.User;

public class MainTeste
{
    public static void main(String[] args)
    {
        UserJdbcDAO userJdbcDAO = new UserJdbcDAO();

        Date date = new Date();

        User pUser = new Lawyer(1, "JA", "JA", "JA", date);

        userJdbcDAO.create(pUser);

        System.out.println(userJdbcDAO.validateLogin("JA@JA.COM", "JA"));
    }
}
