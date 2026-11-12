package com.anupam.habithero;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HabitDao {

    @Insert
    void insertHabit(HabitEntity habit);

    @Query("SELECT * FROM habits")
    List<HabitEntity> getAllHabits();

    @Query("DELETE FROM habits")
    void deleteAllHabits();
}