package model.ViewObject;

import oracle.jbo.domain.Date;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Oct 31 15:04:36 IST 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class eventdetailswithnameRowImpl extends ViewRowImpl {
    public static final int ENTITY_CANDIDATEDATAEO = 0;
    public static final int ENTITY_INTERVIEWERDATAEO = 1;
    public static final int ENTITY_INTERVIEWDETAILSEO = 2;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        CandidateName,
        CandidateEmail,
        InterviewerName,
        InterviewerEmail,
        InterviewerEmailId,
        CandidateEmailId,
        EventId,
        StartTime,
        EndTime,
        RoundNo,
        Status;
        private static AttributesEnum[] vals = null;
        ;
        private static final int firstIndex = 0;

        protected int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        protected static final int firstIndex() {
            return firstIndex;
        }

        protected static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        protected static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }

    public static final int CANDIDATENAME = AttributesEnum.CandidateName.index();
    public static final int CANDIDATEEMAIL = AttributesEnum.CandidateEmail.index();
    public static final int INTERVIEWERNAME = AttributesEnum.InterviewerName.index();
    public static final int INTERVIEWEREMAIL = AttributesEnum.InterviewerEmail.index();
    public static final int INTERVIEWEREMAILID = AttributesEnum.InterviewerEmailId.index();
    public static final int CANDIDATEEMAILID = AttributesEnum.CandidateEmailId.index();
    public static final int EVENTID = AttributesEnum.EventId.index();
    public static final int STARTTIME = AttributesEnum.StartTime.index();
    public static final int ENDTIME = AttributesEnum.EndTime.index();
    public static final int ROUNDNO = AttributesEnum.RoundNo.index();
    public static final int STATUS = AttributesEnum.Status.index();

    /**
     * This is the default constructor (do not remove).
     */
    public eventdetailswithnameRowImpl() {
    }

    /**
     * Gets CandidateDataEO entity object.
     * @return the CandidateDataEO
     */
    public EntityImpl getCandidateDataEO() {
        return (EntityImpl) getEntity(ENTITY_CANDIDATEDATAEO);
    }

    /**
     * Gets InterviewerDataEO entity object.
     * @return the InterviewerDataEO
     */
    public EntityImpl getInterviewerDataEO() {
        return (EntityImpl) getEntity(ENTITY_INTERVIEWERDATAEO);
    }

    /**
     * Gets InterviewDetailsEO entity object.
     * @return the InterviewDetailsEO
     */
    public EntityImpl getInterviewDetailsEO() {
        return (EntityImpl) getEntity(ENTITY_INTERVIEWDETAILSEO);
    }

    /**
     * Gets the attribute value for CANDIDATE_NAME using the alias name CandidateName.
     * @return the CANDIDATE_NAME
     */
    public String getCandidateName() {
        return (String) getAttributeInternal(CANDIDATENAME);
    }

    /**
     * Sets <code>value</code> as attribute value for CANDIDATE_NAME using the alias name CandidateName.
     * @param value value to set the CANDIDATE_NAME
     */
    public void setCandidateName(String value) {
        setAttributeInternal(CANDIDATENAME, value);
    }

    /**
     * Gets the attribute value for CANDIDATE_EMAIL using the alias name CandidateEmail.
     * @return the CANDIDATE_EMAIL
     */
    public String getCandidateEmail() {
        return (String) getAttributeInternal(CANDIDATEEMAIL);
    }

    /**
     * Sets <code>value</code> as attribute value for CANDIDATE_EMAIL using the alias name CandidateEmail.
     * @param value value to set the CANDIDATE_EMAIL
     */
    public void setCandidateEmail(String value) {
        setAttributeInternal(CANDIDATEEMAIL, value);
    }

    /**
     * Gets the attribute value for INTERVIEWER_NAME using the alias name InterviewerName.
     * @return the INTERVIEWER_NAME
     */
    public String getInterviewerName() {
        return (String) getAttributeInternal(INTERVIEWERNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for INTERVIEWER_NAME using the alias name InterviewerName.
     * @param value value to set the INTERVIEWER_NAME
     */
    public void setInterviewerName(String value) {
        setAttributeInternal(INTERVIEWERNAME, value);
    }

    /**
     * Gets the attribute value for INTERVIEWER_EMAIL using the alias name InterviewerEmail.
     * @return the INTERVIEWER_EMAIL
     */
    public String getInterviewerEmail() {
        return (String) getAttributeInternal(INTERVIEWEREMAIL);
    }

    /**
     * Sets <code>value</code> as attribute value for INTERVIEWER_EMAIL using the alias name InterviewerEmail.
     * @param value value to set the INTERVIEWER_EMAIL
     */
    public void setInterviewerEmail(String value) {
        setAttributeInternal(INTERVIEWEREMAIL, value);
    }

    /**
     * Gets the attribute value for INTERVIEWER_EMAIL_ID using the alias name InterviewerEmailId.
     * @return the INTERVIEWER_EMAIL_ID
     */
    public String getInterviewerEmailId() {
        return (String) getAttributeInternal(INTERVIEWEREMAILID);
    }

    /**
     * Sets <code>value</code> as attribute value for INTERVIEWER_EMAIL_ID using the alias name InterviewerEmailId.
     * @param value value to set the INTERVIEWER_EMAIL_ID
     */
    public void setInterviewerEmailId(String value) {
        setAttributeInternal(INTERVIEWEREMAILID, value);
    }

    /**
     * Gets the attribute value for CANDIDATE_EMAIL_ID using the alias name CandidateEmailId.
     * @return the CANDIDATE_EMAIL_ID
     */
    public String getCandidateEmailId() {
        return (String) getAttributeInternal(CANDIDATEEMAILID);
    }

    /**
     * Sets <code>value</code> as attribute value for CANDIDATE_EMAIL_ID using the alias name CandidateEmailId.
     * @param value value to set the CANDIDATE_EMAIL_ID
     */
    public void setCandidateEmailId(String value) {
        setAttributeInternal(CANDIDATEEMAILID, value);
    }

    /**
     * Gets the attribute value for EVENT_ID using the alias name EventId.
     * @return the EVENT_ID
     */
    public Integer getEventId() {
        return (Integer) getAttributeInternal(EVENTID);
    }

    /**
     * Sets <code>value</code> as attribute value for EVENT_ID using the alias name EventId.
     * @param value value to set the EVENT_ID
     */
    public void setEventId(Integer value) {
        setAttributeInternal(EVENTID, value);
    }

    /**
     * Gets the attribute value for START_TIME using the alias name StartTime.
     * @return the START_TIME
     */
    public Date getStartTime() {
        return (Date) getAttributeInternal(STARTTIME);
    }

    /**
     * Sets <code>value</code> as attribute value for START_TIME using the alias name StartTime.
     * @param value value to set the START_TIME
     */
    public void setStartTime(Date value) {
        setAttributeInternal(STARTTIME, value);
    }

    /**
     * Gets the attribute value for END_TIME using the alias name EndTime.
     * @return the END_TIME
     */
    public Date getEndTime() {
        return (Date) getAttributeInternal(ENDTIME);
    }

    /**
     * Sets <code>value</code> as attribute value for END_TIME using the alias name EndTime.
     * @param value value to set the END_TIME
     */
    public void setEndTime(Date value) {
        setAttributeInternal(ENDTIME, value);
    }

    /**
     * Gets the attribute value for ROUND_NO using the alias name RoundNo.
     * @return the ROUND_NO
     */
    public Integer getRoundNo() {
        return (Integer) getAttributeInternal(ROUNDNO);
    }

    /**
     * Sets <code>value</code> as attribute value for ROUND_NO using the alias name RoundNo.
     * @param value value to set the ROUND_NO
     */
    public void setRoundNo(Integer value) {
        setAttributeInternal(ROUNDNO, value);
    }

    /**
     * Gets the attribute value for STATUS using the alias name Status.
     * @return the STATUS
     */
    public String getStatus() {
        return (String) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as attribute value for STATUS using the alias name Status.
     * @param value value to set the STATUS
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }
}

