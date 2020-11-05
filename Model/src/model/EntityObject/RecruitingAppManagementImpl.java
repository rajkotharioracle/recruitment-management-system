package model.EntityObject;

import java.math.BigDecimal;

import model.EntityObject.common.RecruitingAppManagement;

import model.ViewObject.CompletedEventsVOImpl;

import model.ViewObjectQB.EventCandidateDatawithNameImpl;
import model.ViewObjectQB.SelectedCandidatesVOImpl;
import model.ViewObjectQB.approinterviewerImpl;
import model.ViewObjectQB.interviewdetailQBImpl;

import oracle.jbo.Row;
import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.ViewObject;
import oracle.jbo.ViewCriteria;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Oct 30 14:52:21 IST 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class RecruitingAppManagementImpl extends ApplicationModuleImpl implements RecruitingAppManagement {
    /**
     * This is the default constructor (do not remove).
     */
    public RecruitingAppManagementImpl() {
    }

    /**
     * Container's getter for approinterviewer1.
     * @return approinterviewer1
     */
    public approinterviewerImpl getapprointerviewer1() {
        return (approinterviewerImpl) findViewObject("approinterviewer1");
    }

    /**
     * Container's getter for EventCandidateDatawithName1.
     * @return EventCandidateDatawithName1
     */
    public EventCandidateDatawithNameImpl getEventCandidateDatawithName1() {
        return (EventCandidateDatawithNameImpl) findViewObject("EventCandidateDatawithName1");
    }

    /**
     * Container's getter for interviewdetailQB1.
     * @return interviewdetailQB1
     */
    public interviewdetailQBImpl getinterviewdetailQB1() {
        return (interviewdetailQBImpl) findViewObject("interviewdetailQB1");
    }

    /**
     * Container's getter for eventdetailswithname1.
     * @return eventdetailswithname1
     */
    public ViewObjectImpl geteventdetailswithname1() {
        return (ViewObjectImpl) findViewObject("eventdetailswithname1");
    }

    /**
     * Container's getter for EventDetails1.
     * @return EventDetails1
     */
    public ViewObjectImpl getEventDetails1() {
        return (ViewObjectImpl) findViewObject("EventDetails1");
    }

    /**
     * Container's getter for CompletedEventsVO1.
     * @return CompletedEventsVO1
     */
    public CompletedEventsVOImpl getCompletedEventsVO1() {
        return (CompletedEventsVOImpl) findViewObject("CompletedEventsVO1");
    }

    /**
     * Container's getter for SelectedCandidatesVO1.
     * @return SelectedCandidatesVO1
     */
    public SelectedCandidatesVOImpl getSelectedCandidatesVO1() {
        return (SelectedCandidatesVOImpl) findViewObject("SelectedCandidatesVO1");
    }
    
    public void setBindvar()
    {                ViewObject vo = getSelectedCandidatesVO1();
                     ViewObject vo1= getCompletedEventsVO1();
            ViewObject vo2=getCandidatesInInterview1(); //candidates in this event

            ViewObject vo3=getCandidatesEventHistory1();
            ViewObject vo4=getInterviewerwithSpecifcEventId1();
            ViewObject vo5 = getInterviewerEventHistory1();
            ViewObject vo6=getCandiateStatus1();
                     Row currentRow= vo1.getCurrentRow();
                    
                     BigDecimal x = (BigDecimal) currentRow.getAttribute("EventId");
                   //  int a= currentRow.getAttribute("EventId");
                    // String x =(String)vo1.getAttribute("EventId");
                    vo.setNamedWhereClauseParam("evid",x);
            vo2.setNamedWhereClauseParam("eid",x);
            vo3.setNamedWhereClauseParam("eid",x);
            vo4.setNamedWhereClauseParam("eid",x);
            vo5.setNamedWhereClauseParam("eid",x);
            vo6.setNamedWhereClauseParam("eid",x);
                    vo. executeQuery();
                    vo2.executeQuery();
                    vo4.executeQuery();
        }


 public void report_setCandidate()
{ViewObject vo=getCandidatesInInterview1();
 ViewObject vo2=getCandiateStatus1();
        ViewObject vo3=getCandidatesEventHistory1();
        Row currentRow= vo.getCurrentRow();
        String x = (String) currentRow.getAttribute("CandidateEmailId");
        vo3.setNamedWhereClauseParam("ceid",x);
        vo2.setNamedWhereClauseParam("ceid",x);
        
        vo3.executeQuery();
        vo2.executeQuery();
    }
 
 
 public void report_setInterviewer()
 {ViewObject vo4 = getInterviewerwithSpecifcEventId1();
         ViewObject vo5 = getInterviewerEventHistory1();
         Row currentRow= vo4.getCurrentRow();
      String x = (String) currentRow.getAttribute("InterviewerEmail");
      vo5.setNamedWhereClauseParam("iid",x);
        vo5.setNamedWhereClauseParam("fid","pursue");//view.event.getReport_outcome());harccoded change later
      vo5.executeQuery();
      
     }
    /**
     * Container's getter for CandidatesInInterview1.
     * @return CandidatesInInterview1
     */
    public ViewObjectImpl getCandidatesInInterview1() {
        return (ViewObjectImpl) findViewObject("CandidatesInInterview1");
    }

    /**
     * Container's getter for CandidatesEventHistory1.
     * @return CandidatesEventHistory1
     */
    public ViewObjectImpl getCandidatesEventHistory1() {
        return (ViewObjectImpl) findViewObject("CandidatesEventHistory1");
    }

    /**
     * Container's getter for EventInterviewerDetailsVO1.
     * @return EventInterviewerDetailsVO1
     */
    public ViewObjectImpl getEventInterviewerDetailsVO1() {
        return (ViewObjectImpl) findViewObject("EventInterviewerDetailsVO1");
    }

    /**
     * Container's getter for InterviewerEventHistory1.
     * @return InterviewerEventHistory1
     */
    public ViewObjectImpl getInterviewerEventHistory1() {
        return (ViewObjectImpl) findViewObject("InterviewerEventHistory1");
    }

    /**
     * Container's getter for FeedbackDetailsVO1.
     * @return FeedbackDetailsVO1
     */
    public ViewObjectImpl getFeedbackDetailsVO1() {
        return (ViewObjectImpl) findViewObject("FeedbackDetailsVO1");
    }

    /**
     * Container's getter for InterviewerwithSpecifcEventId1.
     * @return InterviewerwithSpecifcEventId1
     */
    public ViewObjectImpl getInterviewerwithSpecifcEventId1() {
        return (ViewObjectImpl) findViewObject("InterviewerwithSpecifcEventId1");
    }

    /**
     * Container's getter for EventCandidateDetailsVO1.
     * @return EventCandidateDetailsVO1
     */
    public ViewObjectImpl getEventCandidateDetailsVO1() {
        return (ViewObjectImpl) findViewObject("EventCandidateDetailsVO1");
    }

    /**
     * Container's getter for CandiateStatus1.
     * @return CandiateStatus1
     */
    public ViewObjectImpl getCandiateStatus1() {
        return (ViewObjectImpl) findViewObject("CandiateStatus1");
    }

    /**
     * Container's getter for CandidateDataVO1.
     * @return CandidateDataVO1
     */
    public ViewObjectImpl getCandidateDataVO1() {
        return (ViewObjectImpl) findViewObject("CandidateDataVO1");
    }

    /**
     * Container's getter for InterviewerDataVO1.
     * @return InterviewerDataVO1
     */
    public ViewObjectImpl getInterviewerDataVO1() {
        return (ViewObjectImpl) findViewObject("InterviewerDataVO1");
    }

    /**
     * Container's getter for InterviewersinEventID1.
     * @return InterviewersinEventID1
     */
    public ViewObjectImpl getInterviewersinEventID1() {
        return (ViewObjectImpl) findViewObject("InterviewersinEventID1");
    }

    /**
     * Container's getter for IntervieweriInEvent1.
     * @return IntervieweriInEvent1
     */
    public ViewObjectImpl getIntervieweriInEvent1() {
        return (ViewObjectImpl) findViewObject("IntervieweriInEvent1");
    }
}

