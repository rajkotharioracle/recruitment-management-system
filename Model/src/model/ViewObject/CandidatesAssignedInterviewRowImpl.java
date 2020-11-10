package model.ViewObject;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Nov 08 23:11:31 IST 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CandidatesAssignedInterviewRowImpl extends ViewRowImpl {


    public static final int ENTITY_INTERVIEWDETAILSEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    protected enum AttributesEnum {
        InterviewerEmailId,
        CandidateEmailId,
        RoundNo,
        EventId,
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


    public static final int INTERVIEWEREMAILID = AttributesEnum.InterviewerEmailId.index();
    public static final int CANDIDATEEMAILID = AttributesEnum.CandidateEmailId.index();
    public static final int ROUNDNO = AttributesEnum.RoundNo.index();
    public static final int EVENTID = AttributesEnum.EventId.index();
    public static final int STATUS = AttributesEnum.Status.index();

    /**
     * This is the default constructor (do not remove).
     */
    public CandidatesAssignedInterviewRowImpl() {
    }
}

