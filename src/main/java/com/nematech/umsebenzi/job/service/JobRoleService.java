package com.nematech.umsebenzi.job.service;

import com.nematech.umsebenzi.job.dto.JobRoleDTO;
import com.nematech.umsebenzi.job.model.JobRole;

import java.util.List;

public interface JobRoleService {

  void createJobRole(List<JobRoleDTO> jobRoleList);
}
