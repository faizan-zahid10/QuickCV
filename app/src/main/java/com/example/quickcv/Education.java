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

public class Education extends AppCompatActivity {

//    hooks
    private EditText etInstitution, etDiscipline, etStartYear, etEndYear, etCGPA;
    private Button btnCancel, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_education);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        // Cancel Button go back to home page
        btnCancel.setOnClickListener(v -> finish());

        // Save Button save data
        btnSave.setOnClickListener(v -> saveEducationData());
    }

    private void init(){
        etInstitution = findViewById(R.id.etInstitution);
        etDiscipline = findViewById(R.id.etDiscipline);
        etStartYear = findViewById(R.id.etStartYear);
        etEndYear = findViewById(R.id.etEndYear);
        etCGPA = findViewById(R.id.etCGPA);
        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);
    }

    private void saveEducationData() {
        // Get input values
        String institution = etInstitution.getText().toString().trim();
        String discipline = etDiscipline.getText().toString().trim();
        String startYear = etStartYear.getText().toString().trim();
        String endYear = etEndYear.getText().toString().trim();
        String cgpa = etCGPA.getText().toString().trim();

        // Validation check (Ensure all fields are filled)
        if (institution.isEmpty() || discipline.isEmpty() || startYear.isEmpty() || endYear.isEmpty() || cgpa.isEmpty()) {
            Toast.makeText(this, "Data is incomplete", Toast.LENGTH_SHORT).show();
            return;
        }

//      intent to send data back
        Intent i = new Intent();
        i.putExtra("institution", institution);
        i.putExtra("discipline", discipline);
        i.putExtra("startYear", startYear);
        i.putExtra("endYear", endYear);
        i.putExtra("cgpa", cgpa);
        setResult(RESULT_OK, i);
        Toast.makeText(this, "Education saved!", Toast.LENGTH_SHORT).show();

        finish();
    }
}