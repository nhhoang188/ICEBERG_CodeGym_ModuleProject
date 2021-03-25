package com.icebergsocialnetwork.services.message;

import com.icebergsocialnetwork.model.message.ChatRoom;
import com.icebergsocialnetwork.services.IGenericService;

import java.util.Optional;

public interface IChatRoomService extends IGeneralService<ChatRoom> {
    Optional<ChatRoom> getChatRoomByIds(Long firstUserId, Long secondUserId);
    Optional<ChatRoom> findByName( String name);

}
