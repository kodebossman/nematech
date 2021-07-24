package com.nematech.umsebenzi.application.service;

import com.nematech.umsebenzi.application.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {

  ApplicationDTO createApplication(ApplicationDTO applicationDTO);

  List<ApplicationDTO> getJobApplications(String jobReferenceNo);

  List<ApplicationDTO> getCandidateApplications(String candidateId);

  List<ApplicationDTO> getAllApplications();

  ApplicationDTO updateApplicationStatus(ApplicationDTO applicationDTO, Long applicationId);

}
