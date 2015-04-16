package webex.ob.sessions.training;

import webex.ob.TimeZoneId;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bonjan on 2015/4/15.
 */
public class AttSchedule {

    public AttSchedule(Integer duration, Integer openTime, Timestamp startDate, TimeZoneId timeZoneId) {
        this.duration = String.valueOf(duration);
        this.openTime = String.valueOf(openTime);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        simpleDateFormat.setTimeZone(timeZoneId.getTimeZone());
        Date date = new Date(startDate.getTime());
        this.startDate = simpleDateFormat.format(date);
        this.timeZoneID = timeZoneId.getId();
    }

    private String startDate;

    private String duration;

    private String timeZoneID;

    private String openTime;

    public String getStartDate() {
        return startDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTimeZoneID() {
        return timeZoneID;
    }

    public void setTimeZoneID(String timeZoneID) {
        this.timeZoneID = timeZoneID;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }
}
