package com.cst2335.rayk0001;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Context;

@Database(entities = {ChatMessage.class}, version = 1)
public abstract class MessageDatabase extends RoomDatabase {
    private static final String DB_NAME = "text_database";

    public abstract ChatMessageDAO chatMessageDAO();

    private static MessageDatabase mInstance;

    public static synchronized MessageDatabase getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(ctx.getApplicationContext(),
                            MessageDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstance;
    }


}