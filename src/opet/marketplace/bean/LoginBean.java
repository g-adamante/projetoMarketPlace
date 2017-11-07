package opet.marketplace.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import opet.marketplace.controller.UserController;
import opet.marketplace.vo.Lawyer;
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
        FacesContext context = FacesContext.getCurrentInstance();
        boolean valid = this.oUserController.validateLogin(getUserEmail(), getUserPass());

        if (valid)
        {
            this.activeUser = this.oUserController.searchByEmail(getUserEmail());
            return "/marketplace/mainMenu";
        }
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário ou senha incorretos. Tente novamente.", null));
        return "Falha no Login";
    }

    public String logOut()
    {
        // setActiveUser(null);
        return "/projectMarketPlaceWeb/index.xhtml";
    }

    public boolean isLawyer()
    {

        try
        {
            if (getActiveUser() instanceof Lawyer)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            return false;
        }

    }

    public User searchUserID(int pUserId) {
        return oUserController.searchById(pUserId);
    }

}
