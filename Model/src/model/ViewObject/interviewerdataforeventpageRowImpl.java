package model.ViewObject;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Nov 02 10:27:01 IST 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class interviewerdataforeventpageRowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        InterviewerName,
        InterviewerEmailId,
        InterviewerMinLevel,
        InterviewerMaxLevel,
        Status,
        EventId;
        private static AttributesEnum[] vals = null;
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

    public static final int INTERVIEWERNAME = AttributesEnum.InterviewerName.index();
    public static final int INTERVIEWEREMAILID = AttributesEnum.InterviewerEmailId.index();
    public static final int INTERVIEWERMINLEVEL = AttributesEnum.InterviewerMinLevel.index();
    public static final int INTERVIEWERMAXLEVEL = AttributesEnum.InterviewerMaxLevel.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int EVENTID = AttributesEnum.EventId.index();

    /**
     * This is the default constructor (do not remove).
     */
    public interviewerdataforeventpageRowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute InterviewerName.
     * @return the InterviewerName
     */
    public String getInterviewerName() {
        return (String) getAttributeInternal(INTERVIEWERNAME);
    }

    /**
     * Gets the attribute value for the calculated attribute InterviewerEmailId.
     * @return the InterviewerEmailId
     */
    public String getInterviewerEmailId() {
        return (String) getAttributeInternal(INTERVIEWEREMAILID);
    }

    /**
     * Gets the attribute value for the calculated attribute InterviewerMinLevel.
     * @return the InterviewerMinLevel
     */
    public Integer getInterviewerMinLevel() {
        return (Integer) getAttributeInternal(INTERVIEWERMINLEVEL);
    }

    /**
     * Gets the attribute value for the calculated attribute InterviewerMaxLevel.
     * @return the InterviewerMaxLevel
     */
    public Integer getInterviewerMaxLevel() {
        return (Integer) getAttributeInternal(INTERVIEWERMAXLEVEL);
    }

    /**
     * Gets the attribute value for the calculated attribute Status.
     * @return the Status
     */
    public String getStatus() {
        return (String) getAttributeInternal(STATUS);
    }

    /**
     * Gets the attribute value for the calculated attribute EventId.
     * @return the EventId
     */
    public Integer getEventId() {
        return (Integer) getAttributeInternal(EVENTID);
    }
}

