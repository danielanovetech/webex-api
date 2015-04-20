package webex.ob.req.sessions.training;

/**
 * Created by bonjan on 2015/4/15.
 */
public class AttAccessControl {

    public enum Listing {
        UNLISTED, PUBLIC, PRIVATE
    }

    public AttAccessControl(Listing listing, String sessionPassword) {
        this.listing = listing.name();
        this.sessionPassword = sessionPassword;
    }

    public AttAccessControl() {
        this.listing = Listing.PUBLIC.name();
    }

    private String listing;

    private String sessionPassword;

    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
    }

    public String getSessionPassword() {
        return sessionPassword;
    }

    public void setSessionPassword(String sessionPassword) {
        this.sessionPassword = sessionPassword;
    }
}
