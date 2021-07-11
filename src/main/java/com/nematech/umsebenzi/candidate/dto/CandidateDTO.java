package com.nematech.umsebenzi.candidate.dto;

import com.nematech.umsebenzi.common.BaseDto;
import com.nematech.umsebenzi.enums.JobCategory;
import com.nematech.umsebenzi.enums.JobType;
import lombok.Data;


@Data
public class CandidateDTO extends BaseDto {

  private String mobileNo;
  private String idNumber;
  private String qualification;
  private JobCategory name;
  private JobType jobType;
  private String surname;
  private String emailAdress;
  private String adress;
}
