package com.example.quickcv;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Experience extends AppCompatActivity {

//    hooks
    private EditText etJobTitle, etCompanyName, etExperienceLevel, etStartDate, etEndDate, etJobDescription;
    private RadioGroup radioGroupEmploymentType;
    private Button btnCancel, btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_experience);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();


        // Cancel Button takes back
        btnCancel.setOnClickListener(v -> finish());

        // Save Button saves data
        btnSave.setOnClickListener(v -> saveExperienceData());

    }

    private void init(){
        etJobTitle = findViewById(R.id.etJobTitle);
        etCompanyName = findViewById(R.id.etCompanyName);
        etExperienceLevel = findViewById(R.id.etExperienceLevel);
        etStartDate = findViewById(R.id.etStartDate);
        etEndDate = findViewById(R.id.etEndDate);
        etJobDescription = findViewById(R.id.etJobDescription);
        radioGroupEmploymentType = findViewById(R.id.radioGroupEmploymentType);
        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);
    }

    private void saveExperienceData() {
        String jobTitle = etJobTitle.getText().toString().trim();
        String companyName = etCompanyName.getText().toString().trim();
        String experienceLevel = etExperienceLevel.getText().toString().trim();
        String startDate = etStartDate.getText().toString().trim();
        String endDate = etEndDate.getText().toString().trim();
        String jobDescription = etJobDescription.getText().toString().trim();

        int selectedId = radioGroupEmploymentType.getCheckedRadioButtonId();
        String employmentType = "";
        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            employmentType = selectedRadioButton.getText().toString();
        }

//      checking fields if any empty
        if (jobTitle.isEmpty() || companyName.isEmpty() || employmentType.isEmpty() ||
                experienceLevel.isEmpty() || startDate.isEmpty() || endDate.isEmpty() || jobDescription.isEmpty()) {
            Toast.makeText(this, "Data is incomplete", Toast.LENGTH_SHORT).show();
            return;
        }

//      intent to send data back
        Intent resultIntent = new Intent();
        resultIntent.putExtra("jobTitle", jobTitle);
        resultIntent.putExtra("companyName", companyName);
        resultIntent.putExtra("employmentType", employmentType);
        resultIntent.putExtra("experienceLevel", experienceLevel);
        resultIntent.putExtra("startDate", startDate);
        resultIntent.putExtra("endDate", endDate);
        resultIntent.putExtra("jobDescription", jobDescription);
        setResult(RESULT_OK, resultIntent);
        Toast.makeText(this, "Experience saved!", Toast.LENGTH_SHORT).show();

        finish();
    }
}