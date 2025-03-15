package com.example.quickcv;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Summary extends AppCompatActivity {

//    hooks
    private EditText etSummary;
    private Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        // Save Button Click
        btnSave.setOnClickListener(v -> {
            String summary = etSummary.getText().toString().trim();

            if (summary.isEmpty()) {
                Toast.makeText(Summary.this, "Summary cannot be empty", Toast.LENGTH_SHORT).show();
            } else {
                Intent i = new Intent();
                i.putExtra("summary", summary);
                setResult(RESULT_OK, i);
                Toast.makeText(Summary.this, "Summary saved!", Toast.LENGTH_SHORT).show();
                finish(); // Go back to MainActivity
            }
        });

        // Cancel Button Click
        btnCancel.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish(); // back to home page
        });
    }

    private void init(){
        etSummary = findViewById(R.id.etSummary);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
    }
}