package view.bean;


import java.io.IOException;
import java.io.OutputStream;
import sun.misc.IOUtils;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.sql.DataSource;

import javax.naming.InitialContext;

import javax.servlet.http.HttpSession;

import view.common.SessionUtils;
import view.common.LoginDAO;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.swing.JFrame;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.OperationBinding;

import view.common.ADFUtils;
import view.common.JSFUtils;


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
    
    
    
    private static final long serialVersionUID = 1094801825228386363L;
    
    private RichInputText usernameInputText;
    private RichInputText passwordInputText;
    
    JFrame f;
    private RichPopup myPopup;

    /*private String msg;

    public String getMsg() {
                    return msg;
            }

    public void setMsg(String msg) {
                    this.msg = msg;
            }*/

    public LoginBean() {
    }

    public void setUsernameInputText(RichInputText usernameInputText) {
        this.usernameInputText = usernameInputText;
    }

    public RichInputText getUsernameInputText() {
        return usernameInputText;
    }

    public void setPasswordInputText(RichInputText passwordInputText) {
        this.passwordInputText = passwordInputText;
    }

    public RichInputText getPasswordInputText() {
        return passwordInputText;
    }

/*
    public String loginAction() {
        String username = usernameInputText.getValue().toString();
        String password = passwordInputText.getValue().toString();

        System.out.println("username: " + username + " - password: " + password);

        PreparedStatement stat = null;
        ResultSet rs = null;
        Connection conn = null;


        try
        {
            String sql = "Select email_id, password from AKMR_USERS_MASTER where email_id = '" + username + "' and password = '" + password + "'";
            conn = MyADFUtil.getConnection();
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while(rs.next())
            {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", username);
                //return "Dashboard";
                //return "null";
                return "1";
            }
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Passowrd", "Please enter correct username and Password"));
        return "login";
    }
*/
    
    public String loginAction() {
        String user = usernameInputText.getValue().toString();
        System.out.println("User   "+ user);
        String pwd = passwordInputText.getValue().toString();
        
            String valid = LoginDAO.validate(user, pwd);
            if (valid!=null) {
                    System.out.println("Valiiiiiid");
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", user);
                    System.out.println("SUCCESS "+ valid);
                    
                    
                    
                    //Session management code
                    DCBindingContainer bindings = (DCBindingContainer)ADFUtils.evaluateEL("#{bindings}");
                    System.out.println("bindings....");
                    OperationBinding opBinding = bindings.getOperationBinding("getUserId");
                    System.out.println("opbindings....");
                    String userID = (String)opBinding.execute();
                    System.out.println("userID...." + userID);
                    JSFUtils.setManagedBeanValue("sessionScope.loggedInUserID", ""+userID);
                    //JSFUtils.setManagedBeanValue("sessionScope.loggedInUserID", ""+user);                    
                    
                    
                    
                    switch (valid){
                    case "admin" : return "adminHome.jsf";
                    //case "interviewer" : return "interviewer_dashboard.jsf";
                    case "interviewer" : return "scheduledInterviews.jsf";
                    case "candidate" : return "candidate_dashboard.jsf";
                    default : return "login.jsf";
                    }
                    //return "Dashboard";
            } else {
                System.out.println("INValiiiiiid");
                    RichPopup.PopupHints hints = new RichPopup.PopupHints();
                    this.myPopup.show(hints);
                    System.out.println("INValiiiiiid 3");
        

                return "login";
            }
    }
    
    

    public void setMyPopup(RichPopup myPopup) {
        this.myPopup = myPopup;
        
    }

    public RichPopup getMyPopup() {
        return myPopup;
    }
    

}

/*

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import view.common.LoginDAO;
import view.common.SessionUtils;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

//import com.journaldev.jsf.dao.LoginDAO;
//import com.journaldev.jsf.util.SessionUtils;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	private String pwd;
	private String msg;
	private String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	//validate login
	public String validateUsernamePassword() {
		boolean valid = LoginDAO.validate(user, pwd);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
			return "admin";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "login";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}
*/
