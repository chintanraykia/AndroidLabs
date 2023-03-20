package com.cst2335.rayk0001;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ChatMessageDAO {
    /**
     *
     * @param m ChatMessage to be inserted
     */
    @Insert
    void insertMessage(ChatMessage m);

    /**
     *
     * @return list of ChatMessages
     */
    @Query("Select * from ChatMessage")
    List<ChatMessage> getAllMessages();

    /**
     *
     * @param m ChatMessage to be deleted
     */
    @Delete
    void deleteMessage(ChatMessage m);
}