package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
  Optional<Candidate> getByIdNumber(String idNumber);
}
