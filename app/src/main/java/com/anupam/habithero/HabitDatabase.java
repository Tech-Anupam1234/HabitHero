package com.anupam.habithero;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {HabitEntity.class},
        version = 1,
        exportSchema = false
)
public abstract class HabitDatabase extends RoomDatabase {

    public abstract HabitDao habitDao();

}