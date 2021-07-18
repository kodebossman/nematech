package com.nematech.umsebenzi.job.service;

import com.nematech.umsebenzi.job.model.JobLocation;
import com.nematech.umsebenzi.job.model.JobRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRoleRepository extends JpaRepository<JobRole,Long> {
  List<JobRole> findByJobId(Long jobId);
}
