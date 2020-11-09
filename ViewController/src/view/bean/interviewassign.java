package view.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.data.RichColumn;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import view.common.DataConnect;

public class interviewassign {
    public String intervieweremailid;
    private RichOutputText candemid2;
    private RichOutputText currRound2;
    private RichOutputText eventId2;
    private RichSelectOneChoice intemid2;

    public interviewassign() {
    }
    public void nameof(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        Map map = ((UIComponent)valueChangeEvent.getSource()).getAttributes();
        intervieweremailid = (String)map.get("rowIndexVal");
        System.out.println(intervieweremailid);
    }
    public String onSubmit() throws SQLException {
        // Add event code here...
        
        int eventid = Integer.parseInt(eventId2.getValue().toString());
        String candemailid = candemid2.getValue().toString();
        //String intemailid = nameof(valueChangeEvent).toString();
        int round = Integer.parseInt(currRound2.getValue().toString()) + 1;
        //String intemailid = this.forintervieweremailid();
        System.out.println(candemailid+" "+intervieweremailid+" "+eventid+" "+round);
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        con = DataConnect.getConnection();
        ps = con.prepareStatement("INSERT INTO AKMR_INTERVIEW_DETAILS VALUES(?,?,?,NULL,?,'scheduled',NULL,NULL)");
        ps.setString(1, candemailid);
        ps.setString(2, intervieweremailid);
        ps.setInt(3, eventid);
        ps.setInt(4, round);
        ps.executeUpdate();
        ps1 = con.prepareStatement("UPDATE AKMR_EVENT_CANDIDATE_DETAILS SET CURRENT_ROUND = ?, STATUS = 'assigned' WHERE EVENT_ID = ? AND CANDIDATE_EMAIL_ID = ?");
        ps1.setInt(1,round);
        ps1.setInt(2,eventid);
        ps1.setString(3,candemailid);
        ps1.executeUpdate();
        BindingContainer bc = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding opb = bc.getOperationBinding("Execute");
        opb.execute();
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

    public void setEventId2(RichOutputText eventId2) {
        this.eventId2 = eventId2;
    }

    public RichOutputText getEventId2() {
        return eventId2;
    }

    public void setIntemid2(RichSelectOneChoice intemid2) {
        this.intemid2 = intemid2;
    }

    public RichSelectOneChoice getIntemid2() {
        return intemid2;
    }

    
}
