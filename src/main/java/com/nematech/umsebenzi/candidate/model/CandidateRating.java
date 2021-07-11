package com.nematech.umsebenzi.candidate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nematech.umsebenzi.common.BaseEntity;
import com.nematech.umsebenzi.enums.JobCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "candidateratings", indexes = {@Index(name = "indx_candidaterating", columnList = "candidateid", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CandidateRating extends BaseEntity {

  @Column(name = "candidateid", nullable = false)
  private Long candidateId;

  @Column(name = "skillid")
  private Long skillId;

  @Column(name = "skillName")
  private int rating;

  @Column(name = "comments")
  private String comments;

  @Column(name = "conpanyid")
  private Long companyId;

}
