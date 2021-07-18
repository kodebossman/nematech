package com.nematech.umsebenzi.application.model.service;

import com.nematech.umsebenzi.application.model.CandidateApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<CandidateApplication,Long> {

  List<CandidateApplication> getByJobReferenceId(String jobReferenceId);
  List<CandidateApplication> getByCandidateId(int candidateId);

}
