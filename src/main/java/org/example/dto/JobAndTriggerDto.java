package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

/**
 * @Author: fmz200
 * @Date: 2023-02-28 14:15
 */
@Setter
@Getter
public class JobAndTriggerDto {

    private String JOB_NAME;

    private String JOB_GROUP;

    private String JOB_CLASS_NAME;

    private String TRIGGER_NAME;

    private String TRIGGER_GROUP;

    private BigInteger REPEAT_INTERVAL;

    private BigInteger TIMES_TRIGGERED;

    private String CRON_EXPRESSION;

    private String TIME_ZONE_ID;

}
