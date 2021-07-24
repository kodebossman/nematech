package com.nematech.umsebenzi.candidate.controller;

import com.nematech.umsebenzi.candidate.dto.CandidateCertificateDTO;
import com.nematech.umsebenzi.candidate.dto.CandidateDTO;
import com.nematech.umsebenzi.candidate.service.CandidateService;
import com.nematech.umsebenzi.candidate.service.CertificateService;
import com.nematech.umsebenzi.exception.ClientException;
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
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/certificates")

public class CertificateController {

  private final CertificateService certificateService;

  @SneakyThrows
  @PostMapping(value = "/create")

  public ResponseEntity<CandidateCertificateDTO> createCandidate(@RequestBody @Validated CandidateCertificateDTO certificateDTO) throws IOException {

    log.info("New Registration : {} ", certificateDTO);

    CandidateCertificateDTO certificate = certificateService.createCandidateCertificate(certificateDTO);
    return new ResponseEntity<>( certificate, HttpStatus.CREATED);

  }

  @GetMapping(value = "/{candidateid}")
  public ResponseEntity<List<CandidateCertificateDTO>> getCandidateCertificates(@PathParam("candidateid") Long candidateId) throws IOException {

    log.info("Get Certificate for CandidadateID : {} ", candidateId);

    List<CandidateCertificateDTO> certificateDTOList = certificateService.getCertificates(candidateId);
    return new ResponseEntity<>( certificateDTOList, HttpStatus.CREATED);

  }

}
