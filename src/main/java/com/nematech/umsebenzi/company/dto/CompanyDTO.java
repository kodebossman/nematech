package com.nematech.umsebenzi.company.dto;

import com.nematech.umsebenzi.common.BaseDto;
import lombok.Data;

@Data
public class CompanyDTO extends BaseDto {

  private String companyReferenceId;
  private String companyDescription;
  private String companyAdress;
  private String emailAdress;
  private String mobileNumber;
}
