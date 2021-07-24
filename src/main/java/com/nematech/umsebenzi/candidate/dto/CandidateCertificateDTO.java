package com.nematech.umsebenzi.candidate.dto;

import com.nematech.umsebenzi.common.BaseDto;
import com.nematech.umsebenzi.enums.Education;
import lombok.Data;

@Data
public class CandidateCertificateDTO extends BaseDto {
  private String candidateId;
  private Education educationLevel;
  private String certificateUrl;
}
