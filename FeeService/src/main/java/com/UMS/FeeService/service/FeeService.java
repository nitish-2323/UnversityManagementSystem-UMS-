package com.UMS.FeeService.service;

import com.UMS.FeeService.dto.FeeRequestDTO;
import com.UMS.FeeService.dto.FeeResponseDTO;

import java.util.List;

public interface FeeService {
    FeeResponseDTO createFee(FeeRequestDTO requestDTO);

    FeeResponseDTO getFeeById(Long feeId);

    List<FeeResponseDTO> getFeesByStudentId(Long studentId);

    FeeResponseDTO updateFee(Long feeId, FeeRequestDTO requestDTO);

    FeeResponseDTO payFee(Long feeId, Double paymentAmount);

    void deleteFee(Long feeId);
}
