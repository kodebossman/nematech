package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.ExpirienceDTO;
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
public class ExpirienceServiceImpl implements ExpirienceService{

  private final ExpirienceRepository repository;
  private final TypeMapper mapper;

  @Override
  public ExpirienceDTO createExpirience(ExpirienceDTO expirienceDTO) {

    return mapper.map(repository.save(mapper.map(expirienceDTO)));
  }

  @Override
  public List<ExpirienceDTO> getExpirience(Long candidateId) {

    return repository.getByCandidateId(candidateId)
      .stream()
      .map(mapper::map
    ).collect(Collectors.toList());
  }
}
