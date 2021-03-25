package com.icebergsocialnetwork.services.notification;

import com.icebergsocialnetwork.model.notification.Notification;
import com.icebergsocialnetwork.services.IGenericService;

import java.util.List;

public interface INotificationService extends IGenericService<Notification> {
    Notification findNotiByPost(Long id);

    List<Notification> findNotiGroupByPost();
}
