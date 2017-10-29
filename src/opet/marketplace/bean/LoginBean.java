package opet.marketplace.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import opet.marketplace.controller.UserController;
import opet.marketplace.vo.User;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean
                implements Serializable
{
    private static final long serialVersionUID = 1L;
    private UserController    oUserController;

    private String            userEmail;

    private String            userPass;

    private User              activeUser;

    public LoginBean()
    {
        oUserController = new UserController();

        System.out.println("LoginBean construtor");
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

    public User getActiveUser()
    {
        return this.activeUser;
    }

    public void setActiveUser(User pActiveUser)
    {
        this.activeUser = pActiveUser;
    }

    public String validateLogin()
    {
        boolean valid = this.oUserController.validateLogin(getUserEmail(), getUserPass());

        if (valid)
        {
            this.activeUser = this.oUserController.searchByEmail(getUserEmail());
            System.out.println(this.activeUser.getUserId());
            return "/marketplace/mainMenu";
        }

        return "falha";
    }
    
    public String logOut(){
//    	setActiveUser(null);
    	return "/projectMarketPlaceWeb/index.xhtml";
    }
}
