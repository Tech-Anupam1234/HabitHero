package com.anupam.habithero;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.ViewHolder> {

    private List<Habit> habitList;

    public HabitAdapter(List<Habit> habitList) {
        this.habitList = habitList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.habit_item,
                        parent,
                        false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        holder.tvHabitName.setText(
                habitList.get(position).getHabitName()
        );
    }

    @Override
    public int getItemCount() {
        return habitList.size();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        TextView tvHabitName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHabitName =
                    itemView.findViewById(R.id.tvHabitName);
        }
    }
}