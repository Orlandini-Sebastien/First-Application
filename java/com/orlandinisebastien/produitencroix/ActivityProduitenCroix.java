package com.orlandinisebastien.produitencroix;

import static com.orlandinisebastien.produitencroix.R.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ActivityProduitenCroix extends AppCompatActivity {
private TextView txtCalculX;
private TextView txtCalculY;
private TextView txtCalculW;
private TextView txtCalculZ;
private TextView txtEffacer;

private EditText etValeurX;
private EditText etValeurY;
private EditText etValeurW;
private EditText etValeurZ;

private TextView noticePEC;

private ImageView imglaCroixZ;
private ImageView imglaCroixX;
    private ImageView imglaCroixY;
    private ImageView imglaCroixW;

private ImageView imglaBarre;

private boolean txtCalculXOK=false;
    private boolean txtCalculYOK=false;
    private boolean txtCalculZOK=false;
    private boolean txtCalculWOK=false;
    private boolean txtEffacerOK=false;

private Double XX;
private Double YY;
private Double ZZ;
private Double WW;

private DecimalFormat df1;
private DecimalFormat df2;

private int increment =0;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_produiten_croix);

        etValeurX = findViewById(R.id.PECtxtBoxValX);
        etValeurY = findViewById(R.id.PECtxtBoxValY);
        etValeurW = findViewById(R.id.PECtxtBoxValW);
        etValeurZ = findViewById(R.id.PECtxtBoxValZ);

        noticePEC = findViewById(id.notice_TM);

        imglaCroixZ = findViewById(R.id.imgLaCroixZ);
        imglaCroixX = findViewById(R.id.imgLaCroixX);
        imglaCroixY = findViewById(R.id.imgLaCroixY);
        imglaCroixW = findViewById(R.id.imgLaCroixW);

        imglaBarre = findViewById(R.id.imgBarretEgal);

        txtCalculX = findViewById(R.id.btnCalculX);
        txtCalculY = findViewById(R.id.btnCalculY);
        txtCalculW = findViewById(R.id.btnCalculW);
        txtCalculZ = findViewById(R.id.btnCalculZ);
        txtEffacer = findViewById(R.id.btnEffacer);

        df1= new DecimalFormat("####.##");
        df2 = new DecimalFormat("0.##E0");

        etValeurX.addTextChangedListener(valeurWatcher);
        etValeurW.addTextChangedListener(valeurWatcher);
        etValeurY.addTextChangedListener(valeurWatcher);
        etValeurZ.addTextChangedListener(valeurWatcher);

        txtCalculX.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if(txtCalculXOK){
                            ZZ = Double.parseDouble(etValeurZ.getText().toString().trim());
                            YY = Double.parseDouble(etValeurY.getText().toString().trim());
                            WW = Double.parseDouble(etValeurW.getText().toString().trim());
                            XX = WW * YY / ZZ;

                            etValeurX.setText(XX.toString());
                            etValeurY.setText(YY.toString());
                            etValeurZ.setText(ZZ.toString());
                            etValeurW.setText(WW.toString());

                            // Couleur verte
                            etValeurX.setBackgroundColor(Color.parseColor("#b1fcb1"));

                            // Couleur jaune
                            etValeurY.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            etValeurW.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            etValeurZ.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculY.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculZ.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculW.setBackgroundColor(Color.parseColor("#fcf7b1"));

                            imglaCroixZ.setVisibility(View.INVISIBLE);
                            imglaBarre.setVisibility(View.INVISIBLE);
                            imglaCroixX.setVisibility(View.VISIBLE);
                            imglaCroixY.setVisibility(View.INVISIBLE);
                            imglaCroixW.setVisibility(View.INVISIBLE);
                        }

                    }
                    case MotionEvent.ACTION_MOVE:{}

                }

                return true;
            }
        });
        txtCalculY.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if(txtCalculYOK){
                            ZZ = Double.parseDouble(etValeurZ.getText().toString().trim());
                            XX = Double.parseDouble(etValeurX.getText().toString().trim());
                            WW = Double.parseDouble(etValeurW.getText().toString().trim());
                            YY = XX * ZZ / WW;

                            etValeurX.setText(XX.toString());
                            etValeurY.setText(YY.toString());
                            etValeurZ.setText(ZZ.toString());
                            etValeurW.setText(WW.toString());




                            etValeurY.setBackgroundColor(Color.parseColor("#b1fcb1"));
                            etValeurX.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            etValeurW.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            etValeurZ.setBackgroundColor(Color.parseColor("#fcf7b1"));

                            txtCalculX.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculZ.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculW.setBackgroundColor(Color.parseColor("#fcf7b1"));

                            imglaBarre.setVisibility(View.INVISIBLE);
                            imglaCroixZ.setVisibility(View.INVISIBLE);
                            imglaCroixX.setVisibility(View.INVISIBLE);
                            imglaCroixY.setVisibility(View.VISIBLE);
                            imglaCroixW.setVisibility(View.INVISIBLE);

                        }

                    }
                    case MotionEvent.ACTION_MOVE:{}

                }

                return true;
            }
        });
        txtCalculW.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if(txtCalculWOK){
                            ZZ = Double.parseDouble(etValeurZ.getText().toString().trim());
                            YY = Double.parseDouble(etValeurY.getText().toString().trim());
                            XX = Double.parseDouble(etValeurX.getText().toString().trim());
                            WW = XX * ZZ / YY;

                            etValeurX.setText(XX.toString());
                            etValeurY.setText(YY.toString());
                            etValeurZ.setText(ZZ.toString());
                            etValeurW.setText(WW.toString());




                            etValeurW.setBackgroundColor(Color.parseColor("#b1fcb1"));
                            etValeurY.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            etValeurX.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            etValeurZ.setBackgroundColor(Color.parseColor("#fcf7b1"));

                            txtCalculY.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculZ.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculX.setBackgroundColor(Color.parseColor("#fcf7b1"));

                            imglaBarre.setVisibility(View.INVISIBLE);
                            imglaCroixZ.setVisibility(View.INVISIBLE);
                            imglaCroixX.setVisibility(View.INVISIBLE);
                            imglaCroixY.setVisibility(View.INVISIBLE);
                            imglaCroixW.setVisibility(View.VISIBLE);

                        }

                    }
                    case MotionEvent.ACTION_MOVE:{}

                }

                return true;
            }
        });
        txtCalculZ.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if(txtCalculZOK){
                            XX = Double.parseDouble(etValeurX.getText().toString().trim());
                            YY = Double.parseDouble(etValeurY.getText().toString().trim());
                            WW = Double.parseDouble(etValeurW.getText().toString().trim());
                            ZZ = WW * YY / XX;

                            etValeurX.setText(XX.toString());
                            etValeurY.setText(YY.toString());
                            etValeurZ.setText(ZZ.toString());
                            etValeurW.setText(WW.toString());


                            etValeurZ.setBackgroundColor(Color.parseColor("#b1fcb1"));
                            etValeurY.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            etValeurW.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            etValeurX.setBackgroundColor(Color.parseColor("#fcf7b1"));

                            txtCalculY.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculX.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculW.setBackgroundColor(Color.parseColor("#fcf7b1"));


                            imglaCroixZ.setVisibility(View.VISIBLE);
                            imglaBarre.setVisibility(View.INVISIBLE);
                            imglaCroixX.setVisibility(View.INVISIBLE);
                            imglaCroixY.setVisibility(View.INVISIBLE);
                            imglaCroixW.setVisibility(View.INVISIBLE);

                        }

                    }
                    case MotionEvent.ACTION_MOVE:{}

                }

                return true;
            }
        });
        txtEffacer.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        etValeurX.setText("");
                        etValeurY.setText("");
                        etValeurZ.setText("");
                        etValeurW.setText("");

                       etValeurZ.setBackgroundColor(Color.parseColor("#fcf7b1"));
                        etValeurY.setBackgroundColor(Color.parseColor("#fcf7b1"));
                        etValeurW.setBackgroundColor(Color.parseColor("#fcf7b1"));
                        etValeurX.setBackgroundColor(Color.parseColor("#fcf7b1"));

                        imglaBarre.setVisibility(View.VISIBLE);
                        imglaCroixZ.setVisibility(View.INVISIBLE);
                        imglaCroixX.setVisibility(View.INVISIBLE);
                        imglaCroixY.setVisibility(View.INVISIBLE);
                        imglaCroixW.setVisibility(View.INVISIBLE);

                        }


                    case MotionEvent.ACTION_MOVE:{}

                }

                return true;
            }
        });


    }

    private TextWatcher valeurWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }


        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            imglaBarre.setVisibility(View.VISIBLE);
            imglaCroixZ.setVisibility(View.INVISIBLE);
            imglaCroixX.setVisibility(View.INVISIBLE);
            imglaCroixY.setVisibility(View.INVISIBLE);
            imglaCroixW.setVisibility(View.INVISIBLE);


            String yInput = etValeurY.getText().toString();
            String zInput = etValeurZ.getText().toString();
            String xInput = etValeurX.getText().toString();
            String wInput = etValeurW.getText().toString();


            if(!yInput.isEmpty() && !zInput.isEmpty() && !wInput.isEmpty()){
                txtCalculX.setBackgroundColor(Color.parseColor("#b1fcb1"));
                txtCalculXOK = true;
            }
            else {
                txtCalculX.setBackgroundColor(Color.parseColor("#fcf7b1"));
                txtCalculXOK = false;
            }

            if(!xInput.isEmpty() && !zInput.isEmpty() && !wInput.isEmpty()){
                txtCalculY.setBackgroundColor(Color.parseColor("#b1fcb1"));
                txtCalculYOK = true;
            }
            else {
                txtCalculY.setBackgroundColor(Color.parseColor("#fcf7b1"));
                txtCalculYOK = false;
            }

            if(!xInput.isEmpty() && !yInput.isEmpty() && !wInput.isEmpty()){
                txtCalculZ.setBackgroundColor(Color.parseColor("#b1fcb1"));
                txtCalculZOK = true;
            }
            else {
                txtCalculZ.setBackgroundColor(Color.parseColor("#fcf7b1"));
                txtCalculZOK = false;
            }

            if(!xInput.isEmpty() && !zInput.isEmpty() && !yInput.isEmpty()){
                txtCalculW.setBackgroundColor(Color.parseColor("#b1fcb1"));
                txtCalculWOK = true;
            }
            else {
                txtCalculW.setBackgroundColor(Color.parseColor("#fcf7b1"));
                txtCalculWOK = false;
            }


            if(!xInput.isEmpty() || !yInput.isEmpty() || !zInput.isEmpty() || !wInput.isEmpty())
            { txtEffacer.setBackgroundColor(Color.parseColor("#c3befa"));
            txtEffacerOK =true;
            }
            else {
                txtEffacer.setBackgroundColor(Color.parseColor("#fcf7b1"));
                txtEffacerOK = false;
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


    public void bntPEC(View view) {
        Intent intent = new Intent(ActivityProduitenCroix.this, ActivityMenu.class);
        startActivity(intent);
    }

    public void btnNoticePEC(View view) {
        if(increment==0) noticePEC.setVisibility(View.VISIBLE);
        if(increment==1){noticePEC.setVisibility(View.INVISIBLE);}
       increment=increment+1;
        if(increment==2) increment=0;




    }


}