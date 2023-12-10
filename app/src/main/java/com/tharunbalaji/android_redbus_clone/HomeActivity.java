package com.tharunbalaji.android_redbus_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    private EditText etFrom, etTo;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFrom = findViewById(R.id.et_from);
        etTo = findViewById(R.id.et_to);
        btnSearch = findViewById(R.id.btn_search);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String from = etFrom.getText().toString();
                String to = etTo.getText().toString();

                Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
                intent.putExtra("from", from);
                intent.putExtra("to", to);

                startActivity(intent);
            }
        });
    }
}