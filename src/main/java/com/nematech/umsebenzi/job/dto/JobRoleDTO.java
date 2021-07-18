package com.nematech.umsebenzi.job.dto;

import com.nematech.umsebenzi.common.BaseDto;
import lombok.Data;

@Data
public class JobRoleDTO extends BaseDto {

  private Long jobId;
  private String jobRole;

}
