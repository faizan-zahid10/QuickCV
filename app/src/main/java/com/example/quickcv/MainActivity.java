package com.example.quickcv;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

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
            summaryLauncher.launch(intent);
        });

        btnEducation.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Education.class);
            educationLauncher.launch(intent);
        });

        btnExperience.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Experience.class);
            experienceLauncher.launch(intent);
        });

        btnCertifications.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Certifications.class);
            certificationsLauncher.launch(intent);
        });

        btnReferences.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, References.class);
            referencesLauncher.launch(intent);
        });

        btnViewCV.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PersonalDetails.class);
            startActivity(intent);
        });

    }

//    Handling/Capture results

    // PersonalDetails Activity Result Launcher
    private final ActivityResultLauncher<Intent> personalDetailsLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    name = data.getStringExtra("name");
                    email = data.getStringExtra("email");
                    phone = data.getStringExtra("phone");
                }
            });


    // Summary Activity Result Launcher
    private final ActivityResultLauncher<Intent> summaryLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    String summary = result.getData().getStringExtra("summary");
                }
            });


    // Education Activity Result Launcher
    private final ActivityResultLauncher<Intent> educationLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    String institution = data.getStringExtra("institution");
                    String discipline = data.getStringExtra("discipline");
                    String startYear = data.getStringExtra("startYear");
                    String endYear = data.getStringExtra("endYear");
                    String cgpa = data.getStringExtra("cgpa");
                }
            });


    // Experience Activity Result Launcher
    private final ActivityResultLauncher<Intent> experienceLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    String jobTitle = data.getStringExtra("jobTitle");
                    String companyName = data.getStringExtra("companyName");
                    String employmentType = data.getStringExtra("employmentType");
                    String experienceLevel = data.getStringExtra("experienceLevel");
                    String startDate = data.getStringExtra("startDate");
                    String endDate = data.getStringExtra("endDate");
                    String jobDescription = data.getStringExtra("jobDescription");

                }
            });


    // Certifications Activity Result Launcher
    private final ActivityResultLauncher<Intent> certificationsLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    String certificationName = data.getStringExtra("certificationName");
                    String issuer = data.getStringExtra("issuer");
                    String issueDate = data.getStringExtra("issueDate");
                    String expirationDate = data.getStringExtra("expirationDate");
                }
            });


    // Reference Activity Result Launcher
    private final ActivityResultLauncher<Intent> referencesLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    String referenceName = data.getStringExtra("referenceName");
                    String designation = data.getStringExtra("designation");
                    String organization = data.getStringExtra("organization");
                    String phone = data.getStringExtra("phone");
                    String relationshipType = data.getStringExtra("relationshipType");
                }
            });


//    connection with front end in init() method
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