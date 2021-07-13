package com.nematech.umsebenzi.job.service;

import com.nematech.umsebenzi.job.dto.JobDTO;

import java.util.List;

public interface JobService {

  JobDTO createJob(JobDTO jobDTO);
  JobDTO getJob(String jobReferenceNumber);
  List<JobDTO>  getJobList();
}
