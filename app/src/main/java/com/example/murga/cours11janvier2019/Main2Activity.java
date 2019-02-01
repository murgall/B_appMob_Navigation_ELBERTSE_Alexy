package com.example.murga.cours11janvier2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {


    //initialisation des variables
    private final String EXTRA_NOM = "nom";
    private final String EXTRA_PRENOM = "prenom";
    private TextView ngtxt;
    private TextView pgtxt;
    private EditText etxt;
    private final String str ="test";
    private Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        ngtxt = (TextView) findViewById(R.id.txtNom);
        pgtxt = (TextView) findViewById(R.id.txtPrenom);
        btn = (Button) findViewById(R.id.buttonRecup);
        etxt = (EditText) findViewById(R.id.testEdit);

        Intent monIntent = getIntent();
        String strNom = monIntent.getStringExtra(EXTRA_NOM);
        String strPrenom = monIntent.getStringExtra(EXTRA_PRENOM);

        ngtxt.setText(strNom);
        pgtxt.setText(strPrenom);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent monIntent2 = new Intent();
                monIntent2.putExtra(str,etxt.getText().toString());
                setResult(MainActivity.RESULT_OK,monIntent2);

                finish();
            }
        });




        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


}
