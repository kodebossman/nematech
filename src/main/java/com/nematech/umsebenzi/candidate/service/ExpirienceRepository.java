package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.model.CandidateExpirience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpirienceRepository extends JpaRepository<CandidateExpirience,Long> {

  List<CandidateExpirience> getByCandidateId(Long candidateId);
}
