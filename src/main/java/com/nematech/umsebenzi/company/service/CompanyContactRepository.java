package com.nematech.umsebenzi.company.service;

import com.nematech.umsebenzi.company.model.CompanyContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyContactRepository extends JpaRepository<CompanyContact,Long> {
}
