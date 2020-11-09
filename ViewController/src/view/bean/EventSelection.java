package view.bean;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;
import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import view.common.ADFUtils;
import view.common.JSFUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.Map;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

import oracle.adf.share.ADFContext;

import view.common.DataConnect;

public class EventSelection {
    private RichTable bndreslttable;
    private RichInputText ineventid;
    private RichSelectOneChoice inemailid;
    private RichInputText inmaxlevel;
    private RichInputText instatus;
    private RichInputText inminlev;
    private RichOutputText eventidfor;
    private String eveid;

    public EventSelection() {
    }

    public String getEventDetail() {
        DCBindingContainer bindings = (DCBindingContainer)ADFUtils.evaluateEL("#{bindings}");
                            //System.out.println("bindings....");
                            OperationBinding opBinding = bindings.getOperationBinding("getEventId");
                            OperationBinding opBinding1 = bindings.getOperationBinding("getEventIdforcandidate");
                            OperationBinding opBinding2 = bindings.getOperationBinding("getEventIdforinterviewer");
                            OperationBinding opBinding3 = bindings.getOperationBinding("getEventIdforinterviewerforadd");
                            OperationBinding opBinding4 = bindings.getOperationBinding("getEventIdforeventinterviewerforadd"); 
                            OperationBinding opBinding5 = bindings.getOperationBinding("getEventIdforScheduledinterview");
                            //System.out.println("opbindings....");
                            String userID = (String)opBinding.execute();
                            String userID1 = (String)opBinding1.execute();
                            String userID2 = (String)opBinding2.execute();
                            String userID3 = (String)opBinding3.execute();
                            String userID4 = (String)opBinding4.execute();
                            String userID5 = (String)opBinding5.execute();
                            //System.out.println("userID...." + userID);
                            JSFUtils.setManagedBeanValue("pageFlowScope.pid1", ""+userID);
                            JSFUtils.setManagedBeanValue("pageFlowScope.pid1", ""+userID1);
                            JSFUtils.setManagedBeanValue("pageFlowScope.pid1", ""+userID2);
                            JSFUtils.setManagedBeanValue("pageFlowScope.pid1", ""+userID3); 
                            JSFUtils.setManagedBeanValue("pageFlowScope.pid1", ""+userID4);
                            JSFUtils.setManagedBeanValue("pageFlowScope.pid1", ""+userID5);
        return "eventDetail.jsf";
    }

    public void createwithparamsforevenid(PopupFetchEvent popupFetchEvent) {
        // Add event code here...
        BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding opb = bc.getOperationBinding("Create1");
        opb.execute();
        System.out.println("createinsert happened");
    }

    public void commitrollbackforaddinterviewer(DialogEvent dialogEvent) {
        // Add event code here...
        if (DialogEvent.Outcome.ok == dialogEvent.getOutcome().ok) {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opb = bc.getOperationBinding("Commit1");
            opb.execute();
            OperationBinding opb1 = bc.getOperationBinding("Execute");
            opb1.execute();
            System.out.println("commit happened");
        } else {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opb = bc.getOperationBinding("Rollback1");
            opb.execute();
        }
    }

    public void setBndreslttable(RichTable bndreslttable) {
        this.bndreslttable = bndreslttable;
    }

    public RichTable getBndreslttable() {
        return bndreslttable;
    }

    public void deleteinterviewer(DialogEvent dialogEvent) {
        // Add event code here...
        if (DialogEvent.Outcome.ok == dialogEvent.getOutcome().ok) {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opbdelete = bc.getOperationBinding("Delete1");
            opbdelete.execute();
            OperationBinding opb = bc.getOperationBinding("Commit1");
            opb.execute();
            OperationBinding opb1 = bc.getOperationBinding("Execute");
            opb1.execute();
        }
    }

    public void updateinterviewer(DialogEvent dialogEvent) throws SQLException {
        // Add event code here...
        if(DialogEvent.Outcome.ok == dialogEvent.getOutcome().ok){
            int eventid = Integer.parseInt(ineventid.getValue().toString());
            String emailid = inemailid.getValue().toString();
            int maxlevel = Integer.parseInt(inmaxlevel.getValue().toString());
            String status = instatus.getValue().toString();
            int minlevel = Integer.parseInt(inminlev.getValue().toString());
            Connection con = null;
            PreparedStatement ps = null;
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Update AKMR_EVENT_INTERVIEWER_DETAILS set INTERVIEWER_MAX_LEVEL = ?,INTERVIEWER_MIN_LEVEL = ? where EVENT_ID = ? AND INTERVIEWER_EMAIL_ID = ? ");
            ps.setInt(3, eventid);
            ps.setString(4, emailid);
            ps.setInt(1, maxlevel);
            ps.setInt(2, minlevel);
            ps.executeUpdate();
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opb1 = bc.getOperationBinding("Execute");
            opb1.execute();
        }else {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opb = bc.getOperationBinding("Rollback");
            opb.execute();
        }
        
    }

    public void setIneventid(RichInputText ineventid) {
        this.ineventid = ineventid;
    }

    public RichInputText getIneventid() {
        return ineventid;
    }

    public void setInemailid(RichSelectOneChoice inemailid) {
        this.inemailid = inemailid;
    }

    public RichSelectOneChoice getInemailid() {
        return inemailid;
    }

    public void setInmaxlevel(RichInputText inmaxlevel) {
        this.inmaxlevel = inmaxlevel;
    }

    public RichInputText getInmaxlevel() {
        return inmaxlevel;
    }

    public void setInstatus(RichInputText instatus) {
        this.instatus = instatus;
    }

    public RichInputText getInstatus() {
        return instatus;
    }

    public void setInminlev(RichInputText inminlev) {
        this.inminlev = inminlev;
    }

    public RichInputText getInminlev() {
        return inminlev;
    }

    /*public String getEventidforAssigningclass() {
        // Add event code here...
        DCBindingContainer bindings = (DCBindingContainer)ADFUtils.evaluateEL("#{bindings}");
        OperationBinding opBinding = (OperationBinding)bindings.get("getEventidforAssigning");
        //opBinding.getParamsMap().put(key, value)
        String temp = fetcheventid();
        opBinding.getParamsMap().put("eventId",temp);
        String userID = (String)opBinding.execute();
        JSFUtils.setManagedBeanValue("pageFlowScope.pid", ""+userID);
        return "createInterview.jsf";
    }*/
    
    public String fetcheventid(){
        
    
        /*DCBindingContainer bindings = (DCBindingContainer)ADFUtils.evaluateEL("#{bindings}");
        OperationBinding opBinding = (OperationBinding)bindings.get("getEventidforAssigning");
        opBinding.execute();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        NavigationHandler navHandler = facesContext.getApplication().getNavigationHandler();
        navHandler.handleNavigation(facesContext, null, "assigning");
        //JSFUtils.setManagedBeanValue("pageFlowScope.pid", ""+userID);
        //return "createInterview.jsf";*/
        DCBindingContainer bindings = (DCBindingContainer)ADFUtils.evaluateEL("#{bindings}");
        OperationBinding opBinding = bindings.getOperationBinding("getEventidforAssigning");
        String userID = (String)opBinding.execute();
        JSFUtils.setManagedBeanValue("pageFlowScope.pid1", ""+userID);
        return "createInterview";
    }

    public void setEventidfor(RichOutputText eventidfor) {
        this.eventidfor = eventidfor;
    }

    public RichOutputText getEventidfor() {
        return eventidfor;
    }

    public void commitrollbackforcandidate(DialogEvent dialogEvent) {
        // Add event code here...
        if (DialogEvent.Outcome.ok == dialogEvent.getOutcome().ok) {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opb = bc.getOperationBinding("Commit1");
            opb.execute();
            OperationBinding opb1 = bc.getOperationBinding("Execute1");
            opb1.execute();
            System.out.println("commit happened");
        } else {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opb = bc.getOperationBinding("Rollback1");
            opb.execute();
        }
    }

    public void createforcandi(PopupFetchEvent popupFetchEvent) {
        // Add event code here...
        BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding opb = bc.getOperationBinding("Create3");
        opb.execute();
        System.out.println("createinsert happened");
    }

    public void deletecandidate(DialogEvent dialogEvent) {
        // Add event code here...
        if (DialogEvent.Outcome.ok == dialogEvent.getOutcome().ok) {
            BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding opbdelete = bc.getOperationBinding("Delete");
            opbdelete.execute();
            OperationBinding opb = bc.getOperationBinding("Commit1");
            opb.execute();
            OperationBinding opb1 = bc.getOperationBinding("Execute1");
            opb1.execute();
        }
    }
}

