package com.UMS.NotificationService.mapper;

import com.UMS.NotificationService.dto.NotificationRequestDTO;
import com.UMS.NotificationService.dto.NotificationResponseDTO;
import com.UMS.NotificationService.dto.StudentResponseDTO;
import com.UMS.NotificationService.entity.Notification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificationMapper {
    public static Notification toEntity(NotificationRequestDTO dto) {

        Notification notification = new Notification();

        notification.setStudentId(dto.getStudentId());
        notification.setTitle(dto.getTitle());
        notification.setMessage(dto.getMessage());
        notification.setNotificationType(dto.getNotificationType());
        notification.setNotificationStatus(dto.getNotificationStatus());

        notification.setCreatedAt(LocalDateTime.now());

        return notification;
    }

    public NotificationResponseDTO toResponseDTO(
            Notification notification,
            StudentResponseDTO student) {

        NotificationResponseDTO dto = new NotificationResponseDTO();

        dto.setNotificationId(notification.getNotificationId());
        dto.setStudentId(notification.getStudentId());
        dto.setTitle(notification.getTitle());
        dto.setMessage(notification.getMessage());
        dto.setNotificationType(notification.getNotificationType());
        dto.setNotificationStatus(notification.getNotificationStatus());
        dto.setCreatedAt(notification.getCreatedAt());
        dto.setReadAt(notification.getReadAt());

        dto.setStudentResponseDTO(student);

        return dto;
    }

}
