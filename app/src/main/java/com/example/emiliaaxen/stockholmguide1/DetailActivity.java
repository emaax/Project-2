package com.example.emiliaaxen.stockholmguide1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textViewItemType;
    TextView textViewItemName;
    TextView textViewItemAddress;
    TextView textViewItemLocation;
    TextView textViewItemDescription;
    ImageView imageViewItemImage;
    private int itemIsClickedAsFavorite = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        textViewItemType = (TextView)findViewById(R.id.item_type_text_view);
        textViewItemName = (TextView) findViewById(R.id.item_name_text_view);
        textViewItemAddress= (TextView) findViewById(R.id.item_address_text_view);
        textViewItemLocation = (TextView) findViewById(R.id.item_location_text_view);
        textViewItemDescription = (TextView) findViewById(R.id.item_description_text_view);
        imageViewItemImage = (ImageView) findViewById(R.id.item_image_view);


        NeighborhoodSQLiteOpenHelper helper = NeighborhoodSQLiteOpenHelper.getInstance(DetailActivity.this);

        int id = getIntent().getIntExtra("id", -1);


          if(id >= 0){

              int image = helper.getImageById(id);
              imageViewItemImage =(ImageView) findViewById(R.id.item_image_view);
              imageViewItemImage.setBackgroundResource(image);

            String type = helper.getTypeById(id);
            textViewItemType = (TextView)findViewById(R.id.item_type_text_view);
            textViewItemType.setText(type);

            String name = helper.getNameById(id);
            textViewItemName = (TextView) findViewById(R.id.item_name_text_view);
            textViewItemName.setText(name);

            String address = helper.getAddressById(id);
            textViewItemAddress= (TextView) findViewById(R.id.item_address_text_view);
            textViewItemAddress.setText("ADDRESS: "+address);

            String location = helper.getLocationById(id);
            textViewItemLocation = (TextView)findViewById(R.id.item_location_text_view);
            textViewItemLocation.setText("Neighborhood: " +location);

            String description = helper.getDescriptionById(id);
            textViewItemDescription = (TextView) findViewById(R.id.item_description_text_view);
            textViewItemDescription.setText("About: " + description);

              itemIsClickedAsFavorite = helper.getFavoriteById(id);
              if(itemIsClickedAsFavorite == 0 ) {
                  fab.setImageResource(R.drawable.item_not_favorite);
              } else {
                  fab.setImageResource(R.drawable.item_favorite);
              }



        }




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(itemIsClickedAsFavorite == 0) {
                    itemIsClickedAsFavorite = 1;
                    fab.setImageResource(R.drawable.item_favorite);
                    Snackbar.make(view, "Added to Favorites", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    itemIsClickedAsFavorite = 0;
                    fab.setImageResource(R.drawable.item_not_favorite);
                    Snackbar.make(view, "Removed from Favorites", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }



            }
        });
    }
}
