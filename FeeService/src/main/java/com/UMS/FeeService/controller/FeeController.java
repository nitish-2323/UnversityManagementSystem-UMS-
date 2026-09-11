package com.UMS.FeeService.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UMS.FeeService.dto.FeeRequestDTO;
import com.UMS.FeeService.dto.FeeResponseDTO;
import com.UMS.FeeService.service.FeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/fees")
@RequiredArgsConstructor
public class FeeController {

    private final FeeService feeService;

    @PostMapping
    public ResponseEntity<FeeResponseDTO> createFee(
            @RequestBody FeeRequestDTO requestDTO) {

        FeeResponseDTO responseDTO = feeService.createFee(requestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{feeId}")
    public ResponseEntity<FeeResponseDTO> getFeeById(
            @PathVariable Long feeId) {

        FeeResponseDTO responseDTO = feeService.getFeeById(feeId);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<FeeResponseDTO>> getFeesByStudentId(
            @PathVariable Long studentId) {

        List<FeeResponseDTO> responseDTO =
                feeService.getFeesByStudentId(studentId);

        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{feeId}")
    public ResponseEntity<FeeResponseDTO> updateFee(
            @PathVariable Long feeId,
            @RequestBody FeeRequestDTO requestDTO) {

        FeeResponseDTO responseDTO =
                feeService.updateFee(feeId, requestDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{feeId}/pay")
    public ResponseEntity<FeeResponseDTO> payFee(
            @PathVariable Long feeId,
            @RequestParam Double paymentAmount) {

        FeeResponseDTO responseDTO =
                feeService.payFee(feeId, paymentAmount);

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{feeId}")
    public ResponseEntity<Void> deleteFee(
            @PathVariable Long feeId) {

        feeService.deleteFee(feeId);

        return ResponseEntity.noContent().build();
    }
}

