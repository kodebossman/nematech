package com.nematech.umsebenzi.application.model.service;

import com.nematech.umsebenzi.application.model.CandidateApplication;
import com.nematech.umsebenzi.application.model.dto.ApplicationDTO;
import com.nematech.umsebenzi.candidate.model.Candidate;
import com.nematech.umsebenzi.candidate.service.CandidateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

  private final ApplicationRepository applicationRepository;

  @Override
  public ApplicationDTO createApplication(ApplicationDTO applicationDTO) {

    log.debug("New Registration for application"+ applicationDTO);
    return getApplicationDTO(applicationRepository.save(getApplication(applicationDTO)));
  }

  @Override
  public List<ApplicationDTO> getJobApplications(String jobReferenceNo) {

    return getApplicationListDTO(applicationRepository.getByJobReferenceId(jobReferenceNo));
  }

  @Override
  public List<ApplicationDTO> getCandidateApplications(String candidateId) {

    return getApplicationListDTO(applicationRepository.getByCandidateId(Integer.parseInt(candidateId)));
  }

  @Override
  public List<ApplicationDTO> getAllApplications() {
    return getApplicationListDTO(applicationRepository.findAll());
  }

  @Override
  public ApplicationDTO updateApplicationStatus(ApplicationDTO applicationDTO, Long applicationId) {

    log.debug("New Update for application"+ applicationDTO);

     CandidateApplication candidateApplication = getApplication(applicationDTO);
     candidateApplication.setId(applicationId);

     return getApplicationDTO(applicationRepository.save(candidateApplication));

  }

  public CandidateApplication getApplication(ApplicationDTO applicationDTO ){

    CandidateApplication candidateApplication = new CandidateApplication();
    candidateApplication.setApplicationDateTime(LocalDateTime.now());
    candidateApplication.setCandidateId(applicationDTO.getCandidateId());
    candidateApplication.setCompanyId(applicationDTO.getCompanyId());
    candidateApplication.setJobReferenceId(applicationDTO.getJobReferenceId());
    candidateApplication.setApplicationStatus(applicationDTO.getApplicationStatus());

    return candidateApplication;
  }

  public ApplicationDTO getApplicationDTO(CandidateApplication application ){

    ApplicationDTO applicationDTO = new ApplicationDTO();
    applicationDTO.setApplicationDateTime(application.getApplicationDateTime());
    applicationDTO.setCandidateId(application.getCandidateId());
    applicationDTO.setCompanyId(application.getCompanyId());
    applicationDTO.setJobReferenceId(application.getJobReferenceId());
    applicationDTO.setApplicationStatus(application.getApplicationStatus());
    return applicationDTO;
  }

  public List<ApplicationDTO> getApplicationListDTO(List<CandidateApplication> applicationList){

    return applicationList.stream().map(this::getApplicationDTO).collect(Collectors.toList());
  }

}
