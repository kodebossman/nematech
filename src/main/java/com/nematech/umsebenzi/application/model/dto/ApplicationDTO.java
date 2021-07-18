package com.nematech.umsebenzi.application.model.dto;

import com.nematech.umsebenzi.common.BaseDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationDTO extends BaseDto {
  private Long candidateId;
  private String  jobReferenceId;
  private Long companyId;
  private LocalDateTime applicationDateTime;

}
