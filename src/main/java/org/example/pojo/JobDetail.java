package org.example.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
public class JobDetail extends JobDetailKey {
    private String description;

    private String jobClassName;

    private String isDurable;

    private String isNonconcurrent;

    private String isUpdateData;

    private String requestsRecovery;

    @Setter
    private byte[] jobData;

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName == null ? null : jobClassName.trim();
    }

    public void setIsDurable(String isDurable) {
        this.isDurable = isDurable == null ? null : isDurable.trim();
    }

    public void setIsNonconcurrent(String isNonconcurrent) {
        this.isNonconcurrent = isNonconcurrent == null ? null : isNonconcurrent.trim();
    }

    public void setIsUpdateData(String isUpdateData) {
        this.isUpdateData = isUpdateData == null ? null : isUpdateData.trim();
    }

    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery == null ? null : requestsRecovery.trim();
    }

}