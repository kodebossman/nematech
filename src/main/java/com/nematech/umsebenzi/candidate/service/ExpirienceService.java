package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.ExpirienceDTO;

import java.util.List;

public interface ExpirienceService {

  ExpirienceDTO createExpirience( ExpirienceDTO expirienceDTO);
  List<ExpirienceDTO> getExpirience(Long candidateId);
}
