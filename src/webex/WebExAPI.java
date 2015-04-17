package webex;

import webex.method.*;
import webex.ob.req.Attendees;
import webex.ob.req.sessions.training.TrainingSession;

import java.util.List;

/**
 * Created by bonjan on 2015/4/15.
 */
public class WebExAPI {

    public static RegisterMeetingAttendee registerMeetingAttendee(List<Attendees> attendees) {
        return new RegisterMeetingAttendee(attendees);
    }

    public static LstOpenSession lstOpenSession() {
        return new LstOpenSession();
    }

    public static LstMeetingAttendee lstMeetingAttendee(String meetingKey) {
        return new LstMeetingAttendee(meetingKey);
    }

    public static GetSessionInfo getSessionInfo(String sessionKey) {
        return new GetSessionInfo(sessionKey);
    }

    public static CreateTrainingSession createTrainingSession(TrainingSession trainingSession) {
        return new CreateTrainingSession(trainingSession);
    }
}
