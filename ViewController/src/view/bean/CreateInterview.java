package view.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.List;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import view.common.DataConnect;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;

import oracle.binding.BindingContainer;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import view.common.ADFUtils;


public class CreateInterview {
    private RichInputText candemid;
    private RichInputText currRound;
    private RichInputText eventId;
    private RichSelectOneChoice intemid;
    public String intervieweremailid;
    public CreateInterview() {
    }
    public void forintervieweremailid(ValueChangeEvent valueChangeEvent) {
           valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
           Map map = ((UIComponent)valueChangeEvent.getSource()).getAttributes();
           String reportTypeValue = (String)map.get("rowIndexVal");
           intervieweremailid = reportTypeValue.toString() ;
    }
    public String onsubmit() throws SQLException {
        // Add event code here...
        int eventid = Integer.parseInt(eventId.getValue().toString());
        String candemailid = candemid.getValue().toString();
        int round = Integer.parseInt(currRound.getValue().toString()) + 1;
        //String intemailid = this.forintervieweremailid();
        System.out.println(candemailid+" "+intervieweremailid+" "+eventid+" "+round);
        Connection con = null;
        PreparedStatement ps = null;
        con = DataConnect.getConnection();
        ps = con.prepareStatement("INSERT INTO AKMR_INTERVIEW_DETAILS VALUES(?,?,?,NULL,?,'scheduled',NULL,NULL)");
        ps.setString(1, candemailid);
        ps.setString(2, intervieweremailid);
        ps.setInt(3, eventid);
        ps.setInt(4, round);
        ps.executeUpdate();
        return null;
    }

    public void setCandemid(RichInputText candemid) {
        this.candemid = candemid;
    }

    public RichInputText getCandemid() {
        return candemid;
    }

    public void setCurrRound(RichInputText currRound) {
        this.currRound = currRound;
    }

    public RichInputText getCurrRound() {
        return currRound;
    }

    public void setEventId(RichInputText eventId) {
        this.eventId = eventId;
    }

    public RichInputText getEventId() {
        return eventId;
    }

    public void setIntemid(RichSelectOneChoice intemid) {
        this.intemid = intemid;
    }

    public RichSelectOneChoice getIntemid() {
        return intemid;
    }


}
