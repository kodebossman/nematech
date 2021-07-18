package com.nematech.umsebenzi.job.controller;

import com.nematech.umsebenzi.exception.ClientException;
import com.nematech.umsebenzi.job.dto.JobDTO;
import com.nematech.umsebenzi.job.dto.JobRoleDTO;
import com.nematech.umsebenzi.job.service.JobRoleService;
import lombok.RequiredArgsConstructor;
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
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/jobroles")
@RequiredArgsConstructor
public class JobRoleController {

 private final JobRoleService jobRoleService;
  @SneakyThrows
  @PostMapping(value = "/create")

  public ResponseEntity<Object> createJobRole(@RequestBody @Validated List<JobRoleDTO> jobRoleDTOList) throws IOException {

    log.info("New Registration : {} ", jobRoleDTOList);

    if (!Objects.isNull(jobRoleDTOList)) {
       jobRoleService.createJobRole(jobRoleDTOList);
      return new ResponseEntity<>(  HttpStatus.CREATED);
    }else{
      throw new ClientException("There is a candidate with ID Number ");
    }

  }
}
