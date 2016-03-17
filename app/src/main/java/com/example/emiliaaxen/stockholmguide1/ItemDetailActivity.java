package com.example.emiliaaxen.stockholmguide1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ItemDetailActivity extends AppCompatActivity {

    TextView textViewItemTitle;
    TextView textViewItemAdress;
    TextView textViewItemDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        textViewItemTitle = (TextView) findViewById(R.id.item_name_text_view);
        textViewItemAdress= (TextView) findViewById(R.id.item_adress_text_view);
        textViewItemDescription = (TextView) findViewById(R.id.item_description_text_view);



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
