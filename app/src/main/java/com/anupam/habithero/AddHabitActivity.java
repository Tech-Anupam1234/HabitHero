package com.anupam.habithero;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddHabitActivity extends AppCompatActivity {

    private EditText etHabitName;
    private EditText etCategory;
    private Button btnSaveHabit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);

        etHabitName = findViewById(R.id.etHabitName);
        etCategory = findViewById(R.id.etCategory);
        btnSaveHabit = findViewById(R.id.btnSaveHabit);

        btnSaveHabit.setOnClickListener(v -> {

            String habitName = etHabitName.getText().toString().trim();
            String category = etCategory.getText().toString().trim();

            if (habitName.isEmpty()) {
                etHabitName.setError("Enter Habit Name");
                return;
            }

            if (category.isEmpty()) {
                etCategory.setError("Enter Category");
                return;
            }

            Intent resultIntent = new Intent();

            resultIntent.putExtra("habit_name", habitName);
            resultIntent.putExtra("category", category);

            setResult(RESULT_OK, resultIntent);

            finish();
        });
    }
}
