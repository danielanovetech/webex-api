package webex.ob.req.sessions.training;

/**
 * Created by bonjan on 2015/4/15.
 */
public class AttRepeat extends AbstractAtt {

    public enum RepeatType {
        SINGLE, RECURRING_SINGLE, MULTIPLE_SESSION
    }

    public AttRepeat(RepeatType repeatType) {
        this.repeatType = repeatType.name();
    }

    public AttRepeat() {
        this.repeatType = RepeatType.SINGLE.name();
    }

    private String repeatType;

    public String getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(String repeatType) {
        this.repeatType = repeatType;
    }
}
