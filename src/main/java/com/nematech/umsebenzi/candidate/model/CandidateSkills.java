package com.nematech.umsebenzi.candidate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nematech.umsebenzi.common.BaseEntity;
import com.nematech.umsebenzi.enums.Education;
import com.nematech.umsebenzi.enums.JobCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "candidateskills", indexes = {@Index(name = "indx_candidateskills", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CandidateSkills extends BaseEntity {

  @Column(name = "candidateid", nullable = false)
  private Long candidateId;

  @Column(name = "skillcategory")
  private JobCategory jobCategory;

  @Column(name = "skillName")
  private String skillName;

  @Column(name = "skillDescription", nullable = true)
  private String skillDescription;

  @Column(name = "noofexperience")
  private int experience;

}
