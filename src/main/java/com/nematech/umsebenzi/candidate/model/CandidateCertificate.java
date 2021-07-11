package com.nematech.umsebenzi.candidate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nematech.umsebenzi.common.BaseEntity;
import com.nematech.umsebenzi.enums.Education;
import com.nematech.umsebenzi.enums.JobCategory;
import com.nematech.umsebenzi.enums.JobType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "candidatecertificate", indexes = {@Index(name = "indx_candidatecertificate", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CandidateCertificate extends BaseEntity {

  @Column(name = "candidateid", nullable = false)
  private String candidateId;

  @Column(name = "certificatelevel")
  private Education educationLevel;

  @Column(name = "certificatelocation")
  private String certificateUrl;
}
