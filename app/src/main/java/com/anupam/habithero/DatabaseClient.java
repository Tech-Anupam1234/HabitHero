package com.anupam.habithero;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private static HabitDatabase database;

    public static HabitDatabase getDatabase(Context context) {

        if (database == null) {

            database = Room.databaseBuilder(
                            context,
                            HabitDatabase.class,
                            "habit_db"
                    )
                    .allowMainThreadQueries()
                    .build();
        }

        return database;
    }
}