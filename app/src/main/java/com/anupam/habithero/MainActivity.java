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

    private static final int REQUEST_CODE_ADD_HABIT = 1;

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

        rvHabits.setLayoutManager(
                new LinearLayoutManager(this));

        rvHabits.setAdapter(adapter);

        btnAddHabit.setOnClickListener(v -> {

            Intent intent =
                    new Intent(MainActivity.this,
                            AddHabitActivity.class);

            startActivityForResult(
                    intent,
                    REQUEST_CODE_ADD_HABIT);
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

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {

        super.onActivityResult(
                requestCode,
                resultCode,
                data);

        if (requestCode == REQUEST_CODE_ADD_HABIT
                && resultCode == RESULT_OK
                && data != null) {

            String habitName =
                    data.getStringExtra("habit_name");

            if (habitName != null
                    && !habitName.isEmpty()) {

                habitList.add(
                        new Habit("✅ " + habitName));

                adapter.notifyDataSetChanged();
            }
        }
    }
}