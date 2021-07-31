package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.CandidateDTO;
import com.nematech.umsebenzi.candidate.dto.CandidateInfoDTO;

public interface CandidateService {

  CandidateDTO createCandidate(CandidateDTO candidateDTO);
  CandidateDTO getCandidate(String candidateIdNo);
  CandidateInfoDTO getCandidateInfo( Long id);

}
