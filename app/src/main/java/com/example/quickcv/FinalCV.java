package com.example.quickcv;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FinalCV extends AppCompatActivity {

//    hooks
    private TextView tvName, tvEmail, tvPhone, tvSummary, tvInstitution, tvDiscipline, tvEducationYears, tvCGPA;
    private TextView tvJobTitle, tvCompanyName, tvEmploymentType, tvExperienceYears, tvJobDescription;
    private TextView tvCertificationName, tvIssuer, tvIssueDate, tvExpirationDate;
    private TextView tvReferenceName, tvReferenceDesignation, tvReferenceOrganization, tvReferencePhone, tvRelationshipType;
    Button btnShare;
    private ImageView ivProfilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final_cv);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        // Retrieve and set data from Intent
        setDataFromIntent();

        btnShare.setOnClickListener(v -> shareCV());
    }

    private void init(){
        ivProfilePic = findViewById(R.id.ivProfilePic);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvSummary = findViewById(R.id.tvSummary);

        tvInstitution = findViewById(R.id.tvInstitution);
        tvDiscipline = findViewById(R.id.tvDiscipline);
        tvEducationYears = findViewById(R.id.tvEducationYears);
        tvCGPA = findViewById(R.id.tvCGPA);

        tvJobTitle = findViewById(R.id.tvJobTitle);
        tvCompanyName = findViewById(R.id.tvCompanyName);
        tvEmploymentType = findViewById(R.id.tvEmploymentType);
        tvExperienceYears = findViewById(R.id.tvExperienceYears);
        tvJobDescription = findViewById(R.id.tvJobDescription);

        tvCertificationName = findViewById(R.id.tvCertificationName);
        tvIssuer = findViewById(R.id.tvIssuer);
        tvIssueDate = findViewById(R.id.tvIssueDate);
        tvExpirationDate = findViewById(R.id.tvExpirationDate);

        tvReferenceName = findViewById(R.id.tvReferenceName);
        tvReferenceDesignation = findViewById(R.id.tvReferenceDesignation);
        tvReferenceOrganization = findViewById(R.id.tvReferenceOrganization);
        tvReferencePhone = findViewById(R.id.tvReferencePhone);
        tvRelationshipType = findViewById(R.id.tvRelationshipType);

        btnShare = findViewById(R.id.btnShareCV);
    }


    // Retrieve and set data directly from Intent
    private void setDataFromIntent() {
        // Load Profile Picture
        String imageUri = getIntent().getStringExtra("profilePicUri");
        if (imageUri != null && !imageUri.isEmpty()) {
            try {
                ivProfilePic.setImageURI(Uri.parse(imageUri));
                Log.d("Image is",imageUri);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        }



        tvName.setText(getIntent().getStringExtra("name"));
        tvEmail.setText(getIntent().getStringExtra("email"));
        tvPhone.setText(getIntent().getStringExtra("phone"));

        tvSummary.setText(getIntent().getStringExtra("summary"));

        tvInstitution.setText(getIntent().getStringExtra("institution"));
        tvDiscipline.setText(getIntent().getStringExtra("discipline"));
        tvEducationYears.setText(getIntent().getStringExtra("startYear") + " - " + getIntent().getStringExtra("endYear"));
        tvCGPA.setText(getIntent().getStringExtra("cgpa"));

        tvJobTitle.setText(getIntent().getStringExtra("jobTitle"));
        tvCompanyName.setText(getIntent().getStringExtra("companyName"));
        tvEmploymentType.setText(getIntent().getStringExtra("employmentType"));
        tvExperienceYears.setText(getIntent().getStringExtra("startDate") + " - " + getIntent().getStringExtra("endDate"));
        tvJobDescription.setText(getIntent().getStringExtra("jobDescription"));

        tvCertificationName.setText(getIntent().getStringExtra("certificationName"));
        tvIssuer.setText(getIntent().getStringExtra("issuer"));
        tvIssueDate.setText(getIntent().getStringExtra("issueDate"));
        tvExpirationDate.setText(getIntent().getStringExtra("expirationDate"));

        tvReferenceName.setText(getIntent().getStringExtra("referenceName"));
        tvReferenceDesignation.setText(getIntent().getStringExtra("designation"));
        tvReferenceOrganization.setText(getIntent().getStringExtra("organization"));
        tvReferencePhone.setText(getIntent().getStringExtra("referencePhone"));
        tvRelationshipType.setText(getIntent().getStringExtra("relationshipType"));
    }


    private void shareCV() {
//        forming the text to share
        StringBuilder cvText = new StringBuilder();
        cvText.append("See my CV:\n\n")
                .append("Name: ").append(tvName.getText().toString()).append("\n")
                .append("Email: ").append(tvEmail.getText().toString()).append("\n")
                .append("Phone: ").append(tvPhone.getText().toString()).append("\n")
                .append("Summary: ").append(tvSummary.getText().toString()).append("\n\n")
                .append("Education: ").append(tvInstitution.getText().toString()).append("\n")
                .append("Discipline: ").append(tvDiscipline.getText().toString()).append("\n")
                .append("CGPA: ").append(tvCGPA.getText().toString()).append("\n\n")
                .append("Experience: ").append(tvJobTitle.getText().toString()).append(" at ")
                .append(tvCompanyName.getText().toString());


//      intent to share the cv
        Intent sharing = new Intent(Intent.ACTION_SEND);
        sharing.setType("text/plain");
        sharing.putExtra(Intent.EXTRA_SUBJECT, "My CV");
        sharing.putExtra(Intent.EXTRA_TEXT, cvText.toString());

        startActivity(Intent.createChooser(sharing, "Share CV via"));
    }
}