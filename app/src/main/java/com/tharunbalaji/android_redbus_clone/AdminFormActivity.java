package com.tharunbalaji.android_redbus_clone;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.tharunbalaji.android_redbus_clone.model.Bus;

public class AdminFormActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private EditText etBusName, etBusType, etStartingTime, etEndingTime, etTicketPrice, etTotalSeats, etStartingLocation, etDestination;
    private Button btnAdd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_form_screen);

        db = FirebaseFirestore.getInstance();

        etBusName = findViewById(R.id.etBusName);
        etBusType = findViewById(R.id.etBusType);
        etStartingTime = findViewById(R.id.etStartingTime);
        etEndingTime = findViewById(R.id.etEndingTime);
        etTicketPrice = findViewById(R.id.etTicketPrice);
        etTotalSeats = findViewById(R.id.etTotalSeats);
        etStartingLocation = findViewById(R.id.etStartingLocation);
        etDestination = findViewById(R.id.etDestination);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String busName = etBusName.getText().toString();
                String busType = etBusType.getText().toString();
                String startingLocation = etStartingLocation.getText().toString();
                String destination = etDestination.getText().toString();
                String startingTime = etStartingTime.getText().toString();
                String endingTime = etEndingTime.getText().toString();
                String ticketPrice = etTicketPrice.getText().toString();
                String totalSeats = etTotalSeats.getText().toString();
                
                Bus newBus = new Bus(busName, busType, startingTime, endingTime, ticketPrice, totalSeats,startingLocation,destination);

                db.collection("buses").add(newBus)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("BUSES", "New Bus added");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("BUSES", "Error occurred");
                            }
                        });
            }
        });
    }
}
