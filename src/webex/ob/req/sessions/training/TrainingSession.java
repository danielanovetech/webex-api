package webex.ob.req.sessions.training;

/**
 * Created by bonjan on 2015/4/15.
 */
public class TrainingSession {

    private AttAccessControl attAccessControl;

    private AttAttendeeOptions attAttendeeOptions;

    private AttEnableOptions attEnableOptions;

    private AttMetaData attMetaData;

    private AttRepeat attRepeat;

    private AttSchedule attSchedule;

    private AttTelephony attTelephony;

    public TrainingSession(AttAccessControl attAccessControl, AttAttendeeOptions attAttendeeOptions,
                           AttEnableOptions attEnableOptions, AttMetaData attMetaData, AttRepeat attRepeat,
                           AttSchedule attSchedule, AttTelephony attTelephony) {
        this.attAccessControl = attAccessControl;
        this.attAttendeeOptions = attAttendeeOptions;
        this.attEnableOptions = attEnableOptions;
        this.attMetaData = attMetaData;
        this.attRepeat = attRepeat;
        this.attSchedule = attSchedule;
        this.attTelephony = attTelephony;
    }

    public AttAccessControl getAttAccessControl() {
        return attAccessControl;
    }

    public void setAttAccessControl(AttAccessControl attAccessControl) {
        this.attAccessControl = attAccessControl;
    }

    public AttAttendeeOptions getAttAttendeeOptions() {
        return attAttendeeOptions;
    }

    public void setAttAttendeeOptions(AttAttendeeOptions attAttendeeOptions) {
        this.attAttendeeOptions = attAttendeeOptions;
    }

    public AttEnableOptions getAttEnableOptions() {
        return attEnableOptions;
    }

    public void setAttEnableOptions(AttEnableOptions attEnableOptions) {
        this.attEnableOptions = attEnableOptions;
    }

    public AttMetaData getAttMetaData() {
        return attMetaData;
    }

    public void setAttMetaData(AttMetaData attMetaData) {
        this.attMetaData = attMetaData;
    }

    public AttRepeat getAttRepeat() {
        return attRepeat;
    }

    public void setAttRepeat(AttRepeat attRepeat) {
        this.attRepeat = attRepeat;
    }

    public AttSchedule getAttSchedule() {
        return attSchedule;
    }

    public void setAttSchedule(AttSchedule attSchedule) {
        this.attSchedule = attSchedule;
    }

    public AttTelephony getAttTelephony() {
        return attTelephony;
    }

    public void setAttTelephony(AttTelephony attTelephony) {
        this.attTelephony = attTelephony;
    }
}