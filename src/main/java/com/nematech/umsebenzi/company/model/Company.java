package com.nematech.umsebenzi.company.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nematech.umsebenzi.common.BaseEntity;
import com.nematech.umsebenzi.enums.JobCategory;
import com.nematech.umsebenzi.enums.JobType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "company", indexes = {@Index(name = "indx_company", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company extends BaseEntity {

  @Column(name = "companyreferenceNo", nullable = false, unique = true,length = 45)
  private String companyReferenceId;

  @Column(name = "companyname")
  private String companyName;

  @Column(name = "companydescription")
  private String companyDescription;

  @Column(name = "companyadress")
  private String companyAdress;

  @Column(name = "emailAdress")
  private String emailAdress;

  @Column(name = "contact", unique = true)
  private String mobileNumber;
}
