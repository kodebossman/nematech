package com.nematech.umsebenzi.company.service;

import com.nematech.umsebenzi.company.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

  CompanyDTO createCompany(CompanyDTO companyDTO);
  CompanyDTO getCompany(String referenceNo);
  List<CompanyDTO> getCompanyList();
}
