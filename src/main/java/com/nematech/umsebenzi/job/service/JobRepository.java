package com.nematech.umsebenzi.job.service;

import com.nematech.umsebenzi.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {

    Job findByJobReferenceNo(String referenceNumber);
}
