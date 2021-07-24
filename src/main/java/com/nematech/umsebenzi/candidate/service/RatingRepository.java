package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.model.CandidateRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<CandidateRating,Long> {

  List<CandidateRating> getByCandidateId(Long candidateId);
}
