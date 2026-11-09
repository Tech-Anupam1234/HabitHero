package com.anupam.habithero;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Habit> habitList;
    private HabitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView rvHabits = findViewById(R.id.rvHabits);
        Button btnAddHabit = findViewById(R.id.btnAddHabit);

        habitList = new ArrayList<>();

        habitList.add(new Habit("✅ Exercise"));
        habitList.add(new Habit("✅ Reading"));
        habitList.add(new Habit("✅ Coding"));

        adapter = new HabitAdapter(habitList);

        rvHabits.setLayoutManager(new LinearLayoutManager(this));
        rvHabits.setAdapter(adapter);

        btnAddHabit.setOnClickListener(v -> {

            Intent intent =
                    new Intent(MainActivity.this,
                            AddHabitActivity.class);

            startActivity(intent);

        });

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars =
                            insets.getInsets(
                                    WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                });
    }
}