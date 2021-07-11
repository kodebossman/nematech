package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.CandidateDTO;
import com.nematech.umsebenzi.candidate.model.Candidate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class CandidateServiceImpl implements CandidateService {

  private final CandidateRepository candidateRepository;

  public CandidateServiceImpl(CandidateRepository candidateRepository) {

    this.candidateRepository = candidateRepository;
  }

  @Override
  public CandidateDTO createCandidate(CandidateDTO candidateDTO) {

    log.info("Register Customer :{}", candidateDTO);

    return getCandidateDto(candidateRepository.save(getCandidate(candidateDTO)));
  }

  @Override
  public CandidateDTO getCandidate(String candidateIdNo) {

    Optional<Candidate> candidate = candidateRepository.getByIdNumber(candidateIdNo);
    if (Objects.isNull(candidate)) {
      throw new IllegalArgumentException("Candidate with this Id is not found " + candidateIdNo);
    }

    return candidate.map(this::getCandidateDto).orElse(null);
  }

  protected CandidateDTO getCandidateDto(Candidate candidate) {

    CandidateDTO candidateDTO = new CandidateDTO();
    candidate.setName(candidate.getName());
    candidate.setIdNumber(candidate.getIdNumber());
    candidate.setEmailAdress(candidate.getEmailAdress());
    candidate.setSurname(candidate.getSurname());
    candidate.setMobileNo(candidate.getMobileNo());
    candidate.setQualification(candidate.getQualification());
    candidate.setJobType(candidate.getJobType());
    candidate.setAdress(candidate.getAdress());

    return candidateDTO;
  }

  protected Candidate getCandidate(CandidateDTO candidateDTO) {

    Candidate candidate = new Candidate();
    candidate.setAdress(candidateDTO.getAdress());
    candidate.setEmailAdress(candidateDTO.getEmailAdress());
    candidate.setJobType(candidateDTO.getJobType());
    candidate.setMobileNo(candidateDTO.getMobileNo());
    candidate.setQualification(candidateDTO.getQualification());
    candidate.setSurname(candidateDTO.getSurname());
    candidate.setIdNumber(candidateDTO.getSurname());
    candidate.setName(candidateDTO.getName());

    return candidate;
  }

}
