package com.cst2335.rayk0001;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    private static final String androidLab4 = "userData";
    private static final String userName = "userName";
    private static final String userAddress = "userAddress";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences sharedPreferences = getSharedPreferences(androidLab4, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Button saveData = findViewById(R.id.saveData);
        Button clearData = findViewById(R.id.clearData);
        EditText name_edit = findViewById(R.id.name);
        EditText address_edit = findViewById(R.id.editTextProfileAddress);

        saveData.setOnClickListener(view -> {
            String name = name_edit.getText().toString();
            String address = address_edit.getText().toString();

            editor.putString(userName, name);
            editor.putString(userAddress, address);
            editor.apply();
        });

        String name = sharedPreferences.getString("userName", "");
        String address = sharedPreferences.getString("userAddress", "");

        name_edit.setText(name);
        address_edit.setText(address);

        Intent fromMain = getIntent();
        String email = fromMain.getStringExtra("EMAIL");
        TextView emailText = findViewById(R.id.EditTextMainEmail);
        emailText.setText(email);

        clearData.setOnClickListener(v -> {
            name_edit.getText().toString();
            address_edit.getText().toString();

            editor.remove(userName);
            editor.remove(userAddress);
            editor.apply();

            name_edit.setText("");
            address_edit.setText("");
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}