package com.tharunbalaji.android_redbus_clone;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.tharunbalaji.android_redbus_clone.adapter.BusAdapter;
import com.tharunbalaji.android_redbus_clone.model.Bus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchActivity extends AppCompatActivity {
    private TextView tvFrom, tvTo;
    private RecyclerView rvBuses;
    private BusAdapter busAdapter;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_screen);

        db = FirebaseFirestore.getInstance();


        String from = getIntent().getStringExtra("from");
        String to = getIntent().getStringExtra("to");

        rvBuses = findViewById(R.id.rv_bus);

        rvBuses.setLayoutManager(new LinearLayoutManager(this));
        busAdapter = new BusAdapter();
        busAdapter.setBusList(new ArrayList<>());

        rvBuses.setAdapter(busAdapter);

        fetchData(from, to);
    }

    private void fetchData(String from, String to){
        db.collection("buses").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<Bus> busList = new ArrayList<>();

                        Log.d("FIRESTORE", "Successfully fetched data");

                        for (QueryDocumentSnapshot document: queryDocumentSnapshots) {
                            String documentId = document.getId();
                            String busName = document.getString("busName");
                            String busType = document.getString("busType");
                            String destination = document.getString("destination");
                            String endingTime = document.getString("endingTime");
                            String startingLocation = document.getString("startingLocation");
                            String startingTime = document.getString("startingTime");
                            String ticketPrice = document.getString("ticketPrice");
                            String totalSeats = document.getString("totalSeats");

                            Bus student = new Bus(busName, busType, startingTime, endingTime, ticketPrice, totalSeats,startingLocation,destination);

                            if (Objects.equals(startingLocation, from) && Objects.equals(destination, to)){
                                busList.add(student);
                            }
                        }

                        busAdapter.setBusList(busList);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SearchActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
