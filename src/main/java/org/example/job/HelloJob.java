package org.example.job;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.JobAndTriggerDto;
import org.example.service.QuartzService;
import org.example.util.SpringUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 *@Author: fmz200
 *@Date: 2023-02-28 11:33
 */
@Slf4j
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        QuartzService quartzService = (QuartzService) SpringUtil.getBean("quartzServiceImpl");
        PageInfo<JobAndTriggerDto> jobAndTriggerDetails = quartzService.getJobAndTriggerDetails(1, 10);
        log.info("任务列表总数为：" + jobAndTriggerDetails.getTotal());
        log.info("Hello Job执行时间: " + DateUtil.now());
    }
}
