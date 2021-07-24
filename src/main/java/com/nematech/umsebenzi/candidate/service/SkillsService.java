package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.CandidateSkillsDTO;

import java.util.List;

public interface SkillsService {
  List<CandidateSkillsDTO> createSkills(List<CandidateSkillsDTO> skillsList);
  List<CandidateSkillsDTO> getSkillsList(Long candidateId);
}
