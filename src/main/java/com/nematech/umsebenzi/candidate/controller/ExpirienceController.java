package com.nematech.umsebenzi.candidate.controller;

import com.nematech.umsebenzi.candidate.dto.ExpirienceDTO;
import com.nematech.umsebenzi.candidate.dto.RatingDTO;
import com.nematech.umsebenzi.candidate.service.ExpirienceRepository;
import com.nematech.umsebenzi.candidate.service.ExpirienceService;
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
@RequestMapping("/expiriences")

public class ExpirienceController {


  private final ExpirienceService expirienceService;

  @SneakyThrows
  @PostMapping(value = "/create")

  public ResponseEntity<ExpirienceDTO> createExpirience(@RequestBody @Validated ExpirienceDTO expirienceDTO) throws IOException {

    log.info("New Registration : {} ", expirienceDTO);

    ExpirienceDTO expirience = expirienceService.createExpirience(expirienceDTO);
    return new ResponseEntity<>( expirience, HttpStatus.CREATED);

  }

  @GetMapping(value = "/{candidateid}")
  public ResponseEntity<List<ExpirienceDTO>> getCandidateCertificateExpiriences(@PathParam("candidateid") Long candidateId) throws IOException {

    log.info("Get Certificate for CandidadateID : {} ", candidateId);

    List<ExpirienceDTO> expirienceDTOList = expirienceService.getExpirience(candidateId);
    return new ResponseEntity<>( expirienceDTOList, HttpStatus.CREATED);

  }

}
