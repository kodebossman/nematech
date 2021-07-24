package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.CandidateSkillsDTO;
import com.nematech.umsebenzi.candidate.model.CandidateSkills;
import com.nematech.umsebenzi.config.TypeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
@RequiredArgsConstructor

public class SkillsServiceImpl implements SkillsService {

  private final SkillsRepository skillsRepository;
  TypeMapper mapper;

  @Override
  public List<CandidateSkillsDTO> createSkills(List<CandidateSkillsDTO> skillsList) {

   List<CandidateSkills> candidateSkills= skillsRepository.
     saveAll(skillsList.stream().map(skill-> mapper.map(skill)).collect(Collectors.toList()));
    return candidateSkills.stream()
      .map( skill-> mapper.map(skill)).collect(Collectors.toList());
  }

  @Override
  public List<CandidateSkillsDTO> getSkillsList(Long candidateId) {
    return skillsRepository
      .getCandidateSkillsByCandidateId(candidateId).stream()
      .map(candidateSkills -> mapper.map(candidateSkills))
      .collect(Collectors.toList());
  }
}
