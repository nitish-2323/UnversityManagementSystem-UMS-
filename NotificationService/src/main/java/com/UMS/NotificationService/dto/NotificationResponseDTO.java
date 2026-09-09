package com.UMS.NotificationService.dto;

import com.UMS.NotificationService.entity.NotificationStatus;
import com.UMS.NotificationService.entity.NotificationType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponseDTO {

    private Long notificationId;

    private Long studentId;

    private String title;

    private String message;

    private NotificationType notificationType;

    private NotificationStatus notificationStatus;

    private LocalDateTime createdAt;

    private LocalDateTime readAt;

    private StudentResponseDTO studentResponseDTO;

}
