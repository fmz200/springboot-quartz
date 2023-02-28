package org.example.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Set;

/**
 *@Author: fmz200
 *@Date: 2023-02-28 11:33
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SimpleJob implements Job {

    private static Logger log = LoggerFactory.getLogger(SimpleJob.class);
    private JobKey jobkey = null;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        jobkey = context.getJobDetail().getKey();
        log.info("开始执行SimpleJob。。。。。。。。。。。。。。。。。。。。。。");
        log.info("Excuting job: " + jobkey + " executing at " + new Date() + " fire by: " + context.getTrigger().getKey());

        if (context.getMergedJobDataMap().size() > 0) {
            Set<String> keys = context.getMergedJobDataMap().keySet();
            for (String key : keys) {
                String value = context.getMergedJobDataMap().getString(key);
                log.info(" jobdatamap entry: " + key + " = " + value);
            }
            context.setResult("hello");
        }


    }

}