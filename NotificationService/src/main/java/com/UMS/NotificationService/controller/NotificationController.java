package com.UMS.NotificationService.controller;

import com.UMS.NotificationService.dto.NotificationRequestDTO;
import com.UMS.NotificationService.dto.NotificationResponseDTO;
import com.UMS.NotificationService.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<NotificationResponseDTO> createNotification(
            @RequestBody NotificationRequestDTO requestDTO) {

        NotificationResponseDTO responseDTO =
                notificationService.createNotification(requestDTO);

        return new ResponseEntity<>(
                responseDTO,
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<NotificationResponseDTO> getNotificationById(
            @PathVariable Long notificationId) {

        NotificationResponseDTO responseDTO =
                notificationService.getNotificationById(notificationId);

        return new ResponseEntity<>(
                responseDTO,
                HttpStatus.OK
        );
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<NotificationResponseDTO>> getNotificationsByStudentId(
            @PathVariable Long studentId) {

        List<NotificationResponseDTO> responseDTO =
                notificationService.getNotificationsByStudentId(studentId);

        return new ResponseEntity<>(
                responseDTO,
                HttpStatus.OK
        );
    }

    @GetMapping("/student/{studentId}/unread")
    public ResponseEntity<List<NotificationResponseDTO>> getUnreadNotifications(
            @PathVariable Long studentId) {

        List<NotificationResponseDTO> responseDTO =
                notificationService.getUnreadNotifications(studentId);

        return new ResponseEntity<>(
                responseDTO,
                HttpStatus.OK
        );
    }

    @PutMapping("/{notificationId}/read")
    public ResponseEntity<NotificationResponseDTO> markAsRead(
            @PathVariable Long notificationId) {

        NotificationResponseDTO responseDTO =
                notificationService.markAsRead(notificationId);

        return new ResponseEntity<>(
                responseDTO,
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> deleteNotification(
            @PathVariable Long notificationId) {

        notificationService.deleteNotification(notificationId);

        return new ResponseEntity<>(
                HttpStatus.NO_CONTENT
        );
    }
}
