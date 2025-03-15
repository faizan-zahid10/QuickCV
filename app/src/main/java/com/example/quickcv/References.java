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

public class References extends AppCompatActivity {

//    hooks
    private EditText etReferenceName, etDesignation, etOrganization, etRefPhone;
    private RadioGroup radioGroupRelationship;
    private Button btnCancel, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_references);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        // Cancel button takes back to home page
        btnCancel.setOnClickListener(v -> finish());

        // Save button saves data
        btnSave.setOnClickListener(v -> saveReferenceData());
    }

    private void init(){
        etReferenceName = findViewById(R.id.etReferenceName);
        etDesignation = findViewById(R.id.etDesignation);
        etOrganization = findViewById(R.id.etOrganization);
        etRefPhone = findViewById(R.id.etRefPhone);
        radioGroupRelationship = findViewById(R.id.radioGroupRelationship);
        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);
    }

    private void saveReferenceData() {
        String referenceName = etReferenceName.getText().toString().trim();
        String designation = etDesignation.getText().toString().trim();
        String organization = etOrganization.getText().toString().trim();
        String phone = etRefPhone.getText().toString().trim();

        int selectedId = radioGroupRelationship.getCheckedRadioButtonId();
        String relationshipType = "";
        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            relationshipType = selectedRadioButton.getText().toString();
        }

        // checking if any field empty
        if (referenceName.isEmpty() || designation.isEmpty() || organization.isEmpty() || phone.isEmpty() || relationshipType.isEmpty()) {
            Toast.makeText(this, "Data is incomplete", Toast.LENGTH_SHORT).show();
            return;
        }

        // sending data MainActivity
        Intent i = new Intent();
        i.putExtra("referenceName", referenceName);
        i.putExtra("designation", designation);
        i.putExtra("organization", organization);
        i.putExtra("phone", phone);
        i.putExtra("relationshipType", relationshipType);
        setResult(RESULT_OK, i);
        Toast.makeText(References.this, "References saved!", Toast.LENGTH_SHORT).show();
        finish();
    }
}