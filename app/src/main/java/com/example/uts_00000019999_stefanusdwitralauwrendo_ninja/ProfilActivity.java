package com.example.uts_00000019999_stefanusdwitralauwrendo_ninja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;


public class ProfilActivity extends AppCompatActivity {
    ImageView profilSaya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] listArray={"ASP","C#","C++","HTML5","Javascript","Java","Objective-C","Perl","PHP","Python","Swift",};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        profilSaya = findViewById(R.id.potoSaya);
        profilSaya.setImageResource(R.drawable.profilesaya);
    }
}
