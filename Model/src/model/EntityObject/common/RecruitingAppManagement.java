package model.EntityObject.common;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Oct 31 16:05:45 IST 2020
// ---------------------------------------------------------------------
public interface RecruitingAppManagement extends ApplicationModule {
    String getEventId(String eventid);

    String getEventIdforcandidate(String eventid);

    String getEventIdforinterviewer(String eventid);

    String getEventIdforinterviewerforadd(String eventid);

    String getEventIdforeventinterviewerforadd(String eventid);

    String getEventidforAssigning(String eventid);
}

