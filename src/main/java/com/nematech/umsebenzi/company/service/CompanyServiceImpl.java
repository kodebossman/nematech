package com.nematech.umsebenzi.company.service;

import com.nematech.umsebenzi.candidate.model.Candidate;
import com.nematech.umsebenzi.candidate.service.CandidateRepository;
import com.nematech.umsebenzi.company.dto.CompanyDTO;
import com.nematech.umsebenzi.company.model.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class CompanyServiceImpl implements CompanyService {

  private final CompanyRepository companyRepository;

  public CompanyServiceImpl(CompanyRepository companyRepository) {

    this.companyRepository = companyRepository;
  }

  @Override
  public CompanyDTO createCompany(CompanyDTO companyDTO) {

    log.info("Register Company :{}", companyDTO);
    return getCompanyDTO(companyRepository.save(getCompany(companyDTO)));
  }

  @Override
  public CompanyDTO getCompany(String referenceNo) {

    Optional<Company> company = companyRepository.getByCompanyReferenceId(referenceNo);
    if (Objects.isNull(company)) {
      throw new IllegalArgumentException("Company with this Id is not found " + referenceNo);
    }

    return company.map(this::getCompanyDTO).orElse(null);

  }

  @Override
  public List<CompanyDTO> getCompanyList() {
    return getCompanyListDTO(companyRepository.findAll());
  }

  protected Company getCompany(CompanyDTO companyDTO){

    Company company = new Company();
    company.setCompanyAdress(companyDTO.getCompanyAdress());
    company.setCompanyDescription(companyDTO.getCompanyDescription());
    company.setCompanyReferenceId(companyDTO.getCompanyReferenceId());
    company.setEmailAdress(companyDTO.getEmailAdress());
    company.setMobileNumber(companyDTO.getMobileNumber());
    return company;
  }

  protected CompanyDTO getCompanyDTO(Company company){

    CompanyDTO companyDTO = new CompanyDTO();
    companyDTO.setCompanyAdress(company.getCompanyAdress());
    companyDTO.setMobileNumber(company.getMobileNumber());
    companyDTO.setEmailAdress(company.getEmailAdress());
    companyDTO.setCompanyReferenceId(company.getCompanyReferenceId());
    companyDTO.setId(company.getId());

    return companyDTO;
  }

  protected List<CompanyDTO> getCompanyListDTO(List<Company> companyList){

    return companyList.stream().map(company -> {

      CompanyDTO companyDTO = new CompanyDTO();
      companyDTO.setId(company.getId());
      companyDTO.setCompanyAdress(company.getCompanyAdress());
      companyDTO.setCompanyDescription(company.getCompanyDescription());
      companyDTO.setCompanyReferenceId(company.getCompanyReferenceId());
      companyDTO.setEmailAdress(company.getEmailAdress());
      companyDTO.setMobileNumber(company.getMobileNumber());

      return companyDTO;
    }).collect(Collectors.toList());
  }
}
