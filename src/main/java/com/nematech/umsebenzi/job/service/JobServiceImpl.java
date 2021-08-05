package com.nematech.umsebenzi.job.service;

import com.nematech.umsebenzi.config.TypeMapper;
import com.nematech.umsebenzi.job.dto.JobDTO;
import com.nematech.umsebenzi.job.model.Job;
import com.nematech.umsebenzi.job.model.JobLocation;
import com.nematech.umsebenzi.job.model.JobRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

  private final JobRepository jobRepository;
  private final JobRoleRepository jobRoleRepository;
  private final JobLocationRepository jobLocationRepository;
  private final TypeMapper mapper;

  @Override
  public JobDTO createJob(JobDTO jobDTO) {

    log.info("Register Job :{}", jobDTO);

    Job job = jobRepository.save(mapper.map(jobDTO));
    mapper.map(job);

    if (!Objects.isNull(jobDTO.getJobLocation())) {
      JobLocation jobLocation = new JobLocation();
      jobLocation.setJobId(job.getId());
      jobLocation.setJobLocation(jobDTO.getJobLocation().getJobLocation());
      JobLocation location = jobLocationRepository.save(jobLocation);
      jobDTO.setJobLocation(location);
    }

    if (!Objects.isNull(jobDTO.getJobRoleList())) {
      List<JobRole> jobRoleList = jobDTO.getJobRoleList().stream().map(jobRole -> {

        jobRole.setJobId(job.getId());
        jobRole.setJobRole(jobRole.getJobRole());
        return jobRoleRepository.save(jobRole);
      }).collect(Collectors.toList());

      jobDTO.setJobRoleList(jobRoleList);
    }

    return jobDTO;
  }

  @Override
  public JobDTO getJob(String jobReferenceNumber) {

    Job job = jobRepository.findByJobReferenceNo(jobReferenceNumber);

    if(Objects.isNull(job)){
      return null;
    }
    JobDTO jobDTO = mapper.map(job);
    List<JobRole> jobRoleList = jobRoleRepository.findByJobId(job.getId());
    if (!Objects.isNull(jobRoleList)) {

      jobDTO.setJobRoleList(jobRoleList);
    }
    JobLocation jobLocation = jobLocationRepository.findByJobId(job.getId());
    if (!Objects.isNull(jobLocation)) {
      jobDTO.setJobLocation(jobLocation);
    }

    return jobDTO;
  }

  @Override
  public List<JobDTO> getJobList() {
    return getJobDTO(jobRepository.findAll());
  }

  public JobDTO getJobDTO(Job job) {

    JobDTO jobDTO = new JobDTO();
    jobDTO.setBasicSalary(job.getBasicSalary());
    jobDTO.setEducationLevelRequirement(job.getEducationLevelRequirement());
    jobDTO.setBasicSalary(job.getBasicSalary());
    jobDTO.setEmployerId(job.getEmployerId());
    jobDTO.setJobCategory(job.getJobCategory());
    jobDTO.setJobDescription(job.getJobDescription());
    jobDTO.setJobReferenceNo(job.getJobReferenceNo());
    jobDTO.setJobTitle(job.getJobTitle());
    jobDTO.setJobType(job.getJobType());
    jobDTO.setJobCategory(job.getJobCategory());
    jobDTO.setYearsOfExpirience(job.getYearsOfExpirience());
    jobDTO.setId(job.getId());
    jobDTO.setJobLocation(jobLocationRepository.findByJobId(jobDTO.getId()));
    jobDTO.setJobRoleList(jobRoleRepository.findByJobId(job.getId()));
    return jobDTO;
  }

  public List<JobDTO> getJobDTO(List<Job> jobList) {

    List<JobDTO> jobDTOList = new ArrayList<>();
    for (Job job : jobList) {

      JobDTO jobDTO = getJobDTO(job);
      jobDTO.setJobLocation(jobLocationRepository.findByJobId(job.getId()));
      jobDTO.setJobRoleList(jobRoleRepository.findByJobId(job.getId()));
      jobDTOList.add(jobDTO);
    }

    return jobDTOList;
  }

}
