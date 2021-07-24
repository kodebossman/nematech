package com.nematech.umsebenzi.candidate.controller;

import com.nematech.umsebenzi.candidate.dto.CandidateCVDTO;
import com.nematech.umsebenzi.candidate.dto.CandidateSkillsDTO;
import com.nematech.umsebenzi.candidate.service.CVService;
import com.nematech.umsebenzi.candidate.service.SkillsService;
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
@RequestMapping("/skills")
public class SkillsController {

  private final SkillsService skillsService;

  @SneakyThrows
  @PostMapping(value = "/create")

  public ResponseEntity<List<CandidateSkillsDTO>> createSkills(@RequestBody @Validated List<CandidateSkillsDTO> skillsDTO) throws IOException {

    log.info("New Registration : {} ", skillsDTO);

    List<CandidateSkillsDTO> skillsDTOS = skillsService.createSkills(skillsDTO);
    return new ResponseEntity<>( skillsDTOS, HttpStatus.CREATED);

  }

  @GetMapping(value = "/search/{candidateid}")
  public ResponseEntity<List<CandidateSkillsDTO>> getCandidateSkills(@PathParam("candidateid") Long candidateId) throws IOException {

    log.info("Get CV for CandidadateID : {} ", candidateId);

    List<CandidateSkillsDTO> candidateSkillsDTOList = skillsService.getSkillsList(candidateId);
    return new ResponseEntity<>( candidateSkillsDTOList, HttpStatus.OK);

  }


}
