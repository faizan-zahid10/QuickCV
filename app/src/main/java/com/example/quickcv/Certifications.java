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

public class Certifications extends AppCompatActivity {

//    hooks
    private EditText etCertificationName, etIssuer;
    private Button btnCancel, btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_certifications);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        // Cancel Button takes back to home page
        btnCancel.setOnClickListener(v -> finish());

        // Save Button save data
        btnSave.setOnClickListener(v -> saveCertificationData());
    }

    private void init(){
        etCertificationName = findViewById(R.id.etCertificationName);
        etIssuer = findViewById(R.id.etIssuer);
        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);
    }

    private void saveCertificationData() {
        String certificationName = etCertificationName.getText().toString().trim();
        String issuer = etIssuer.getText().toString().trim();

        // checking fields if any empty
        if (certificationName.isEmpty() || issuer.isEmpty()) {
            Toast.makeText(this, "Data is incomplete", Toast.LENGTH_SHORT).show();
            return;
        }

//      intent to send data back
        Intent resultIntent = new Intent();
        resultIntent.putExtra("certificationName", certificationName);
        resultIntent.putExtra("issuer", issuer);
        setResult(RESULT_OK, resultIntent);
        Toast.makeText(this, "Certification saved!", Toast.LENGTH_SHORT).show();

        finish();
    }
}