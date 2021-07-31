package com.nematech.umsebenzi.candidate.dto;

import com.nematech.umsebenzi.common.BaseDto;
import lombok.Data;

import java.util.List;

@Data
public class CandidateInfoDTO extends BaseDto {
   private CandidateDTO candidateDTO;
   private List<CandidateCertificateDTO> candidateCertificateDTO;
   private CandidateCVDTO candidateCVDTO;
   private List<ExpirienceDTO> expirienceDTO;
   private List<RatingDTO> ratingDTO;
   private List<CandidateSkillsDTO> skillsDTOList;
}
