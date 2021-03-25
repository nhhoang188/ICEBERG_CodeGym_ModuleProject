package com.icebergsocialnetwork.services.message;

import com.icebergsocialnetwork.model.message.ChatMessage;

import java.util.List;

public interface IChatMessageService extends IGeneralService<ChatMessage> {
    List<ChatMessage> getChatMessageByChatRoom(Long chatRoomId);
}
