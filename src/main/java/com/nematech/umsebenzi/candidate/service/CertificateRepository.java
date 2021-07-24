package com.nematech.umsebenzi.candidate.service;


import com.nematech.umsebenzi.candidate.model.CandidateCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepository extends JpaRepository<CandidateCertificate,Long> {

  List<CandidateCertificate> getCandidateCertificateByCandidateId(Long candidateId);
}
