package com.nematech.umsebenzi.config;

import com.nematech.umsebenzi.candidate.dto.*;
import com.nematech.umsebenzi.candidate.model.*;
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
}

