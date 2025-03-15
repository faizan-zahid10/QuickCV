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

    // Personal Details
    private String name, email, phone;

    // Summary
    private String summary;

    // Education
    private String institution, discipline, startYear, endYear, cgpa;

    // Experience
    private String jobTitle, companyName, employmentType, experienceLevel, startDate, endDate, jobDescription;

    // Certifications
    private String certificationName, issuer, issueDate, expirationDate;

    // References
    private String referenceName, designation, organization, referencePhone, relationshipType;

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

//       Final cv page displayed on this "View Cv" button click
        btnViewCV.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FinalCV.class);

            // Passing all collected data
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("phone", phone);
            intent.putExtra("summary", summary);
            intent.putExtra("institution", institution);
            intent.putExtra("discipline", discipline);
            intent.putExtra("startYear", startYear);
            intent.putExtra("endYear", endYear);
            intent.putExtra("cgpa", cgpa);
            intent.putExtra("jobTitle", jobTitle);
            intent.putExtra("companyName", companyName);
            intent.putExtra("employmentType", employmentType);
            intent.putExtra("experienceLevel", experienceLevel);
            intent.putExtra("startDate", startDate);
            intent.putExtra("endDate", endDate);
            intent.putExtra("jobDescription", jobDescription);
            intent.putExtra("certificationName", certificationName);
            intent.putExtra("issuer", issuer);
            intent.putExtra("issueDate", issueDate);
            intent.putExtra("expirationDate", expirationDate);
            intent.putExtra("referenceName", referenceName);
            intent.putExtra("designation", designation);
            intent.putExtra("organization", organization);
            intent.putExtra("referencePhone", referencePhone);
            intent.putExtra("relationshipType", relationshipType);

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
                    summary = result.getData().getStringExtra("summary");
                }
            });


    // Education Activity Result Launcher
    private final ActivityResultLauncher<Intent> educationLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    institution = data.getStringExtra("institution");
                    discipline = data.getStringExtra("discipline");
                    startYear = data.getStringExtra("startYear");
                    endYear = data.getStringExtra("endYear");
                    cgpa = data.getStringExtra("cgpa");
                }
            });


    // Experience Activity Result Launcher
    private final ActivityResultLauncher<Intent> experienceLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    jobTitle = data.getStringExtra("jobTitle");
                    companyName = data.getStringExtra("companyName");
                    employmentType = data.getStringExtra("employmentType");
                    experienceLevel = data.getStringExtra("experienceLevel");
                    startDate = data.getStringExtra("startDate");
                    endDate = data.getStringExtra("endDate");
                    jobDescription = data.getStringExtra("jobDescription");

                }
            });


    // Certifications Activity Result Launcher
    private final ActivityResultLauncher<Intent> certificationsLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    certificationName = data.getStringExtra("certificationName");
                    issuer = data.getStringExtra("issuer");
                    issueDate = data.getStringExtra("issueDate");
                    expirationDate = data.getStringExtra("expirationDate");
                }
            });


    // Reference Activity Result Launcher
    private final ActivityResultLauncher<Intent> referencesLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Intent data = result.getData();
                    referenceName = data.getStringExtra("referenceName");
                    designation = data.getStringExtra("designation");
                    organization = data.getStringExtra("organization");
                    referencePhone = data.getStringExtra("phone");
                    relationshipType = data.getStringExtra("relationshipType");
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