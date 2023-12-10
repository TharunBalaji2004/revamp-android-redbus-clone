package com.tharunbalaji.android_redbus_clone.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tharunbalaji.android_redbus_clone.R;
import com.tharunbalaji.android_redbus_clone.model.Bus;

import java.util.List;


public class BusAdapter extends RecyclerView.Adapter<BusAdapter.StudentViewHolder> {

    private List<Bus> busList;

    public void setBusList(List<Bus> studentList){
        this.busList = studentList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_item, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Bus bus = busList.get(position);

        holder.busName.setText(bus.getBusName());
        holder.busType.setText(bus.getBusType());
        holder.startingTime.setText(bus.getStartingTime());
        holder.endingTime.setText(bus.getEndingTime());
        holder.ticketPrice.setText(bus.getTicketPrice());
        holder.totalSeats.setText(bus.getTotalSeats());
        holder.startingLocation.setText(bus.getStartingLocation());
        holder.destination.setText(bus.getDestination());
    }

    @Override
    public int getItemCount() {
        return busList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView busName, busType, startingTime, endingTime, ticketPrice, totalSeats,startingLocation,destination;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            busName = itemView.findViewById(R.id.tvBusName);
            busType = itemView.findViewById(R.id.tvBusType);
            startingTime = itemView.findViewById(R.id.tvStartingTime);
            endingTime = itemView.findViewById(R.id.tvEndingTime);
            ticketPrice = itemView.findViewById(R.id.tvTicketPrice);
            totalSeats = itemView.findViewById(R.id.tvSeats);
            startingLocation = itemView.findViewById(R.id.tvFrom);
            destination = itemView.findViewById(R.id.tvTo);
        }

    }
}
