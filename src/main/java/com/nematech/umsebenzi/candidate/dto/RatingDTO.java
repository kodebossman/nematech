package com.nematech.umsebenzi.candidate.dto;

import com.nematech.umsebenzi.common.BaseDto;
import lombok.Data;

@Data
public class RatingDTO extends BaseDto {

  private Long candidateId;
  private Long skillId;
  private int rating;
  private String comments;
  private Long companyId;
}
