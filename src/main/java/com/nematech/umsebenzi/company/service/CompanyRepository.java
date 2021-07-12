package com.nematech.umsebenzi.company.service;

import com.nematech.umsebenzi.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {

  Optional<Company> getByCompanyReferenceId(String referenceNumber);

}
