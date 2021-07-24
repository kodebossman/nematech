package com.nematech.umsebenzi.candidate.controller;

import com.nematech.umsebenzi.candidate.dto.CandidateCertificateDTO;
import com.nematech.umsebenzi.candidate.dto.RatingDTO;
import com.nematech.umsebenzi.candidate.service.CertificateService;
import com.nematech.umsebenzi.candidate.service.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/ratings")

public class RatingsController {

  private final RatingService ratingService;

  @SneakyThrows
  @PostMapping(value = "/create")

  public ResponseEntity<RatingDTO> createRatings(@RequestBody @Validated RatingDTO ratingDTO) throws IOException {

    log.info("New Registration : {} ", ratingDTO);

    RatingDTO rating = ratingService.createRating(ratingDTO);
    return new ResponseEntity<>( rating, HttpStatus.CREATED);

  }

  @GetMapping(value = "/{candidateid}")
  public ResponseEntity<List<RatingDTO>> getCandidateCertificates(@PathParam("candidateid") Long candidateId) throws IOException {

    log.info("Get Certificate for CandidadateID : {} ", candidateId);

    List<RatingDTO> ratingDTOList = ratingService.getRatingList(candidateId);
    return new ResponseEntity<>( ratingDTOList, HttpStatus.CREATED);

  }


}
