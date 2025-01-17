package org.example.controller;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.JobAndTriggerDto;
import org.example.service.QuartzService;
import org.example.vo.ResultMap;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: fmz200
 * @Date: 2023-02-28 11:41
 */
@Slf4j
@Controller
@RequestMapping(path = "/quartz")
public class QuartzController {

    @Autowired
    private QuartzService quartzService;

    /**
     * 新增定时任务
     *
     * @param jName  任务名称
     * @param jGroup 任务组
     * @param tName  触发器名称
     * @param tGroup 触发器组
     * @param cron   cron表达式
     * @return ResultMap
     */
    @PostMapping(path = "/addjob")
    public ResultMap addjob(String jName, String jGroup, String tName, String tGroup, String cron) {
        try {
            quartzService.addjob(jName, jGroup, tName, tGroup, cron);
            return new ResultMap().success().message("添加任务成功");
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResultMap().error().message("添加任务失败");
        }
    }

    /**
     * 暂停任务
     *
     * @param jName  任务名称
     * @param jGroup 任务组
     * @return ResultMap
     */
    @PostMapping(path = "/pausejob")

    public ResultMap pausejob(String jName, String jGroup) {
        try {
            quartzService.pausejob(jName, jGroup);
            return new ResultMap().success().message("暂停任务成功");
        } catch (SchedulerException e) {
            log.info(e.getMessage());
            return new ResultMap().error().message("暂停任务失败");
        }
    }

    /**
     * 恢复任务
     *
     * @param jName  任务名称
     * @param jGroup 任务组
     * @return ResultMap
     */
    @PostMapping(path = "/resumejob")

    public ResultMap resumejob(String jName, String jGroup) {
        try {
            quartzService.resumejob(jName, jGroup);
            return new ResultMap().success().message("恢复任务成功");
        } catch (SchedulerException e) {
            log.info(e.getMessage());
            return new ResultMap().error().message("恢复任务失败");
        }
    }

    /**
     * 重启任务
     *
     * @param jName  任务名称
     * @param jGroup 任务组
     * @param cron   cron表达式
     * @return ResultMap
     */
    @PostMapping(path = "/reschedulejob")

    public ResultMap rescheduleJob(String jName, String jGroup, String cron) {
        try {
            quartzService.rescheduleJob(jName, jGroup, cron);
            return new ResultMap().success().message("重启任务成功");
        } catch (SchedulerException e) {
            log.info(e.getMessage());
            return new ResultMap().error().message("重启任务失败");
        }
    }

    /**
     * 删除任务
     *
     * @param jName  任务名称
     * @param jGroup 任务组
     * @return ResultMap
     */
    @PostMapping(path = "/deletejob")

    public ResultMap deletejob(String jName, String jGroup) {
        try {
            quartzService.deletejob(jName, jGroup);
            return new ResultMap().success().message("删除任务成功");
        } catch (SchedulerException e) {
            log.info(e.getMessage());
            return new ResultMap().error().message("删除任务失败");
        }
    }

    /**
     * 查询任务
     *
     * @param pageNum  页码
     * @param pageSize 每页显示多少条数据
     * @return Map
     */
    @GetMapping(path = "/queryjob")
    public ResultMap queryjob(Integer pageNum, Integer pageSize) {
        PageInfo<JobAndTriggerDto> pageInfo = quartzService.getJobAndTriggerDetails(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isEmpty(pageInfo.getTotal())) {
            map.put("JobAndTrigger", pageInfo);
            map.put("number", pageInfo.getTotal());
            return new ResultMap().success().data(map).message("查询任务成功");
        }
        return new ResultMap().fail().message("查询任务成功失败，没有数据");
    }
}
