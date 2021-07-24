package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.CandidateDTO;

public interface CandidateService {

  CandidateDTO createCandidate(CandidateDTO candidateDTO);
  CandidateDTO getCandidate(String candidateIdNo);

}
