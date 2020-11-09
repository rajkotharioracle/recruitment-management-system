package view.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.List;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.output.RichOutputText;

import view.common.DataConnect;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;

import oracle.binding.BindingContainer;

import oracle.jbo.uicli.binding.JUCtrlListBinding;

import view.common.ADFUtils;


public class CreateInterview {
    public String intervieweremailid;
    private RichOutputText candemid2;
    private RichOutputText currRound2;
    private RichSelectOneChoice intemid2;
    private RichOutputText eventId2;

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
        int eventid = Integer.parseInt(eventId2.getValue().toString());
        String candemailid = candemid2.getValue().toString();
        int round = Integer.parseInt(currRound2.getValue().toString()) + 1;
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


    public void setCandemid2(RichOutputText candemid2) {
        this.candemid2 = candemid2;
    }

    public RichOutputText getCandemid2() {
        return candemid2;
    }

    public void setCurrRound2(RichOutputText currRound2) {
        this.currRound2 = currRound2;
    }

    public RichOutputText getCurrRound2() {
        return currRound2;
    }

    public void setIntemid2(RichSelectOneChoice intemid2) {
        this.intemid2 = intemid2;
    }

    public RichSelectOneChoice getIntemid2() {
        return intemid2;
    }

    public void setEventId2(RichOutputText eventId2) {
        this.eventId2 = eventId2;
    }

    public RichOutputText getEventId2() {
        return eventId2;
    }
}
