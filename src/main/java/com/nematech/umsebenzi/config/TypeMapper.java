package com.nematech.umsebenzi.config;

import com.nematech.umsebenzi.candidate.dto.*;
import com.nematech.umsebenzi.candidate.model.*;
import com.nematech.umsebenzi.company.dto.CompanyDTO;
import com.nematech.umsebenzi.company.model.Company;
import com.nematech.umsebenzi.job.dto.JobDTO;
import com.nematech.umsebenzi.job.dto.JobRoleDTO;
import com.nematech.umsebenzi.job.model.Job;
import com.nematech.umsebenzi.job.model.JobRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {
 CandidateSkills map(CandidateSkillsDTO candidateSkillsDTO);
 CandidateSkillsDTO map(CandidateSkills candidateSkills);
 CandidateCertificate map(CandidateCertificateDTO certificateDTO);
 CandidateCertificateDTO map(CandidateCertificate candidateCertificate);
 RatingDTO map(CandidateRating rating);
 CandidateRating map(RatingDTO ratingDTO);
 ExpirienceDTO map(CandidateExpirience candidateExpirience);
 CandidateExpirience map(ExpirienceDTO expirienceDTO);
 CandidateCVDTO map(CandidateCV candidateCV);
 CandidateCV map(CandidateCVDTO candidateCV);
 CandidateDTO map(Candidate candidate);
 Candidate map(CandidateDTO candidateDTO);
 JobDTO map(Job job);
 Job map(JobDTO jobDTO);
 JobRole map(JobRoleDTO jobRoleDTO);
 JobRoleDTO map(JobRole jobRole);
 Company map(CompanyDTO companyDTO);
 CompanyDTO map(Company company);
}

