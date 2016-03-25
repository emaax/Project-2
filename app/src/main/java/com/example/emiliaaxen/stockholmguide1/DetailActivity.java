package com.example.emiliaaxen.stockholmguide1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This is the Detail Activity, which displays the name, image, type, address, neighborhood and
 * description of the Item being pressed on in the previous activity.
 * Furthermore, this activity also displays a favorite button, which,
 * when being pressed on, allowes the user to add the item being displayed
 * on the screen to be added to a favorite list.
 */

public class DetailActivity extends AppCompatActivity {

    TextView textViewItemType;
    TextView textViewItemName;
    TextView textViewItemAddress;
    TextView textViewItemLocation;
    TextView textViewItemDescription;
    ImageView imageViewItemImage;

    private int itemIsClickedAsFavorite = 0;
    int id;

    NeighborhoodSQLiteOpenHelper helper;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        helper = NeighborhoodSQLiteOpenHelper.getInstance(DetailActivity.this);
        fab = (FloatingActionButton) findViewById(R.id.fab);


        initViews();


        setInfo();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemIsClickedAsFavorite == 0) {
                    itemIsClickedAsFavorite = 1;
                    fab.setImageResource(R.drawable.item_favorite);
                    helper.setFavoriteById(id, true);
                    Snackbar.make(view, "Added to Favorites", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    itemIsClickedAsFavorite = 0;
                    fab.setImageResource(R.drawable.item_not_favorite);
                    helper.setFavoriteById(id, false);
                    Snackbar.make(view, "Removed from Favorites", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

    }

    public void initViews() {
        textViewItemType = (TextView) findViewById(R.id.item_type_text_view);
        textViewItemName = (TextView) findViewById(R.id.item_name_text_view);
        textViewItemAddress = (TextView) findViewById(R.id.item_address_text_view);
        textViewItemLocation = (TextView) findViewById(R.id.item_location_text_view);
        textViewItemDescription = (TextView) findViewById(R.id.item_description_text_view);
        imageViewItemImage = (ImageView) findViewById(R.id.item_image_view);


    }

    public void setInfo() {
        id = getIntent().getIntExtra("id", -1);
        if (id >= 0) {

            //populate the type
            String type = helper.getTypeById(id);
            textViewItemType.setText(type);
            //populate the item image
            int image = helper.getImageById(id);
            imageViewItemImage.setBackgroundResource(image);
            //Populate the item name
            String name = helper.getNameById(id);
            textViewItemName.setText(name);
            //Populate the item address
            String address = helper.getAddressById(id);
            textViewItemAddress.setText("ADDRESS: " + address);
            //Populate the item location
            String location = helper.getLocationById(id);
            textViewItemLocation.setText("NEIGHBORHOOD: " + location);
            //Populate the item description
            String description = helper.getDescriptionById(id);
            textViewItemDescription.setText("ABOUT: " + description);
            //Populate the favorite "check button"
            itemIsClickedAsFavorite = helper.getFavoriteById(id);
            if (itemIsClickedAsFavorite == 0) {
                fab.setImageResource(R.drawable.item_not_favorite);
            } else {
                fab.setImageResource(R.drawable.item_favorite);
            }


        }
    }
}
