package com.example.quickcv;

import android.app.Activity;
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

public class PersonalDetails extends AppCompatActivity {

//    hooks
    private EditText etName, etEmail, etPhoneNumber;
    private Button btnCancel, btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

//       Store data and return to Home
        btnSave.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("name", etName.getText().toString());
            intent.putExtra("email", etEmail.getText().toString());
            intent.putExtra("phone", etPhoneNumber.getText().toString());
            setResult(Activity.RESULT_OK, intent);
            Toast.makeText(PersonalDetails.this, "Info saved!", Toast.LENGTH_SHORT).show();
            finish();
        });

//      Discard and go back
        btnCancel.setOnClickListener(v -> finish());
    }

    private void init(){
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);
    }
}