package com.nematech.umsebenzi.job.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.nematech.umsebenzi.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "joblocation", indexes = {@Index(name = "indx_jobslocation", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class JobLocation extends BaseEntity {

  @Column(name = "jobid")
  private Long jobId;
  @Column(name = "joblocation")
  private String jobLocation;
}
