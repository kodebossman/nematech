package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.CandidateCVDTO;
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
public class CVServiceImpl implements CVService {

  private final CVRepository repository;
  private final TypeMapper typeMapper;

  @Override
  public CandidateCVDTO createCV(CandidateCVDTO candidateCVDTO) {

    return typeMapper.map(repository.save(typeMapper.map(candidateCVDTO)));
  }

  @Override
  public CandidateCVDTO getCV(Long candidateId) {

    return typeMapper.map(repository.getByCandidateId(candidateId));
  }

  @Override
  public List<CandidateCVDTO> getCVList(String category) {

    return repository.getByCvCategory(category).stream().map(
      typeMapper::map
    ).collect(Collectors.toList());
  }
}
