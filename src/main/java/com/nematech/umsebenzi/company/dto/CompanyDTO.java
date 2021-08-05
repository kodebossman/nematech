package com.nematech.umsebenzi.company.dto;

import com.nematech.umsebenzi.common.BaseDto;
import com.nematech.umsebenzi.company.model.CompanyContact;
import lombok.Data;

@Data
public class CompanyDTO extends BaseDto {

  private String companyReferenceId;
  private String companyName;
  private String companyDescription;
  private String companyAdress;
  private String emailAdress;
  private String mobileNumber;
  private CompanyContact companyContact;

}
