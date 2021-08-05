package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.*;
import com.nematech.umsebenzi.candidate.model.*;
import com.nematech.umsebenzi.config.TypeMapper;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ServiceImpl implements CandidateService{

  private final CandidateRepository candidateRepository;
  private final SkillsRepository skillsRepository;
  private  final CertificateRepository certificateRepository;
  private final CVRepository cvRepository;
  private final ExpirienceRepository expirienceRepository;
  private final RatingRepository ratingRepository;
  private final TypeMapper mapper;

  @Override
  public CandidateDTO createCandidate(CandidateDTO candidateDTO) {

    log.info("Register Customer :{}", candidateDTO);
  Candidate candidate = candidateRepository.save(mapper.map(candidateDTO));
   return mapper.map(candidate);
  }

  @Override
  public CandidateDTO getCandidate(String candidateIdNo) {

    Optional<Candidate> candidate = candidateRepository.getByIdNumber(candidateIdNo);
    if (Objects.isNull(candidate)) {
      throw new IllegalArgumentException("Candidate with this Id is not found " + candidateIdNo);
    }

    return candidate.map(this::getCandidateDto).orElse(null);
  }

  @Override
  public CandidateInfoDTO getCandidateInfo(Long id) {

    CandidateInfoDTO candidateInfoDTO = new CandidateInfoDTO();

    Candidate candidate = candidateRepository.getById(id);
    candidateInfoDTO.setCandidateDTO(mapper.map(candidate));
    List<CandidateCertificate> candidateCertificateList = certificateRepository
      .getCandidateCertificateByCandidateId(id);
    candidateInfoDTO.setCandidateCertificateDTO(candidateCertificateList
      .stream().map(mapper::map).collect(Collectors.toList()));
    candidateInfoDTO.setCandidateCVDTO(mapper.map(cvRepository.getByCandidateId(id)));
    List<CandidateExpirience> expirienceDTOList = expirienceRepository.getByCandidateId(id);
    candidateInfoDTO.setExpirienceDTO(expirienceDTOList.
      stream().map(mapper::map).collect(Collectors.toList()));
    List<CandidateRating> candidateRatingsList = ratingRepository.getByCandidateId(id);
    candidateInfoDTO.setRatingDTO(candidateRatingsList
      .stream().map(mapper::map).collect(Collectors.toList()));
    List<CandidateSkills> skillsDTOList = skillsRepository.getCandidateSkillsByCandidateId(id);
    candidateInfoDTO.setSkillsDTOList(skillsDTOList.stream()
      .map(mapper::map).collect(Collectors.toList()));

    return candidateInfoDTO;
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




}
