package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.model.CandidateCV;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CVRepository extends JpaRepository<CandidateCV,Long> {

  List<CandidateCV> getByCvCategory(String category);
  CandidateCV getByCandidateId(long candidateId);
}
