package com.orlandinisebastien.produitencroix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public void btnTriange(View view) {
        Intent intent = new Intent(ActivityMenu.this, ActivityTriangleMagique.class);
        startActivity(intent);
    }

    public void bntPEC(View view) {
        Intent intent = new Intent(ActivityMenu.this, ActivityProduitenCroix.class);
        startActivity(intent);
    }
}