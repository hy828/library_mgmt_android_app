package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase
{
    private static MyDatabase DATABASE;

    public static synchronized MyDatabase getDatabase(Context context) {
        if(DATABASE == null) {
            DATABASE = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "library")
                    .build();
        }
        return DATABASE;
    }
    public abstract BookDAO getBookDao();

}