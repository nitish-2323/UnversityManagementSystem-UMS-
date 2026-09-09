package com.UMS.NotificationService.service;

import com.UMS.NotificationService.client.StudentClient;
import com.UMS.NotificationService.dto.NotificationRequestDTO;
import com.UMS.NotificationService.dto.NotificationResponseDTO;
import com.UMS.NotificationService.dto.StudentResponseDTO;
import com.UMS.NotificationService.entity.Notification;
import com.UMS.NotificationService.entity.NotificationStatus;
import com.UMS.NotificationService.execption.NotificationNotFoundException;
import com.UMS.NotificationService.mapper.NotificationMapper;
import com.UMS.NotificationService.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final StudentClient studentClient;

    @Override
    public NotificationResponseDTO createNotification(
            NotificationRequestDTO requestDTO) {

        StudentResponseDTO student =
                studentClient.getStudentById(
                        requestDTO.getStudentId());

        Notification notification =
                notificationMapper.toEntity(requestDTO);

        notification.setCreatedAt(LocalDateTime.now());

        Notification savedNotification =
                notificationRepository.save(notification);

        return notificationMapper.toResponseDTO(
                savedNotification,
                student);
    }

    @Override
    public NotificationResponseDTO getNotificationById(
            Long notificationId) {

        Notification notification =
                notificationRepository.findById(notificationId)
                        .orElseThrow(() -> new NotificationNotFoundException(
                                "Notification not found with id: "
                                        + notificationId));

        StudentResponseDTO student =
                studentClient.getStudentById(
                        notification.getStudentId());

        return notificationMapper.toResponseDTO(
                notification,
                student);
    }

    @Override
    public List<NotificationResponseDTO> getNotificationsByStudentId(
            Long studentId) {

        List<Notification> notifications =
                notificationRepository.findByStudentId(studentId);

        StudentResponseDTO student =
                studentClient.getStudentById(studentId);

        return notifications.stream()
                .map(notification ->
                        notificationMapper.toResponseDTO(
                                notification,
                                student))
                .toList();
    }

    @Override
    public List<NotificationResponseDTO> getUnreadNotifications(
            Long studentId) {

        List<Notification> notifications =
                notificationRepository.findByStudentIdAndReadAtIsNull(
                        studentId);

        StudentResponseDTO student =
                studentClient.getStudentById(studentId);

        return notifications.stream()
                .map(notification ->
                        notificationMapper.toResponseDTO(
                                notification,
                                student))
                .toList();
    }

    @Override
    public NotificationResponseDTO markAsRead(
            Long notificationId) {

        Notification notification =
                notificationRepository.findById(notificationId)
                        .orElseThrow(() -> new NotificationNotFoundException(
                                "Notification not found with id: "
                                        + notificationId));

        notification.setReadAt(LocalDateTime.now());
        notification.setNotificationStatus(
                NotificationStatus.SENT);

        Notification updatedNotification =
                notificationRepository.save(notification);

        StudentResponseDTO student =
                studentClient.getStudentById(
                        notification.getStudentId());

        return notificationMapper.toResponseDTO(
                updatedNotification,
                student);
    }

    @Override
    public void deleteNotification(Long notificationId) {

        Notification notification =
                notificationRepository.findById(notificationId)
                        .orElseThrow(() -> new NotificationNotFoundException(
                                "Notification not found with id: "
                                        + notificationId));

        notificationRepository.delete(notification);
    }
}