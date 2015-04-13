package webex.ob;

/**
 * Created by bonjan on 2015/4/2.
 */
public class RegisterInfo {

    public enum Type {
        VISITOR,
        MEMBER
    }

    public enum JoinStatus {
        REGISTER,
        ACCEPT,
        REJECT
    }

    public enum Role {
        ATTENDEE,
        PRESENTER
    }

    public enum EmailInvitation {
        TRUE("true"),
        FALSE("false");

        private String value;
        EmailInvitation(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    private String name;

    private String email;

    private String type;

    private String role;

    private String joinStatus;

    private String emailInvitation;

    private String sessionKey;

    private String sessionNum;

    public RegisterInfo(String name, String email, Type type, Role role, JoinStatus joinStatus,
                        EmailInvitation emailInvitation, String sessionKey, String sessionNum) {
        this.name = name;
        this.email = email;
        this.type = type.name();
        this.role = role.name();
        this.joinStatus = joinStatus.name();
        this.emailInvitation = emailInvitation.getValue();
        this.sessionKey = sessionKey;
        this.sessionNum = sessionNum;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJoinStatus() {
        return joinStatus;
    }

    public void setJoinStatus(String joinStatus) {
        this.joinStatus = joinStatus;
    }

    public String getEmailInvitation() {
        return emailInvitation;
    }

    public void setEmailInvitation(String emailInvitation) {
        this.emailInvitation = emailInvitation;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionNum() {
        return sessionNum;
    }

    public void setSessionNum(String sessionNum) {
        this.sessionNum = sessionNum;
    }
}
