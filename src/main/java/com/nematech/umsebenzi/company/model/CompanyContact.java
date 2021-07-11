package com.nematech.umsebenzi.company.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nematech.umsebenzi.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "companycontact", indexes = {@Index(name = "indx_contactperson", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CompanyContact extends BaseEntity {

  @Column(name = "companyreferenceno", nullable = false, unique = true,length = 45)
  private String jobReferenceNo;

  @Column(name = "username")
  private String userName;

  @Column(name = "name")
  private String contactName;

  @Column(name = "mobileno", unique = true)
  private String mobileNumber;
}
