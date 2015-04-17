package webex.ob.resp;

/**
 * Created by bonjan on 2015/4/7.
 */
public class SessionInfo {

    private String confName;

    private String status;

    private String isRecurring;

    private String hostFirstName;

    private String hostLastName;

    private String hostEmail;

    private String hostID;

    private String startDate;

    private String timeZone;

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsRecurring() {
        return isRecurring;
    }

    public void setIsRecurring(String isRecurring) {
        this.isRecurring = isRecurring;
    }

    public String getHostFirstName() {
        return hostFirstName;
    }

    public void setHostFirstName(String hostFirstName) {
        this.hostFirstName = hostFirstName;
    }

    public String getHostLastName() {
        return hostLastName;
    }

    public void setHostLastName(String hostLastName) {
        this.hostLastName = hostLastName;
    }

    public String getHostEmail() {
        return hostEmail;
    }

    public void setHostEmail(String hostEmail) {
        this.hostEmail = hostEmail;
    }

    public String getHostID() {
        return hostID;
    }

    public void setHostID(String hostID) {
        this.hostID = hostID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
