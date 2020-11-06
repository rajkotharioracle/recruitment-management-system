package view.bean;


import java.io.IOException;
import java.io.OutputStream;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.sql.DataSource;

import javax.naming.InitialContext;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.output.RichOutputText;

import view.common.SessionUtils;
import view.common.LoginDAO;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

import java.sql.SQLException;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.bean.SessionScoped;
import javax.swing.JFrame;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.OperationBinding;

import view.common.ADFUtils;
import view.common.DataConnect;
import view.common.JSFUtils;


@ManagedBean
@SessionScoped
public class InterviewerDashboardBean  {

    private RichOutputText candidateEmail;
    private RichColumn emailCand;

    public void AcceptInterview() {
        
    }


    public void acceptInterview(ActionEvent actionEvent) throws SQLException {
        String candidateEmail = this.candidateEmail.getValue().toString();
                Connection con = null;
                PreparedStatement ps = null;
                con = DataConnect.getConnection();
                ps = con.prepareStatement("UPDATE AKMR_INTERVIEW_DETAILS set AKMR_INTERVIEW_DETAILS.STATUS='assigned' where AKMR_INTERVIEW_DETAILS.CANDIDATE_EMAIL_ID=?");
                System.out.println("Email "+candidateEmail);
                ps.setString(1, candidateEmail);
                int rs = ps.executeUpdate();
                System.out.println("Updating candidates status ...... ");
                //ResultSet rs = ps.executeUpdate();
                if (rs==1) {
                        //result found, means valid inputs
                        System.out.println("UPDATING CANDIDATE SUCCESS......");
                        //return null;
                       // return "interviewer_dashboard.jsf";
                }
               // return null;

    }
    
    public void declineInterview(ActionEvent actionEvent) throws SQLException {
        String candidateEmail = this.candidateEmail.getValue().toString();
                Connection con = null;
                PreparedStatement ps = null;
                con = DataConnect.getConnection();
                ps = con.prepareStatement("UPDATE AKMR_INTERVIEW_DETAILS set AKMR_INTERVIEW_DETAILS.STATUS='declined' where AKMR_INTERVIEW_DETAILS.CANDIDATE_EMAIL_ID=?");
                System.out.println("Email "+candidateEmail);
                ps.setString(1, candidateEmail);
                int rs = ps.executeUpdate();
                System.out.println("Updating candidates status ...... ");
                //ResultSet rs = ps.executeUpdate();
                if (rs==1) {
                        //result found, means valid inputs
                        System.out.println("UPDATING CANDIDATE SUCCESS......");
                        //return null;
                       // return "interviewer_dashboard.jsf";
                }
               // return null;

    }

    public void setCandidateEmail(RichOutputText candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public RichOutputText getCandidateEmail() {
        return candidateEmail;
    }

    public void setEmailCand(RichColumn emailCand) {
        this.emailCand = emailCand;
    }

    public RichColumn getEmailCand() {
        return emailCand;
    }

    public void startInterview(ActionEvent actionEvent) {
        // Add event code here...
    }
}

