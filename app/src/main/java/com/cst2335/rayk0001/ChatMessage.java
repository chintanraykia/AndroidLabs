package com.cst2335.rayk0001;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChatMessage {
    @ColumnInfo(name = "message")
    private String message;
    @ColumnInfo(name = "TimeSent")
    private String timeSent;
    @ColumnInfo(name = "SendOrReceive")
    private boolean isSentButton;

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public int id;

    public ChatMessage() {
    }

    /**
     *
     * @param m message content
     * @param t message timing
     * @param sent sent or received
     */
    public ChatMessage(String m, String t, boolean sent) {
        this.message = m;
        this.timeSent = t;
        this.isSentButton = sent;
    }

    /**
     *
     * @return message content
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @return message time
     */
    public String getTimeSent() {
        return timeSent;
    }

    /**
     *
     * @return message sent or received
     */
    public boolean isSentButton() {
        return isSentButton;
    }

    /**
     *
     * @param message message content
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @param timeSent message time
     */
    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    /**
     *
     * @param isSentButton message sent or received
     */
    public void setSentButton(boolean isSentButton) {
        this.isSentButton = isSentButton;
    }
}
