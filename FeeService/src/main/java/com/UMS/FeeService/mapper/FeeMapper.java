package com.UMS.FeeService.mapper;

import com.UMS.FeeService.dto.FeeRequestDTO;
import com.UMS.FeeService.dto.FeeResponseDTO;
import com.UMS.FeeService.dto.StudentResponseDTO;
import com.UMS.FeeService.entity.Fee;

import org.springframework.stereotype.Component;

@Component
public class FeeMapper {

    public Fee toEntity(FeeRequestDTO requestDTO) {

        Fee fee = new Fee();

        fee.setStudentId(requestDTO.getStudentId());
        fee.setAmount(requestDTO.getAmount());
        fee.setPaidAmount(requestDTO.getPaidAmount());
        fee.setFeeType(requestDTO.getFeeType());
        fee.setPaymentStatus(requestDTO.getPaymentStatus());
        fee.setDueDate(requestDTO.getDueDate());

        return fee;
    }

    public FeeResponseDTO toResponseDTO(
            Fee fee,
            StudentResponseDTO studentResponseDTO) {

        FeeResponseDTO responseDTO = new FeeResponseDTO();

        responseDTO.setFeeId(fee.getFeeId());
        responseDTO.setStudentId(fee.getStudentId());
        responseDTO.setAmount(fee.getAmount());
        responseDTO.setPaidAmount(fee.getPaidAmount());
        responseDTO.setRemainingAmount(fee.getRemainingAmount());
        responseDTO.setFeeType(fee.getFeeType());
        responseDTO.setPaymentStatus(fee.getPaymentStatus());
        responseDTO.setDueDate(fee.getDueDate());
        responseDTO.setPaidAt(fee.getPaidAt());
        responseDTO.setCreatedAt(fee.getCreatedAt());
        responseDTO.setUpdatedAt(fee.getUpdatedAt());
        responseDTO.setStudentResponseDTO(studentResponseDTO);

        return responseDTO;
    }
}
