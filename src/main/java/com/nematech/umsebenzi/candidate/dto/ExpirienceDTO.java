package com.nematech.umsebenzi.candidate.dto;

import com.nematech.umsebenzi.common.BaseDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpirienceDTO extends BaseDto {

  private Long candidateId;
  private String jobRole;
  private String description;
  private LocalDate startDate;
}
