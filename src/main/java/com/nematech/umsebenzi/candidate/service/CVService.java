package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.CandidateCVDTO;

import java.util.List;

public interface CVService {

  CandidateCVDTO createCV( CandidateCVDTO candidateCVDTO);
  CandidateCVDTO getCV(Long candidateId);
  List<CandidateCVDTO> getCVList(String category);
}

