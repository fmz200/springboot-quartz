package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.dto.JobAndTriggerDto;
import org.example.pojo.JobDetail;
import org.example.pojo.JobDetailKey;

import java.util.List;

@Mapper
public interface JobDetailMapper {
    int deleteByPrimaryKey(JobDetailKey key);

    int insert(JobDetail record);

    int insertSelective(JobDetail record);

    JobDetail selectByPrimaryKey(JobDetailKey key);

    int updateByPrimaryKeySelective(JobDetail record);

    int updateByPrimaryKeyWithBLOBs(JobDetail record);

    int updateByPrimaryKey(JobDetail record);

    List<JobAndTriggerDto> getJobAndTriggerDetails();
}