package webex.ob.sessions.training;

/**
 * Created by bonjan on 2015/4/15.
 */
public class AttRepeat {

    public enum RepeatType {
        SINGLE, RECURRING_SINGLE, MULTIPLE_SESSION
    }

    public AttRepeat(RepeatType repeatType) {
        this.repeatType = repeatType.name();
    }

    private String repeatType;

    public String getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(String repeatType) {
        this.repeatType = repeatType;
    }
}
