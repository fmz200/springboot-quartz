package org.example.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Trigger extends TriggerKey {
    private String jobName;

    private String jobGroup;

    private String description;

    @Setter
    private Long nextFireTime;

    @Setter
    private Long prevFireTime;

    @Setter
    private Integer priority;

    private String triggerState;

    private String triggerType;

    @Setter
    private Long startTime;

    @Setter
    private Long endTime;

    private String calendarName;

    @Setter
    private Short misfireInstr;

    @Setter
    private byte[] jobData;

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup == null ? null : jobGroup.trim();
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public void setTriggerState(String triggerState) {
        this.triggerState = triggerState == null ? null : triggerState.trim();
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType == null ? null : triggerType.trim();
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName == null ? null : calendarName.trim();
    }

}