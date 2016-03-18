package com.example.emiliaaxen.stockholmguide1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textViewItemType;
    TextView textViewItemName;
    TextView textViewItemAddress;
    TextView textViewItemLocation;
    TextView textViewItemDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewItemType = (TextView)findViewById(R.id.item_type_text_view);
        textViewItemName = (TextView) findViewById(R.id.item_name_text_view);
        textViewItemAddress= (TextView) findViewById(R.id.item_address_text_view);
        textViewItemLocation = (TextView) findViewById(R.id.item_location_text_view);
        textViewItemDescription = (TextView) findViewById(R.id.item_description_text_view);

        NeighborhoodSQLiteOpenHelper helper = NeighborhoodSQLiteOpenHelper.getInstance(DetailActivity.this);

        int id = getIntent().getIntExtra("id",-1);

        if(id >= 0){


            String type = helper.getTypeById(id);
            textViewItemType = (TextView)findViewById(R.id.item_type_text_view);
            textViewItemType.setText(type);

            String name = helper.getNameById(id);
            textViewItemName = (TextView) findViewById(R.id.item_name_text_view);
            textViewItemName.setText(name);

            String address = helper.getAddressById(id);
            textViewItemAddress= (TextView) findViewById(R.id.item_address_text_view);
            textViewItemAddress.setText(address);

            String location = helper.getLocationById(id);
            textViewItemLocation = (TextView)findViewById(R.id.item_location_text_view);
            textViewItemLocation.setText(location);

            String description = helper.getDescriptionById(id);
            textViewItemDescription = (TextView) findViewById(R.id.item_description_text_view);
            textViewItemDescription.setText(description);

        }




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
