package webex.ob.resp;

/**
 * Created by bonjan on 2015/4/1.
 */
public class Attendee {

    private String name;

    private String email;

    private String type;

    private String joinStatus;

    private String role;

    private String registerID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJoinStatus() {
        return joinStatus;
    }

    public void setJoinStatus(String joinStatus) {
        this.joinStatus = joinStatus;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRegisterID() {
        return registerID;
    }

    public void setRegisterID(String registerID) {
        this.registerID = registerID;
    }

    public boolean isVisitor() {
        return "VISITOR".equals(type);
    }

    public boolean isMember() {
        return "MEMBER".equals(type);
    }

    public boolean isRegister() {
        return "REGISTER".equals(joinStatus);
    }

    public boolean isAccept() {
        return "ACCEPT".equals(joinStatus);
    }

    public boolean isReject() {
        return "REJECT".equals(joinStatus);
    }

    public boolean isInvite() {
        return "INVITE".equals(joinStatus);
    }

    public boolean isAttendee() {
        return "ATTENDEE".equals(role);
    }

    public boolean isPresenter() {
        return "PRESENTER".equals(role);
    }
}
