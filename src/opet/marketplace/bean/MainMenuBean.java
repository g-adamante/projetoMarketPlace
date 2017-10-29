package opet.marketplace.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import opet.marketplace.vo.Lawyer;

@ManagedBean(name = "mainMenuBean")
@SessionScoped
public class MainMenuBean
                implements Serializable
{

	private static final long serialVersionUID = -749204422378866387L;
	
	@ManagedProperty("#{loginBean}")
    private LoginBean         loginBean;


    public MainMenuBean()
    {
        System.out.println("lawyerMainMenuBean construtor");


    }
    
    public String getUserType(){
    	if(loginBean.getActiveUser() instanceof Lawyer){
    		return "Advogado";
    		
    	}
    	else {
    		return "Cliente";
    	}
    }
	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
    
    

    
   
}
