package com.nematech.umsebenzi.candidate.controller;

import com.nematech.umsebenzi.candidate.dto.CandidateDTO;
import com.nematech.umsebenzi.candidate.model.Candidate;
import com.nematech.umsebenzi.candidate.service.CandidateService;
import com.nematech.umsebenzi.exception.ClientException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CandidateController {

  private final CandidateService candidateService;
  public CandidateController( CandidateService candidateService) {

    this.candidateService = candidateService;
  }

  @SneakyThrows
  @PostMapping(value = "/create")

  public ResponseEntity<CandidateDTO> createCandidate(@RequestBody @Validated CandidateDTO candidateDTO) throws IOException {

    log.info("New Registration : {} ", candidateDTO);

    CandidateDTO candidate = candidateService.getCandidate(candidateDTO.getIdNumber());

    if (Objects.isNull(candidate)) {
      final CandidateDTO candidate1 = candidateService.createCandidate(candidateDTO);
      return new ResponseEntity<>( candidate1, HttpStatus.CREATED);
    }else{
      throw new ClientException("There is a candidate with ID Number "+ candidateDTO.getIdNumber());
    }

  }



}
