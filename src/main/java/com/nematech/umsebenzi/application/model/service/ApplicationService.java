package com.nematech.umsebenzi.application.model.service;

import com.nematech.umsebenzi.application.model.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {

ApplicationDTO createApplication(ApplicationDTO applicationDTO);
List<ApplicationDTO> getJobApplications(String jobReferenceNo);
List<ApplicationDTO>getCandidateApplications(String candidateId);
List<ApplicationDTO>getAllApplications();
}
