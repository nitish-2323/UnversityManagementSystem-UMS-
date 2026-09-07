package com.UMS.ExaminationService.service;

import com.UMS.ExaminationService.client.StudentClient;
import com.UMS.ExaminationService.dto.ResultRequestDTO;
import com.UMS.ExaminationService.dto.ResultResponseDTO;
import com.UMS.ExaminationService.dto.StudentResponseDTO;
import com.UMS.ExaminationService.entity.Result;
import com.UMS.ExaminationService.execption.ResourceNotFoundException;
import com.UMS.ExaminationService.mapper.ResultMapper;
import com.UMS.ExaminationService.repository.ResultRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements  ResultService{
    private final ResultRepository resultRepository;
    private final ResultMapper resultMapper;

    private final StudentClient studentClient;


    @Override
    public ResultResponseDTO createResult(
            ResultRequestDTO resultRequestDTO) {

        // Check Student Service
        StudentResponseDTO student =
                studentClient.getStudentById(
                        resultRequestDTO.getStudentId()
                );

        Result result =
                resultMapper.toEntity(resultRequestDTO);

        Result savedResult =
                resultRepository.save(result);

        ResultResponseDTO response =
                resultMapper.toResponseDTO(savedResult);

        response.setStudent(student);

        return response;
    }


    @Override
    public ResultResponseDTO getResultById(Long resultId) {

        Result result = resultRepository.findById(resultId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Result not found with id: " + resultId
                        ));

        ResultResponseDTO response =
                resultMapper.toResponseDTO(result);

        StudentResponseDTO student =
                studentClient.getStudentById(
                        result.getStudentId()
                );

        response.setStudent(student);

        return response;
    }


    @Override
    public List<ResultResponseDTO> getAllResults() {

        return resultRepository.findAll()
                .stream()
                .map(result -> {

                    ResultResponseDTO response =
                            resultMapper.toResponseDTO(result);

                    StudentResponseDTO student =
                            studentClient.getStudentById(
                                    result.getStudentId()
                            );

                    response.setStudent(student);

                    return response;
                })
                .toList();
    }


    @Override
    public ResultResponseDTO updateResult(
            Long resultId,
            ResultRequestDTO resultRequestDTO) {

        Result result = resultRepository.findById(resultId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Result not found with id: " + resultId
                        ));

        result.setExamId(resultRequestDTO.getExamId());
        result.setStudentId(resultRequestDTO.getStudentId());
        result.setMarksObtained(resultRequestDTO.getMarksObtained());
        result.setGrade(resultRequestDTO.getGrade());
        result.setStatus(resultRequestDTO.getStatus());

        Result updatedResult =
                resultRepository.save(result);

        ResultResponseDTO response =
                resultMapper.toResponseDTO(updatedResult);

        StudentResponseDTO student =
                studentClient.getStudentById(
                        updatedResult.getStudentId()
                );

        response.setStudent(student);

        return response;
    }


    @Override
    public void deleteResult(Long resultId) {

        Result result = resultRepository.findById(resultId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Result not found with id: " + resultId
                        ));

        resultRepository.delete(result);
    }
}