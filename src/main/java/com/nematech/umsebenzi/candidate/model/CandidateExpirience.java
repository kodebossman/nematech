package com.nematech.umsebenzi.candidate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nematech.umsebenzi.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidatexpirience", indexes = {@Index(name = "indx_candidatexpirience", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class CandidateExpirience extends BaseEntity {

  @Column(name = "candidateid")
  private Long candidateId;

  @Column(name = "jobrole")
  private String jobRole;

  @Column(name = "description")
  private String description;

  @Column(name = "startdate")
  private LocalDate startDate;

  @Column(name = "enddate")
  private LocalDate endDate;

  @Column(name = "companyname")
  private String companyName;

}
