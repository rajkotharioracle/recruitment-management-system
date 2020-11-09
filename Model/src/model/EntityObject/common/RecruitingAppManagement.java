package model.EntityObject.common;

import oracle.jbo.ApplicationModule;

public interface RecruitingAppManagement extends ApplicationModule {
    String getEventId(String eventid);

    String getEventIdforcandidate(String eventid);

    String getEventIdforinterviewer(String eventid);

    String getEventIdforinterviewerforadd(String eventid);

    String getEventIdforeventinterviewerforadd(String eventid);

    String getEventidforAssigning(String eventid);
    
    void setBindvar();

    void report_setCandidate();

    void report_setInterviewer();

    String getEventIdforScheduledinterview(String eventid);
}

