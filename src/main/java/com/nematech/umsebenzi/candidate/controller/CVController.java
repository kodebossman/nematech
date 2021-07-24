package com.nematech.umsebenzi.candidate.controller;

import com.nematech.umsebenzi.candidate.dto.CandidateCVDTO;
import com.nematech.umsebenzi.candidate.dto.ExpirienceDTO;
import com.nematech.umsebenzi.candidate.service.CVService;
import com.nematech.umsebenzi.candidate.service.ExpirienceService;
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
@RequestMapping("/cvs")
public class CVController {


  private final CVService cvService;

  @SneakyThrows
  @PostMapping(value = "/create")

  public ResponseEntity<CandidateCVDTO> createCandidateCV(@RequestBody @Validated CandidateCVDTO candidateCVDTO) throws IOException {

    log.info("New Registration : {} ", candidateCVDTO);

    CandidateCVDTO cvdto = cvService.createCV(candidateCVDTO);
    return new ResponseEntity<>( cvdto, HttpStatus.CREATED);

  }

  @GetMapping(value = "/search/{candidateid}")
  public ResponseEntity<CandidateCVDTO> getCandidateCV(@PathParam("candidateid") Long candidateId) throws IOException {

    log.info("Get CV for CandidadateID : {} ", candidateId);

    CandidateCVDTO candidateCVDTO = cvService.getCV(candidateId);
    return new ResponseEntity<>( candidateCVDTO, HttpStatus.OK);

  }

  @GetMapping(value = "/list/{category}")
  public ResponseEntity<List<CandidateCVDTO>> getCandidateCVList(@PathParam("category") String category) throws IOException {

    log.info("Get CV for CandidadateID : {} ", category);

    List<CandidateCVDTO> candidateCVDTOs = cvService.getCVList(category);
    return new ResponseEntity<>( candidateCVDTOs, HttpStatus.OK);

  }

}
