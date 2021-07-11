package com.nematech.umsebenzi.job.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nematech.umsebenzi.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "jobrole", indexes = {@Index(name = "indx_jobsrole", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobRole extends BaseEntity {

  @Column(name = "jobid")
  private Long jobId;
  @Column(name = "jobRole")
  private String jobRole;

}
