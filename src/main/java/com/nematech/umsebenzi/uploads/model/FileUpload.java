package com.nematech.umsebenzi.uploads.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nematech.umsebenzi.common.BaseEntity;
import com.nematech.umsebenzi.enums.JobCategory;
import com.nematech.umsebenzi.enums.JobType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "fileuploads", indexes = {@Index(name = "indx_fileupload", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FileUpload extends BaseEntity {

    @Column(name = "filename", nullable = false, unique = true,length = 45)
    private String fileName;

    @Column(name = "documenturl")
    private String documentUrl;

    @Column(name = "owner")
    private String documentOwner;

    @Column(name = "documenttype")
    private String documentType;

}
