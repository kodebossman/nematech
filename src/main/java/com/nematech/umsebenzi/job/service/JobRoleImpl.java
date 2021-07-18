package com.nematech.umsebenzi.job.service;

import com.nematech.umsebenzi.job.dto.JobRoleDTO;
import com.nematech.umsebenzi.job.model.JobRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
@RequiredArgsConstructor
public class JobRoleImpl implements JobRoleService{

  private final JobRoleRepository jobRoleRepository;
  @Override
  public void createJobRole(List<JobRoleDTO> jobRoleList) {

    jobRoleRepository.saveAll(getJobRoleList(jobRoleList));
  }

  public JobRole createJobRole(JobRoleDTO jobRoleDTO){

    JobRole jobRole = new JobRole();
    jobRole.setJobRole(jobRoleDTO.getJobRole());
    jobRole.setJobId(jobRole.getJobId());
    return jobRole;
  }

  protected List<JobRole> getJobRoleList(List<JobRoleDTO> jobRoleDTOList){

   return jobRoleDTOList.stream().map(this::createJobRole).collect(Collectors.toList());

  }
}
