package com.cst2335.rayk0001;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_constraint);
        Button loginButton = findViewById(R.id.button2);

        loginButton.setOnClickListener(view -> {
            EditText emailEditText = findViewById(R.id.edit_text);

            Intent goToProfile = new Intent(MainActivity.this, ProfileActivity.class);
            goToProfile.putExtra("EMAIL", emailEditText.getText().toString());
            startActivity(goToProfile);
        });
    }
}


