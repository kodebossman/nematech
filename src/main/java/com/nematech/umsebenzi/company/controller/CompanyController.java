package com.nematech.umsebenzi.company.controller;

import com.nematech.umsebenzi.company.dto.CompanyDTO;
import com.nematech.umsebenzi.company.service.CompanyService;
import com.nematech.umsebenzi.exception.ClientException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
@Slf4j
@RestController
@RequestMapping("/companies")
public class CompanyController {

  private final CompanyService companyService;
  public CompanyController( CompanyService companyService) {
    this.companyService = companyService;
  }

  @SneakyThrows
  @PostMapping(value = "/create")

  public ResponseEntity<CompanyDTO> createCandidate(@RequestBody @Validated CompanyDTO companyDTO) throws IOException {

    log.info("New Registration : {} ", companyDTO);

    CompanyDTO company = companyService.getCompany(companyDTO.getCompanyReferenceId());

    if (Objects.isNull(company)) {
      final CompanyDTO companyDTO1 = companyService.createCompany(companyDTO);
      return new ResponseEntity<>( companyDTO1, HttpStatus.CREATED);
    }else{
      throw new ClientException("There is a candidate with ID Number "+ companyDTO.getCompanyReferenceId());
    }

  }

  @GetMapping(value = "/list")
  public ResponseEntity<List<CompanyDTO>> getCompanies() {

      return new ResponseEntity<>( companyService.getCompanyList(), HttpStatus.CREATED);
  }
}
