package com.nematech.umsebenzi.candidate.service;

import com.nematech.umsebenzi.candidate.dto.RatingDTO;

import java.util.List;

public interface RatingService {

  RatingDTO createRating(RatingDTO ratingDTO);

  List<RatingDTO> getRatingList(Long candidateId);


}
