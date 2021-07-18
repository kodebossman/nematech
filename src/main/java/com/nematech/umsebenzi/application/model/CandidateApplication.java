package com.nematech.umsebenzi.application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nematech.umsebenzi.common.BaseEntity;
import com.nematech.umsebenzi.enums.JobCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidatesapplications", indexes = {@Index(name = "indx_candidateapp", columnList = "candidateid", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CandidateApplication extends BaseEntity {


  @Column(name = "candidateid", nullable = false)
  private Long candidateId;

  @Column(name = "jobreferenceid")
  private String  jobReferenceId;

  @Column(name = "companyid")
  private Long companyId;

  @Column(name = "skillName", nullable = true)
  private LocalDateTime applicationDateTime;

}
