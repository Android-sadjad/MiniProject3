package com.example.miniproject3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ItemsContent> arrayList;
    ImageView imgProfile;
    TextView nameTv;
    TextView bioTv;
    RatingBar ratingBar;
    final int REQUEST_CODE_READ_EXTERNAL = 10;
    private static final int SELECT_PHOTO = 100;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        init();

        RatingBarr();
        config();


    }

    private void init(){
arrayList = new ArrayList<>();
arrayList.add(new ItemsContent("اندروید","5 days"));
arrayList.add(new ItemsContent("اندروید1","5 days"));
arrayList.add(new ItemsContent("اندروید2","5 days"));
arrayList.add(new ItemsContent("اندروید3","5 days"));
arrayList.add(new ItemsContent("اندروید3","5 days"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdaptor myAdaptor=new MyAdaptor(this,arrayList);
        recyclerView.setAdapter(myAdaptor);


    }

    private void RatingBarr() {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

    }

    private void findViews() {
        ratingBar = findViewById(R.id.ratingBar);
        imgProfile = findViewById(R.id.profile_image);
        nameTv = findViewById(R.id.tv_name);
        bioTv = findViewById(R.id.tv_bio);
        recyclerView=findViewById(R.id.recycler_viwe);
    }

    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permission)) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
            }
        } else {
            getImageFromGallery();
        }

    }

    private void getImageFromGallery() {


        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        if (requestCode == SELECT_PHOTO) {
            if (resultCode == RESULT_OK) {
                Uri selectedImage = imageReturnedIntent.getData();


                //  Toast.makeText(this, clientInfo.getImageAddress(), Toast.LENGTH_LONG).show();

                InputStream imageStream = null;
                try {
                    imageStream = getContentResolver().openInputStream(selectedImage);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
                imgProfile.setImageBitmap(yourSelectedImage);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        if (requestCode == REQUEST_CODE_READ_EXTERNAL) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                getImageFromGallery();

            } else {
                Toast.makeText(getApplicationContext(), "محوز داده نشد", Toast.LENGTH_SHORT).show();
            }
            return;
        }
    }

    private void config() {

        imgProfile.setOnClickListener(v -> {

            askForPermission(Manifest.permission.READ_EXTERNAL_STORAGE, REQUEST_CODE_READ_EXTERNAL);

        });
    }
}