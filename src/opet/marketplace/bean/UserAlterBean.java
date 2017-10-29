package opet.marketplace.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import opet.marketplace.controller.UserController;
import opet.marketplace.vo.Client;
import opet.marketplace.vo.Lawyer;
import opet.marketplace.vo.User;

@ManagedBean(name = "userAlterBean")
@SessionScoped
public class UserAlterBean
                implements Serializable
{
    private static final long serialVersionUID = -6859924979288350847L;
    @ManagedProperty("#{loginBean}")
    private LoginBean         loginBean;
    private UserController    oUserController;
    private User              alteredUser;
    private String            userEmail;
    private String            userPass;
    private String            userName;
    private int               userType;
    private Date              date;

    public UserAlterBean()
    {
        System.out.println("UserAlterBean construtor");

        this.oUserController = new UserController();
        this.date = new Date();
    }
 

    public String alterUser()
    {
        if (this.loginBean == null)
        {
            System.out.println("nulo");

        }
        else
            if (this.loginBean != null)
            {
                System.out.println("Não Nulo");
            }

        if (userType == 1)
        {

            this.alteredUser = new Lawyer(this.loginBean.getActiveUser().getUserId(), getUserName(), getUserPass(), getUserEmail(), this.date);

        }
        else
        {

            this.alteredUser = new Client(this.loginBean.getActiveUser().getUserId(), getUserName(), getUserPass(), getUserEmail(), this.date);
        }

        this.oUserController.update(this.alteredUser);

        return "/marketplace/mainMenu";
    }

    public String getUserEmail()
    {
        return this.userEmail;
    }

    public void setUserEmail(String pUserEmail)
    {
        this.userEmail = pUserEmail;
    }

    public String getUserPass()
    {
        return this.userPass;
    }

    public void setUserPass(String pUserPass)
    {
        this.userPass = pUserPass;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String pUserName)
    {
        this.userName = pUserName;
    }

    public int getUserType()
    {
        return this.userType;
    }

    public void setUserType(int pUserType)
    {
        this.userType = pUserType;
    }
    
	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
