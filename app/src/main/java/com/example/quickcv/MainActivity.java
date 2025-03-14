package com.example.quickcv;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int PERSONAL_DETAILS_REQUEST = 1;

    //    hooks
    private Button btnProfilePicture, btnPersonalDetails, btnSummary, btnEducation, btnExperience, btnCertifications, btnReferences, btnViewCV;

    // Variables to store user data
    private String name, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

//        all action listeners now
        btnProfilePicture.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfilePicture.class);
            startActivity(intent);
        });

        btnPersonalDetails.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PersonalDetails.class);
            personalDetailsLauncher.launch(intent);
        });

        btnSummary.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Summary.class);
            startActivity(intent);
        });

        btnEducation.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Education.class);
            startActivity(intent);
        });

        btnExperience.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Experience.class);
            startActivity(intent);
        });

        btnCertifications.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Certifications.class);
            startActivity(intent);
        });

        btnReferences.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, References.class);
            startActivity(intent);
        });

        btnViewCV.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PersonalDetails.class);
            startActivity(intent);
        });

    }

//    Handling/Capture results

    private final ActivityResultLauncher<Intent> personalDetailsLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    name = data.getStringExtra("name");
                    email = data.getStringExtra("email");
                    phone = data.getStringExtra("phone");
                }
            });


    private void init(){
        btnProfilePicture = findViewById(R.id.btnProfilePicture);
        btnPersonalDetails = findViewById(R.id.btnPersonalDetails);
        btnSummary = findViewById(R.id.btnSummary);
        btnEducation = findViewById(R.id.btnEducation);
        btnExperience = findViewById(R.id.btnExperience);
        btnCertifications = findViewById(R.id.btnCertifications);
        btnReferences = findViewById(R.id.btnReferences);
        btnViewCV = findViewById(R.id.btnViewCV);
    }
}