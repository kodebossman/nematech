package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.model.CandidateSkills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillsRepository extends JpaRepository<CandidateSkills,Long> {

  List<CandidateSkills> getCandidateSkillsByCandidateId(Long candidateId);

}
