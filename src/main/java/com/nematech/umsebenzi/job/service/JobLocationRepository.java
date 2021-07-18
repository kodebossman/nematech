package com.nematech.umsebenzi.job.service;

import com.nematech.umsebenzi.job.model.JobLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobLocationRepository extends JpaRepository<JobLocation,Long> {

  JobLocation findByJobId(Long jobId);
}
