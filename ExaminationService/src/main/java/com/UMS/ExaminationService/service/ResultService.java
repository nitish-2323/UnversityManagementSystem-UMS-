package com.UMS.ExaminationService.service;

import com.UMS.ExaminationService.dto.ResultRequestDTO;
import com.UMS.ExaminationService.dto.ResultResponseDTO;

import java.util.List;

public interface ResultService {
    ResultResponseDTO createResult(ResultRequestDTO resultRequestDTO);

    ResultResponseDTO getResultById(Long resultId);

    List<ResultResponseDTO> getAllResults();

    ResultResponseDTO updateResult(Long resultId, ResultRequestDTO resultRequestDTO);

    void deleteResult(Long resultId);
}
