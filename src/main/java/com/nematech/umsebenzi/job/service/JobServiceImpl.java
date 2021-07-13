package com.nematech.umsebenzi.job.service;

import com.nematech.umsebenzi.job.dto.JobDTO;
import com.nematech.umsebenzi.job.model.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class JobServiceImpl implements JobService{

  private final JobRepository jobRepository;

  public JobServiceImpl(JobRepository jobRepository) {

    this.jobRepository = jobRepository;
  }
  @Override
  public JobDTO createJob(JobDTO jobDTO) {

    log.info("Register Job :{}", jobDTO);
    return getJobDTO(jobRepository.save(getJob(jobDTO)));
  }

  @Override
  public JobDTO getJob(String jobReferenceNumber) {

    return getJobDTO(jobRepository.findByJobReferenceNo(jobReferenceNumber));
  }

  @Override
  public List<JobDTO> getJobList() {
    return getJobDTO(jobRepository.findAll());
  }


  public Job getJob(JobDTO jobDTO){

    Job job = new Job();
    job.setBasicSalary(jobDTO.getBasicSalary());
    job.setEducationLevelRequirement(jobDTO.getEducationLevelRequirement());
    job.setEmployerId(jobDTO.getEmployerId());
    job.setJobCategory(jobDTO.getJobCategory());
    job.setJobDescription(jobDTO.getJobDescription());
    job.setJobCategory(jobDTO.getJobCategory());
    job.setJobReferenceNo(job.getJobReferenceNo());
    job.setJobTitle(job.getJobTitle());
    job.setYearsOfExpirience(job.getYearsOfExpirience());
    job.setJobType(jobDTO.getJobType());
    return job;
  }

  public JobDTO getJobDTO(Job job){

    JobDTO jobDTO = new JobDTO();
    jobDTO.setBasicSalary(job.getBasicSalary());
    jobDTO.setEducationLevelRequirement(job.getEducationLevelRequirement());
    jobDTO.setBasicSalary(job.getBasicSalary());
    jobDTO.setEmployerId(job.getEmployerId());
    jobDTO.setJobCategory(job.getJobCategory());
    jobDTO.setJobDescription(job.getJobDescription());
    jobDTO.setEmployerId(job.getEmployerId());
    jobDTO.setJobReferenceNo(job.getJobReferenceNo());
    jobDTO.setJobTitle(job.getJobTitle());
    jobDTO.setJobType(job.getJobType());
    jobDTO.setJobCategory(job.getJobCategory());
    jobDTO.setYearsOfExpirience(job.getYearsOfExpirience());
    jobDTO.setId(job.getId());
    return jobDTO;
  }

  public List<JobDTO> getJobDTO(List<Job> jobList){
    List<JobDTO> jobDTOList = new ArrayList<>();
    for(Job job:jobList){
      jobDTOList.add(getJobDTO(job));
    }
    return jobDTOList;
  }


}
