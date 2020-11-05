package view;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectManyShuttle;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneListbox;
import oracle.adf.view.rich.component.rich.nav.RichButton;


import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCBindingContainer.*;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;
import model.EntityObject.RecruitingAppManagementImpl;

import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;

import view.common.ADFUtils;
import model.EntityObject.*;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import view.common.ADFUtils;
import view.common.*;
import java.math.BigDecimal;

import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;


import java.util.List;

import oracle.jbo.uicli.binding.JUCtrlListBinding;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.binding.BindingContainer;

import oracle.jbo.RowSetIterator;


public class Event {
    private RichSelectOneListbox eventName;
    private RichTable xyzcolumn;
    private RichSelectOneChoice report_outcome;
    private RichInputText ename;
    private RichInputText estatus;
    private RichInputDate estime;
    private RichInputText emaxrounds;
    private RichButton createEvent;
    private RichSelectManyShuttle selectedCandidates;
    private List selectedIndxList;

    public Event() {
    }
    
    public void setCompletedEvent()
    {
        
        }

    public void sol1_validator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        // Add event code here...
        
        
        
        }

    public void setEventName(RichSelectOneListbox eventName) {
        this.eventName = eventName;
    }

    public RichSelectOneListbox getEventName() {
        return eventName;
    }
public  String geteid()
{return eventName.toString() ;
    }
 

    public  String b1_action() {
        // Add event code here...
      //  SelectedCandidatesVOImpl.accessBindEid(geteid());
        
      //ApplicationModule apmod=Configuration.createRootApplicationModule("model.ViewObjectQB", "RecruitingAppManagement");
       // ViewObject vo = appMod.findViewObject(SelectedCandidatesVO1);
       /* ViewObject vo = getSelectedCandidatesVO1();
        
        vo.resetViewCriteriaName("SelectedCandidatesVOCriteria");
        vo.setNamedWhereClauseParam("evid",geteid());
        vo. executeQuery();
         */
      // DCBindingContainer bindings = (DCBindingContainer)ADFUtils.evaluateEL("#{bindings}");
       //System.out.println("bindings....");
       //OperationBinding opBinding = bindings.getOperationBinding("setBindvar");
     
           

        
        return null;
    }

    public void setXyzcolumn(RichTable xyzcolumn) {
        this.xyzcolumn = xyzcolumn;
    }

    public RichTable getXyzcolumn() {
        return xyzcolumn;
    }


    public void soc1_validator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        
        // Add event code here...
        
        

    }


    public void soc2_validator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        // Add event code here...

    }

    public void report_outcome_valuechange(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        
     // ViewObject v=model.EntityObject.RecruitingAppManagementImpl.getEventInterviewerDetailsVO1();
     //v.setNamedWhereClauseParam("fid", getReport_outcome());
        
        
        
        
    }

    public void setReport_outcome(RichSelectOneChoice report_outcome) {
        this.report_outcome = report_outcome;
    }

    public RichSelectOneChoice getReport_outcome() {
        return report_outcome;
        
    }

    public String b1_action2() throws SQLException {
        // Add event code here...
        String name = getEname().toString();
                String status = getEstatus().toString();
                String startTime = getEstime().toString();
                String maxRounds=getEmaxrounds().toString();
                Connection con = null;
                PreparedStatement ps = null;
                con = DataConnect.getConnection();
                //ps = con.prepareStatement("Select EMAIL_ID, PASSWORD from AKMR_USERS_MASTER where EMAIL_ID = ? and PASSWORD = ?");
                //ps = con.prepareStatement("Select EMAIL_ID, PASSWORD, IS_ENABLED, USER_TYPE from AKMR_USERS_MASTER where EMAIL_ID = ? and PASSWORD = ? and IS_ENABLED = 1");
                //ps.setString(1, user);
                //ps.setString(2, password);

    
            ps = con.prepareStatement("Insert into AKMR_EVENT_DETAILS(EVENT_ID,EVENT_NAME,EVENT_STATUS,EVENT_START_TIME,EVENT_END_TIME,EVENT_MAX_ROUNDS) " +
                "VALUES(NULL,?,?,?,NULL,?)");
            ps.setString(1, name);
                        ps.setString(2, status);
                        ps.setString(3, startTime);
                     //  ps.setInt(4, maxRounds);
            ps.setString(4, maxRounds);
                    int x= ps.executeUpdate();
                        if (x==1) {
                                //result found, means valid inputs
                            System.out.println("executed successfully");
                                return null;
                                //return true;
                        }
         /*catch (SQLException e) {
            e.getMessage();
            System.out.println("Error Caught");
        }*/
       
              

        
        return null;
    }





    public void setEname(RichInputText ename) {
        this.ename = ename;
    }

    public RichInputText getEname() {
        return ename;
    }

    public void setEstatus(RichInputText estatus) {
        this.estatus = estatus;
    }

    public RichInputText getEstatus() {
        return estatus;
    }

    public void setEstime(RichInputDate estime) {
        this.estime = estime;
    }

    public RichInputDate getEstime() {
        return estime;
    }

    public void setEmaxrounds(RichInputText emaxrounds) {
        this.emaxrounds = emaxrounds;
    }

    public RichInputText getEmaxrounds() {
        return emaxrounds;
    }

    public void setCreateEvent(RichButton createEvent) {
        this.createEvent = createEvent;
    }

    public RichButton getCreateEvent() {
        return createEvent;
    }

    public String createEvent1(ActionEvent actionEvent)  throws SQLException, ParseException {
    
                String name = ename.getValue().toString();
                String status = estatus.getValue().toString();
                String startTime = estime.getValue().toString();
                //startTime = TO_TIMESTAMP_TZ(startTime,'YYYY/MM/DD HH:MI:SS TZH:TZM');
                System.out.println("Creating events ...... 1 " + startTime);
                int maxRounds=Integer.parseInt(emaxrounds.getValue().toString());
                Connection con = null;
                PreparedStatement ps = null;
                con = DataConnect.getConnection();
                ps = con.prepareStatement("Insert into AKMR_EVENT_DETAILS VALUES(NULL,?,?,?,NULL,?)");
                ps.setString(1, name);
                ps.setString(2, status);
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss a");
                Date parsedDate = dateFormat.parse(startTime);
                Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
                ps.setTimestamp(3, timestamp);        
                System.out.println("Creating events ...... ts " + timestamp);
                ps.setInt(4, maxRounds);
                System.out.println("Creating events ...... 2 " + ps);
                //ResultSet rs = ps.executeQuery();
                int rs = ps.executeUpdate();
                System.out.println("Creating events done ...... ");
                //ResultSet rs = ps.executeUpdate();
                if (rs==1) {
                        //result found, means valid inputs
                        System.out.println("Creating events SUCCESS......");
                        return "create_event2.jsf";
                        
                }
           return null;
            }


    public void setSelectedCandidates(RichSelectManyShuttle selectedCandidates) {
        this.selectedCandidates = selectedCandidates;
    }

    public RichSelectManyShuttle getSelectedCandidates() {
        return selectedCandidates;
    }



    public void SetCandidates(ActionEvent actionEvent) throws SQLException {
        System.out.println("Funtion called");
         BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        DCIteratorBinding candi_itr =(DCIteratorBinding)bindings.get("CandidateDataVO1Iterator");
        ViewObject vo=candi_itr.getViewObject();
        Row [] selectedRows=vo.getFilteredRows("selectCandidate",true);
        Connection con = null;
        PreparedStatement ps = null;
        con = DataConnect.getConnection();
        for(Row row :selectedRows)
        {System.out.println("Inside loop");
            //System.out.println(row.getAttribute("CandidateName"));
           // System.out.println(row.getAttribute("CandidateEmail"));
            ps = con.prepareStatement("Insert into AKMR_EVENT_CANDIDATE_DETAILS VALUES(?,?,?,?)");
            ps.setInt(1,5); //add event id from previous page
            ps.setString(2, (String) row.getAttribute("CandidateEmail"));
            ps.setInt(3,0);
            ps.setString(4,"Available");
                ps.executeUpdate();
            }
    
        
        System.out.println("Funtion ended");
    }

    public void setInterviewers(ActionEvent actionEvent) throws SQLException {
        // Add event code here...
        System.out.println("Funtion called");
         BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bindings = bctx.getCurrentBindingsEntry();
        DCIteratorBinding candi_itr =(DCIteratorBinding)bindings.get("InterviewerDataVO1Iterator");
        ViewObject vo=candi_itr.getViewObject();
        Row [] selectedRows=vo.getFilteredRows("selectedInterviewer",true);
        Connection con = null;
        PreparedStatement ps = null;
        con = DataConnect.getConnection();
        for(Row row :selectedRows)
        {System.out.println("Inside loop");
            //System.out.println(row.getAttribute("CandidateName"));
           // System.out.println(row.getAttribute("CandidateEmail"));
            ps = con.prepareStatement("Insert into AKMR_EVENT_INTERVIEWER_DETAILS VALUES(?,?,?,?,?)");
            ps.setInt(1,5); //add event id from previous page
            ps.setString(2, (String) row.getAttribute("InterviewerEmail"));
            ps.setInt(3,7); //SET USING PARAMETER PREVIOUS PAGE
            ps.setString(4,"Available");
            ps.setInt(5,1);
                ps.executeUpdate();
            }
        
        
        System.out.println("Funtion ended");
    }

    public void checkfun(ActionEvent actionEvent) {
        // Add event code here...   INSTEAD of this function ,pass bind variable directly from previous page.
        BindingContext bctx = BindingContext.getCurrent();
                BindingContainer bindings = bctx.getCurrentBindingsEntry();
        DCIteratorBinding candi_itr =(DCIteratorBinding)bindings.get("IntervieweriInEvent1Iterator");
        ViewObject vo=candi_itr.getViewObject();
        
        vo.setNamedWhereClauseParam("eid","5");
        vo.executeQuery();
    }
}