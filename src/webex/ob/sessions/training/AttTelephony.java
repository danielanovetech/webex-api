package webex.ob.sessions.training;

/**
 * Created by bonjan on 2015/4/15.
 */
public class AttTelephony {

    public enum TelephonySupport {
        NONE, CALLIN, CALLBACK, OTHER
    }

    public AttTelephony(TelephonySupport telephonySupport) {
        this.telephonySupport = telephonySupport.name();
    }

    private String telephonySupport;

    public String getTelephonySupport() {
        return telephonySupport;
    }

    public void setTelephonySupport(String telephonySupport) {
        this.telephonySupport = telephonySupport;
    }
}
