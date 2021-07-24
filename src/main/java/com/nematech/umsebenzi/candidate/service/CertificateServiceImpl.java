package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.CandidateCertificateDTO;
import com.nematech.umsebenzi.config.TypeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService{

  private final CertificateRepository repository;
  private final TypeMapper mapper;
  @Override
  public CandidateCertificateDTO createCandidateCertificate(CandidateCertificateDTO certificateDto) {

   return mapper.map(repository.save(mapper.map(certificateDto)));
  }

  @Override
  public List<CandidateCertificateDTO> getCertificates(Long candidateNo) {

    return repository
      .getCandidateCertificateByCandidateId(candidateNo)
      .stream().map(
        mapper::map
      ).collect(Collectors.toList());
  }
}
