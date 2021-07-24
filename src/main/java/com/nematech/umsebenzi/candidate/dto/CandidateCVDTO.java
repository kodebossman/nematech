package com.nematech.umsebenzi.candidate.dto;

import com.nematech.umsebenzi.common.BaseDto;
import com.nematech.umsebenzi.enums.Education;
import lombok.Data;

@Data
public class CandidateCVDTO extends BaseDto {
  private Long candidateId;
  private Education educationLevel;
  private String cvUrl;
  private String cvCategory;
}
