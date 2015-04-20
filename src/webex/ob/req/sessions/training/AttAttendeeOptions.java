package webex.ob.req.sessions.training;

import webex.ob.TimeZoneId;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bonjan on 2015/4/15.
 */
public class AttAttendeeOptions {

    private String request;

    private String registration;

    private String auto;

    private String registrationPWD;

    private String maxRegistrations;

    private String registrationCloseDate;

    private String emailInvitations;

    public AttAttendeeOptions(Boolean request, Boolean registration, Boolean auto, String registrationPWD,
                              Integer maxRegistrations, Timestamp registrationCloseDate, Boolean emailInvitations,
                              TimeZoneId timeZoneId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        simpleDateFormat.setTimeZone(timeZoneId.getTimeZone());
        Date date = new Date(registrationCloseDate.getTime());
        this.registrationCloseDate = simpleDateFormat.format(date);
        this.request = String.valueOf(request);
        this.registration = String.valueOf(registration);
        this.auto = String.valueOf(auto);
        this.registrationPWD = registrationPWD;
        this.maxRegistrations = String.valueOf(maxRegistrations);
        this.emailInvitations = String.valueOf(emailInvitations);
    }

    public AttAttendeeOptions() {
        this.request = String.valueOf(true);
        this.registration = String.valueOf(true);
        this.auto = String.valueOf(true);
        this.emailInvitations = String.valueOf(false);
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getRegistrationPWD() {
        return registrationPWD;
    }

    public void setRegistrationPWD(String registrationPWD) {
        this.registrationPWD = registrationPWD;
    }

    public String getMaxRegistrations() {
        return maxRegistrations;
    }

    public void setMaxRegistrations(String maxRegistrations) {
        this.maxRegistrations = maxRegistrations;
    }

    public String getRegistrationCloseDate() {
        return registrationCloseDate;
    }

    public void setRegistrationCloseDate(String registrationCloseDate) {
        this.registrationCloseDate = registrationCloseDate;
    }

    public String getEmailInvitations() {
        return emailInvitations;
    }

    public void setEmailInvitations(String emailInvitations) {
        this.emailInvitations = emailInvitations;
    }
}
