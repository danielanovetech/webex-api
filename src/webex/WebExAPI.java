package webex;

import webex.method.GetSessionInfo;
import webex.method.LstMeetingAttendee;
import webex.method.LstOpenSession;
import webex.method.RegisterMeetingAttendee;
import webex.ob.RegisterInfo;

import java.util.List;

/**
 * Created by bonjan on 2015/4/15.
 */
public class WebExAPI {

    public static RegisterMeetingAttendee registerMeetingAttendee(List<RegisterInfo> registerInfos) {
        return new RegisterMeetingAttendee(registerInfos);
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
}
