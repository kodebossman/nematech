package com.nematech.umsebenzi.job.model;

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
@Table(name = "jobs", indexes = {@Index(name = "indx_jobs", columnList = "jobreferenceno", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Job extends BaseEntity {

  @Column(name = "jobreferenceno", nullable = false, unique = true,length = 45)
  private String jobReferenceNo;

  @Column(name = "jobdescription")
  private String jobDescription;

  @Column(name = "jobTitle", unique = false, nullable = false, length = 15)
  private String jobTitle;

  @Column(name = "jobtype")
  private JobType jobType;

  @Column(name = "jobcategory")
  private JobCategory jobCategory;

  @Column(name = "expirience", unique = false)
  private int  yearsOfExpirience;

  @Column(name = "basicSalary")
  private double basicSalary;

  @Column(name = "basiceducationrequirement")
  private Education educationLevelRequirement;

  @Column(name = "employerId")
  private Long employerId;

}
