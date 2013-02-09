
package com.app.vo;

/**
 *
 * @author Devraj
 */
public class ActivityVO {
    
    int ActivityNo;
    String ActivityType;
    int ActivityBy;
    String Message;
    String time;
    int hour;
    int minute;

    public ActivityVO(int ActivityNo, String ActivityType, int ActivityBy, String Message, String time, int hour, int minute) {
        this.ActivityNo = ActivityNo;
        this.ActivityType = ActivityType;
        this.ActivityBy = ActivityBy;
        this.Message = Message;
        this.time = time;
        this.hour = hour;
        this.minute = minute;
    }

    public int getActivityBy() {
        return ActivityBy;
    }

    public void setActivityBy(int ActivityBy) {
        this.ActivityBy = ActivityBy;
    }

    public int getActivityNo() {
        return ActivityNo;
    }

    public void setActivityNo(int ActivityNo) {
        this.ActivityNo = ActivityNo;
    }

    public String getActivityType() {
        return ActivityType;
    }

    public void setActivityType(String ActivityType) {
        this.ActivityType = ActivityType;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
