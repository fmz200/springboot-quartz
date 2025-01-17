package org.example.pojo;

import lombok.Getter;

@Getter
public class TriggerKey {
    private String schedName;

    private String triggerName;

    private String triggerGroup;

    public void setSchedName(String schedName) {
        this.schedName = schedName == null ? null : schedName.trim();
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName == null ? null : triggerName.trim();
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup == null ? null : triggerGroup.trim();
    }
}