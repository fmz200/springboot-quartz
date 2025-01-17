package org.example.pojo;

import lombok.Getter;

@Getter
public class CronTrigger extends CronTriggerKey {
    private String cronExpression;
    private String timeZoneId;

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId == null ? null : timeZoneId.trim();
    }
}