package com.nematech.umsebenzi.job.dto;

import com.nematech.umsebenzi.common.BaseDto;
import com.nematech.umsebenzi.enums.Education;
import com.nematech.umsebenzi.enums.JobCategory;
import com.nematech.umsebenzi.enums.JobType;
import lombok.Data;

@Data
public class JobDTO extends BaseDto {

  private String jobReferenceNo;
  private String jobDescription;
  private String jobTitle;
  private JobType jobType;
  private JobCategory jobCategory;
  private int  yearsOfExpirience;
  private double basicSalary;
  private Education educationLevelRequirement;
  private Long employerId;
}
