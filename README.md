# recruitment-management-system

Objective
Develop an application to manage entire recruitment process of an organization. Main objective is to reduce manual processes and execute the recruitment process in efficient manner. Apart from handling recruitment process on site, application should have separate module to conduct online MCQ tests as per the requirement of an organization. This can help to filter candidates at first step whenever required. Application should automate tasks right from applying job/posting job requirement until the rolling out of the final result.
Primary Feature to Focus upon
While above objective is to develop an application to handle an end-to-end process, our primary focus for this project will be handling interviews for the particular event. Other features can be implemented only after mentor approves completion of this primary feature and extra time is there before you submit the project.
High level Functionalities of Primary Feature
• Create users and roles to implement security.
• Application should have provision to configure data from seeded data for the particular event. This includes name of interviewers (panelists), number of rounds, process methodology, parameters to evaluate ... etc. For an example, there will be master dataset containing list of interviewers out of which required interviewers can be selected by Admin for the particular event.
• Admin can add/edit/delete master data as required. Master data is irrespective of an event. It is common across all events.
• On the day of interview, application should help to track candidates' performance (In-process status) which includes whether candidate has been selected for further round or not and comments(feedback) by interviewer after the particular round. At the end of an interview day, final report should be generated stating whether particular candidate is selected or not in each of rounds and name of interviewer for each of rounds.
• Optional columns should be maintained at database level, which can be used for the particular report/functionality if any additional requirement comes later on.
• Application should maintain history of the particular candidate, which should be helpful for an organization to track candidate's performance in previous occurrences.
Detailed Functionalities of Primary Feature
:One: Before starting an event
• Updating master data as required.
:Two: Starting/Resuming an event
• Admin can start event by specific action. Till Admin ends the particular event, data and status with respect to the event must be stored/saved automatically.
• Upon starting an application, admin can either start new event OR resume one of previous ongoing events which is not ended yet.
• Data of each event gets stored separately and will have no relation with any of other events except one scenario which is explained in one of points below.
• Admin will have a provision to give unique name for each of events he/she is starting.
• Once particular event is started by Admin, Admin needs to select list of interviewers and list of rounds per candidate. Also, which is the maximum round particular interviewer can take.
• Additionally, Admin will also fill details like Name, Email and Mobile numbers of all candidates.
• There will be duplicate check happening automatically when details of particular candidate is being filled in. If candidate with same details is found in same or any of previous events, there should be a warning message upon saving stating in which of events (with start date of that event), a particular candidate is found. However, this will not stop an admin from entering and submitting data. It'll be upto an admin to decide whether to keep such candidate or not. This is the only scenario when data of other events will come into picture for a particular event.
:Three: Event in progress
• There should be an option to add/remove/update interviewers' list and candidates' list while the particular event is on going.
• Admin should be able to add additional round of an interview for the particular candidate if required.
• Admin cannot assign an interviewer who has already taken one of previous rounds for the same candidate.
• When admin assigns a candidate to particular Interviewer, Interviewer should get a notification with details of a candidate, round of the candidate and feedback of previous rounds (if any). Upon reviewing data, interviewer will confirm which will start an interview of particular round. There will be a provision to discard interview request with justification for an interviewer in which case, admin will be notified and candidate will again be in waiting state. Once interviewer confirms a candidate and starts the interview round, status of the candidate will change from waiting to the 'in progress'. Also, there should be an intermediate another status when candidate is allocated to an interviewer by an admin and interviewer is yet to confirm.
• Interviewer will have to end an interview upon completion of a particular round. This will be allowed only after interviewer fills in feedback and choose the status.
• Interviewers will have an option to go for a break only when none of interview round is in progress which is assigned to him/her. Interviewer will have a provision to tell an application that, he/she is going for a break and once back, he/she will tell an application again.
• Candidate will not go to 'Offered' status even if he/she clears all rounds. In such case, status of candidate will be unique which indicates he/she has cleared all rounds and only after an approval of an admin, status will get changed to an 'offered' one. If required, admin can opt for one more round for such candidate and status of the candidate should change accordingly in such case.
:Four: Facility to find following information while recruitment process is in progress...
• Candidates in waiting state for the next round (ordered by timestamp of completion of last round)
• Out of total number of candidates, how many are selected, rejected, in waiting state and did not appear.
• Whose and which round of an interview is being taken by a particular interviewer.
• Which of interviewers are available and not taking any interview at the moment.
:Five: Reports after an event
• Who took which round of an interview for the particular candidate(s)
• Final status of the particular candidate
• How many interviews particular interviewer took segregated by outcome of each round (pursue/hold/reject)
• Maintaining history of the particular candidate which can be searched efficiently at any time. History can be saved in master data post completion of an event. UI should be developed where if exists, candidate's past performance can be fetched.
Additional features to implement (optional)
• Job seekers can register themselves for vacant positions.
• Once registered, Candidates can fill in their application and send it to a particular organization.
• Provision to conduct online tests as per the requirement. Based on topics chosen and time set by the organization, test should be prepared automatically.
• Each candidate should get different or shuffled questions in online test but same difficulty level should be maintained for the particular test.
• Organization can add/update/delete job/vacancy related details.
• Organization can set different preferences for a particular job like number of vacancies, number of interview rounds, deadline to fill in vacancy.. etc. This should be used to automate relevant tasks and various notifications should be sent at appropriate time.
• Organization should be notified once timeline is completed or maximum possible number of candidates has applied for the particular job. After this, application should help to prepare the test/interview schedule automatically based on the preference set by the organization.
• Candidate should be able to find relevant job easily based on his/her skill set. This can be achieved with the help of efficient search system where search results are filtered based on different factors.
• Application should help to generate different reports like 'Different open jobs for the particular organization', 'Interested candidates for the particular job', 'Shortlisted candidates for the particular round', 'Finalized candidates'.. etc.
• System should detect if same candidate applies with different login.
• Candidate should be able to see status of his application online at various point of time.
