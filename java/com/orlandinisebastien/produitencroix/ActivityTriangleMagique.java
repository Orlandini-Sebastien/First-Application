package com.orlandinisebastien.produitencroix;

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

public class ActivityTriangleMagique extends AppCompatActivity {

    private int increment =0;
    private TextView noticeTM;

    private TextView valeurXdanstriangle;
    private TextView valeurYdanstriangle;
    private TextView valeurZdanstriangle;

    private TextView txtCalculXTM;
    private TextView txtCalculYTM;
    private TextView txtCalculZTM;
    private TextView txtEffacerTM;

    private EditText etValeurXTM;
    private EditText etValeurYTM;
    private EditText etValeurZTM;

    private ImageView imgTriangleTM;

    private ImageView pourNotice;


    private boolean txtCalculXOKTM =false;
    private boolean txtCalculYOKTM =false;
    private boolean txtCalculZOKTM =false;

    private boolean txtEffacerOKTM =false;

    private Double XXTM;
    private Double YYTM;
    private Double ZZTM;


    private DecimalFormat df1;
    private DecimalFormat df2;

    private int increment2=0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_magique);

pourNotice= findViewById(R.id.pourNoticeTM);

        etValeurXTM =findViewById(R.id.TMtxtBoxValX);
        etValeurYTM =findViewById(R.id.TMtxtBoxValY);
        etValeurZTM =findViewById(R.id.TMtxtBoxValZ);

        noticeTM = findViewById(R.id.notice_TM);

        valeurXdanstriangle = findViewById(R.id.txtValeurXTriangle);
        valeurYdanstriangle = findViewById(R.id.txtValeurYTriangle);
        valeurZdanstriangle = findViewById(R.id.txtValeurZTriangle);

        txtCalculXTM =findViewById(R.id.TMbtnCalculX);
        txtCalculYTM =findViewById(R.id.TMbtnCalculY);
        txtCalculZTM =findViewById(R.id.TMbtnCalculZ);
        txtEffacerTM =findViewById(R.id.btnEffacerTM);

noticeTM.setVisibility(View.GONE);

        imgTriangleTM =findViewById(R.id.imgTriangleTM);

        etValeurXTM.addTextChangedListener(valeurWatcherTM);
        etValeurYTM.addTextChangedListener(valeurWatcherTM);
        etValeurZTM.addTextChangedListener(valeurWatcherTM);

        df1= new DecimalFormat("####.##");
        df2 = new DecimalFormat("0.##E0");

        txtCalculXTM.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if(txtCalculXOKTM){




                            ZZTM = Double.parseDouble(etValeurZTM.getText().toString().trim());
                            YYTM = Double.parseDouble(etValeurYTM.getText().toString().trim());

                            XXTM =  YYTM / ZZTM;

                            etValeurZTM.setText(ZZTM.toString());
                            etValeurYTM.setText(YYTM.toString());
                            etValeurXTM.setText(XXTM.toString());

                            valeurZdanstriangle.setText(df1.format(ZZTM));
                            valeurYdanstriangle.setText(df1.format(YYTM));
                            valeurXdanstriangle.setText(df1.format(XXTM));

                            if(ZZTM >10000) {
                                valeurZdanstriangle.setText(df2.format(ZZTM));
                            }
                            if(XXTM >10000) {
                                valeurXdanstriangle.setText(df2.format(XXTM));
                            }
                            if(YYTM >10000) {
                                valeurYdanstriangle.setText(df2.format(YYTM));
                            }

                           //  Couleur verte
                            etValeurXTM.setBackgroundColor(Color.parseColor("#b1fcb1"));

                            // Couleur jaune
                            etValeurYTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            etValeurZTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculYTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculZTM.setBackgroundColor(Color.parseColor("#fcf7b1"));

                            imgTriangleTM.setImageResource(R.drawable.triangleysurz);

                            valeurXdanstriangle.setTextColor(Color.parseColor("#b80742"));
                            valeurYdanstriangle.setTextColor(Color.BLACK);
                            valeurZdanstriangle.setTextColor(Color.BLACK);



                        }

                    }
                    case MotionEvent.ACTION_MOVE:{}

                }

                return true;
            }
        });
        txtCalculYTM.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if(txtCalculYOKTM){






                            ZZTM = Double.parseDouble(etValeurZTM.getText().toString().trim());
                            XXTM = Double.parseDouble(etValeurXTM.getText().toString().trim());

                            YYTM = XXTM * ZZTM;

                            etValeurZTM.setText(ZZTM.toString());
                            etValeurYTM.setText(YYTM.toString());
                            etValeurXTM.setText(XXTM.toString());

                            valeurZdanstriangle.setText(df1.format(ZZTM));
                            valeurYdanstriangle.setText(df1.format(YYTM));
                            valeurXdanstriangle.setText(df1.format(XXTM));

                            if(ZZTM >10000) {
                                valeurZdanstriangle.setText(df2.format(ZZTM));
                            }
                            if(XXTM >10000) {
                                valeurXdanstriangle.setText(df2.format(XXTM));
                            }
                            if(YYTM >10000) {
                                valeurYdanstriangle.setText(df2.format(YYTM));
                            }

                            etValeurYTM.setBackgroundColor(Color.parseColor("#b1fcb1"));

                            etValeurXTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            etValeurZTM.setBackgroundColor(Color.parseColor("#fcf7b1"));

                            txtCalculXTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculZTM.setBackgroundColor(Color.parseColor("#fcf7b1"));

                            valeurXdanstriangle.setTextColor(Color.BLACK);
                            valeurZdanstriangle.setTextColor(Color.BLACK);
                            valeurYdanstriangle.setTextColor(Color.parseColor("#b80742"));

                            imgTriangleTM.setImageResource(R.drawable.trianglexfoisz);



                        }

                    }
                    case MotionEvent.ACTION_MOVE:{}

                }

                return true;
            }
        });
        txtCalculZTM.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if(txtCalculZOKTM){


                            XXTM = Double.parseDouble(etValeurXTM.getText().toString().trim());
                            YYTM = Double.parseDouble(etValeurYTM.getText().toString().trim());

                            ZZTM =  YYTM / XXTM;

                            etValeurZTM.setText(ZZTM.toString());
                            etValeurYTM.setText(YYTM.toString());
                            etValeurXTM.setText(XXTM.toString());

                            valeurZdanstriangle.setText(df1.format(ZZTM));
                            valeurYdanstriangle.setText(df1.format(YYTM));
                            valeurXdanstriangle.setText(df1.format(XXTM));

                            if(ZZTM >10000) {
                                valeurZdanstriangle.setText(df2.format(ZZTM));
                            }
                            if(XXTM >10000) {
                                valeurXdanstriangle.setText(df2.format(XXTM));
                            }
                            if(YYTM >10000) {
                                valeurYdanstriangle.setText(df2.format(YYTM));
                            }


                            etValeurZTM.setBackgroundColor(Color.parseColor("#b1fcb1"));
                            valeurZdanstriangle.setTextColor(Color.parseColor("#b80742"));
                            etValeurYTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            etValeurXTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculYTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            txtCalculXTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                            valeurYdanstriangle.setTextColor(Color.BLACK);
                            valeurXdanstriangle.setTextColor(Color.BLACK);
                            imgTriangleTM.setImageResource(R.drawable.triangleysurx);


                        }

                    }
                    case MotionEvent.ACTION_MOVE:{}

                }

                return true;
            }
        });
        txtEffacerTM.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        etValeurXTM.setText("");
                        etValeurYTM.setText("");
                        etValeurZTM.setText("");
                        valeurYdanstriangle.setText("");
                        valeurXdanstriangle.setText("");
                        valeurZdanstriangle.setText("");

                        valeurYdanstriangle.setTextColor(Color.BLACK);
                        valeurXdanstriangle.setTextColor(Color.BLACK);
                        valeurZdanstriangle.setTextColor(Color.BLACK);
                        etValeurZTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                        etValeurYTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                        etValeurXTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                        imgTriangleTM.setImageResource(R.drawable.letriangletm);

                    }


                    case MotionEvent.ACTION_MOVE:{}

                }

                return true;
            }
        });

        pourNotice.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        if(increment2==0) noticeTM.setVisibility(View.VISIBLE);
                        if(increment2==1) noticeTM.setVisibility(View.INVISIBLE);
                        increment2=increment2+1;
                        if(increment2 == 2)increment2=0;
                    }

                }
                return true;
            }
        });

    }

    private TextWatcher valeurWatcherTM = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }


        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //    imgTriangleTM.setImageResource(R.drawable.letriangletm);

            String yInput = etValeurYTM.getText().toString();
            String zInput = etValeurZTM.getText().toString();
            String xInput = etValeurXTM.getText().toString();



            if(!yInput.isEmpty() && !zInput.isEmpty() ){
                txtCalculXTM.setBackgroundColor(Color.parseColor("#b1fcb1"));
                txtCalculXOKTM = true;
            }
            else {
                txtCalculXTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                txtCalculXOKTM = false;
            }

            if(!xInput.isEmpty() && !zInput.isEmpty() ){
                txtCalculYTM.setBackgroundColor(Color.parseColor("#b1fcb1"));
                txtCalculYOKTM = true;
            }
            else {
                txtCalculYTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                txtCalculYOKTM = false;
            }

            if(!xInput.isEmpty() && !yInput.isEmpty() ){
                txtCalculZTM.setBackgroundColor(Color.parseColor("#b1fcb1"));
                txtCalculZOKTM = true;
            }
            else {
                txtCalculZTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                txtCalculZOKTM = false;
            }



            if(!xInput.isEmpty() || !yInput.isEmpty() || !zInput.isEmpty() )
            { txtEffacerTM.setBackgroundColor(Color.parseColor("#c3befa"));
                txtEffacerOKTM =true;
            }
            else {
                txtEffacerTM.setBackgroundColor(Color.parseColor("#fcf7b1"));
                txtEffacerOKTM = false;
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };



/*
    public void btnNoticeTM(View view) {
        if(increment==0)increment=0;

        if(increment==1){noticeTM.setVisibility(View.INVISIBLE);}
        if(increment==0){noticeTM.setVisibility(View.VISIBLE);}
    }

 */

    public void btnTMversTitre(View view) {
        Intent intent = new Intent(ActivityTriangleMagique.this, ActivityMenu.class);
        startActivity(intent);
    }
}