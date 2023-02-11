package com.cst2335.rayk0001;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "PROFILE_ACTIVITY";
    private ActivityResultLauncher<Intent> myPictureTakerLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.e(TAG, "In function: onCreate");

        Button takePictureButton = findViewById(R.id.pictureButton);
        EditText name_edit = findViewById(R.id.editTextTextPersonName2);
        String name = "Chintan";

        takePictureButton.setOnClickListener(v -> dispatchTakePictureIntent());

        myPictureTakerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        ImageView imgView = findViewById(R.id.imageView);
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            assert data != null;
                            Bitmap imgBitmap = (Bitmap) data.getExtras().get("data");
                            imgView.setImageBitmap(imgBitmap);
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            Log.i(TAG, "User refused to capture a picture.");
                        }
                    }
                }
        );

        Intent fromMain = getIntent();
        String email = fromMain.getStringExtra("EMAIL");
        EditText emailText = findViewById(R.id.editTextTextEmailName);
        emailText.setText(email);

        name_edit.setText(name);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "In function: onStarts");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "In function: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "In function: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "In function: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "In function: onDestroy");
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            myPictureTakerLauncher.launch(takePictureIntent);
        }

    }


}