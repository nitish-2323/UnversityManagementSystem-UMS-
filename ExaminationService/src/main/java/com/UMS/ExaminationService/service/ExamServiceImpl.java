package com.UMS.ExaminationService.service;

import com.UMS.ExaminationService.client.CourseClient;
import com.UMS.ExaminationService.client.TeacherClient;
import com.UMS.ExaminationService.dto.CourseResponseDTO;
import com.UMS.ExaminationService.dto.ExamRequestDTO;
import com.UMS.ExaminationService.dto.ExamResponseDTO;
import com.UMS.ExaminationService.dto.TeacherResponseDTO;
import com.UMS.ExaminationService.entity.Exam;
import com.UMS.ExaminationService.execption.ResourceNotFoundException;
import com.UMS.ExaminationService.mapper.ExamMapper;
import com.UMS.ExaminationService.repository.ExamRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements  ExamService{
    private final ExamRepository examRepository;
    private final ExamMapper examMapper;

    private final CourseClient courseClient;
    private final TeacherClient teacherClient;


    @Override
    public ExamResponseDTO createExam(ExamRequestDTO examRequestDTO) {

        // Check Course Service
        CourseResponseDTO course =
                courseClient.getCourseById(examRequestDTO.getCourseId());

        // Check Teacher Service
        TeacherResponseDTO teacher =
                teacherClient.getTeacherById(examRequestDTO.getTeacherId());

        Exam exam = examMapper.toEntity(examRequestDTO);

        Exam savedExam = examRepository.save(exam);

        ExamResponseDTO response =
                examMapper.toResponseDTO(savedExam);

        response.setCourse(course);
        response.setTeacher(teacher);

        return response;
    }


    @Override
    public ExamResponseDTO getExamById(Long examId) {

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Exam not found with id: " + examId
                        ));

        ExamResponseDTO response =
                examMapper.toResponseDTO(exam);

        CourseResponseDTO course =
                courseClient.getCourseById(exam.getCourseId());

        TeacherResponseDTO teacher =
                teacherClient.getTeacherById(exam.getTeacherId());

        response.setCourse(course);
        response.setTeacher(teacher);

        return response;
    }


    @Override
    public List<ExamResponseDTO> getAllExams() {

        return examRepository.findAll()
                .stream()
                .map(exam -> {

                    ExamResponseDTO response =
                            examMapper.toResponseDTO(exam);

                    CourseResponseDTO course =
                            courseClient.getCourseById(exam.getCourseId());

                    TeacherResponseDTO teacher =
                            teacherClient.getTeacherById(exam.getTeacherId());

                    response.setCourse(course);
                    response.setTeacher(teacher);

                    return response;
                })
                .toList();
    }


    @Override
    public ExamResponseDTO updateExam(
            Long examId,
            ExamRequestDTO examRequestDTO) {

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Exam not found with id: " + examId
                        ));

        exam.setCourseId(examRequestDTO.getCourseId());
        exam.setTeacherId(examRequestDTO.getTeacherId());
        exam.setExamType(examRequestDTO.getExamType());
        exam.setExamDate(examRequestDTO.getExamDate());
        exam.setStartTime(examRequestDTO.getStartTime());
        exam.setEndTime(examRequestDTO.getEndTime());
        exam.setRoomNumber(examRequestDTO.getRoomNumber());
        exam.setTotalMarks(examRequestDTO.getTotalMarks());
        exam.setStatus(examRequestDTO.getStatus());

        Exam updatedExam =
                examRepository.save(exam);

        ExamResponseDTO response =
                examMapper.toResponseDTO(updatedExam);

        CourseResponseDTO course =
                courseClient.getCourseById(updatedExam.getCourseId());

        TeacherResponseDTO teacher =
                teacherClient.getTeacherById(updatedExam.getTeacherId());

        response.setCourse(course);
        response.setTeacher(teacher);

        return response;
    }


    @Override
    public void deleteExam(Long examId) {

        Exam exam = examRepository.findById(examId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Exam not found with id: " + examId
                        ));

        examRepository.delete(exam);
    }
}