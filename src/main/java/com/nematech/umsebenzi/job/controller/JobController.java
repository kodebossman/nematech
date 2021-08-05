package com.nematech.umsebenzi.job.controller;

import com.nematech.umsebenzi.exception.ClientException;
import com.nematech.umsebenzi.job.dto.JobDTO;
import com.nematech.umsebenzi.job.service.JobService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/jobs")
public class JobController {

  private final JobService jobService;
  public JobController( JobService jobService) {
    this.jobService = jobService;
  }

  @SneakyThrows
  @PostMapping(value = "/create")

  public ResponseEntity<JobDTO> createCandidate(@RequestBody @Validated JobDTO jobDTO) throws IOException {

    log.info("New Registration : {} ", jobDTO);

    JobDTO jobDTO1 = jobService.getJob(jobDTO.getJobReferenceNo());

    if (Objects.isNull(jobDTO1)) {
      final JobDTO job = jobService.createJob(jobDTO);
      return new ResponseEntity<>( job, HttpStatus.CREATED);
    }else{
      throw new ClientException("There is a candidate with ID Number "+ jobDTO.getJobReferenceNo());
    }

  }

  @GetMapping(value = "/list")
  public ResponseEntity<List<JobDTO>> getJobs() {
    return new ResponseEntity<>( jobService.getJobList(), HttpStatus.OK);
  }

}
