package com.example.murga.cours11janvier2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonvalid;
    private final String EXTRA_NOM = "nom";
    private final String EXTRA_PRENOM = "prenom";
    private final String EXTRA_TITRE = "titre";
    private EditText ntxt;
    private EditText ptxt;
    private RecyclerView monRecyclerView;
    private RecyclerView.Adapter monAdapter;
    private RecyclerView.LayoutManager monLayoutManager;
    private TextView textView;
    private String[] monDataset = {"Tales of Symphonia","Tales of Xillia","Tales of Berseria"};
    private final String str ="test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monRecyclerView = (RecyclerView)findViewById(R.id.maliste);
        monRecyclerView.setHasFixedSize(true);
        monLayoutManager = new LinearLayoutManager(this);
        monRecyclerView.setLayoutManager(monLayoutManager);
        monAdapter = new rec_adapter(monDataset);
        monRecyclerView.setAdapter(monAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        buttonvalid = (Button) findViewById(R.id.button);
        ntxt = (EditText) findViewById(R.id.txt1);
        ptxt = (EditText) findViewById(R.id.txt2);


        buttonvalid.setOnClickListener(new View.OnClickListener()
                                       {
            @Override
                public void onClick(View v) {
                Intent monIntent = new Intent(MainActivity.this,Main2Activity.class);
                monIntent.putExtra(EXTRA_NOM,ntxt.getText().toString());
                monIntent.putExtra(EXTRA_PRENOM,ptxt.getText().toString());
                startActivityForResult(monIntent,0);


                    }
                }
                );




        //crée la liste sur l'activité
        monRecyclerView.addOnItemTouchListener( new RecyclerItemClickListener(getApplicationContext(),
                new RecyclerItemClickListener.OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                switch (monDataset[position])
                {
                    case "Tales of Symphonia":
                        Intent monintent2 = new Intent(MainActivity.this,Main3Activity.class);
                        monintent2.putExtra(EXTRA_TITRE,monDataset[position]);
                        startActivity(monintent2);
                        break;
                    case "Tales of Xillia":
                        Intent monintent3 = new Intent(MainActivity.this,Main3Activity.class);
                        monintent3.putExtra(EXTRA_TITRE,monDataset[position]);
                        startActivity(monintent3);
                        break;
                    case "Tales of Berseria":
                        Intent monintent4 = new Intent(MainActivity.this,Main3Activity.class);
                        monintent4.putExtra(EXTRA_TITRE,monDataset[position]);
                        startActivity(monintent4);
                        break;

                }

            }

            }));


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

//récupère le resultat envoyé par l'activité 2
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        textView = (TextView) findViewById(R.id.textView);

        // check that it is the SecondActivity with an OK result
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK

                // get String data from Intent
                String returnString = data.getStringExtra(str);


                // set text view with string

                textView.setText(returnString);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
