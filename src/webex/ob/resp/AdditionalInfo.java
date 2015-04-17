package webex.ob.resp;

/**
 * Created by bonjan on 2015/4/17.
 */
public class AdditionalInfo {

    private String sessionKey;

    private String guestToken;

    public String getGuestToken() {
        return guestToken;
    }

    public void setGuestToken(String guestToken) {
        this.guestToken = guestToken;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
