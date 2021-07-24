package com.nematech.umsebenzi.candidate.dto;

import com.nematech.umsebenzi.common.BaseDto;
import com.nematech.umsebenzi.enums.JobCategory;
import lombok.Data;

@Data
public class CandidateSkillsDTO extends BaseDto {

  private Long candidateId;
  private JobCategory jobCategory;
  private String skillName;
  private String skillDescription;
  private int experience;
}
