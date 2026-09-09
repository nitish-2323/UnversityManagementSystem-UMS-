package com.UMS.NotificationService.service;

import com.UMS.NotificationService.dto.NotificationRequestDTO;
import com.UMS.NotificationService.dto.NotificationResponseDTO;

import java.util.List;

public interface NotificationService {
    NotificationResponseDTO createNotification(NotificationRequestDTO requestDTO);

    NotificationResponseDTO getNotificationById(Long notificationId);

    List<NotificationResponseDTO> getNotificationsByStudentId(Long studentId);

    List<NotificationResponseDTO> getUnreadNotifications(Long studentId);

    NotificationResponseDTO markAsRead(Long notificationId);

    void deleteNotification(Long notificationId);
}
