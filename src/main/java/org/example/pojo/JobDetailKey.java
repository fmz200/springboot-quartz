package org.example.pojo;

import lombok.Getter;

@Getter
public class JobDetailKey {
    private String schedName;

    private String jobName;

    private String jobGroup;

    public void setSchedName(String schedName) {
        this.schedName = schedName == null ? null : schedName.trim();
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup == null ? null : jobGroup.trim();
    }
}