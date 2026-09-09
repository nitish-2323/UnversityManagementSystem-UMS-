package com.UMS.NotificationService.dto;

import com.UMS.NotificationService.entity.NotificationStatus;
import com.UMS.NotificationService.entity.NotificationType;
import lombok.Data;

@Data
public class NotificationRequestDTO {
    private Long studentId;

    private String title;

    private String message;

    private NotificationType notificationType;

    private NotificationStatus notificationStatus;
}
