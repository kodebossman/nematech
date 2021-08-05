package com.nematech.umsebenzi.candidate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nematech.umsebenzi.common.BaseEntity;
import com.nematech.umsebenzi.enums.JobCategory;
import com.nematech.umsebenzi.enums.JobType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "candidates", indexes = {@Index(name = "indx_candidate", columnList = "mobileno", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Candidate extends BaseEntity {

  @Column(name = "mobileno", nullable = false, unique = true,length = 45)
  private String mobileNo;

  @Column(name = "name")
  private String qualification;

  @Column(name = "idnumber")
  private String idNumber;

  @Column(name = "candidatecategory")
  private JobCategory name;

  @Column(name = "candidatetype")
  private JobType jobType;

  @Column(name = "surname")
  private String surname;

  @Column(name = "emailAdress")
  private String emailAdress;

  @Column(name = "adress")
  private String adress;

}
