package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.CandidateCertificateDTO;

import java.util.List;

public interface CertificateService {

  CandidateCertificateDTO createCandidateCertificate(CandidateCertificateDTO certificateDto);
  List<CandidateCertificateDTO> getCertificates( Long candidateNo);
}
