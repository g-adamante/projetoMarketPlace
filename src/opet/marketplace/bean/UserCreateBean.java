package opet.marketplace.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import opet.marketplace.controller.UserController;
import opet.marketplace.vo.Client;
import opet.marketplace.vo.Lawyer;
import opet.marketplace.vo.User;

@ManagedBean(name = "userCreateBean")
@SessionScoped
public class UserCreateBean
                implements Serializable
{

    /**
	 *
	 */
	private static final long serialVersionUID = 8600853947226721506L;
    private UserController    oUserController;
    private User              newUser;
    private String            userEmail;
    private String            userPass;
    private String            userName;
    private Date              date;
    private boolean           userLawyer;

    public UserCreateBean()
    {
        System.out.println("UserAlterBean construtor");

        this.oUserController = new UserController();
        this.date = new Date();
    }


    public String createUser()
    {

        if (userLawyer)
        {

            this.newUser = new Lawyer(1, getUserName(), getUserPass(), getUserEmail(), this.date);

        }
        else
        {

            this.newUser = new Client(1, getUserName(), getUserPass(), getUserEmail(), this.date);
        }

        this.oUserController.create(this.newUser);
        setUserEmail(null);
        setUserName(null);
        setUserPass(null);
        setUserLawyer(false);
        return "/index";
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


    public boolean isUserLawyer()
    {
        return userLawyer;
    }


    public void setUserLawyer(boolean pUserLawyer)
    {
        userLawyer = pUserLawyer;
    }

}
