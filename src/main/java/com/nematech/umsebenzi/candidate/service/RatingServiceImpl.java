package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.RatingDTO;
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
public class RatingServiceImpl implements RatingService {

  private final RatingRepository ratingRepository;
  private final TypeMapper mapper;

  @Override
  public RatingDTO createRating(RatingDTO ratingDTO) {

    return mapper.map(ratingRepository.save(mapper.map(ratingDTO)));
  }

  @Override
  public List<RatingDTO> getRatingList(Long candidateId) {
    return
      ratingRepository.getByCandidateId(candidateId)
        .stream().map(mapper::map).collect(Collectors.toList());
  }
}
