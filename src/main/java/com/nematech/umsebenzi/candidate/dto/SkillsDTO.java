package com.nematech.umsebenzi.candidate.dto;

import com.nematech.umsebenzi.enums.JobCategory;
import lombok.Data;

@Data
public class SkillsDTO {
  private Long candidateId;
  private JobCategory jobCategory;
  private String skillName;
  private String skillDescription;
  private int experience;
}
