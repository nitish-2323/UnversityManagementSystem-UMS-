package com.UMS.FeeService.service;

import java.time.LocalDateTime;
import java.util.List;

import com.UMS.FeeService.service.FeeService;
import org.springframework.stereotype.Service;

import com.UMS.FeeService.client.StudentClient;
import com.UMS.FeeService.dto.FeeRequestDTO;
import com.UMS.FeeService.dto.FeeResponseDTO;
import com.UMS.FeeService.dto.StudentResponseDTO;
import com.UMS.FeeService.entity.Fee;
import com.UMS.FeeService.exception.FeeNotFoundException;
import com.UMS.FeeService.exception.InvalidFeeException;
import com.UMS.FeeService.mapper.FeeMapper;
import com.UMS.FeeService.repository.FeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeeServiceImpl implements FeeService {

    private final FeeRepository feeRepository;
    private final FeeMapper feeMapper;
    private final StudentClient studentClient;

    @Override
    public FeeResponseDTO createFee(FeeRequestDTO requestDTO) {

        StudentResponseDTO student =
                studentClient.getStudentById(requestDTO.getStudentId());

        if (student == null) {
            throw new InvalidFeeException(
                    "Student not found with id: "
                            + requestDTO.getStudentId());
        }

        Double amount = requestDTO.getAmount();
        Double paidAmount = requestDTO.getPaidAmount();

        if (amount == null || amount <= 0) {
            throw new InvalidFeeException(
                    "Fee amount must be greater than zero");
        }

        if (paidAmount == null) {
            paidAmount = 0.0;
        }

        if (paidAmount < 0) {
            throw new InvalidFeeException(
                    "Paid amount cannot be negative");
        }

        if (paidAmount > amount) {
            throw new InvalidFeeException(
                    "Paid amount cannot be greater than fee amount");
        }

        Fee fee = feeMapper.toEntity(requestDTO);

        Double remainingAmount = amount - paidAmount;

        fee.setAmount(amount);
        fee.setPaidAmount(paidAmount);
        fee.setRemainingAmount(remainingAmount);

        if (remainingAmount == 0.0) {
            fee.setPaymentStatus("PAID");
            fee.setPaidAt(LocalDateTime.now());
        } else if (paidAmount > 0.0) {
            fee.setPaymentStatus("PARTIAL");
        } else {
            fee.setPaymentStatus("PENDING");
        }

        fee.setCreatedAt(LocalDateTime.now());
        fee.setUpdatedAt(LocalDateTime.now());

        Fee savedFee = feeRepository.save(fee);

        return feeMapper.toResponseDTO(savedFee, student);
    }

    @Override
    public FeeResponseDTO getFeeById(Long feeId) {

        Fee fee = feeRepository.findById(feeId)
                .orElseThrow(() ->
                        new FeeNotFoundException(
                                "Fee not found with id: " + feeId));

        StudentResponseDTO student =
                studentClient.getStudentById(fee.getStudentId());

        return feeMapper.toResponseDTO(fee, student);
    }

    @Override
    public List<FeeResponseDTO> getFeesByStudentId(Long studentId) {

        StudentResponseDTO student =
                studentClient.getStudentById(studentId);

        if (student == null) {
            throw new InvalidFeeException(
                    "Student not found with id: " + studentId);
        }

        List<Fee> fees =
                feeRepository.findByStudentId(studentId);

        return fees.stream()
                .map(fee -> feeMapper.toResponseDTO(fee, student))
                .toList();
    }

    @Override
    public FeeResponseDTO updateFee(
            Long feeId,
            FeeRequestDTO requestDTO) {

        Fee fee = feeRepository.findById(feeId)
                .orElseThrow(() ->
                        new FeeNotFoundException(
                                "Fee not found with id: " + feeId));

        StudentResponseDTO student =
                studentClient.getStudentById(requestDTO.getStudentId());

        if (student == null) {
            throw new InvalidFeeException(
                    "Student not found with id: "
                            + requestDTO.getStudentId());
        }

        Double amount = requestDTO.getAmount();
        Double paidAmount = requestDTO.getPaidAmount();

        if (amount == null || amount <= 0) {
            throw new InvalidFeeException(
                    "Fee amount must be greater than zero");
        }

        if (paidAmount == null) {
            paidAmount = 0.0;
        }

        if (paidAmount < 0) {
            throw new InvalidFeeException(
                    "Paid amount cannot be negative");
        }

        if (paidAmount > amount) {
            throw new InvalidFeeException(
                    "Paid amount cannot be greater than fee amount");
        }

        Double remainingAmount = amount - paidAmount;

        fee.setStudentId(requestDTO.getStudentId());
        fee.setAmount(amount);
        fee.setPaidAmount(paidAmount);
        fee.setRemainingAmount(remainingAmount);
        fee.setFeeType(requestDTO.getFeeType());
        fee.setDueDate(requestDTO.getDueDate());

        if (remainingAmount == 0.0) {

            fee.setPaymentStatus("PAID");

            if (fee.getPaidAt() == null) {
                fee.setPaidAt(LocalDateTime.now());
            }

        } else if (paidAmount > 0.0) {

            fee.setPaymentStatus("PARTIAL");
            fee.setPaidAt(null);

        } else {

            fee.setPaymentStatus("PENDING");
            fee.setPaidAt(null);
        }

        fee.setUpdatedAt(LocalDateTime.now());

        Fee updatedFee = feeRepository.save(fee);

        return feeMapper.toResponseDTO(updatedFee, student);
    }

    @Override
    public FeeResponseDTO payFee(
            Long feeId,
            Double paymentAmount) {

        Fee fee = feeRepository.findById(feeId)
                .orElseThrow(() ->
                        new FeeNotFoundException(
                                "Fee not found with id: " + feeId));

        if (paymentAmount == null || paymentAmount <= 0) {
            throw new InvalidFeeException(
                    "Payment amount must be greater than zero");
        }

        Double currentPaidAmount = fee.getPaidAmount();

        if (currentPaidAmount == null) {
            currentPaidAmount = 0.0;
        }

        Double remainingAmount =
                fee.getAmount() - currentPaidAmount;

        if (paymentAmount > remainingAmount) {
            throw new InvalidFeeException(
                    "Payment amount cannot be greater than remaining fee");
        }

        Double newPaidAmount =
                currentPaidAmount + paymentAmount;

        Double newRemainingAmount =
                fee.getAmount() - newPaidAmount;

        fee.setPaidAmount(newPaidAmount);
        fee.setRemainingAmount(newRemainingAmount);

        if (newRemainingAmount == 0.0) {

            fee.setPaymentStatus("PAID");
            fee.setPaidAt(LocalDateTime.now());

        } else {

            fee.setPaymentStatus("PARTIAL");
        }

        fee.setUpdatedAt(LocalDateTime.now());

        Fee updatedFee = feeRepository.save(fee);

        StudentResponseDTO student =
                studentClient.getStudentById(fee.getStudentId());

        return feeMapper.toResponseDTO(updatedFee, student);
    }

    @Override
    public void deleteFee(Long feeId) {

        Fee fee = feeRepository.findById(feeId)
                .orElseThrow(() ->
                        new FeeNotFoundException(
                                "Fee not found with id: " + feeId));

        feeRepository.delete(fee);
    }
}
